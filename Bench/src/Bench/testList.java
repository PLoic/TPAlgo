package Bench;

import java.util.*;

/**
 * Created by loic on 26/01/2016.
 */
public class testList {

    private List list;
    private Generator generator;

    public testList(List list) {
        this.list = list;
        this.generator = new Generator();
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

        Random rng = new Random(Double.doubleToLongBits(Math.random()));

        List tmp = list;

        Set<Integer> rand = generator.generateIndex(tmp.size());

        long startTime = System.nanoTime();

        for(Integer j : rand){
            tmp.remove(j);
        }

        long endTime = System.nanoTime();

        System.out.println("Total execution time Remove : " + (endTime - startTime) + " ns" );

    }

    private void search(){

        List<String> tmp = list;

        String toSearch = tmp.get(generator.generateOneIndex(tmp.size()));

        Iterator ite = tmp.iterator();

        long startTime = System.nanoTime();

        while (ite.hasNext())
            if (ite.next() == toSearch) break;

        long endTime = System.nanoTime();

        System.out.println("Total execution time Search : " + (endTime - startTime) + " ns" );
    }
}
