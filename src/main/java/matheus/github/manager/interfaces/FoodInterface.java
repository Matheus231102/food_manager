package matheus.github.manager.interfaces;

import matheus.github.manager.enums.NutrientNameEnum;

public interface FoodInterface {
    int getNutrientValueByName(NutrientNameEnum nutrientName);
}
