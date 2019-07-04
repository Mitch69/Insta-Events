package android.example.instaevents.BrowsePage.AllCategories;

import android.example.instaevents.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class allCategoriesActivity extends AppCompatActivity {

    List<AllCategoriesModel> listCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_categories_recyclerview);

        listCategory = new ArrayList<>();
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "Agriculture"));
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "Outdoors & Adventure"));
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "IT & Tech"));
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "Entertainment"));
        listCategory.add(new AllCategoriesModel(R.drawable.choma, "Animals & Pets"));

        RecyclerView recyclerView= (RecyclerView)findViewById(R.id.allCategoriesRecyclerview);
        AllCategoriesAdapter adapter = new AllCategoriesAdapter(this, listCategory);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);


    }
}
