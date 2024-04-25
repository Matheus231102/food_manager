package matheus.github.manager.interfaces;

import matheus.github.manager.model.Food;

import java.util.List;

public interface MealInterface {
     List<Food> addFood(Food food);
     List<Food> addFoods(List<Food> foods);
     List<Food> removeFoodByName(String name) throws Exception;
     void updateInfo();
     void updateProteins();
     void updateCarbohydrates();
     void updateFats();
     void updateCalories();
     void updatePrice();
}
