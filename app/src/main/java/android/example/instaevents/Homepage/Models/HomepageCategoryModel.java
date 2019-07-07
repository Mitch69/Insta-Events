package android.example.instaevents.Homepage.Models;

import java.util.ArrayList;

public class HomepageCategoryModel {
    String Category;
    String Description;
    ArrayList<EventDetailsModel> arrayList;

    public HomepageCategoryModel(String category, String description) {
        Category = category;
        Description = description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ArrayList<EventDetailsModel> getArrayList() {
        return arrayList;
    }
}
