package backend;

import java.util.ArrayList;
import java.util.Collections;

public class BackRankedList {
    public ArrayList<BackCandidate> rankedList(ArrayList<BackCandidate> candidateArray){
        ArrayList<Integer> candidateScoreArray = new ArrayList<>();

        for (BackCandidate candidate : candidateArray){
            candidateScoreArray.add(candidate.getCandidateScore());
        }

        if(candidateScoreArray.size() > 1){
            for (int candidateScoreArrayLength : candidateScoreArray){
                for (int i = 0; i < (candidateScoreArray.size() - 1); i++){
                    if(candidateScoreArray.get(i) < candidateScoreArray.get(i + 1)){
                        Collections.swap(candidateArray, i, i + 1);
                    }
                }
            }
        }
        return candidateArray;
    }
}
