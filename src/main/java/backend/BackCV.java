package backend;

import java.util.ArrayList;
import java.util.Properties;

import edu.stanford.nlp.pipeline.*;

public class BackCV {
    // Instance Variables
    private String cvFileType = null;
    private String cvFile = null;
    private Boolean cvSubmit = false;
    private String cvText = CVText();

    ArrayList<String> extractedNameArrayList = new ArrayList<>();
    ArrayList<String> extractedOrganisationsArrayList = new ArrayList<>();

    ArrayList<String> cvKeywordsArrayList = new ArrayList<>();
    ArrayList<String> extractedKeywordsArrayList = new ArrayList<>();

    // Getters and Setters
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

    // Methods
    public void CVAnalyserMain(){
        CVTextAnalyserNLP();
        CVTextAnalyserKeywords();

        System.out.println(getExtractedName());
        System.out.println(getExtractedOrganisations());
        System.out.println(getExtractedKeywords());
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

    public String CVText(){
        String cvRawText = "github data scientist Microsoft skilled in Python, machine learning, and NLP. "
                + "Worked at XYZ Corp developing Java software models and programming improving data pipelines."
                + "Proficient in TensorFlow, Matt Landeryou, and SQL.";

        return cvRawText;
    }
}

