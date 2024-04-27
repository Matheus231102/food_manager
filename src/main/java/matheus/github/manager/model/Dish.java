package matheus.github.manager.model;

import lombok.Getter;
import lombok.Setter;
import matheus.github.manager.exceptions.ImpossibleDeacreseException;
import matheus.github.manager.interfaces.DishInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Dish implements DishInterface {
     private List<Meal> meals;
     private int mealsLength;

     private String name;
     private int dishCalories;
     private int dishProteins;
     private int dishFats;
     private int dishCarbohydrate;
     private double dishPrice;

     public static Dish create() {
          return new Dish();
     }

     private Dish() {
          meals = new ArrayList<>();
          updateDishInfo();
     }



     @Override
     public List<Meal> addMeal(Meal meal) {
          getMeals().add(meal);
          increaseLenght();
          updateDishInfo();
          return getMeals();
     }

     @Override
     public List<Meal> addMeals(List<Meal> meals) {
          for (Meal meal : meals) {
               this.meals.add(meal);
               increaseLenght();
          }
          updateDishInfo();
          return this.meals;
     }

     @Override
     public List<Meal> removeMealByName(String name) throws Exception {
          List<Meal> deletedMeals = meals.stream()
                  .filter(meal -> meal.getName().equals(name))
                  .collect(Collectors.toList());

          deacreseLength(deletedMeals.size());

          meals = meals.stream()
                  .filter(meal -> !meal.getName().equals(name))
                  .collect(Collectors.toList());

          return deletedMeals;
     }

     @Override
     public void updateDishInfo() {
          updateCalories();
          updateProteins();
          updateCarbohydrates();
          updateFats();
          updatePrice();
     }

     public void updatePrice() {
          this.dishProteins = getMeals().stream()
                  .mapToInt(Meal::getMealProteins)
                  .sum();
     }

     public void updateFats() {
          this.dishFats = getMeals().stream()
                  .mapToInt(Meal::getMealFats)
                  .sum();
     }

     public void updateCarbohydrates() {
          this.dishCarbohydrate = getMeals().stream()
                  .mapToInt(Meal::getMealCarbohydrate)
                  .sum();
     }

     public void updateProteins() {
          this.dishProteins = getMeals().stream()
                  .mapToInt(Meal::getMealProteins)
                  .sum();
     }

     public void updateCalories() {
          this.dishCalories = getMeals().stream()
                  .mapToInt(Meal::getMealCalories)
                  .sum();
     }

     public int getMealCalories() {
          updateCalories();
          return dishCalories;
     }

     public int getMealProteins() {
          updateProteins();
          return dishProteins;
     }

     public int getMealFats() {
          updateFats();
          return dishFats;
     }

     public int getMealCarbohydrate() {
          updateCarbohydrates();
          return dishCarbohydrate;
     }

     public double getMealPrice() {
          updatePrice();
          return dishPrice;
     }

     public int increaseLenght() {
          return ++this.mealsLength;
     }

     public int deacreseLength() throws Exception {
          if (getMealsLength() == 0) {
               throw new ImpossibleDeacreseException();
          }
          return --this.mealsLength;
     }

     public int deacreseLength(int times) throws Exception {
          if (times > this.mealsLength) {
               throw new ImpossibleDeacreseException();
          }
          for (int i = 0; i < times; i++) {
               --this.mealsLength;
          }
          return this.mealsLength;
     }

}

