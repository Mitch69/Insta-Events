package android.example.instaevents.BrowsePage.AllCategories;

import android.example.instaevents.Homepage.Adapters.HomepageVerticalAdapter;
import android.example.instaevents.Homepage.Models.HomepageCategoryModel;
import android.example.instaevents.R;
import android.example.instaevents.Retrofit.APIClient;
import android.example.instaevents.Retrofit.ApiInterface;
import android.example.instaevents.Retrofit.ListPojo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrowseFragment extends Fragment {

    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private  AllCategoriesAdapter adapter;
    List<AllCategoriesModel> listCategory = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_categories_recyclerview, container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.allCategoriesRecyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        adapter = new AllCategoriesAdapter(getActivity(), listCategory);
        recyclerView.setAdapter(adapter);

        listCategory = new ArrayList<>();
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "Agriculture"));
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "Outdoors & Adventure"));
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "IT & Tech"));
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "Entertainment"));
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "Animals & Pets"));


        return view;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//
//
//
//    }
}
