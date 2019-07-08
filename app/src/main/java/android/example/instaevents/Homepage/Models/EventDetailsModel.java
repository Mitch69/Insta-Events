package android.example.instaevents.Homepage.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventDetailsModel {

    @SerializedName("event_poster")
    @Expose
    private int Thumbnail;

    @SerializedName("event_name")
    @Expose
    private String eventName;

    @SerializedName("event_date")
    @Expose
    private String date;

    @SerializedName("event_location")
    @Expose
    private String venue;

    public EventDetailsModel(int thumbnail, String eventName, String date, String venue) {
        Thumbnail = thumbnail;
        this.eventName = eventName;
        this.date = date;
        this.venue = venue;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
