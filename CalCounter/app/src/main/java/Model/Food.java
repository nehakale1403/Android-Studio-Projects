package Model;

import java.io.Serializable;

public class Food implements Serializable {

    private static final long serialVersionUID = 10L;
    private String foodName;
    private int calories;
    private int foodId;
    private String recordDates;

    //constructor
    public Food(String food, int cals, int id, String date){
        foodName = food;
        calories = cals;
        foodId = id;
        recordDates = date;
    }
    public Food(){

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getRecordDates() {
        return recordDates;
    }

    public void setRecordDates(String recordDates) {
        this.recordDates = recordDates;
    }
}
