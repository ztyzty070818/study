package annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    enum Color{ RED,BULE,GREEN};
    Color value() default Color.BULE;

}
//public @interface FruitColor {
//    /**
//     * 颜色枚举
//     * @author peida
//     *
//     */
//    public enum Color{ BULE,RED,GREEN};
//
//    /**
//     * 颜色属性
//     * @return
//     */
//    Color fruitColor() default Color.GREEN;
//
//}