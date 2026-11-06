package kitchen;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;

import kitchen.meals.*;
import kitchen.person.*;

public class KitchenTest{
    @Test
    public void constructorExceptionTest(){
        Chef gordon = new Chef("Gordon Ramsay", MealType.MEAT);
        Chef alain = new Chef("Alain Ducasse", MealType.FISH);
        Chef massimo = new Chef("Massimo Bottura", MealType.PASTRY);
        Chef thomas = new Chef("Thomas Keller", MealType.FISH);
        
        Chef[] chefs = {gordon,alain,massimo,thomas};
        assertThrows(IllegalArgumentException.class, () -> new Kitchen(chefs));
    }

    @Test
    public void cookMealTest(){

        Chef gordon = new Chef("Gordon Ramsay", MealType.MEAT);

        Meal croissant = new Meal("Croissant", MealType.PASTRY);
        Meal steak = new Meal("Steak", MealType.MEAT);

        Meal[] mainCourse = {croissant,steak};
        
        Chef[] michelinChef = {gordon};
        Kitchen Aubergine = new Kitchen(michelinChef);
        Aubergine.cookMeal(mainCourse);
        assertEquals(List.of(steak), Aubergine.getFinishedMeals());
    }
}