package Bench;

import java.util.*;

/**
 * Created by paulettl on 22/01/16.
 */
public class testArray {

    private String[] list;

    public testArray(String[] list) {
        this.list = list;
    }

    public void execute( int generate ){

        insert(generate);
        remove();
        search();

    }

    private void insert(int generate){

        String[] tmp = new String[list.length + generate];

        java.lang.System.arraycopy(list,0,tmp,0,list.length);

        Generator generator = new Generator();

        Set<String> stringSet = generator.generateSet(generate);

        long startTime = System.nanoTime();

        for (int i = 0; i < stringSet.size() ; i++) {

            tmp[list.length + i] =  stringSet.toArray(new String[stringSet.size()])[i];

        }

        long endTime = System.nanoTime();

        System.out.println("Total execution time Insert : " + (endTime - startTime) + " ns" );

    }

    private void remove(){

        String[] tmp = list;

        long startTime = System.nanoTime();

        for (int i = 0; i < tmp.length ; i++) {
           tmp[i] = null;
        }

        assert(tmp.length == 0);

        long endTime = System.nanoTime();

        System.out.println("Total execution time Remove : " + (endTime - startTime) + " ns" );
    }

    private void search(){

        Random rng = new Random(Double.doubleToLongBits(Math.random()));

        String[] tmp = list;

        int nbIndex = (tmp.length * 10) / 100;

        long startTime = System.nanoTime();

        for (int i = 0; i < nbIndex ; i++) {
            Arrays.asList(tmp).get(rng.nextInt(tmp.length));
        }

        long endTime = System.nanoTime();

        System.out.println("Total execution time Search : " + (endTime - startTime) + " ns" );
    }
}
