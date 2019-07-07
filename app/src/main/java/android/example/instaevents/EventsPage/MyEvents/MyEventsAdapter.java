package android.example.instaevents.EventsPage.MyEvents;

import android.content.Context;
import android.content.Intent;
import android.example.instaevents.ClickedEvent.ClickedEventActivity;
import android.example.instaevents.R;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.List;

public class MyEventsAdapter extends RecyclerView.Adapter <MyEventsAdapter.MyViewHolder> {

    private Context context;
    private List<MyEventsModel> data;

    public MyEventsAdapter(Context context, List<MyEventsModel> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.myevents_tab_cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(data.get(position).getThumbnail());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ClickedEventActivity.class);

                //Start the activity
                v.getContext().startActivity(intent);

                //Activity Animation
                Animatoo.animateZoom(v.getContext());
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.idEventImage);
            cardView= (CardView)itemView.findViewById(R.id.idTabCardview);

        }
    }

}

