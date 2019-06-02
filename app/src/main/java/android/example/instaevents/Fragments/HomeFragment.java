package android.example.instaevents.Fragments;

import android.example.instaevents.Adapters.HomepageVerticalAdapter;
import android.example.instaevents.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomepageVerticalAdapter adapter;
    ArrayList<String> itemsArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homepage_parent_recyclerview, container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.parentRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        String[] items = {"Trending", "Music", "Tech", "Agriculture"};
        for (int i = 0; i < items.length; i++) {
            itemsArrayList.add(items[i]);
        }

        adapter = new HomepageVerticalAdapter(itemsArrayList, getActivity());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }
}

