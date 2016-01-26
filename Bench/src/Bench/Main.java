package Bench;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by loic on 26/01/2016.
 */
public class Main {

    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();

        Generator generator = new Generator();

        strings = generator.generateSet(400000);

        //testArray testArray = new testArray(strings.toArray(new String[strings.size()]));
        //testArray.execute(40000);

        testList testList = new testList(new ArrayList(strings));
        testList.execute(40000);
    }

}
