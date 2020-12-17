package com.example.day03_01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03_01.Bean.NewsBean;
import com.example.day03_01.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<NewsBean.NewsDTO> list;
    private TextView tvText;

    public Adapter(Context context, ArrayList<NewsBean.NewsDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tv_text.setText(list.get(position).getTile());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   class ViewHolder extends RecyclerView.ViewHolder{

       private final TextView tv_text;

       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           tv_text = itemView.findViewById(R.id.tv_text);
       }
   }
}
