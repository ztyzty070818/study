package serial;

import java.io.*;
import java.util.Random;

public class TestObjSerializeAndDeserialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        testByte2String();
        serializePerson();
    }

    private static void serializePerson() throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setName("Tom");
        person.setAge(18);
        person.setSex("男");
        person.setProvince("新疆");

        File file = new File("/tmp/test/person.txt");
        try(
//             FileOutputStream fos = new FileOutputStream(file, false);
             FileInputStream fis = new FileInputStream(file);
//             ObjectOutputStream oo = new ObjectOutputStream(fos);
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
//            oo.writeObject(person);
//            System.out.println("Person对象序列化成功");

            Person person1 = (Person) ois.readObject();
            System.out.println("Person对象反序列化成功");
            System.out.println(person1);

        }
    }

    public static void testByte2String() {

        Random random = new Random();

        byte[] bytes = new byte[1024];
        byte[] base = {'a','b','c'};
        for(int i=0; i<bytes.length; i++) {
            bytes[i] = base[random.nextInt(base.length)];
        }

//        System.out.println(Arrays.toString(bytes));
//        System.out.println(bytes.toString());
        System.out.println(new String(bytes));
    }
}
