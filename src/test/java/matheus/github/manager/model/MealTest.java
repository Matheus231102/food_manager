package matheus.github.manager.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MealTest {

     private Food food1;
     private Food food2;
     private Food food3;
     private Food food4;

     private Meal meal;

     @BeforeEach
     void setUp() {
          this.meal = Meal.create();

          this.food1 = Food.Builder()
                  .id(1)
                  .name("Maçã")
                  .calorie(52)
                  .protein(10)
                  .fat(1)
                  .carbohydrate(14)
                  .price(2.5);

          this.food2 = Food.Builder()
                  .id(2)
                  .name("Arroz")
                  .calorie(129)
                  .protein(2)
                  .fat(9)
                  .carbohydrate(28)
                  .price(4.0);

          this.food3 = Food.Builder()
                  .id(3)
                  .name("Frango")
                  .calorie(165)
                  .protein(31)
                  .fat(3)
                  .carbohydrate(0)
                  .price(8.0);

          this.food4 = Food.Builder()
                  .id(4)
                  .name("Batata")
                  .calorie(77)
                  .protein(2)
                  .fat(0)
                  .carbohydrate(17)
                  .price(3.0);
     }

     @Test
     void createTest() {
          Meal meal1 = Meal.create();
          Assertions.assertTrue(true);
          Assertions.assertEquals(0, meal1.getLength());
          Assertions.assertEquals(0, meal1.getFoods().size());
     }

     @Test
     void increaseLengthTest() {
          meal.increaseLenght();
          meal.increaseLenght();
          meal.increaseLenght();
          Assertions.assertEquals(3, meal.getLength());
     }

     @Test
     void deacreseLengthTest() throws Exception {
          meal.increaseLenght();
          meal.increaseLenght();
          meal.increaseLenght();
          meal.increaseLenght();
          meal.deacreseLength();
          meal.deacreseLength();
          Assertions.assertEquals(2, meal.getLength());

          Assertions.assertThrows(Exception.class, () -> {
               meal.deacreseLength();
               meal.deacreseLength();
               Assertions.assertEquals(0, meal.getLength());
               meal.deacreseLength();
          });
     }

     @Test
     void addFoodTest() {
          meal.addFood(this.food1);
          meal.addFood(this.food2);
          meal.addFood(this.food3);
          Assertions.assertEquals(3, meal.getFoods().size());
          Assertions.assertEquals(food1, meal.getFoods().get(0));
          Assertions.assertEquals(food2, meal.getFoods().get(1));
          Assertions.assertEquals(food3, meal.getFoods().get(2));
     }

     @Test
     void addFoodsTest() {
          meal.addFoods(List.of(food1, food2, food3));

          Assertions.assertEquals(3, meal.getFoods().size());
          Assertions.assertEquals(food1, meal.getFoods().get(0));
          Assertions.assertEquals(food2, meal.getFoods().get(1));
          Assertions.assertEquals(food3, meal.getFoods().get(2));
     }

     @Test
     void removeFoodByNameTest() throws Exception {
          meal.addFood(food1);
          meal.addFood(food2);

          Assertions.assertEquals(2, meal.getLength() );

          List<Food> deletedFoods = meal.removeFoodByName(food1.getName());
          Assertions.assertEquals(1, deletedFoods.size());
          Assertions.assertEquals(food1, deletedFoods.getFirst());

          List<Food> deletedFoodsAgain = meal.removeFoodByName(food2.getName());
          Assertions.assertEquals(1, deletedFoodsAgain.size());
          Assertions.assertEquals(food2, deletedFoodsAgain.getFirst());

          Assertions.assertEquals(0, meal.getLength());

          Assertions.assertThrows(Exception.class, () -> {
             meal.deacreseLength();
          });

     }

     @Test
     void updateProteinsTest() {
          meal.addFood(food1);
          Assertions.assertEquals(10, meal.getProteins());

          meal.addFood(food2);
          Assertions.assertEquals(12, meal.getProteins());

     }

     @Test
     void updateCarbohydratesTest() {
          meal.addFood(food1);
          Assertions.assertEquals(14, meal.getCarbohydrates());

          meal.addFood(food2);
          Assertions.assertEquals(42, meal.getCarbohydrates());

     }

     @Test
     void updateFatsTest() {
          meal.addFood(food1);
          Assertions.assertEquals(1, meal.getFats());

          meal.addFood(food2);
          Assertions.assertEquals(10, meal.getFats());

     }

     @Test
     void updateCaloriesTest() {
          meal.addFood(food1);
          Assertions.assertEquals(52, meal.getCalories());

          meal.addFood(food2);
          Assertions.assertEquals(181, meal.getCalories());

     }

     @Test
     void updatePriceTest() {
          meal.addFood(food1);
          Assertions.assertEquals(2.5, meal.getPrice());

          meal.addFood(food2);
          Assertions.assertEquals(6.5, meal.getPrice());
     }

     @Test
     void updateInfoTest() {
          meal.addFoods(List.of(food1, food2, food3));

          int calories = meal.getFoods().stream()
                  .mapToInt(Food::getCalorie)
                  .sum();

          int proteins = meal.getFoods().stream()
                  .mapToInt(Food::getProtein)
                  .sum();

          int fats = meal.getFoods().stream()
                  .mapToInt(Food::getFat)
                  .sum();

          int carbohydrates = meal.getFoods().stream()
                  .mapToInt(Food::getCarbohydrate)
                  .sum();

          double price = meal.getFoods().stream()
                  .mapToDouble(Food::getPrice)
                  .sum();

          Assertions.assertEquals(346, meal.getCalories());
          Assertions.assertEquals(calories, meal.getCalories());

          Assertions.assertEquals(43, meal.getProteins());
          Assertions.assertEquals(proteins, meal.getProteins());

          Assertions.assertEquals(13, meal.getFats());
          Assertions.assertEquals(fats, meal.getFats());

          Assertions.assertEquals(42, meal.getCarbohydrates());
          Assertions.assertEquals(carbohydrates, meal.getCarbohydrates());

          Assertions.assertEquals(14.5, meal.getPrice());
          Assertions.assertEquals(price, meal.getPrice());

          meal.addFood(food4);

          calories = meal.getFoods().stream()
                  .mapToInt(Food::getCalorie)
                  .sum();

          proteins = meal.getFoods().stream()
                  .mapToInt(Food::getProtein)
                  .sum();

          fats = meal.getFoods().stream()
                  .mapToInt(Food::getFat)
                  .sum();

          carbohydrates = meal.getFoods().stream()
                  .mapToInt(Food::getCarbohydrate)
                  .sum();

          price = meal.getFoods().stream()
                  .mapToDouble(Food::getPrice)
                  .sum();

          Assertions.assertEquals(423, meal.getCalories());
          Assertions.assertEquals(calories, meal.getCalories());

          Assertions.assertEquals(45, meal.getProteins());
          Assertions.assertEquals(proteins, meal.getProteins());

          Assertions.assertEquals(13, meal.getFats());
          Assertions.assertEquals(fats, meal.getFats());

          Assertions.assertEquals(59, meal.getCarbohydrates());
          Assertions.assertEquals(carbohydrates, meal.getCarbohydrates());

          Assertions.assertEquals(17.5, meal.getPrice());
          Assertions.assertEquals(price, meal.getPrice());
     }

     @Test
     void getNameTest() {
          Assertions.assertTrue(food1.getName().equals("Maçã"));
     }

     @Test
     void getCaloriesTest() {
          Assertions.assertTrue(food1.getCalorie() == 52);
     }

     @Test
     void getProteinsTest() {
          Assertions.assertTrue(food1.getProtein() == 10);
     }

     @Test
     void getFatsTest() {
          Assertions.assertTrue(food1.getFat() == 1);
     }

     @Test
     void getCarbohydratesTest() {
          Assertions.assertTrue(food1.getCarbohydrate() == 14);
     }

     @Test
     void getPriceTest() {
          Assertions.assertTrue(food1.getPrice() == 2.5);
     }

     @Test
     void getFoodsTest() {

     }
}