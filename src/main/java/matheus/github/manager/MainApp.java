package matheus.github.manager;

import matheus.github.manager.enums.NutrientNameEnum;
import matheus.github.manager.exceptions.NegativeNumberParameterException;
import matheus.github.manager.model.Food;
import matheus.github.manager.model.Meal;

import java.util.List;

public class MainApp {
     public static void main(String[] args) throws NegativeNumberParameterException {
          Food food1 = Food.create()
                  .id(1)
                  .name("Maçã")
                  .calorie(52)
                  .protein(10)
                  .fat(1)
                  .carbohydrate(14)
                  .price(2.5);

          Food food2 = Food.create()
                  .id(2)
                  .name("Arroz")
                  .calorie(129)
                  .protein(2)
                  .fat(9)
                  .carbohydrate(28)
                  .price(4.0);

          Food food3 = Food.create()
                  .id(3)
                  .name("Frango")
                  .calorie(165)
                  .protein(31)
                  .fat(3)
                  .carbohydrate(0)
                  .price(8.0);

          Food food4 = Food.create()
                  .id(4)
                  .name("Batata")
                  .calorie(77)
                  .protein(2)
                  .fat(0)
                  .carbohydrate(17)
                  .price(3.0);

          Meal meal2 = Meal.create();
          meal2.addFoods(List.of(food1, food2, food3, food4));
          Meal mealFiltered = meal2.getFoodsByNutrient(NutrientNameEnum.CARBOHYDRATE, 10, 20);
     }
}
