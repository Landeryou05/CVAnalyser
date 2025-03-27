package backend;

import java.io.File;
import java.util.ArrayList;

public class BackCandidate{
    private ArrayList<String> candidateArrayList = new ArrayList<>();

    // Candidate Constructor
    public BackCandidate(String cvCandidateRank, String cvCandidateName, String cvCandidateSkills, String cvCandidateOrganisations){
        this.candidateArrayList.add(cvCandidateRank);
        this.candidateArrayList.add(cvCandidateName);
        this.candidateArrayList.add(cvCandidateSkills);
        this.candidateArrayList.add(cvCandidateOrganisations);
    }
}
