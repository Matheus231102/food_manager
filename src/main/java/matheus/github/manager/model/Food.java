package matheus.github.manager.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Food {
     private int id;
     private String name;
     private int calorie;
     private int protein;
     private int fat;
     private int carbohydrate;
     private double price;
}
