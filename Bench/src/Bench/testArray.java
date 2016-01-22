package Bench;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by paulettl on 22/01/16.
 */
public class testArray {

    private String[] list;

    public testArray(String[] list) {
        this.list = list;
    }

    public void execute( int generate ){

        long startTime = System.currentTimeMillis();

        insert(generate);

        long endTime = System.currentTimeMillis();

        System.out.println("Total execution time Insert : " + (endTime - startTime) );

        startTime = System.currentTimeMillis();

        remove();

        endTime = System.currentTimeMillis();

        System.out.println("Total execution time remove : " + (endTime - startTime) );

        startTime = System.currentTimeMillis();

        search();

        endTime = System.currentTimeMillis();

        System.out.println("Total execution time search : " + (endTime - startTime) );
    }

    private void insert(int generate){

        String[] tmp = new String[list.length + generate];

        java.lang.System.arraycopy(list,0,tmp,0,list.length);

        Generator generator = new Generator();

        for (int i = list.length; i < tmp.length ; i++) {

            tmp[i] =  generator.generateString();

        }

    }

    private void remove(){

        String[] tmp = list;

        for (int i = 0; i < tmp.length ; i++) {
            ArrayUtils.remove(tmp, i);
        }

        assert(tmp.length == 0);
    }

    private void search(){

        Random rng = new Random(Double.doubleToLongBits(Math.random()));

        String[] tmp = list;

        int nbIndex = (tmp.length * 10) / 100;

        for (int i = 0; i < nbIndex ; i++) {
            Arrays.asList(tmp).get(rng.nextInt(tmp.length));
        }
    }
}
