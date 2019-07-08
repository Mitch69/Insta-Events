package android.example.instaevents.Retrofit;

import android.example.instaevents.BrowsePage.AllCategories.AllCategoriesModel;
import android.example.instaevents.ClickedEvent.ClickedEventModel;
import android.example.instaevents.Homepage.Models.EventDetailsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListPojo {
    @SerializedName("data")
    @Expose
    private List<ClickedEventModel> data = null;



    @SerializedName("eventdetailsdata")
    @Expose
    private ArrayList<EventDetailsModel> eventdetailsdata = null;


    public List<ClickedEventModel> getData() {
        return data;
    }

    public void setData(List<ClickedEventModel> data) {
        this.data = data;
    }




    public ArrayList<EventDetailsModel> getEventdetailsdata() {
        return eventdetailsdata;
    }

    public void setEventdetailsdata(ArrayList<EventDetailsModel> eventdetailsdata) {
        this.eventdetailsdata = eventdetailsdata;
    }
}
