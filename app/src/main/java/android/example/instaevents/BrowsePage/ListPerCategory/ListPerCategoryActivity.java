package android.example.instaevents.BrowsePage.ListPerCategory;

import android.example.instaevents.Homepage.Models.EventDetailsModel;
import android.example.instaevents.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListPerCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ListPerCategoryAdapter adapter;
    List<EventDetailsModel> eventDetailsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_per_category_recyclerview);


        eventDetailsData = new ArrayList<>();
        eventDetailsData.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngomaaa", "12th June 2019", "KICC"));
        eventDetailsData.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngomaaa", "12th June 2019", "KICC"));
        eventDetailsData.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngomaaa", "12th June 2019", "KICC"));
        eventDetailsData.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngomaaa", "12th June 2019", "KICC"));
        eventDetailsData.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngomaaa", "12th June 2019", "KICC"));

        recyclerView = findViewById(R.id.idrv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        adapter = new ListPerCategoryAdapter(this, eventDetailsData);
        recyclerView.setAdapter(adapter);
    }
}
