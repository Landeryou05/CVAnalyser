package backend;

import java.util.ArrayList;
import java.util.Collections;

/**
 * BackRankedList handles the ranking of candidate objects stored within an array list.
 * */
public class BackRankedList {
    /**
     * rankedList is the method that returns the sorted array of candidate objects.
     * @param candidateArray Array list containing candidate objects.
     * @return candidateArray Sorted array list of candidate objects.
     * */
    public ArrayList<Object[]> rankedList(ArrayList<Object[]> candidateArray){

        Collections.sort(candidateArray, (candidateA, candidateB) -> { // Uses collections which is part of Java's standard library.
            int candidateAScore = Integer.parseInt(candidateA[0].toString());
            int candidateBScore = Integer.parseInt(candidateB[0].toString());

            return Integer.compare(candidateBScore, candidateAScore); // compares and sorts in descending order.
        });

        return candidateArray;
    }
}
