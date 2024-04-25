package matheus.github.manager;

import matheus.github.manager.model.Food;
import matheus.github.manager.model.Meal;

public class MainApp {
     public static void main(String[] args) {
          Food food1 = Food.Builder()
                  .id(10)
                  .name("Teste1")
                  .calorie(128);

          Food food2 = Food.Builder()
                  .id(11)
                  .name("Teste2")
                  .calorie(321);

          Meal meal = Meal.create();

          meal.addFood(food1);
          meal.addFood(food2);

          System.out.println(meal.getCalories());


     }
}
