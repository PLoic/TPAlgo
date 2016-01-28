package Bench;

import java.util.*;

/**
 * Created by loic on 26/01/2016.
 */
public class testList {
    private List list;

    public testList(List list) {
        this.list = list;
    }


    public void execute(int generate ){



        insert(generate);

        remove();

        search();

    }

    private void insert(int generate){

        List tmp = this.list;

        Generator generator = new Generator();

        Set<String> stringSet = generator.generateSet(generate);

        long startTime = System.nanoTime();

        tmp.addAll(stringSet);

        long endTime = System.nanoTime();

        System.out.println("Total execution time Insert : " + (endTime - startTime) + " ns" );

    }

    /**
     * http://stackoverflow.com/questions/6961356/list-clear-vs-list-new-arraylistinteger
     */
    private void remove(){

        List tmp = this.list;

        long startTime = System.nanoTime();

        tmp = new ArrayList<>();

        long endTime = System.nanoTime();

        System.out.println("Total execution time Remove : " + (endTime - startTime) + " ns" );

    }

    private void search(){

        Random rng = new Random(Double.doubleToLongBits(Math.random()));

        List tmp = list;

        int nbIndex = (tmp.size() * 10) / 100;

        long startTime = System.nanoTime();

        for (int i = 0; i < nbIndex ; i++) {
            tmp.get(rng.nextInt(tmp.size()));
        }

        long endTime = System.nanoTime();

        System.out.println("Total execution time Search : " + (endTime - startTime) + " ns" );
    }
}
