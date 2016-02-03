package Bench;

import java.util.*;

/**
 * Created by loic on 28/01/2016.
 */
public class testHash {

    private HashMap map;
    private Generator generator;

    public testHash(Set set) {

        this.map = new HashMap<Integer,String>();

        Integer i = 0;

        Iterator ite = set.iterator();

        while (ite.hasNext()){
            map.put(i++,ite.next());
        }

        this.generator = new Generator();

    }

    public void execute(int generate ){

        insert(generate);

        remove();

        search();

    }

    private void insert(int generate){

        HashMap tmp = this.map;

        Generator generator = new Generator();

        Set<String> stringSet = generator.generateSet(generate);

        Integer i = tmp.size();

        Iterator ite = stringSet.iterator();

        double startTime = System.nanoTime();

        while (ite.hasNext()){
            map.put(i++,ite.next());
        }

        double endTime = System.nanoTime();

        System.out.println("Total execution time Insert : " + (endTime - startTime) + " ns" );

    }


    private void remove(){

        HashMap tmp = this.map;

        Set<Integer>  rand = generator.generateIndex(tmp.size());

        double startTime = System.nanoTime();

        for(Integer j : rand){
            tmp.remove(j);
        }

        double endTime = System.nanoTime();

        System.out.println("Total execution time Remove : " + (endTime - startTime) + " ns" );

    }

    private void search(){

        HashMap tmp = this.map;

        Set<Integer> rand = generator.generateIndex(tmp.size());

        double startTime = System.nanoTime();

        for(Integer j : rand){
            tmp.get(j);
        }

        double endTime = System.nanoTime();

        System.out.println("Total execution time Search : " + (endTime - startTime) + " ns" );
    }
}