package android.example.instaevents.Homepage.Adapters;

import android.content.Context;
import android.example.instaevents.Homepage.Models.EventDetailsModel;
import android.example.instaevents.Homepage.Models.HomepageCategoryModel;
import android.example.instaevents.R;
import android.example.instaevents.Retrofit.APIClient;
import android.example.instaevents.Retrofit.ApiInterface;
import android.example.instaevents.Retrofit.ListPojo;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class HomepageVerticalAdapter extends RecyclerView.Adapter<HomepageVerticalAdapter.MyViewHolder> {

    ArrayList<HomepageCategoryModel> data;
    Context context;
    ArrayList<EventDetailsModel> eventDetails = new ArrayList<>();
    ApiInterface apiInterface;


    public HomepageVerticalAdapter(ArrayList<HomepageCategoryModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_vertical_recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ItemName.setText(data.get(position).getCategory());
        holder.ItemDescription.setText(data.get(position).getDescription());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.ChildRV.setLayoutManager(layoutManager);
        holder.ChildRV.setHasFixedSize(true);

//        eventDetails = new ArrayList<>();
//        eventDetails.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngoma", "1th May 2019", "Kasarani" ));
//        eventDetails.add(new EventDetailsModel(R.drawable.choma, "Color Fest", "12th May 2019", "Machakos" ));
//        eventDetails.add(new EventDetailsModel(R.drawable.choma, "Black and Whiteis", "19th May 2019","Embakasi" ));


        final HomepageCardviewAdapter homepageCardviewAdapter = new HomepageCardviewAdapter(eventDetails);
        holder.ChildRV.setAdapter(homepageCardviewAdapter);
        homepageCardviewAdapter.notifyDataSetChanged();


//        apiInterface = APIClient.getClient().create(ApiInterface.class);
//        Call<ListPojo> call = apiInterface.getClickedEventModel();
//
//        call.enqueue(new Callback<ListPojo>() {
//            @Override
//            public void onResponse(Call<ListPojo> call, Response<ListPojo> response) {
//                if(!response.isSuccessful()){
////                    Toast toast=Toast.makeText(getContext(),"Code: " + response.code() ,Toast.LENGTH_SHORT);
////                    toast.show();
//                    Log.i("error",response.toString());
//
//
//                }else {
//
//                    eventDetails = response.body().getEventdetailsdata();
//                    homepageCardviewAdapter.setEventdetailsdata(eventDetails);
//                    homepageCardviewAdapter.notifyDataSetChanged();
//
//                    Log.i("ERROR: Size is " + eventDetails.size(), response.toString());
//                }
//
//            }//onResponse
//
//            @Override
//            public void onFailure(Call<ListPojo> call, Throwable t) {
////                Toast toast=Toast.makeText(getContext(),"Message: " + t.getMessage() ,Toast.LENGTH_SHORT);
////                Toast toast=Toast.makeText(getApplicationContext(),"No internet connection available"  ,Toast.LENGTH_SHORT);
////                toast.show();
//                t.printStackTrace();
//            }
//        });






    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ItemName;
        TextView ItemDescription;
        RecyclerView ChildRV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ItemName = itemView.findViewById(R.id.idHomepageEventCategory);
            ItemDescription = itemView.findViewById(R.id.idDescriptionOfCategory);
            ChildRV = itemView.findViewById(R.id.childRV);
        }
    }
}
