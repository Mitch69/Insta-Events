package android.example.instaevents.Homepage.Adapters;


import android.example.instaevents.Homepage.Models.EventDetailsModel;
import android.example.instaevents.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomepageCardviewAdapter extends RecyclerView.Adapter<HomepageCardviewAdapter.MyViewHolder> {

    private ArrayList<EventDetailsModel> data;

    public HomepageCardviewAdapter(ArrayList<EventDetailsModel> data) {
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
        holder.imageView.setImageResource(data.get(position).getThumbnail());
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
