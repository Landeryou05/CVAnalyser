package backend;

/**
 * BackCandidate provides the blueprint for creating a candidate object.
 * */
public class BackCandidate {
    private Integer candidateScore;
    private String candidateName;
    private String candidateSkills;
    private String candidateOrganisations;
    private String candidateFile;

    /*
    * Getters to access candidate attributes within FrontRankedList.
    * */
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

    /**
     * Constructor that is used to create a candidate object.
     * All parameters are passed as an argument with method call within FrontAddCVFile class.
     * @param cvCandidateScore Score generated.
     * @param cvCandidateName Name extracted.
     * @param cvCandidateSkills Skills extracted.
     * @param cvCandidateOrganisations Organisations or companies extracted.
     * @param cvCandidateFile Path to file that has been chosen by the user.
     * */
    public BackCandidate(Integer cvCandidateScore, String cvCandidateName, String cvCandidateSkills, String cvCandidateOrganisations, String cvCandidateFile){
        this.candidateScore = cvCandidateScore;
        this.candidateName = cvCandidateName;
        this.candidateSkills = cvCandidateSkills;
        this.candidateOrganisations = cvCandidateOrganisations;
        this.candidateFile = cvCandidateFile;
    }
}
