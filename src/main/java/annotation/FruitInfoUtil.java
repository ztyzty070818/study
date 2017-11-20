package annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {
    public static void main(String[] args) {
        Field[] fields = Fruit.class.getDeclaredFields();
        for(Field field : fields) {
            if(field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                System.out.println(fruitName.fruitName());
            } else if(field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                System.out.println(fruitColor.value());
            } else if(field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                System.out.println(fruitProvider.name());
            }
        }
    }
}
