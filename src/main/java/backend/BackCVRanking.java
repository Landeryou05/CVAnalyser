package backend;

public class BackCVRanking extends BackCV{
    private Integer cvScore;

    private Integer organisationScore;
    private Integer keywordScore;

    public Integer getCVScore(){
        return cvScore;
    }

    public void setCVScore(Integer calculatedCVScore){
        this.cvScore = calculatedCVScore;
    }

    public Integer getOrganisationScore(){
        return organisationScore;
    }

    public Integer getKeywordScore(){
        return keywordScore;
    }

    public void cvKeywordsScore(){
//        Integer calculatedCVScore = getCVScore();

        CVTextAnalyserKeywords();

        System.out.println(getExtractedKeywords().size());

//
    }

    public void cvNLPScore(){
//        Integer calculatedCVScore = getCVScore();

        CVTextAnalyserNLP();
//
        System.out.println(getExtractedOrganisations().size());
//
//        setOrganisationScore(getExtractedOrganisations().size());
    }
}
