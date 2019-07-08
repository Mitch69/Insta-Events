package android.example.instaevents.ClickedEvent;

import android.content.Context;
import android.content.Intent;
import android.example.instaevents.MyBounceInterpolator;
import android.example.instaevents.R;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ClickedEventAdapter extends PagerAdapter {

    private List<ClickedEventModel> eventInfoData;
    private LayoutInflater layoutInflater;
    private Context context;

    public ClickedEventAdapter(List<ClickedEventModel> eventInfoData, Context context) {
        this.eventInfoData = eventInfoData;
        this.context = context;
    }

    //Method in ListPojo
    public void setData(List<ClickedEventModel> eventInfoData) {
        this.eventInfoData = eventInfoData;
    }

    @Override
    public int getCount() {
        return eventInfoData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.clicked_event_cardview, container, false);

        ImageView imageView;
        final TextView eventNameText, dateText, timeText, locationText, featuringText, moreInfoText;
        final Button interested;
        final ImageButton share;


        imageView = view.findViewById(R.id.image);
        eventNameText = view.findViewById(R.id.idEventName);
        dateText = view.findViewById(R.id.idDate);
        timeText = view.findViewById(R.id.idTime);
        locationText = view.findViewById(R.id.idLocation);
        featuringText = view.findViewById(R.id.idFeaturing);
        moreInfoText = view.findViewById(R.id.idMoreInfo);
        interested = view.findViewById(R.id.idbtnInterested);
        share = view.findViewById(R.id.idbtnShare);



        ClickedEventModel clickedEventModel=eventInfoData.get(position);
        Glide.with(context)
                .load(clickedEventModel.getImage())
                .into(imageView);

        eventNameText.setText(eventInfoData.get(position).getEventName());
        dateText.setText(eventInfoData.get(position).getDate());
        timeText.setText(eventInfoData.get(position).getTime());
        locationText.setText(eventInfoData.get(position).getLocation());
        featuringText.setText(eventInfoData.get(position).getFeaturing());
        moreInfoText.setText(eventInfoData.get(position).getMoreInfo());
        interested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce);
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.07, 30);
                myAnim.setInterpolator(interpolator);

                interested.startAnimation(myAnim);

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce);
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.07, 30);
                myAnim.setInterpolator(interpolator);

                share.startAnimation(myAnim);


                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                intent.putExtra(Intent.EXTRA_TEXT, "Check out "
                        +  eventInfoData.get(position).getEventName() +
                        " on Insta Events"

                );

                context.startActivity(Intent.createChooser(intent, "Send to "));
            }
        });


        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}

