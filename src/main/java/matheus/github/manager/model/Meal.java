package matheus.github.manager.model;

import lombok.Getter;
import lombok.Setter;
import matheus.github.manager.enums.NutrientNameEnum;
import matheus.github.manager.exceptions.ImpossibleDeacreseException;
import matheus.github.manager.exceptions.NegativeNumberParameterException;
import matheus.github.manager.interfaces.MealInterface;
import matheus.github.manager.validate.isNumberPositiveValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Meal implements MealInterface {
     private List<Food> foods;
     private int foodsLength;

     private String name;
     private int mealCalories;
     private int mealProteins;
     private int mealFats;
     private int mealCarbohydrate;
     private double mealPrice;

     public static Meal create() {
          return new Meal();
     }

     public Meal name(String name) {
          setName(name);
          return this;
     }

     private Meal() {
          this.foods = new ArrayList<>();
          this.updateMealInfo();
     }

     @Override
     public Meal getFoodsByNutrient(NutrientNameEnum nutrientName, int minimumNutrientValue, int maximumNutrientValue) throws NegativeNumberParameterException {
          isNumberPositiveValidation.validate(minimumNutrientValue);
          isNumberPositiveValidation.validate(maximumNutrientValue);

          Meal resultMeal = new Meal();
          this.foods.stream()
                  .filter(food -> {
                       int nutrientValue = food.getNutrientValueByName(nutrientName);
                       return nutrientValue >= minimumNutrientValue && nutrientValue <= maximumNutrientValue;
                  })
                  .peek(filteredFood -> resultMeal.addFood(filteredFood))
                  .toList();

          return resultMeal;
     }

     @Override
     public Meal getFoodsByMinimumNutrient(NutrientNameEnum nutrientName, int minimumNutrientValue) throws NegativeNumberParameterException {
          isNumberPositiveValidation.validate(minimumNutrientValue);

          Meal resultMeal = new Meal();
          this.foods.stream()
                  .filter(food -> {
                       int nutrientValue = food.getNutrientValueByName(nutrientName);
                       return nutrientValue >= minimumNutrientValue;
                  })
                  .peek(filteredFood -> resultMeal.addFood(filteredFood))
                  .toList();

          return resultMeal;
     }

     @Override
     public Meal getFoodsByMaximumNutrient(NutrientNameEnum nutrientName, int maximumNutrientValue) throws NegativeNumberParameterException {
          isNumberPositiveValidation.validate(maximumNutrientValue);

          Meal resultMeal = new Meal();
          this.foods.stream()
                  .filter(food -> {
                       int nutrientValue = food.getNutrientValueByName(nutrientName);
                       return nutrientValue <= maximumNutrientValue;
                  })
                  .peek(filteredFood -> resultMeal.addFood(filteredFood))
                  .toList();

          return resultMeal;
     }

     @Override
     public List<Food> addFood(Food food) {
          this.foods.add(food);
          increaseLenght();
          updateMealInfo();
          return this.foods;
     }

     @Override
     public List<Food> addFoods(List<Food> foods) {
          for (Food food : foods) {
               this.foods.add(food);
               increaseLenght();
          }
          updateMealInfo();
          return this.foods;
     }

     @Override
     public List<Food> removeFoodByName(String name) throws Exception {
          List<Food> deletedFoods = foods.stream()
                  .filter(food -> food.getName().equals(name))
                  .collect(Collectors.toList());

          deacreseLength(deletedFoods.size());

          foods = foods.stream()
                  .filter(food -> !food.getName().equals(name))
                  .collect(Collectors.toList());

          return deletedFoods;
     }

     @Override
     public void updateProteins() {
          this.mealProteins = getFoods().stream()
                  .mapToInt(Food::getFoodProtein)
                  .sum();
     }

     @Override
     public void updateCarbohydrates() {
          this.mealCarbohydrate = getFoods().stream()
                  .mapToInt(Food::getFoodCarbohydrate)
                  .sum();
     }

     @Override
     public void updateFats() {
          this.mealFats = getFoods().stream()
                  .mapToInt(Food::getFoodFat)
                  .sum();
     }

     @Override
     public void updateCalories() {
          this.mealCalories = getFoods().stream()
                  .mapToInt(Food::getFoodCalorie)
                  .sum();
     }

     @Override
     public void updatePrice() {
          this.mealPrice = getFoods().stream()
                  .mapToDouble(Food::getFoodPrice)
                  .sum();
     }


     @Override
     public void updateMealInfo() {
          updateCalories();
          updateProteins();
          updateCarbohydrates();
          updateFats();
          updatePrice();
     }

     public int getMealCalories() {
          updateCalories();
          return mealCalories;
     }

     public int getMealProteins() {
          updateProteins();
          return mealProteins;
     }

     public int getMealFats() {
          updateFats();
          return mealFats;
     }

     public int getMealCarbohydrate() {
          updateCarbohydrates();
          return mealCarbohydrate;
     }

     public double getMealPrice() {
          updatePrice();
          return mealPrice;
     }

     public int increaseLenght() {
          return ++this.foodsLength;
     }

     public int deacreseLength() throws Exception {
          if (this.foodsLength == 0) {
               throw new ImpossibleDeacreseException();
          }
          return --this.foodsLength;
     }

     public int deacreseLength(int times) throws Exception {
          if (times > this.foodsLength) {
               throw new ImpossibleDeacreseException();
          }
          for (int i = 0; i < times; i++) {
               --this.foodsLength;
          }
          return this.foodsLength;
     }

     public void seeMeal(boolean info) {
          if (info) {
               for (Food food : getFoods()) {
                    System.out.println("-----------------");
                    food.seeFood();
                    System.out.println("-----------------");
               }
          } else {
               System.out.print("|");
               for (Food food : getFoods()) {
                    System.out.print(" " + food.getName());
                    System.out.print(" |");
               }
          }
     }
}
