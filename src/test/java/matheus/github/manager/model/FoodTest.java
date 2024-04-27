package matheus.github.manager.model;

import matheus.github.manager.enums.NutrientNameEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FoodTest {
    private Food food1;
    private Food food2;
    @BeforeEach
    void setUp() {
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
    }

    @Test
    void getNutrientValueByNameTest() {
	   int carbohydrates = food1.getNutrientValueByName(NutrientNameEnum.CARBOHYDRATE);
	   int proteins = food1.getNutrientValueByName(NutrientNameEnum.PROTEIN);
	   int fats = food1.getNutrientValueByName(NutrientNameEnum.FAT);

	   Assertions.assertEquals(14, carbohydrates);
	   Assertions.assertEquals(10, proteins);
	   Assertions.assertEquals(1, fats);

	   int carbohydrates2 = food2.getNutrientValueByName(NutrientNameEnum.CARBOHYDRATE);
	   int proteins2 = food2.getNutrientValueByName(NutrientNameEnum.PROTEIN);
	   int fats2 = food2.getNutrientValueByName(NutrientNameEnum.FAT);

	   Assertions.assertEquals(28, carbohydrates2);
	   Assertions.assertEquals(2, proteins2);
	   Assertions.assertEquals(9, fats2);
    }
}
