package matheus.github.manager.model;

import matheus.github.manager.enums.NutrientNameEnum;
import matheus.github.manager.exceptions.ImpossibleDeacreseException;
import matheus.github.manager.exceptions.NegativeNumberParameterException;
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

     // não alterar valores
     @BeforeEach
     void setUp() {
          this.meal = Meal.create().name("Testing");

          this.food1 = Food.create()
                  .id(1)
                  .name("Maçã")
                  .calorie(52)
                  .protein(10)
                  .fat(1)
                  .carbohydrate(14)
                  .price(2.5);

          this.food2 = Food.create()
                  .id(2)
                  .name("Arroz")
                  .calorie(129)
                  .protein(2)
                  .fat(9)
                  .carbohydrate(28)
                  .price(4.0);

          this.food3 = Food.create()
                  .id(3)
                  .name("Frango")
                  .calorie(165)
                  .protein(31)
                  .fat(3)
                  .carbohydrate(0)
                  .price(8.0);

          this.food4 = Food.create()
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
          Assertions.assertEquals(0, meal1.getFoodsLength());
          Assertions.assertEquals(0, meal1.getFoods().size());
     }

     @Test
     void getNameMealTest() {
          final String mealsName = "Café da manhã";
          Meal meal1 = Meal.create();
          meal1.setName(mealsName);
          Assertions.assertEquals(mealsName, meal1.getName());
     }

     @Test
     void increaseLengthTest() {
          meal.increaseLenght();
          meal.increaseLenght();
          meal.increaseLenght();
          Assertions.assertEquals(3, meal.getFoodsLength());
     }

     @Test
     void getFoodsByNutrientTest() throws NegativeNumberParameterException {
          meal.addFoods(List.of(food1, food2, food3, food4));

          Meal listFat = meal.getFoodsByNutrient(NutrientNameEnum.FAT,2, 5);
          Assertions.assertEquals(List.of(food3), listFat.getFoods());

          Meal listProtein = meal.getFoodsByNutrient(NutrientNameEnum.PROTEIN, 10, 40);
          Assertions.assertEquals(List.of(food1, food3), listProtein.getFoods());

          Meal listCarbohydrate = meal.getFoodsByNutrient(NutrientNameEnum.CARBOHYDRATE, 15, 28);
          Assertions.assertEquals(List.of(food2, food4), listCarbohydrate.getFoods());
     }

     @Test
     void getFoodsByMinimumNutrientTest() throws NegativeNumberParameterException {
          meal.addFoods(List.of(food1, food2, food3, food4));

          Meal list1 = meal.getFoodsByMinimumNutrient(NutrientNameEnum.PROTEIN, 30);
          Assertions.assertEquals(List.of(food3), list1.getFoods());

          Meal list2 = meal.getFoodsByMinimumNutrient(NutrientNameEnum.CARBOHYDRATE, 14);
          Assertions.assertEquals(List.of(food1, food2, food4), list2.getFoods());

          Meal list3 = meal.getFoodsByMinimumNutrient(NutrientNameEnum.FAT, 1);
          Assertions.assertEquals(List.of(food1, food2, food3), list3.getFoods());
     }

     @Test
     void getFoodsByMaximumNutrientTest() throws NegativeNumberParameterException {
          meal.addFoods(List.of(food1, food2, food3, food4));

          Meal list1 = meal.getFoodsByMaximumNutrient(NutrientNameEnum.PROTEIN, 20);
          Assertions.assertEquals(List.of(food1, food2, food4), list1.getFoods());

          Meal list2 = meal.getFoodsByMaximumNutrient(NutrientNameEnum.CARBOHYDRATE, 20);
          Assertions.assertEquals(List.of(food1, food3, food4), list2.getFoods());

          Meal list3 = meal.getFoodsByMaximumNutrient(NutrientNameEnum.FAT, 5);
          Assertions.assertEquals(List.of(food1, food3, food4), list3.getFoods());
     }


     @Test
     void deacreseLengthTest() throws Exception {
          meal.increaseLenght();
          meal.increaseLenght();
          meal.increaseLenght();
          meal.increaseLenght();
          meal.deacreseLength();
          meal.deacreseLength();
          Assertions.assertEquals(2, meal.getFoodsLength());

          Assertions.assertThrows(ImpossibleDeacreseException.class, () -> {
               meal.deacreseLength();
               meal.deacreseLength();
               Assertions.assertEquals(0, meal.getFoodsLength());
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

          Assertions.assertEquals(2, meal.getFoodsLength() );

          List<Food> deletedFoods = meal.removeFoodByName(food1.getName());
          Assertions.assertEquals(1, deletedFoods.size());
          Assertions.assertEquals(food1, deletedFoods.getFirst());

          List<Food> deletedFoodsAgain = meal.removeFoodByName(food2.getName());
          Assertions.assertEquals(1, deletedFoodsAgain.size());
          Assertions.assertEquals(food2, deletedFoodsAgain.getFirst());

          Assertions.assertEquals(0, meal.getFoodsLength());

          Assertions.assertThrows(ImpossibleDeacreseException.class, () -> {
             meal.deacreseLength();
          });

     }

     @Test
     void updateProteinsTest() {
          meal.addFood(food1);
          Assertions.assertEquals(10, meal.getMealProteins());

          meal.addFood(food2);
          Assertions.assertEquals(12, meal.getMealProteins());

     }

     @Test
     void updateCarbohydratesTest() {
          meal.addFood(food1);
          Assertions.assertEquals(14, meal.getMealCarbohydrate());

          meal.addFood(food2);
          Assertions.assertEquals(42, meal.getMealCarbohydrate());

     }

     @Test
     void updateFatsTest() {
          meal.addFood(food1);
          Assertions.assertEquals(1, meal.getMealFats());

          meal.addFood(food2);
          Assertions.assertEquals(10, meal.getMealFats());

     }

     @Test
     void updateCaloriesTest() {
          meal.addFood(food1);
          Assertions.assertEquals(52, meal.getMealCalories());

          meal.addFood(food2);
          Assertions.assertEquals(181, meal.getMealCalories());

     }

     @Test
     void updatePriceTest() {
          meal.addFood(food1);
          Assertions.assertEquals(2.5, meal.getMealPrice());

          meal.addFood(food2);
          Assertions.assertEquals(6.5, meal.getMealPrice());
     }

     @Test
     void updateMealInfoTest() {
          meal.addFoods(List.of(food1, food2, food3));

          int calories = meal.getFoods().stream()
                  .mapToInt(Food::getFoodCalorie)
                  .sum();

          int proteins = meal.getFoods().stream()
                  .mapToInt(Food::getFoodProtein)
                  .sum();

          int fats = meal.getFoods().stream()
                  .mapToInt(Food::getFoodFat)
                  .sum();

          int carbohydrates = meal.getFoods().stream()
                  .mapToInt(Food::getFoodCarbohydrate)
                  .sum();

          double price = meal.getFoods().stream()
                  .mapToDouble(Food::getFoodPrice)
                  .sum();

          Assertions.assertEquals(346, meal.getMealCalories());
          Assertions.assertEquals(calories, meal.getMealCalories());

          Assertions.assertEquals(43, meal.getMealProteins());
          Assertions.assertEquals(proteins, meal.getMealProteins());

          Assertions.assertEquals(13, meal.getMealFats());
          Assertions.assertEquals(fats, meal.getMealFats());

          Assertions.assertEquals(42, meal.getMealCarbohydrate());
          Assertions.assertEquals(carbohydrates, meal.getMealCarbohydrate());

          Assertions.assertEquals(14.5, meal.getMealPrice());
          Assertions.assertEquals(price, meal.getMealPrice());

          meal.addFood(food4);

          calories = meal.getFoods().stream()
                  .mapToInt(Food::getFoodCalorie)
                  .sum();

          proteins = meal.getFoods().stream()
                  .mapToInt(Food::getFoodProtein)
                  .sum();

          fats = meal.getFoods().stream()
                  .mapToInt(Food::getFoodFat)
                  .sum();

          carbohydrates = meal.getFoods().stream()
                  .mapToInt(Food::getFoodCarbohydrate)
                  .sum();

          price = meal.getFoods().stream()
                  .mapToDouble(Food::getFoodPrice)
                  .sum();

          Assertions.assertEquals(423, meal.getMealCalories());
          Assertions.assertEquals(calories, meal.getMealCalories());

          Assertions.assertEquals(45, meal.getMealProteins());
          Assertions.assertEquals(proteins, meal.getMealProteins());

          Assertions.assertEquals(13, meal.getMealFats());
          Assertions.assertEquals(fats, meal.getMealFats());

          Assertions.assertEquals(59, meal.getMealCarbohydrate());
          Assertions.assertEquals(carbohydrates, meal.getMealCarbohydrate());

          Assertions.assertEquals(17.5, meal.getMealPrice());
          Assertions.assertEquals(price, meal.getMealPrice());
     }

     @Test
     void shouldThrowNegativeNumberParameterException() {
          Assertions.assertThrows(NegativeNumberParameterException.class, () -> {
               meal.getFoodsByNutrient(NutrientNameEnum.CARBOHYDRATE, -1, 1);
          });

          Assertions.assertThrows(NegativeNumberParameterException.class, () -> {
               meal.getFoodsByNutrient(NutrientNameEnum.CARBOHYDRATE, 0, -1);
          });


          Assertions.assertThrows(NegativeNumberParameterException.class, () -> {
               meal.getFoodsByMinimumNutrient(NutrientNameEnum.CARBOHYDRATE, -1);
          });

          Assertions.assertThrows(NegativeNumberParameterException.class, () -> {
               meal.getFoodsByMaximumNutrient(NutrientNameEnum.CARBOHYDRATE, -1);
          });
     }

     @Test
     void getNameTest() {
          Assertions.assertTrue(food1.getName().equals("Maçã"));
     }

     @Test
     void getCaloriesTest() {
          Assertions.assertTrue(food1.getFoodCalorie() == 52);
     }

     @Test
     void getProteinsTest() {
          Assertions.assertTrue(food1.getFoodProtein() == 10);
     }

     @Test
     void getFatsTest() {
          Assertions.assertTrue(food1.getFoodFat() == 1);
     }

     @Test
     void getCarbohydratesTest() {
          Assertions.assertTrue(food1.getFoodCarbohydrate() == 14);
     }

     @Test
     void getPriceTest() {
          Assertions.assertTrue(food1.getFoodPrice() == 2.5);
     }

     @Test
     void getFoodsTest() {

     }
}