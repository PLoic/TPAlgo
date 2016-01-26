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

        List tmp = this.list;

        Generator generator = new Generator();

        Set<String> stringSet = generator.generateSet(generate);

        tmp.addAll(stringSet);

    }

    /**
     * http://stackoverflow.com/questions/6961356/list-clear-vs-list-new-arraylistinteger
     */
    private void remove(){

        List tmp = this.list;

        tmp = new ArrayList<>();
    }

    private void search(){

        Random rng = new Random(Double.doubleToLongBits(Math.random()));

        List tmp = list;

        int nbIndex = (tmp.size() * 10) / 100;

        for (int i = 0; i < nbIndex ; i++) {
            tmp.get(rng.nextInt(tmp.size()));
        }
    }
}
