package com.example.myrecipeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.MyHolder> {
    private Context mContext;
    private List<recipes> mData;
    private ViewGroup viewGroup;

    public  RecipeRecyclerViewAdapter (Context mContext, List<recipes> mData){
        this.mContext = mContext;
        this.mData = mData;
    }







    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
         view = layoutInflater.inflate(R.layout.cardview_recipe,viewGroup,false);
        return  new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int i) {
        MyHolder.recipeTitle.setText(mData.get(i).getRecipeName());
        MyHolder.img_recipe_thumbnail.setImageResource(mData.get(i).getThumbnail());
        MyHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,RecipeActivity.class);

                intent.putExtra("RecipeName",mData.get(i).getRecipeName());
                intent.putExtra("RecipeIngredients",mData.get(i).getRecipeIngredients());
                intent.putExtra("RecipeMethodTitle",mData.get(i).getRecipeMethodTitle());
                intent.putExtra("Recipe",mData.get(i).getRecipe());
                intent.putExtra("Thumbnail",mData.get(i).getThumbnail());

                mContext.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        static TextView recipeTitle;
        static CardView cardView;
        static ImageView img_recipe_thumbnail;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            recipeTitle = (TextView)itemView.findViewById(R.id.recipe_text);
            img_recipe_thumbnail = (ImageView)itemView.findViewById(R.id.recipe_img);
            cardView = (CardView)itemView.findViewById(R.id.card_view_id);
        }
    }
}
