package android.example.instaevents.BrowsePage.AllCategories;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.example.instaevents.BrowsePage.ListPerCategory.ListPerCategoryActivity;
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

public class AllCategoriesAdapter extends RecyclerView.Adapter <AllCategoriesAdapter.MyViewHolder> {

    private Context context;
    private List<AllCategoriesModel> data;

    public AllCategoriesAdapter(Context context, List<AllCategoriesModel> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.all_categories_cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.categoryText.setText(data.get(position).getCategory());
        holder.categoryImage.setImageResource(data.get(position).getThumbnail());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ListPerCategoryActivity.class);

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

        TextView categoryText;
        ImageView categoryImage;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);

            categoryText = (TextView)itemView.findViewById(R.id.category);
            categoryImage = (ImageView)itemView.findViewById(R.id.categoryimage);
            cardView= (CardView)itemView.findViewById(R.id.idCardview);

        }
    }
}

