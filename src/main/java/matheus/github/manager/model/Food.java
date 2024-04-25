package matheus.github.manager.model;

import lombok.*;

@Getter
@Setter
@ToString
public class Food {

     private int id;

     private String name;

     private int calorie;

     private int protein;

     private int fat;

     private int carbohydrate;

     private double price;

     public static Food Builder() {
          return new Food();
     }

     public Food id(Integer id) {
          this.id = id;
          return this;
     }

     public Food name(String name) {
          this.name = name;
          return this;
     }

     public Food calorie(int calorie) {
          this.calorie = calorie;
          return this;
     }

     public Food protein(int protein) {
          this.protein = protein;
          return this;
     }

     public Food fat(int fat) {
          this.fat = fat;
          return this;
     }

     public Food carbohydrate(int carbohydrate) {
          this.carbohydrate = carbohydrate;
          return this;
     }

     public Food price(double price) {
          this.price = price;
          return this;
     }

}
