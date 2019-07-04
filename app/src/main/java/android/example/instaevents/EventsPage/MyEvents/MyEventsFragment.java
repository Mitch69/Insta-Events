package android.example.instaevents.EventsPage.MyEvents;

import android.example.instaevents.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyEventsFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyEventsAdapter adapter;
    List<MyEventsModel> eventDetails;

    View view;

    public MyEventsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.myevents_tab_recyclerview, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.allCategoriesRecyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        eventDetails = new ArrayList<>();
        eventDetails.add(new MyEventsModel(R.drawable.choma));
        eventDetails.add(new MyEventsModel(R.drawable.choma));
        eventDetails.add(new MyEventsModel(R.drawable.choma));
        eventDetails.add(new MyEventsModel(R.drawable.choma));
        eventDetails.add(new MyEventsModel(R.drawable.choma));
        eventDetails.add(new MyEventsModel(R.drawable.choma));
        eventDetails.add(new MyEventsModel(R.drawable.choma));
        eventDetails.add(new MyEventsModel(R.drawable.choma));
        eventDetails.add(new MyEventsModel(R.drawable.choma));
        eventDetails.add(new MyEventsModel(R.drawable.choma));
        eventDetails.add(new MyEventsModel(R.drawable.choma));
        eventDetails.add(new MyEventsModel(R.drawable.choma));


        adapter = new MyEventsAdapter(getActivity(), eventDetails);
        recyclerView.setAdapter(adapter);

        return view;
    }
}

