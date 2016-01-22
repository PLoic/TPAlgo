package Bench;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by brunemic on 22/01/16.
 */
public class Generator {



    public static String generateString()
    {
        Random rng = new Random(Double.doubleToLongBits(Math.random()));

        final String characters = new String("abcdefghijklmnopqrstuvwxyz");

        char[] text = new char[4];

        for (int i = 0; i < 4; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }

        return new String(text);
    }


    public static Set<String> generateSet(int size){

        Set<String> stringSet = new HashSet<>();

        for (int i = 0 ; i < size ; ++i){
            while(!stringSet.add(generateString()));
        }

        return  stringSet;

    }

    public static void main(String[] args) {

        final long startTime = System.currentTimeMillis();

        Set<String> test;
        test = generateSet(100000);

        System.out.println(test.size());
        System.out.println();

        for( String a : test){
            System.out.println(a);
        }

        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) );
    }
}
