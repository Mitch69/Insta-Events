package android.example.instaevents.Adapters;

import android.content.Context;
import android.example.instaevents.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HomepageVerticalAdapter extends RecyclerView.Adapter<HomepageVerticalAdapter.MyViewHolder> {

    ArrayList<String> HomepageArrayList;
    Context context;
    ArrayList<String> daysArrayList = new ArrayList<>();


    public HomepageVerticalAdapter(ArrayList<String> HomepageArrayList, Context context) {
        this.HomepageArrayList = HomepageArrayList;
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
        holder.ItemName.setText(HomepageArrayList.get(position));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.ChildRV.setLayoutManager(layoutManager);
        holder.ChildRV.setHasFixedSize(true);
        daysArrayList.clear();
        String[] days = {"Karura Forest Drive", "20th May 2019", "Karura, BongoMoyo"};
        for (int i=0; i<days.length; i++){
            daysArrayList.add(days[i]);
        }

        HomepageHorizontalAdapter homepageHorizontalAdapter = new HomepageHorizontalAdapter(daysArrayList);
        holder.ChildRV.setAdapter(homepageHorizontalAdapter);
        homepageHorizontalAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return HomepageArrayList.size();
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
