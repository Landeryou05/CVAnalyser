package backend;

import java.util.Vector;

public class BackCandidate {
    private Integer candidateScore;
    private String candidateName;
    private String candidateSkills;
    private String candidateOrganisations;

    public Integer getCandidateScore(){
        return candidateScore;
    }

    public String getCandidateName(){
        return candidateName;
    }

    public String getCandidateSkills(){
        return candidateSkills;
    }

    public String getCandidateOrganisations(){
        return candidateOrganisations;
    }

    // Candidate Constructor
    public BackCandidate(Integer cvCandidateScore, String cvCandidateName, String cvCandidateSkills, String cvCandidateOrganisations){
        this.candidateScore = cvCandidateScore;
        this.candidateName = cvCandidateName;
        this.candidateSkills = cvCandidateSkills;
        this.candidateOrganisations = cvCandidateOrganisations;
    }
}
