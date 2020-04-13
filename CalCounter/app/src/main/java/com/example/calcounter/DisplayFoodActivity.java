package com.example.calcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Data.CustomListViewdapter;
import Data.DataBaseHandler;
import Model.Food;
import Util.Utils;

public class DisplayFoodActivity extends AppCompatActivity {

    private DataBaseHandler dba;
    private ArrayList<Food> dbFoods = new ArrayList<>();
    private CustomListViewdapter foodAdapter;
    private ListView listView;
    private Food myFood;
    private TextView totalCals, totalFoods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_food);

        listView = (ListView) findViewById(R.id.list);
        totalCals = (TextView) findViewById(R.id.totalAmountTextView);
        totalFoods= (TextView) findViewById(R.id.totalItemsTextView);

        refreshData();
    }

    private void refreshData() {

        dbFoods.clear();
        dba = new DataBaseHandler(getApplicationContext());

        ArrayList<Food> foodsFromDB = dba.getFoods();

        int calsValue = dba.totalCalories();
        int totalItems = dba.getTotalItems();

        String formattedValue = Utils.formatNumber(calsValue);
        String formattedItems = Utils.formatNumber(totalItems);

        totalCals.setText("Total Calories: " + formattedValue);
        totalFoods.setText("Total Foods: " + formattedItems);

        for(int i=0; i<foodsFromDB.size(); i++){

            String name = foodsFromDB.get(i).getFoodName();
            String dateText = foodsFromDB.get(i).getRecordDates();
            int cals = foodsFromDB.get(i).getCalories();
            int foodId = foodsFromDB.get(i).getFoodId();


            myFood = new Food();
            myFood.setFoodName(name);
            myFood.setCalories(cals);
            myFood.setRecordDates(dateText);
            myFood.setFoodId(foodId);

            dbFoods.add(myFood);

        }

        dba.close();

        //set up adapter

        foodAdapter = new CustomListViewdapter(DisplayFoodActivity.this, R.layout.list_row,dbFoods);
        listView.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();


    }
}
