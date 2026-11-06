package kitchen;

import kitchen.meals.*;
import kitchen.person.*;

import java.util.ArrayList;

public class Kitchen{
    private Chef[] chefs;
    private ArrayList<Meal> finishedMeals;

    public ArrayList<Meal> getFinishedMeals(){
        return this.finishedMeals;
    }

    public Kitchen(Chef[] chefs){
        if(chefs.length > 3){
           throw new IllegalArgumentException("Invalid number of chefs"); 
        }

        this.chefs = chefs;
        this.finishedMeals = new ArrayList<Meal>();
    }

    public void cookMeal(Meal[] mealsToBeCooked){
        ArrayList<Meal> cookable = getCookableMeals(mealsToBeCooked);

        for(int j = 0; j < cookable.size(); j++){
            for(int i = 0; i < this.chefs.length; i++){
                if(this.chefs[i].canCookMeal(cookable.get(j))){
                    chefs[i].cookMeal(cookable.get(j));
                    break;
                }
            }
            this.finishedMeals.add(cookable.get(j));
        }
    }

    private ArrayList<Meal> getCookableMeals(Meal[] mealsToBeCooked){

        ArrayList<Meal> cookable = new ArrayList<Meal>();
        int mealLength = mealsToBeCooked.length;

        for(int i = 0; i < this.chefs.length; i++){
            for(int j = 0; j < mealLength; j++){
                if(this.chefs[i].canCookMeal(mealsToBeCooked[j])){
                    if(!(cookable.contains(mealsToBeCooked[j]))){
                        cookable.add(mealsToBeCooked[j]);
                    }
                }
            }
        }
        return cookable; 
    }
}