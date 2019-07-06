package android.example.instaeventsv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
        eventList.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngoma", "12git th June", "Kasarani"));
        eventList.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngoma", "12th June", "Kasarani"));
        eventList.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngoma", "12th June", "Kasarani"));


        recyclerView = (RecyclerView)findViewById(R.id.parentRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        adapter = new GetStartedAdapter(eventList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void launchMainActivity(View view) {
        //Get the currently signed-in user
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser == null){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
