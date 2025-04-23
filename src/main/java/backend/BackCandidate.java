package backend;

public class BackCandidate {
    private Integer candidateScore;
    private String candidateName;
    private String candidateSkills;
    private String candidateOrganisations;
    private String candidateFile;

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

    public String getCandidateFile(){
        return candidateFile;
    }

    // Candidate Constructor
    public BackCandidate(Integer cvCandidateScore, String cvCandidateName, String cvCandidateSkills, String cvCandidateOrganisations, String cvCandidateFile){
        this.candidateScore = cvCandidateScore;
        this.candidateName = cvCandidateName;
        this.candidateSkills = cvCandidateSkills;
        this.candidateOrganisations = cvCandidateOrganisations;
        this.candidateFile = cvCandidateFile;
    }
}
