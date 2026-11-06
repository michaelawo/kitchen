package kitchen.person;
import kitchen.meals.*;
public class Chef{
    private final String name;
    private final MealType specialty;
    private int finishedMeals;
    private static final int payPerFinishedMeals = 5000;

    public Chef(String name, MealType specialty){
        if(name == null || name.isEmpty() || specialty == null){
            throw new IllegalArgumentException("Invalid name or specialty");
        }

        this.name = name;
        this.specialty = specialty;
        this.finishedMeals = 0;
    }

    public void cookMeal(Meal meal){
        if (meal != null && meal.getType() == this.specialty){
            meal.setFinished(true);
            this.finishedMeals += 1;
        }
    }

    public boolean canCookMeal(Meal meal){
        if (meal.getType() == this.specialty){
            return true;
        }
        return false;
    }

    private int getWage(){
        int totalWage = this.payPerFinishedMeals * this.finishedMeals;
        return totalWage;
    }

    @Override
    public String toString() {
        return "Chef " + this.name + " specializes in " + this.specialty + " with current wage: " + this.getWage();
    }

}