package android.example.instaevents.ClickedEvent;

import android.example.instaevents.R;
import android.example.instaevents.Retrofit.APIClient;
import android.example.instaevents.Retrofit.ApiInterface;
import android.example.instaevents.Retrofit.ListPojo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhouwei.blurlibrary.EasyBlur;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClickedEventActivity extends AppCompatActivity {

    ViewPager viewPager;
    ClickedEventAdapter clickedEventAdapter;
    List<ClickedEventModel> eventInfoData = new ArrayList<>();
    Integer[]  pics;
    ImageView blurredImage;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicked_event_viewpager);


        blurredImage = (ImageView) findViewById(R.id.activity_bg);
        final int[] RES = new int[]{R.drawable.car,R.drawable.choma,R.drawable.zainab,R.drawable.karen,};


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
//                Bitmap source = BitmapFactory.decodeResource(getResources(),RES[position]);
//                Bitmap bitmap = EasyBlur.with(getApplicationContext())
//                        .bitmap(source)
//                        .radius(20)
//                        .blur();
//
//                blurredImage.setImageBitmap(bitmap);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        // Retrofit starts here
        apiInterface = APIClient.getClient().create(ApiInterface.class);
        Call<ListPojo> call = apiInterface.getClickedEventModel();

        call.enqueue(new Callback<ListPojo>() {
            @Override
            public void onResponse(Call<ListPojo> call, Response<ListPojo> response) {
                if(!response.isSuccessful()){
                    Toast toast=Toast.makeText(getApplicationContext(),"Code: " + response.code() ,Toast.LENGTH_SHORT);
                    toast.show();
                    Log.i("error",response.toString());


                }else {

                    eventInfoData = response.body().getData();
                    clickedEventAdapter.setData(eventInfoData);
                    clickedEventAdapter.notifyDataSetChanged();

                    Log.i("ERROR: Size is " + eventInfoData.size(), response.toString());
                }

            }//onResponse

            @Override
            public void onFailure(Call<ListPojo> call, Throwable t) {
                Toast toast=Toast.makeText(getApplicationContext(),"Message: " + t.getMessage() ,Toast.LENGTH_SHORT);
//                Toast toast=Toast.makeText(getApplicationContext(),"No internet connection available"  ,Toast.LENGTH_SHORT);
                toast.show();
                t.printStackTrace();
            }
        });




    } //onCreate


}//AppCompativity

