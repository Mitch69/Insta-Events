package android.example.instaevents.Homepage.Adapters;


import android.content.Context;
import android.example.instaevents.Homepage.Models.EventDetailsModel;
import android.example.instaevents.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class HomepageCardviewAdapter extends RecyclerView.Adapter<HomepageCardviewAdapter.MyViewHolder> {

    private ArrayList<EventDetailsModel> data;
    private Context context;

    public HomepageCardviewAdapter(ArrayList<EventDetailsModel> data) {
        this.data = data;
    }

    public HomepageCardviewAdapter(Context context) {
        this.context = context;
    }

    public void setEventdetailsdata(List<EventDetailsModel> detailsModels) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_cardview,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        EventDetailsModel eventDetailsModel=data.get(position);
        Glide.with(context)
                .load(eventDetailsModel.getThumbnail())
                .into(holder.imageView);

        holder.textViewEvent.setText(data.get(position).getEventName());
        holder.textViewDate.setText(data.get(position).getDate());
        holder.textViewVenue.setText(data.get(position).getVenue());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewEvent;
        TextView textViewDate;
        TextView textViewVenue;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.idEventImage);
            textViewEvent = itemView.findViewById(R.id.idEventText);
            textViewDate = itemView.findViewById(R.id.idDateText);
            textViewVenue = itemView.findViewById(R.id.idVenueText);
        }
    }


}
