package android.example.instaevents.ClickedEvent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClickedEventModel {

    @SerializedName("event_poster")
    @Expose
    private int Image;

    @SerializedName("event_name")
    @Expose
    private String EventName;

    @SerializedName("event_date")
    @Expose
    private String Date;

    @SerializedName("event_time")
    @Expose
    private String Time;

    @SerializedName("event_location")
    @Expose
    private String Location;

    @SerializedName("event_artists")
    @Expose
    private String Featuring;

    @SerializedName("event_description")
    @Expose
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
