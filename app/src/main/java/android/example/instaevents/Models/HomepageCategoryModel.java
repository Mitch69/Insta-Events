package android.example.instaevents.Models;

import java.util.ArrayList;

public class HomepageCategoryModel {
    String homepageCategory;
    ArrayList<EventDetailsModel> arrayList;

    public HomepageCategoryModel(String home) {
    }

    public void setHomepageCategory(String homepageCategory) {
        this.homepageCategory = homepageCategory;
    }

    public String getHomepageCategory() {
        return homepageCategory;
    }

    public ArrayList<EventDetailsModel> getArrayList() {
        return arrayList;
    }
}
