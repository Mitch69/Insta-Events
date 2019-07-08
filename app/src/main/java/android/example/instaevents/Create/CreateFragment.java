package android.example.instaevents.Create;

import android.example.instaevents.MyBounceInterpolator;
import android.example.instaevents.R;
import android.example.instaevents.Retrofit.APIClient;
import android.example.instaevents.Retrofit.ApiInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateFragment extends Fragment {

    TextInputEditText TextName, TextDate, TextTime, TextLocation, TextArtists, TextMoreInfo;
    AppCompatButton CreateButton;
    Spinner spinner;
    ApiInterface apiInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_activity, container, false);

        spinner = view.findViewById(R.id.idSpinner);
        TextName = view.findViewById(R.id.nameInput);
        TextDate = view.findViewById(R.id.dateInput);
        TextTime = view.findViewById(R.id.timeInput);
        TextLocation = view.findViewById(R.id.locationInput);
        TextArtists = view.findViewById(R.id.featuringArtistsInput);
        TextMoreInfo = view.findViewById(R.id.moreInfoInput);
        CreateButton = view.findViewById(R.id.createButton);

        apiInterface = APIClient.getClient().create(ApiInterface.class);

        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Button animation
                final Animation myAnim = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.07, 30);
                myAnim.setInterpolator(interpolator);

                CreateButton.startAnimation(myAnim);

                String categoryID = spinner.getSelectedItem().toString().trim();
                String eventName = TextName.getText().toString().trim();
                String eventDescription = TextMoreInfo.getText().toString().trim();
                String eventDate = TextDate.getText().toString().trim();
                String eventLocation = TextLocation.getText().toString().trim();
                String eventTime = TextTime.getText().toString().trim();
                String eventArtists = TextArtists.getText().toString().trim();


                if(!TextUtils.isEmpty(categoryID) && !TextUtils.isEmpty(eventName) && !TextUtils.isEmpty(eventDescription) && !TextUtils.isEmpty(eventDate) && !TextUtils.isEmpty(eventLocation) && !TextUtils.isEmpty(eventTime) && !TextUtils.isEmpty(eventArtists)) {
                    sendPost(categoryID, eventName, eventDescription, eventDate, eventLocation, eventTime, eventArtists);
                }
            }
        });

        return view;
    }


    public void sendPost(String categoryID, String eventName, String eventDescription, String eventDate, String eventLocation, String eventTime, String eventArtists) {
        apiInterface.savePost(categoryID, eventName, eventDescription, eventDate, eventLocation, eventTime, eventArtists).enqueue(new Callback<CreatePojo>() {
            @Override
            public void onResponse(Call<CreatePojo> call, Response<CreatePojo> response) {

                if(!response.isSuccessful()) {

                    Log.i("Error ", response.toString());


                }else{

                    Log.i("Post submitted to API.", response.body().toString());

                }
            }

            @Override
            public void onFailure(Call<CreatePojo> call, Throwable t) {
                Toast toast=Toast.makeText(getContext(),"Message: " + t.getMessage() ,Toast.LENGTH_SHORT);
//                Toast toast=Toast.makeText(getApplicationContext(),"No internet connection available"  ,Toast.LENGTH_SHORT);
                toast.show();
                t.printStackTrace();
            }
        });
    }

} //onCreateView
