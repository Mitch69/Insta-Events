package android.example.instaevents.ClickedEvent;

import android.content.Context;
import android.example.instaevents.R;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ClickedEventAdapter extends PagerAdapter {


//    public static final int[] RES = new int[]{R.drawable.car,R.drawable.choma,R.drawable.zainab,R.drawable.karen,};

    private List<ClickedEventModel> eventInfoData;
    private LayoutInflater layoutInflater;
    private Context context;

    public ClickedEventAdapter(List<ClickedEventModel> eventInfoData, Context context) {
        this.eventInfoData = eventInfoData;
        this.context = context;
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
        TextView eventNameText, dateText, timeText, locationText, hostText, featuringText, moreInfoText;



        imageView = view.findViewById(R.id.image);
        eventNameText = view.findViewById(R.id.idEventName);
        dateText = view.findViewById(R.id.idDate);
        timeText = view.findViewById(R.id.idTime);
        locationText = view.findViewById(R.id.idLocation);
        featuringText = view.findViewById(R.id.idFeaturing);
        moreInfoText = view.findViewById(R.id.idMoreInfo);


        imageView.setImageResource(eventInfoData.get(position).getImage());
        eventNameText.setText(eventInfoData.get(position).getEventName());
        dateText.setText(eventInfoData.get(position).getDate());
        timeText.setText(eventInfoData.get(position).getTime());
        locationText.setText(eventInfoData.get(position).getLocation());
        featuringText.setText(eventInfoData.get(position).getFeaturing());
        moreInfoText.setText(eventInfoData.get(position).getMoreInfo());

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}

