package matheus.github.manager.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Meals {
     private List<Meal> meals;

     private static Meals create() {
          return new Meals();
     }

     private Meals() {
          this.meals = new ArrayList<>();
     }


}
