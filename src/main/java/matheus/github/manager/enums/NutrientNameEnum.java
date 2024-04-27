package matheus.github.manager.enums;

public enum NutrientNameEnum {
    PROTEIN("protein"),
    CARBOHYDRATE("carbohydrate"),
    FAT("fat");

    private final String name;

    NutrientNameEnum(String name) {
	   this.name = name;
    }
}
