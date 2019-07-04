package android.example.instaevents.BrowsePage.AllCategories;

import android.example.instaevents.Homepage.Adapters.HomepageVerticalAdapter;
import android.example.instaevents.Homepage.Models.HomepageCategoryModel;
import android.example.instaevents.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class BrowseFragment extends Fragment {

    private RecyclerView recyclerView;
    private  AllCategoriesAdapter adapter;
    List<AllCategoriesModel> listCategory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_categories_recyclerview, container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.allCategoriesRecyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        listCategory = new ArrayList<>();
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "Agriculture"));
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "Outdoors & Adventure"));
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "IT & Tech"));
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "Entertainment"));
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "Animals & Pets"));


        adapter = new AllCategoriesAdapter(getActivity(), listCategory);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }


}
