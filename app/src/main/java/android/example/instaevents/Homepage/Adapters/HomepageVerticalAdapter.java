package android.example.instaevents.Homepage.Adapters;

import android.content.Context;
import android.example.instaevents.Homepage.Models.EventDetailsModel;
import android.example.instaevents.Homepage.Models.HomepageCategoryModel;
import android.example.instaevents.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HomepageVerticalAdapter extends RecyclerView.Adapter<HomepageVerticalAdapter.MyViewHolder> {

    ArrayList<HomepageCategoryModel> data;
    Context context;
    ArrayList<EventDetailsModel> eventDetails;


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

        eventDetails = new ArrayList<>();
        eventDetails.add(new EventDetailsModel(R.drawable.choma, "Choma na Ngoma", "1th May 2019", "Kasarani" ));
        eventDetails.add(new EventDetailsModel(R.drawable.choma, "Color Fest", "12th May 2019", "Machakos" ));
        eventDetails.add(new EventDetailsModel(R.drawable.choma, "Black and Whiteis", "19th May 2019","Embakasi" ));


        HomepageCardviewAdapter homepageCardviewAdapter = new HomepageCardviewAdapter(eventDetails);
        holder.ChildRV.setAdapter(homepageCardviewAdapter);
        homepageCardviewAdapter.notifyDataSetChanged();
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
