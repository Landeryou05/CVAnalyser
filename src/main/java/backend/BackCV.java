package backend;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

import edu.stanford.nlp.pipeline.*;
import org.apache.tika.Tika;

public class BackCV {
    // Instance Variables
    private String cvText;
    private Integer cvScore = 0;
    private static StanfordCoreNLP pipeline;

    private static ArrayList<BackCandidate> candidateArray = new ArrayList<>();

    private ArrayList<String> cvKeywordsArrayList = new ArrayList<>();

    private ArrayList<String> extractedNameArrayList = new ArrayList<>();
    private ArrayList<String> extractedOrganisationsArrayList = new ArrayList<>();
    private ArrayList<String> extractedKeywordsArrayList = new ArrayList<>();

    // Getters and Setters
    public StanfordCoreNLP getPipeline() {
        return pipeline;
    }

    public void setPipeline(StanfordCoreNLP pipeline) {
        this.pipeline = pipeline;
    }

    public String getCVText(){
        return cvText;
    }

    public void setCVText(String setCVText){
        cvText = setCVText;
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
    public BackCandidate CVAnalyserMain(String chosenFile){
        fileStringConversion(chosenFile);

        CVTextAnalyserNLP();
        CVTextAnalyserKeywords();

        cvKeywordsScore();
        cvNLPScore();

        BackCandidate candidate = new BackCandidate(getCVScore(), getExtractedName().toString(), getExtractedKeywords().toString(), getExtractedOrganisations().toString(), chosenFile);

        candidateArray.add(candidate);

        return candidate;
    }

    public void nlpInitialLoad(){
        Runnable nlpThread = new Runnable(){
            @Override
            public void run(){
                Properties properties = new Properties();
                properties.setProperty("annotators", "tokenize,pos,lemma,ner");
                setPipeline(new StanfordCoreNLP(properties));
            }
        };

        Thread runNLPThread = new Thread(nlpThread);
        runNLPThread.start();
    }

    public void fileStringConversion(String cvFile){
        try{
            setCVText(Files.readString(Paths.get(cvFile)));
        }catch (Exception e){
            try{
                Tika fileConvert = new Tika();
                File cvFilePathConvert = new File(cvFile);
                setCVText(fileConvert.parseToString(cvFilePathConvert));
            } catch (Exception f){
                f.printStackTrace();
            }
        }
    }

    public void CVTextAnalyserNLP(){
        while (getPipeline() == null) {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        CoreDocument document = new CoreDocument(getCVText());
        StanfordCoreNLP pipeLine = getPipeline();
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

//    public String CVFileConvert(String cvFilePath){
//        if(cvFilePath.contains("txt") || cvFilePath.contains("pdf") || cvFilePath.contains("docx")){
//            try{
//                String cvFileContent = Files.readString(Paths.get(cvFilePath));
//                return cvFileContent;
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }else{
//            System.out.println("Wrong file type");
//        }
//
//        return null;
//    }

    public void cvKeywordsScore(){
        setCVScore(getCVScore() + (getExtractedKeywords().size()));
    }

    public void cvNLPScore(){
        setCVScore(getCVScore() + (getExtractedOrganisations().size()));
    }
}