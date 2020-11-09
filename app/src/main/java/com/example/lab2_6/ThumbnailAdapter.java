package com.example.lab2_6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ThumbnailAdapter extends BaseAdapter {

    Context context;
    List<Thumbnail> thumbnailList;
    LayoutInflater inflater;

    ThumbnailAdapter(Context context, List<Thumbnail> thumbnailList){
        this.context= context;
        this.thumbnailList= thumbnailList;
    }

    @Override
    public int getCount() {
        return Math.max(thumbnailList.size(), 0);
    }

    @Override
    public Object getItem(int position) {
        return thumbnailList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //dấu img đi khi không dropdown
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return CustomView(position, convertView, parent,false);
    }

    //hiện img khi dropdown
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return CustomView(position, convertView, parent,true);
    }

    //xử lý inflate layout, adapter dữ liệu và hiện img thumbnail
    public View CustomView(int position, View convertView, ViewGroup parent, boolean IsDropDown){
        ViewHolder holder = new ViewHolder();
        if(convertView == null){//chưa có view nào
            inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.spinner_thumbnail_item, parent, false);
            holder.textView_name_thumbnail= convertView.findViewById(R.id.spinner_thumbnail_name_item);
            holder.imageView_thumbnail_img= convertView.findViewById(R.id.spinner_thumbnail_img_item);
            convertView.setTag(holder);
        }
        else
            holder= (ViewHolder) convertView.getTag();

        holder.textView_name_thumbnail.setText(thumbnailList.get(position).getName());
        holder.imageView_thumbnail_img.setImageResource(thumbnailList.get(position).getImg());

        if(IsDropDown){
            //hiện img
            holder.imageView_thumbnail_img.setVisibility(View.VISIBLE);
        }
        else
            //bỏ img
            holder.imageView_thumbnail_img.setVisibility(View.GONE);
        return convertView;
    }

    //holder để bớt thời gian findView
    class ViewHolder{
        TextView textView_name_thumbnail;
        ImageView imageView_thumbnail_img;
    }
}
