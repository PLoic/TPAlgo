package Bench;

import java.util.Set;

/**
 * Created by loic on 31/01/2016.
 */
public class testAVL {

    private AVLTree avlTree;
    private String[] list;
    private Generator generator;

    public testAVL(String[] list) {
        this.avlTree = new AVLTree();

        for (int i = 1; i < list.length ; i++) {
            avlTree.insert(list[i]);
        }

        this.generator = new Generator();

        this.list = list;

    }

    public void execute( int generate ){

        insert(generate);

        remove();

        search();

    }

    private void insert(int generate){

        AVLTree bstTemp = this.avlTree;

        Set<String> stringSet = generator.generateSet(generate);

        String[] list = stringSet.toArray(new String[stringSet.size()]);

        long startTime = System.nanoTime();

        for (int i = 0; i < list.length ; i++) {

            bstTemp.insert(list[i]);

        }

        long endTime = System.nanoTime();

        System.out.println("Total execution time Insert : " + (endTime - startTime) + " ns" );

    }

    private void remove(){

        AVLTree avlTmp = this.avlTree;

        Integer rand = generator.generateOneIndex(list.length);

        String toSearch = list[rand];

        long startTime = System.nanoTime();

        avlTmp.delete(toSearch);

        long endTime = System.nanoTime();

        System.out.println("Total execution time Remove : " + (endTime - startTime) + " ns" );
    }

    private void search(){

        AVLTree avlTmp = this.avlTree;

        Integer rand = generator.generateOneIndex(list.length);

        String toSearch = list[rand];

        long startTime = System.nanoTime();

        avlTmp.search(avlTmp.getRoot(),toSearch);

        long endTime = System.nanoTime();

        System.out.println("Total execution time Search : " + (endTime - startTime) + " ns" );
    }
}
