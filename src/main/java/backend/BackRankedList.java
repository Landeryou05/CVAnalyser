package backend;

import java.util.ArrayList;
import java.util.Collections;

public class BackRankedList {
    public ArrayList<Object[]> rankedList(ArrayList<Object[]> candidateArray){

        Collections.sort(candidateArray, (candidateA, candidateB) -> {
            int candidateAScore = Integer.parseInt(candidateA[0].toString());
            int candidateBScore = Integer.parseInt(candidateB[0].toString());

            return Integer.compare(candidateBScore, candidateAScore);
        });

        //System.out.println(candidateArray);

        return candidateArray;
    }
}
