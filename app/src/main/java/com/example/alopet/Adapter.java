package com.example.alopet;

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

import com.example.alopet.Model.Articles;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
Context context;
List<Articles> articles;
    public Adapter(Context context, List<Articles> articles) {
        this.context = context;
        this.articles = articles;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Articles a=articles.get(position);
        holder.tvTitle.setText(a.getTitle());
        holder.tvDate.setText(a.getPublishedAt());
        String imageUrl=a.getUrlToImage();
        String url=a.getUrl();
        Picasso.get().load(imageUrl).into(holder.imageView);

        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(context,Detailed.class);
                intent.putExtra("title",a.getTitle());
                intent.putExtra("source",a.getSource().getName());
                intent.putExtra("time",a.getPublishedAt());
                intent.putExtra("desc",a.getDescription());
                intent.putExtra("imageUrl",a.getUrlToImage());
                intent.putExtra("url",a.getUrl());
                context.startActivity(intent);

            }


        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,tvSource,tvDate;
        ImageView imageView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvDate=itemView.findViewById(R.id.tvDate);
            imageView=itemView.findViewById(R.id.image);
            cardView=itemView.findViewById(R.id.cardView);



        }
    }
}

