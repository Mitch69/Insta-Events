package android.example.viewtrial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

public class GetStartedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<EventDetailsModel> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_started_activity);

        eventList = new ArrayList<>();
        eventList.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngoma", "12th June", "Kasarani"));
        eventList.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngoma", "12th June", "Kasarani"));
        eventList.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngoma", "12th June", "Kasarani"));
        eventList.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngoma", "12th June", "Kasarani"));


        recyclerView = (RecyclerView)findViewById(R.id.parentRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        adapter = new GetStartedAdapter(eventList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

//        String [] days = {"Karura Forest Drive", "20th May 2019", "Karura, BongoMoyo"};
//       for (int i=0; i<days.length; i++){
//           itemsArrayList.add(days[i]);
//       }

    }

}
