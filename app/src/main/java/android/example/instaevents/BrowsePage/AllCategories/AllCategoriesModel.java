package android.example.instaevents.BrowsePage.AllCategories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllCategoriesModel {

    @SerializedName("category_poster")
    @Expose
    private int Thumbnail;

    @SerializedName("category")
    @Expose
    private String Category;

    public AllCategoriesModel() {
    }

    public AllCategoriesModel(int thumbnail, String category) {
        Thumbnail = thumbnail;
        Category = category;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}

