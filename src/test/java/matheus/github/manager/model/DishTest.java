package matheus.github.manager.model;

import matheus.github.manager.exceptions.ImpossibleDeacreseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class DishTest {

    private Food food1;
    private Food food2;
    private Food food3;
    private Food food4;

    private Meal meal1;
    private Meal meal2;
    private Meal meal3;

    private Dish dish;

    // não alterar valores
    @BeforeEach
    void setUp() {
        this.dish = Dish.create();

        this.meal1 = Meal.create().name("Café da manhã");
        this.meal2 = Meal.create().name("Almoço");
        this.meal3 = Meal.create().name("Janta");

        this.food1 = Food.create()
                .id(1)
                .name("Maçã")
                .calorie(7)
                .protein(10)
                .fat(1)
                .carbohydrate(10)
                .price(2.5);

        this.food2 = Food.create()
                .id(2)
                .name("Arroz")
                .calorie(9)
                .protein(2)
                .fat(9)
                .carbohydrate(8)
                .price(4.0);

        this.food3 = Food.create()
                .id(3)
                .name("Frango")
                .calorie(12)
                .protein(10)
                .fat(3)
                .carbohydrate(0)
                .price(8.0);

        this.food4 = Food.create()
                .id(4)
                .name("Batata")
                .calorie(5)
                .protein(2)
                .fat(0)
                .carbohydrate(3)
                .price(3.0);

        meal1.addFoods(List.of(food1, food2, food3, food4));
        meal2.addFoods(List.of(food1, food2));
        meal3.addFoods(List.of(food3, food4));

        // meal3 -> calories: 17 | proteins: 12 | fat: 3 | carbohydrate: 3 | price: 11.0 |
        // meal2 -> calories: 16 | proteins: 12 | fat: 10 | carbohydrate: 18 | price: 6.5 |
        // meal1 -> calories: 33 | proteins: 24 | fat: 13 | carbohydrate: 21 | price: 17.5 |
    }

    @Test
    void addMeal() {
        dish.addMeal(meal1);
        dish.addMeal(meal2);
        dish.addMeal(meal3);
        Assertions.assertEquals(3, dish.getMeals().size());
        Assertions.assertEquals(meal1, dish.getMeals().get(0));
        Assertions.assertEquals(meal2, dish.getMeals().get(1));
        Assertions.assertEquals(meal3, dish.getMeals().get(2));
    }

    @Test
    void addMeals() {
        dish.addMeals(List.of(meal1, meal2, meal3));

        Assertions.assertEquals(3, dish.getMeals().size());
        Assertions.assertEquals(meal1, dish.getMeals().get(0));
        Assertions.assertEquals(meal2, dish.getMeals().get(1));
        Assertions.assertEquals(meal3, dish.getMeals().get(2));
    }

    @Test
    void removeMealByName() throws Exception {
        dish.addMeal(meal1);
        dish.addMeal(meal2);

        Assertions.assertEquals(2, dish.getMealsLength());

        List<Meal> deletedMeals = dish.removeMealByName(meal1.getName());
        Assertions.assertEquals(1, deletedMeals.size());
        Assertions.assertEquals(meal1, deletedMeals.getFirst());

        List<Meal> deletedMealsAgain = dish.removeMealByName(meal2.getName());
        Assertions.assertEquals(1, deletedMealsAgain.size());
        Assertions.assertEquals(meal2, deletedMealsAgain.getFirst());

        Assertions.assertEquals(0, dish.getMealsLength());

        Assertions.assertThrows(ImpossibleDeacreseException.class, () -> {
            dish.deacreseLength();
        });
    }

}