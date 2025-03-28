package backend;

import java.io.File;
import java.util.ArrayList;

public class BackCandidate{
    private Integer candidateRank;
    private String candidateName;
    private String candidateSkills;
    private String candidateOrganisations;

    public Integer getCVCandidateRank(){
        return candidateRank;
    }

    public String getCVCandidateName(){
        return candidateName;
    }

    public String getCVCandidateSkills(){
        return candidateSkills;
    }

    public String getCVCandidateOrganisations(){
        return candidateOrganisations;
    }

    // Candidate Constructor
    public BackCandidate(Integer cvCandidateRank, String cvCandidateName, String cvCandidateSkills, String cvCandidateOrganisations){
        this.candidateRank = cvCandidateRank;
        this.candidateName = cvCandidateName;
        this.candidateSkills = cvCandidateSkills;
        this.candidateOrganisations = cvCandidateOrganisations;
    }
}
