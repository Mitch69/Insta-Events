package android.example.instaevents.EventsPage.MyEvents;

public class MyEventsModel {
    private int Thumbnail;

    public MyEventsModel(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

}
