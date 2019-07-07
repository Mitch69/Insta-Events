package android.example.instaevents.BrowsePage.ListPerCategory;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.example.instaevents.ClickedEvent.ClickedEventActivity;
import android.example.instaevents.Homepage.Models.EventDetailsModel;
import android.example.instaevents.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.List;

//This class is using the EventDetailsModel located in .Homepage.Models

public class ListPerCategoryAdapter extends RecyclerView.Adapter<ListPerCategoryAdapter.MyViewHolder> {

    private Context context;
    private List<EventDetailsModel> eventDetailsData;


    public ListPerCategoryAdapter(Context context, List<EventDetailsModel> eventDetailsData) {

        this.context = context;
        this.eventDetailsData = eventDetailsData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.list_per_category_cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewNumber.setText("#" + (position + 1));
        holder.textViewEvent.setText(eventDetailsData.get(position).getThumbnail());
        holder.textViewEvent.setText(eventDetailsData.get(position).getEventName());
        holder.textViewDate.setText(eventDetailsData.get(position).getDate());
        holder.textViewVenue.setText(eventDetailsData.get(position).getVenue());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ClickedEventActivity.class);

                //Start the activity
                context.startActivity(intent);

                //Activity Animation
                Animatoo.animateZoom(context);
            }
        });

    }


    @Override
    public int getItemCount() {
        return eventDetailsData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewNumber, textViewEvent, textViewDate, textViewVenue;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumber = itemView.findViewById(R.id.idNumber);
            imageView = itemView.findViewById(R.id.idEventImage);
            textViewEvent = itemView.findViewById(R.id.idEventText);
            textViewDate = itemView.findViewById(R.id.idDateText);
            textViewVenue = itemView.findViewById(R.id.idVenueText);
            cardView= (CardView)itemView.findViewById(R.id.idListPerCategoryCardView);
        }
    }


}
