package android.example.instaevents.Homepage.Models;

public class EventDetailsModel {
    private int Thumbnail;
    private String eventName, date, venue;

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
