package kitchen.person;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import kitchen.meals.*;

public class ChefTest{

    @ParameterizedTest
    @CsvSource({
        "'MEAT', 'MEAT', true",
        "'PASTRY', 'PASTRY', true",
        "'MEAT', 'PASTRY', false",
        "'FISH', 'VEGETABLE', false" 
    })
    public void cookMealTest(MealType mealtype, MealType specialty, boolean IsFinished){
        Meal meal = new Meal("meal", mealtype);
        Chef pristiani = new Chef("Pristiani", specialty);
        pristiani.cookMeal(meal);
        assertEquals(IsFinished,meal.isFinished());
    }

    @Test
    public void textualRepresentationTest(){
        Meal steak = new Meal("Steak", MealType.MEAT);
        Chef pristiani = new Chef("Pristiani", MealType.MEAT);
        pristiani.cookMeal(steak);
        assertEquals("Chef Pristiani specializes in MEAT with current wage: 5000", pristiani.toString());
    }
    

    
}