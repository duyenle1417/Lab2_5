package com.example.lab2_6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DishAdapter  extends ArrayAdapter<Dish> {

    LayoutInflater inflater;
    public DishAdapter(@NonNull Context context, int resource, @NonNull List<Dish> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder= new ViewHolder();
        if(convertView==null){
            inflater= LayoutInflater.from(getContext());
            convertView= inflater.inflate(R.layout.gridview_dishes_item, parent, false);
            holder.imageView_thumbnail= convertView.findViewById(R.id.gridview_dish_thumbnail_img_item);
            holder.textView_dish_name= convertView.findViewById(R.id.gridview_dish_name_tv_item);
            holder.imageView_promotion= convertView.findViewById(R.id.gridview_dish_promotion_item);
            convertView.setTag(holder);
        }
        else
            holder= (ViewHolder) convertView.getTag();

        //set các view
        holder.imageView_thumbnail.setImageResource(getItem(position).getThumbnail().getImg());
        holder.textView_dish_name.setText(getItem(position).getDish_name());
        holder.textView_dish_name.setSelected(true);//hiện marquee chữ = chạy chữ
        if(getItem(position).isPromotion()){
            holder.imageView_promotion.setVisibility(View.VISIBLE);
        }
        else
            holder.imageView_promotion.setVisibility(View.GONE);

        return convertView;
    }

    class ViewHolder{
        CustomImageView imageView_thumbnail;
        TextView textView_dish_name;
        ImageView imageView_promotion;
    }
}
