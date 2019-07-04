package android.example.instaevents.Profile;

import android.content.Context;
import android.example.instaevents.BlurUtils;
import android.example.instaevents.R;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    private ImageView blurredImage, profileImage;
    private TextView displayName;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.profile_activity, container, false);

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }


    // This event is triggered soon after onCreateView().
    // Any view setup occurs here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        blurredImage = view.findViewById(R.id.blurImage);
        profileImage = view.findViewById(R.id.profile_image);
        displayName = view.findViewById(R.id.username);

        //Get the bitmap from the ImageView.
        Bitmap bitmap = ((BitmapDrawable) blurredImage.getDrawable()).getBitmap();

        //Let's apply Gaussian blur effect with radius "10.5" and set to ImageView.
        blurredImage.setImageBitmap(new BlurUtils().blur(getContext(), bitmap, 25.0f));


        profileImage.setImageResource(R.drawable.pic);
        displayName.setText("Sandra");

    }
}
