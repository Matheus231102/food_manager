package matheus.github.manager.interfaces;

import matheus.github.manager.enums.NutrientNameEnum;
import matheus.github.manager.exceptions.NegativeNumberParameterException;
import matheus.github.manager.model.Food;
import matheus.github.manager.model.Meal;

import java.util.List;

public interface MealInterface {
     List<Food> addFood(Food food);
     List<Food> addFoods(List<Food> foods);
     List<Food> removeFoodByName(String name) throws Exception;

     void updateMealInfo();
     void updateProteins();
     void updateCarbohydrates();
     void updateFats();
     void updateCalories();
     void updatePrice();

     Meal getFoodsByNutrient(NutrientNameEnum nutrientName, int minimumNutrientValue, int maximumNutrientValue) throws NegativeNumberParameterException;
     Meal getFoodsByMinimumNutrient(NutrientNameEnum nutrientName, int minimumNutrientValue) throws NegativeNumberParameterException;
     Meal getFoodsByMaximumNutrient(NutrientNameEnum nutrientName, int maximumNutrientValue) throws NegativeNumberParameterException;
}
