package android.example.instaevents;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ViewPager viewPager;
    android.example.instaevents.Adapter adapter;
    List<android.example.instaevents.Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        models = new ArrayList<>();
        models.add(new android.example.instaevents.Model(R.drawable.image1, "Brochure", "Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));
        models.add(new android.example.instaevents.Model(R.drawable.image2, "Sticker", "Sticker is a type of label: a piece of printed paper, plastic, vinyl, or other material with pressure sensitive adhesive on one side"));
        models.add(new android.example.instaevents.Model(R.drawable.image3, "Poster", "Poster is any piece of printed paper designed to be attached to a wall or vertical surface."));
        models.add(new android.example.instaevents.Model(R.drawable.image4, "Namecard", "Business cards are cards bearing business information about a company or individual."));

        adapter = new android.example.instaevents.Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);
    }

    public void btnSettings_onclick(View view) {
        Intent intent = new Intent(this,SettingsActivity.class);
        startActivity(intent);
        finish();
    }
}
