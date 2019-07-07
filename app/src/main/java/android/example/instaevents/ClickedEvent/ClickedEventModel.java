package android.example.instaevents.ClickedEvent;

public class ClickedEventModel {

    private int Image;
    private String EventName;
    private String Date;
    private String Time;
    private String Location;
    private String Featuring;
    private String moreInfo;

    public ClickedEventModel(int image, String eventName, String date, String time, String location, String featuring, String moreInfo) {
        Image = image;
        EventName = eventName;
        Date = date;
        Time = time;
        Location = location;
        Featuring = featuring;
        this.moreInfo = moreInfo;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getFeaturing() {
        return Featuring;
    }

    public void setFeaturing(String featuring) {
        Featuring = featuring;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }
}
