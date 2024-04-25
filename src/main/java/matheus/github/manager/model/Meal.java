package matheus.github.manager.model;

import lombok.Getter;
import lombok.ToString;
import matheus.github.manager.interfaces.MealInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class Meal implements MealInterface {
     private List<Food> foods;
     private int length;

     private String name;
     private int calories;
     private int proteins;
     private int fats;
     private int carbohydrates;
     private double price;

     public static Meal create() {
          return new Meal();
     }

     private Meal() {
          this.foods = new ArrayList<>();
          this.updateInfo();
     }

     @Override
     public List<Food> addFood(Food food) {
          this.foods.add(food);
          increaseLenght();
          updateInfo();
          return this.foods;
     }

     @Override
     public List<Food> addFoods(List<Food> foods) {
          for (Food food : foods) {
               this.foods.add(food);
               increaseLenght();
          }
          updateInfo();
          return this.foods;
     }

     @Override
     public List<Food> removeFoodByName(String name) throws Exception {
          List<Food> deletedFoods = foods.stream()
                  .filter(food -> food.getName().equals(name))
                  .collect(Collectors.toList());

          for (int i = 1; i <= deletedFoods.size(); i++) {
               deacreseLength();
          }

          foods = foods.stream()
                  .filter(food -> !food.getName().equals(name))
                  .collect(Collectors.toList());

          return deletedFoods;
     }

     @Override
     public void updateProteins() {
          this.proteins = getFoods().stream()
                  .mapToInt(Food::getProtein)
                  .sum();
     }

     @Override
     public void updateCarbohydrates() {
          this.carbohydrates = getFoods().stream()
                  .mapToInt(Food::getCarbohydrate)
                  .sum();
     }

     @Override
     public void updateFats() {
          this.fats = getFoods().stream()
                  .mapToInt(Food::getFat)
                  .sum();
     }

     @Override
     public void updateCalories() {
          this.calories = getFoods().stream()
                  .mapToInt(Food::getCalorie)
                  .sum();
     }

     @Override
     public void updatePrice() {
          this.price = getFoods().stream()
                  .mapToDouble(Food::getPrice)
                  .sum();
     }


     @Override
     public void updateInfo() {
          updateCalories();
          updateProteins();
          updateCarbohydrates();
          updateFats();
     }

     public String getName() {
          return name;
     }

     public int getCalories() {
          updateCalories();
          return calories;
     }

     public int getProteins() {
          updateProteins();
          return proteins;
     }

     public int getFats() {
          updateFats();
          return fats;
     }

     public int getCarbohydrates() {
          updateCarbohydrates();
          return carbohydrates;
     }

     public double getPrice() {
          updatePrice();
          return price;
     }

     public int increaseLenght() {
          return ++this.length;
     }

     public int deacreseLength() throws Exception {
          if (this.length == 0) {
               throw new Exception("Is impossible to deacrese the length");
          }
          return --this.length;
     }
}
