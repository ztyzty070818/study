package guice.clazz;

import com.google.inject.*;

public class People {

    private Shoes shoes;
    private Clothes clothes;
    private LongTier longTier;

    @Inject
    public People(Shoes shoes, Clothes clothes, LongTier longTier) {
        this.shoes = shoes;
        this.clothes = clothes;
        this.longTier = longTier;
    }

    interface Shoes {
        void getColor();
    }

    interface Clothes {
        void getSize();
    }


    public static void main(String[] args) {
        Injector inject = Guice.createInjector((binder) -> {
            binder.bind(Clothes.class).to(BigClothes.class);
            binder.bind(Shoes.class).to(RedShoes.class);
            binder.bind(LongTier.class).in(Scopes.SINGLETON);
        });
        People people = inject.getInstance(People.class);
        people.shoes.getColor();
        people.clothes.getSize();
        people.longTier.getLength();

        People people1 = inject.getInstance(People.class);
    }
}
