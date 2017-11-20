package annotation;

public class Fruit {
    @FruitName()
    private String fruitName;

    @FruitColor(FruitColor.Color.BULE)
    private String fruitColor;

    @FruitProvider(age=12)
    private FruitProvider fruitProvider;
}
