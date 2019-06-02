package android.example.instaevents.Adapters;


import android.example.instaevents.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomepageHorizontalAdapter extends RecyclerView.Adapter<HomepageHorizontalAdapter.MyViewHolder> {
    ArrayList<String> arrayList;
    public HomepageHorizontalAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_horizontal_recyclerview,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewEvent.setText(arrayList.get(position));
        holder.textViewDate.setText(arrayList.get(position));
        holder.textViewVenue.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
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
