package android.example.instaevents.ClickedEvent;

import android.animation.ArgbEvaluator;
import android.example.instaevents.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.zhouwei.blurlibrary.EasyBlur;

import java.util.ArrayList;
import java.util.List;

public class ClickedEventActivity extends AppCompatActivity {

    ViewPager viewPager;
    ClickedEventAdapter clickedEventAdapter;
    List<ClickedEventModel> eventInfoData;
    Integer[]  pics;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ImageView blurredImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicked_event_viewpager);


        blurredImage = (ImageView) findViewById(R.id.activity_bg);
        final int[] RES = new int[]{R.drawable.car,R.drawable.choma,R.drawable.zainab,R.drawable.karen,};

        eventInfoData = new ArrayList<>();
        eventInfoData.add(new ClickedEventModel(R.drawable.car,"The Great RiftValley Circuit", "22nd June", "9:00am to 6:00pm", "RiftValley","Delta", "You better come to this race"));
        eventInfoData.add(new ClickedEventModel(R.drawable.choma, "Choma na Ngoma 2019", "1st June 2019", "6:00pm - 6:00am", "KICC", "Sauti Sol, Nandy, Willy Paul, Hart The Band", "Choma Na Ngoma Festival will be a one of a kind music concert that seeks to celebrate African contemporary music , dance, drink and food. The concert seeks to further showcase some of the key artists who reflect the kind of music appreciated by the Kenyan audiences and played on the station." ));
        eventInfoData.add(new ClickedEventModel(R.drawable.zainab, "Zainab Sule Live", "22nd June 2019", "7:00pm - 11:00pm", "Crooked Q's Rooftop, Westlands", "Null", "Join Nigeria's Queen of Soft Rock, Zainab Sule and some fine Kenyan rock acts in an unstoppable night of beautiful rock music." ));
        eventInfoData.add(new ClickedEventModel(R.drawable.karen, "KCB Karen Masters", "30th June 2019", "8:00am - 6:00pm", "Karen Country Club", "Null", "A distinctly African tournament designed to promote the game of golf in Africa and to support local players in their quest to become world beating golfers.A large South African contingent alongside players from Kenya, Zambia and Zimbabwe and some from off the continent; Brazil, Ireland, England, USA will be represented." ));

        clickedEventAdapter = new ClickedEventAdapter(eventInfoData, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(clickedEventAdapter);
        viewPager.setPadding(40, 0, 40, 0);



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Bitmap source = BitmapFactory.decodeResource(getResources(),RES[position]);
                Bitmap bitmap = EasyBlur.with(getApplicationContext())
                        .bitmap(source)
                        .radius(20)
                        .blur();

                blurredImage.setImageBitmap(bitmap);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    } //SavedInstance


}//AppCompativity

