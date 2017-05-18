package com.example.giorgi.sample_lists;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RVbody extends  RecyclerView.Adapter<RVbody.sightViewHolder>{

    public static class sightViewHolder extends RecyclerView.ViewHolder{

        TextView Name, txt;
        ImageView img;
        LinearLayout items;

        sightViewHolder(View itemView, final OnClickListener c) {
            super(itemView);

            Name = (TextView)itemView.findViewById(R.id.cardtxt);
            img = (ImageView)itemView.findViewById(R.id.cardimg);
            txt = (TextView) itemView.findViewById(R.id.cardname);
            items = (LinearLayout) itemView.findViewById(R.id.itembody);

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

    List<Card> data;

    public RVbody(List<Card> data){ this.data = data; }

    @Override
    public RVbody.sightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_body, parent, false);
        return new RVbody.sightViewHolder(v, click);
    }
    @Override
    public void onBindViewHolder(RVbody.sightViewHolder holder, int position) {
        holder.img.setImageResource(data.get(position).getImg());
        holder.Name.setText(data.get(position).getTxt());
        holder.txt.setText(data.get(position).getName());
    }
    @Override
    public int getItemCount() { return data.size(); }
}
