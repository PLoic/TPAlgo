package Bench;

import java.util.*;

/**
 * Created by paulettl on 22/01/16.
 */
public class testArray {

    private String[] list;
    private Generator generator;

    public testArray(String[] list) {
        this.list = list;
        this.generator = new Generator();
    }

    public void execute( int generate ){

        insert(generate);

        remove();

        search();

    }

    private void insert(int generate){

        String[] tmp = new String[list.length + generate];

        java.lang.System.arraycopy(list,0,tmp,0,list.length);

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

        Set<Integer> rand = generator.generateIndex(list.length);

        long startTime = System.nanoTime();

        for(Integer j : rand) {
            tmp[j] = null;
        }

        long endTime = System.nanoTime();

        System.out.println("Total execution time Remove : " + (endTime - startTime) + " ns" );
    }

    private void search(){

        String[] tmp = list;

        String toSearch = tmp[generator.generateOneIndex(tmp.length)];

        long startTime = System.nanoTime();

        for (int i = 0; i < tmp.length; ++i)
            if(tmp[i] == toSearch) break;

        long endTime = System.nanoTime();

        System.out.println("Total execution time Search : " + (endTime - startTime) + " ns" );
    }
}
