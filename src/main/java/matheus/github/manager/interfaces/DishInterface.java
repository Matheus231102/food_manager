package matheus.github.manager.interfaces;

import matheus.github.manager.model.Meal;

import java.util.List;

public interface DishInterface {
    List<Meal> addMeal(Meal meal);

    List<Meal> addMeals(List<Meal> meals);

    List<Meal> removeMealByName(String name) throws Exception;

    void updateDishInfo();

    void updateProteins();

    void updateCarbohydrates();

    void updateFats();

    void updateCalories();

    void updatePrice();
}
