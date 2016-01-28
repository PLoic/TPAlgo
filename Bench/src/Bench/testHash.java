package Bench;

import java.util.*;

/**
 * Created by loic on 28/01/2016.
 */
public class testHash {

    private HashMap map;

    public testHash(Set set) {

        map = new HashMap<Integer,String>();

        Integer i = 0;

        Iterator ite = set.iterator();

        while (ite.hasNext()){
            map.put(i++,ite.next());
        }

    }

    public void execute(int generate ){

        insert(generate);

        remove();

        //search();

    }

    private void insert(int generate){

        HashMap tmp = this.map;

        Generator generator = new Generator();

        Set<String> stringSet = generator.generateSet(generate);

        long startTime = System.nanoTime();

        Integer i = tmp.size();

        Iterator ite = stringSet.iterator();

        while (ite.hasNext()){
            map.put(i++,ite.next());
        }

        long endTime = System.nanoTime();

        System.out.println("Total execution time Insert : " + (endTime - startTime) + " ns" );

    }


    private void remove(){

        HashMap tmp = this.map;

        Iterator ite = tmp.entrySet().iterator();

        long startTime = System.nanoTime();

        while (ite.hasNext()){
            map.remove(ite.next());
        }

        long endTime = System.nanoTime();

        System.out.println("Total execution time Remove : " + (endTime - startTime) + " ns" );

    }
/**
 * http://stackoverflow.com/questions/6961356/list-clear-vs-list-new-arraylistinteger

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
    }*/
}