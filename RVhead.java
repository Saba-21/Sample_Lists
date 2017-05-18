package com.example.giorgi.sample_lists;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RVhead extends RecyclerView.Adapter<RVhead.CityViewHolder> {

    public static class CityViewHolder extends RecyclerView.ViewHolder{

        TextView Name;
        ImageView img;
        LinearLayout items;

        CityViewHolder(View itemView, final OnClickListener c) {
            super(itemView);

            Name = (TextView)itemView.findViewById(R.id.txt);
            img = (ImageView)itemView.findViewById(R.id.img);
            items = (LinearLayout) itemView.findViewById(R.id.itemhead);

            items.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c.onClick(getLayoutPosition());
                }
            });
        }
    }
    OnClickListener click;

    public void setClick(OnClickListener cc){ click = cc; }

    List<City> data;

    public RVhead(List<City> data){ this.data = data; }

    @Override
    public RVhead.CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_head, parent, false);
        return new CityViewHolder(v, click);
    }
    @Override
    public void onBindViewHolder(RVhead.CityViewHolder holder, int position) {
        holder.img.setImageResource(data.get(position).getImg());
        holder.Name.setText(data.get(position).getTxt());
    }
    @Override
    public int getItemCount() { return data.size(); }

}
