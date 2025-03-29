package backend;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

import edu.stanford.nlp.pipeline.*;

public class BackCV {
    // Instance Variables
    private String cvText;
    private Integer cvScore = 0;

    private ArrayList<String> cvKeywordsArrayList = new ArrayList<>();

    private ArrayList<String> extractedNameArrayList = new ArrayList<>();
    private ArrayList<String> extractedOrganisationsArrayList = new ArrayList<>();
    private ArrayList<String> extractedKeywordsArrayList = new ArrayList<>();

    // Getters and Setters
    public String getCVText(){
        return cvText;
    }

    public void setCVText(){
        this.cvText = "C://Users/lande/Documents/test.txt/";
    }

    public ArrayList<String> getExtractedName(){
        return extractedNameArrayList;
    }

    public void setExtractedName(String extractedName){
        extractedNameArrayList.add(extractedName);
    }

    public ArrayList<String> getExtractedOrganisations(){
        return extractedOrganisationsArrayList;
    }

    public void setExtractedOrganisations(String extractedOrganisation){
        extractedOrganisationsArrayList.add(extractedOrganisation);
    }

    public ArrayList<String> getCVKeywords(){
        return cvKeywordsArrayList;
    }

    public void setCVKeywords(String keywords){
        cvKeywordsArrayList.add(keywords);
    }

    public ArrayList<String> getExtractedKeywords(){
        return extractedKeywordsArrayList;
    }

    public void setExtractedKeywords(String extractedKeywords){
        extractedKeywordsArrayList.add(extractedKeywords);
    }

    public Integer getCVScore(){
        return cvScore;
    }

    public void setCVScore(Integer calculatedCVScore){
        this.cvScore = calculatedCVScore;
    }

    // Methods
    public void CVAnalyserMain(){
        CVTextAnalyserKeywords();
        CVTextAnalyserNLP();

        cvKeywordsScore();
        cvNLPScore();

        BackCandidate candidate = new BackCandidate(getCVScore(), getExtractedName().toString(), getExtractedKeywords().toString(), getExtractedOrganisations().toString());

        System.out.println(getCVScore());
    }

    public void CVTextAnalyserNLP(){
        Properties properties = new Properties();
        properties.setProperty("annotators", "tokenize,pos,lemma,ner");
        StanfordCoreNLP pipeLine = new StanfordCoreNLP(properties);

        CoreDocument document = new CoreDocument(cvText);
        pipeLine.annotate(document);

        ArrayList<String> falsePositives = new ArrayList<>();
        falsePositives.add("Python");
        falsePositives.add("Github");

        for(CoreEntityMention nameEntity : document.entityMentions()){
            if(nameEntity.entityType().equals("PERSON") && !falsePositives.contains(nameEntity.text())){
                setExtractedName(nameEntity.text());
            }
        }

        for(CoreEntityMention organisation : document.entityMentions()) {
            if (organisation.entityType().equals("ORGANIZATION")) {
                setExtractedOrganisations(organisation.text());
            }
        }
    }

    public void CVTextAnalyserKeywords(){
        setCVKeywords("python");
        setCVKeywords("java");
        setCVKeywords("programming");
        setCVKeywords("software");
        setCVKeywords("github");

        cvText = cvText.toLowerCase();

        for(int i = 0; i < getCVKeywords().size(); i++){
            if(cvText.contains(getCVKeywords().get(i))){
                setExtractedKeywords(getCVKeywords().get(i));
            }
        }
    }

    public String CVFileConvert(String cvFilePath){
        if(cvFilePath.contains("txt") || cvFilePath.contains("pdf") || cvFilePath.contains("docx")){
            try{
                String cvFileContent = Files.readString(Paths.get(cvFilePath));
                return cvFileContent;
            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            System.out.println("Wrong file type");
        }

        return null;
    }

    public void cvKeywordsScore(){
        setCVScore(getCVScore() + (getExtractedKeywords().size()));
    }

    public void cvNLPScore(){
        setCVScore(getCVScore() + (getExtractedOrganisations().size()));
    }
}