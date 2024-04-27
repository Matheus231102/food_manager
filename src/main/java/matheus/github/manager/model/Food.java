package matheus.github.manager.model;

import lombok.*;
import matheus.github.manager.enums.NutrientNameEnum;
import matheus.github.manager.interfaces.FoodInterface;

@Getter
@Setter
@ToString
public class Food implements FoodInterface {

     private int id;

     private String name;

     private int foodCalorie;

     private int foodProtein;

     private int foodFat;

     private int foodCarbohydrate;

     private double foodPrice;

     public static Food create() {
          return new Food();
     }

     public Food id(Integer id) {
          setId(id);
          return this;
     }

     public Food name(String name) {
          setName(name);
          return this;
     }

     public Food calorie(int calorie) {
          setFoodCalorie(calorie);
          return this;
     }

     public Food protein(int protein) {
          setFoodProtein(protein);
          return this;
     }

     public Food fat(int fat) {
          setFoodFat(fat);
          return this;
     }

     public Food carbohydrate(int carbohydrate) {
          setFoodCarbohydrate(carbohydrate);
          return this;
     }

     public Food price(double price) {
          setFoodPrice(price);
          return this;
     }

     public void seeFood() {
          System.out.println("Name: " + getName());
          System.out.println("Calories: " + getFoodCalorie());
          System.out.println("Proteins: " + getFoodProtein());
          System.out.println("Carbohydrates: " + getFoodCarbohydrate());
          System.out.println("Fats: " + getFoodFat());
          System.out.println("Price: " + getFoodPrice());
     }

     @Override
     public int getNutrientValueByName(NutrientNameEnum nutrientName) {
          switch (nutrientName) {
               case FAT -> {
                    return getFoodFat();
               }
               case PROTEIN -> {
                    return getFoodProtein();
               }
               case CARBOHYDRATE -> {
                    return getFoodCarbohydrate();
               }
               default -> {
                    return 0;
               }
          }
	}
}
