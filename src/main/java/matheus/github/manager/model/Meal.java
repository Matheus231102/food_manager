package matheus.github.manager.model;

import java.util.ArrayList;
import java.util.List;

public class Meal {
     private List<Food> foods;

     private static Meal create() {
          return new Meal();
     }

     private Meal() {
          this.foods = new ArrayList<>();
     }
}
