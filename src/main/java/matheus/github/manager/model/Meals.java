package matheus.github.manager.model;

import java.util.ArrayList;
import java.util.List;

public class Meals {
     private List<Meal> meals;

     private static Meals create() {
          return new Meals();
     }

     private Meals() {
          this.meals = new ArrayList<>();
     }

}
