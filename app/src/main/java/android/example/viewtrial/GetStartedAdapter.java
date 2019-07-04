package android.example.viewtrial;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GetStartedAdapter extends RecyclerView.Adapter<GetStartedAdapter.MyViewHolder> {

    private ArrayList<EventDetailsModel> eventList;

    public GetStartedAdapter(ArrayList<EventDetailsModel> eventList) {
        this.eventList = eventList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.get_started_cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(eventList.get(position).getThumbnail());
        holder.textViewEvent.setText(eventList.get(position).getEventName());
        holder.textViewDate.setText(eventList.get(position).getDate());
        holder.textViewVenue.setText(eventList.get(position).getVenue());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

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

