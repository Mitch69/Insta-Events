package android.example.instaevents.Retrofit;


import android.example.instaevents.Create.CreatePojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("events")
    Call<ListPojo> getClickedEventModel();

    @GET("events")
    Call<ListPojo> getEventDetailsModel();

    @POST("events")
    @FormUrlEncoded
    Call<CreatePojo> savePost(
            @Field("category") String categoryID,
            @Field("event_name") String eventName,
            @Field("event_description") String eventDescription,
            @Field("event_location") String eventLocation,
            @Field("event_time") String eventTime,
            @Field("event_date") String eventDate,
            @Field("event_artists") String eventArtists);


}
