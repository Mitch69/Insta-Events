package android.example.instaevents.Create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreatePojo {

    @SerializedName("event_id")
    @Expose
    private Integer eventId;

    @SerializedName("category")
    @Expose
    private String categoryId;

    @SerializedName("event_name")
    @Expose
    private String eventName;

    @SerializedName("event_description")
    @Expose
    private String eventDescription;

    @SerializedName("event_location")
    @Expose
    private String eventLocation;

    @SerializedName("event_date")
    @Expose
    private String eventDate;


    private String eventHost;

    @SerializedName("event_time")
    @Expose
    private String eventTime;

    @SerializedName("event_artists")
    @Expose
    private String eventArtists;

    @SerializedName("event_poster")
    @Expose
    private Object eventPoster;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventHost() {
        return eventHost;
    }

    public void setEventHost(String eventHost) {
        this.eventHost = eventHost;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventArtists() {
        return eventArtists;
    }

    public void setEventArtists(String eventArtists) {
        this.eventArtists = eventArtists;
    }

    public Object getEventPoster() {
        return eventPoster;
    }

    public void setEventPoster(Object eventPoster) {
        this.eventPoster = eventPoster;
    }

}
