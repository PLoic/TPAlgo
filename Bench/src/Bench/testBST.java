package Bench;

import java.util.Set;

/**
 * Created by loic on 30/01/2016.
 */
public class testBST {

    private BinarySearchTree binarySearchTree;
    private String[] list;
    private Generator generator;

    public testBST(String[] list) {
        this.binarySearchTree = new BinarySearchTree(list[0]);

        for (int i = 1; i < list.length ; i++) {
            binarySearchTree.insert(null, binarySearchTree.getRoot(), list[i]);
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

        BinarySearchTree bstTemp = this.binarySearchTree;

        Set<String> stringSet = generator.generateSet(generate);

        String[] list = stringSet.toArray(new String[stringSet.size()]);

        double startTime = System.nanoTime();

        for (int i = 0; i < list.length ; i++) {

           bstTemp.insert(null,bstTemp.getRoot(),list[i]);

        }

        double endTime = System.nanoTime();

        System.out.println("Total execution time Insert : " + (endTime - startTime) + " ns" );

    }

    private void remove(){

        BinarySearchTree bstTemp = this.binarySearchTree;

        Integer rand = generator.generateOneIndex(list.length);

        String toSearch = list[rand];

        double startTime = System.nanoTime();

        bstTemp.delete(null,bstTemp.getRoot(),toSearch);

        double endTime = System.nanoTime();

        System.out.println("Total execution time Remove : " + (endTime - startTime) + " ns" );
    }

    private void search(){

        BinarySearchTree bstTemp = this.binarySearchTree;

        Integer rand = generator.generateOneIndex(list.length);

        String toSearch = list[rand];

        double startTime = System.nanoTime();

        assert(bstTemp.search(bstTemp.getRoot(),toSearch) != null);

        double endTime = System.nanoTime();

        System.out.println("Total execution time Search : " + (endTime - startTime) + " ns" );
    }
}
