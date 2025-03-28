package backend;

public class BackCandidate{
    private Integer candidateRank;
    private String candidateName;
    private String candidateSkills;
    private String candidateOrganisations;

    // Candidate Constructor
    public BackCandidate(Integer cvCandidateRank, String cvCandidateName, String cvCandidateSkills, String cvCandidateOrganisations){
        this.candidateRank = cvCandidateRank;
        this.candidateName = cvCandidateName;
        this.candidateSkills = cvCandidateSkills;
        this.candidateOrganisations = cvCandidateOrganisations;
    }
}
