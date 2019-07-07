package android.example.instaevents.Profile;

import android.content.Context;
import android.content.Intent;
import android.example.instaevents.Authentication.LoginActivity;
import android.example.instaevents.BlurUtils;
import android.example.instaevents.MainActivity;
import android.example.instaevents.R;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;


public class ProfileFragment extends Fragment {

    private static final int CHOOSE_IMAGE = 101;

    private ImageView blurredImage, profileImage;
    //private TextView displayName;
    private Context mContext;

    //Gabriel member vairables
    private CircleImageView setupImage;
    private EditText setupName;
    private Button setupBtn;
    private ProgressBar setupProgressBar;
    private Button logout_btn;


    FirebaseAuth mAuth;

    String profileImageUrl;

    Uri uriProfileImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.profile_activity, container, false);

        mAuth = FirebaseAuth.getInstance();

        setupName = view.findViewById(R.id.setup_name);
        setupImage = view.findViewById(R.id.setup_image);
        setupBtn = view.findViewById(R.id.setup_btn);
        setupProgressBar = view.findViewById(R.id.setupProgressBar);
        blurredImage = view.findViewById(R.id.blurImage);
        logout_btn = view.findViewById(R.id.logout_btn);

        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            loadUserInformation();
        }
        else{
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }

        setupImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageChooser();
            }
        });

        setupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInformation();
            }
        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });

        return view;

    }

    private void loadUserInformation() {
        FirebaseUser user = mAuth.getCurrentUser();

        if(user.getPhotoUrl() != null) {
            setupProgressBar.setVisibility(View.VISIBLE);
            Glide.with(getActivity())
                    .load(user.getPhotoUrl().toString())
                    .into(setupImage);
            Glide.with(getActivity())
                    .load(user.getPhotoUrl().toString())
                    .into(blurredImage);
            setupProgressBar.setVisibility(View.INVISIBLE);
        }
        if(user.getDisplayName() != null) {
            setupName.setText(user.getDisplayName());
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHOOSE_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null){
            uriProfileImage = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),uriProfileImage);
                setupImage.setImageBitmap(bitmap);

                uploadImageToFirebaseStorage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void uploadImageToFirebaseStorage() {
        //This sets the reference to the storage path in the Firebase database
        //The images will be saved in profilepics/(time to upload in ms).jpg e.g profilepics/144223.jpg
        final StorageReference profileImageReference = FirebaseStorage
                .getInstance()
                .getReference("profilepics/"+System.currentTimeMillis() +  ".jpg");

        if (uriProfileImage != null){
            setupProgressBar.setVisibility(View.VISIBLE);
            profileImageReference.putFile(uriProfileImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    setupProgressBar.setVisibility(View.INVISIBLE);


                    Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                    while (!urlTask.isSuccessful());
                    profileImageUrl = urlTask.getResult().toString();
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            setupProgressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(getActivity(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else{
            Toast.makeText(getActivity(), "No file Selected",Toast.LENGTH_SHORT).show();
        }
    }

    private void saveUserInformation() {
        String displayName = setupName.getText().toString();

        if(displayName.isEmpty()){
            setupName.setError("Name Required!");
            setupName.requestFocus();
            return;
        }

        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null && profileImageUrl != null){
            //Request used to update user profile information.
            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                    .setDisplayName(displayName)
                    .setPhotoUri(Uri.parse(profileImageUrl))
                    .build();

            user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getActivity(), "Profile Updated", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }

    }

    private void showImageChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Profile Image"), CHOOSE_IMAGE);
    }

    private void logOut() {
        mAuth.signOut();
        sendToLogin();
    }

    private void sendToLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }


    // This event is triggered soon after onCreateView().
    // Any view setup occurs here.  E.g., view lookups and attaching view listeners.
    /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        //blurredImage = view.findViewById(R.id.blurImage);
       // profileImage = view.findViewById(R.id.setup_image);


        //Get the bitmap from the ImageView.
        Bitmap bitmap = ((BitmapDrawable) blurredImage.getDrawable()).getBitmap();

        //Let's apply Gaussian blur effect with radius "10.5" and set to ImageView.
        blurredImage.setImageBitmap(new BlurUtils().blur(getContext(), bitmap, 25.0f));


        profileImage.setImageResource(R.drawable.user);
        displayName.setText("Sandra");

    } */


}
