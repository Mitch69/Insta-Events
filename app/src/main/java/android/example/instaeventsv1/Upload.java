package android.example.instaeventsv1;

public class Upload {

    private String mName;
    private String mImageUrl;

    public Upload (){
        //empty constructor needed
    }

    public Upload(String name, String imageUrl){
            //.trim() removes the empty spaces at the beginning and end of the string
        if (name.trim().equals("")){
            name = "No name";
        }

        mName = name;
        mImageUrl = imageUrl;
    }


    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
