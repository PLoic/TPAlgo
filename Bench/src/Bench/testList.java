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

        double startTime = System.nanoTime();

        tmp.addAll(stringSet);

        double endTime = System.nanoTime();

        System.out.println("Total execution time Insert : " + (endTime - startTime) + " ns" );

    }


    private void remove(){

        Random rng = new Random(Double.doubleToLongBits(Math.random()));

        List tmp = list;

        Set<Integer> rand = generator.generateIndex(tmp.size());

        double startTime = System.nanoTime();

        for(Integer j : rand){
            tmp.remove(j);
        }

        double endTime = System.nanoTime();

        System.out.println("Total execution time Remove : " + (endTime - startTime) + " ns" );

    }

    private void search(){

        List<String> tmp = list;

        String toSearch = tmp.get(generator.generateOneIndex(tmp.size()));

        Iterator ite = tmp.iterator();

        double startTime = System.nanoTime();

        while (ite.hasNext())
            if (ite.next() == toSearch) break;

        double endTime = System.nanoTime();

        System.out.println("Total execution time Search : " + (endTime - startTime) + " ns" );
    }
}
