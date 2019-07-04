package android.example.instaevents.EventsPage.Upcoming;

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

public class UpcomingFragment extends Fragment {

    private ImageView blurredImage, eventImage;
    private TextView textDaysNumber;

    public UpcomingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.upcoming_activity, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        blurredImage = view.findViewById(R.id.blurImage);
        eventImage = view.findViewById(R.id.idEventImage);
        textDaysNumber = view.findViewById(R.id.idDaysNumber);

        //Get the bitmap from the ImageView.
        Bitmap bitmap = ((BitmapDrawable) blurredImage.getDrawable()).getBitmap();

        //Let's apply Gaussian blur effect with radius "10.5" and set to ImageView.
        blurredImage.setImageBitmap(new BlurUtils().blur(getContext(), bitmap, 15f));

        eventImage.setImageResource(R.drawable.choma);
        textDaysNumber.setText("123");
    }
}
