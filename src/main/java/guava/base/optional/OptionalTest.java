package guava.base.optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void testOptional() throws Exception {
        Optional<Integer> possible = Optional.of(9);
        Optional<Integer> absentOpt = Optional.empty();
        Optional<Integer> NullableOpt = Optional.ofNullable(null);
        Optional<Integer> NoNullableOpt = Optional.ofNullable(10);

        if(possible.isPresent()) {
            System.out.println("possible isPresent:" + possible.isPresent());
            System.out.println("possible value:" + possible.get());
        }

        if(absentOpt.isPresent()) {
            System.out.println("absentOpt isPresent:" + absentOpt.isPresent());
        }
        if(NullableOpt.isPresent()){
            System.out.println("fromNullableOpt isPresent:"+NullableOpt.isPresent());
        }
        if(NoNullableOpt.isPresent()){
            System.out.println("NoNullableOpt isPresent:"+NoNullableOpt.isPresent());
        }
    }

}
