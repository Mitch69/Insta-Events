package android.example.instaevents.BrowsePage.AllCategories;

public class AllCategoriesModel {

    private int Thumbnail;
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

