package Bench;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by loic on 26/01/2016.
 */
public class Main {

    public static void main(String[] args) {
        Set<String> strings;

        Generator generator = new Generator();

        strings = generator.generateSet(50000);

        System.out.println("Test Array : ");
        testArray testArray = new testArray(strings.toArray(new String[strings.size()]));
        testArray.execute(20000);


        System.out.println("\nTest List : ");
        testList testList = new testList(new ArrayList(strings));
        testList.execute(20000);

        System.out.println("\nTest Hash : ");
        testHash testHash = new testHash(strings);
        testHash.execute(20000);
    }

}
