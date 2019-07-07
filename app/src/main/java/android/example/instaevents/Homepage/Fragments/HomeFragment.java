package android.example.instaevents.Homepage.Fragments;

import android.example.instaevents.Homepage.Adapters.HomepageVerticalAdapter;
import android.example.instaevents.Homepage.Models.HomepageCategoryModel;
import android.example.instaevents.R;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomepageVerticalAdapter adapter;
    ArrayList<HomepageCategoryModel> eventCategory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homepage_parent_recyclerview, container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.parentRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        eventCategory = new ArrayList<>();
        eventCategory.add(new HomepageCategoryModel("Trending", "Things that you may like"));
        eventCategory.add(new HomepageCategoryModel("Agriculture", "Things that you may like"));
        eventCategory.add(new HomepageCategoryModel("IT & Tech", "Things that you may like"));
        eventCategory.add(new HomepageCategoryModel("Entertainment", "Things that you may like"));


        adapter = new HomepageVerticalAdapter(eventCategory, getActivity());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }
}

