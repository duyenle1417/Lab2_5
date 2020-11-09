package com.example.lab2_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText_dishname;
    Spinner spinner_thumbnail;
    CheckBox checkBox_promotion;
    Button button_add_dish;
    GridView gridView_dishes;
    ThumbnailAdapter thumbnailAdapter;
    List<Thumbnail> thumbnailList;
    DishAdapter dishAdapter;
    List<Dish> dishList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gán view
        editText_dishname = findViewById(R.id.edit_text_dish_name);
        spinner_thumbnail = findViewById(R.id.spinner_thumbnail);
        checkBox_promotion = findViewById(R.id.checkBox_isPromotion);
        button_add_dish = findViewById(R.id.btn_add_dish);
        gridView_dishes = findViewById(R.id.grid_view_dishes);
        thumbnailList = new ArrayList<>();
        dishList = new ArrayList<>();

        //adpate dữ liệu thumbnail cho spinner
        thumbnailAdapter = new ThumbnailAdapter(this, thumbnailList);
        spinner_thumbnail.setAdapter(thumbnailAdapter);
        AddThumbnail();//thêm dữ liệu để adapte

        //adapte dữ liệu cho gridview dishes
        dishAdapter = new DishAdapter(this,R.layout.gridview_dishes_item, dishList);
        gridView_dishes.setAdapter(dishAdapter);

        //xử lý sự kiện nhấn btn_add dish mới
        button_add_dish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText_dishname.length()>0) {
                    AddNewDish();
                    //khung nhập dữ liệu về default
                    editText_dishname.setText("");
                    spinner_thumbnail.setSelection(0);
                    checkBox_promotion.setChecked(false);
                    Toast.makeText(MainActivity.this, "Added successfully!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Mời bạn nhập tên món ăn.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AddNewDish() {
        String dish_name= editText_dishname.getText().toString();
        Thumbnail thumbnail = Thumbnail.valueOf(spinner_thumbnail.getSelectedItem().toString());
        boolean IsPromotion = checkBox_promotion.isChecked();
        Dish newdish= new Dish();
        newdish.setDish_name(dish_name);
        newdish.setThumbnail(thumbnail);
        newdish.setPromotion(IsPromotion);
        //thêm vào list và báo cho adapter
        dishList.add(newdish);
        dishAdapter.notifyDataSetChanged();
    }

    private void AddThumbnail(){
        thumbnailList.add(Thumbnail.Thumbnail1);
        thumbnailList.add(Thumbnail.Thumbnail2);
        thumbnailList.add(Thumbnail.Thumbnail3);
        thumbnailList.add(Thumbnail.Thumbnail4);
        thumbnailAdapter.notifyDataSetChanged();
    }
}