package backend;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

import edu.stanford.nlp.pipeline.*;
import org.apache.tika.Tika;

/**
 * BackCV handles the rendering and extraction of the CV, so that key data, such as name, skills, etc can be extracted from the CV given.
 * */
public class BackCV {
    /*
    * Declaring instance variables.
    * */
    private String cvText;
    private Integer cvScore = 0;
    private static StanfordCoreNLP pipeline;

    private static ArrayList<BackCandidate> candidateArray = new ArrayList<>(); // Array list to store candidate data.

    private ArrayList<String> cvKeywordsArrayList = new ArrayList<>(); // Array to store the keywords before being added to extracted keywords array.

    private ArrayList<String> extractedNameArrayList = new ArrayList<>();
    private ArrayList<String> extractedOrganisationsArrayList = new ArrayList<>();
    private ArrayList<String> extractedKeywordsArrayList = new ArrayList<>();

    /*
     * Getters and Setters.
     * */
    public StanfordCoreNLP getPipeline() {
        return pipeline;
    }

    public void setPipeline(StanfordCoreNLP pipeline) {
        this.pipeline = pipeline;
    }

    public String getCVText(){
        return cvText;
    }

    public void setCVText(String cvText){
        this.cvText = cvText;
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

    public void setCVScore(Integer cvScore){
        this.cvScore = cvScore;
    }

    /**
     * cvAnalyserMain is the entry point for the class, or where it is controlled.
     * @param chosenFile This is the path of the file that the user has chosen.
     * @return candidate
     * */
    public BackCandidate cvAnalyserMain(String chosenFile){
        fileStringConversion(chosenFile);

        cvTextAnalyserNLP();
        cvTextAnalyserKeywords();

        cvKeywordsScore();
        cvNLPScore();

        BackCandidate candidate = new BackCandidate(getCVScore(), getExtractedName().toString(), getExtractedKeywords().toString(), getExtractedOrganisations().toString(), chosenFile);

        candidateArray.add(candidate);

        return candidate;
    }

    /**
     * nlpInitialLoad handles the thread that preloads the NLP.
     * This saves time for when the user wants to add a CV by utilising more CPU threads.
     * */
    public void nlpInitialLoad(){
        Runnable nlpThread = new Runnable(){
            @Override
            public void run(){
                Properties properties = new Properties();
                properties.setProperty("annotators", "tokenize,pos,lemma,ner"); // Loading annotators and tokenisers for NLP usage.
                setPipeline(new StanfordCoreNLP(properties));
            }
        };

        Thread runNLPThread = new Thread(nlpThread);
        runNLPThread.start();
    }

    /**
     * fileStringConversion handles the conversion of the file to a string that can be processed by the NLP.
     * @param cvFile This is the path of the file that the user has chosen.
     * */
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

    /**
     * cvTextAnalyserNLP handles the NLP functionality.
     * */
    public void cvTextAnalyserNLP(){
        while (getPipeline() == null) {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        CoreDocument document = new CoreDocument(getCVText()); // Document is the text that has been extracted within the fileStringConversion method.
        StanfordCoreNLP pipeLine = getPipeline(); // Retrieves the pipeline loaded by the nlpInitialLoad method.
        pipeLine.annotate(document); // Annotates the extracted string with tokens so that specific attributes can be extracted.

        ArrayList<String> falsePositives = new ArrayList<>(); // Array of words that have been falsely extracted in the wrong entity.
        falsePositives.add("Python");
        falsePositives.add("Github");

        // Checks for mentioned names within given CV file.
        for(CoreEntityMention nameEntity : document.entityMentions()){
            if(nameEntity.entityType().equals("PERSON") && !falsePositives.contains(nameEntity.text())){
                setExtractedName(nameEntity.text());
            }
        }

        // Checks for mentioned organisations within given CV file.
        for(CoreEntityMention organisation : document.entityMentions()) {
            if (organisation.entityType().equals("ORGANIZATION")) {
                setExtractedOrganisations(organisation.text());
            }
        }
    }

    /**
     * cvTextAnalyserKeywords searches through the extracted string and returns matched keywords.
     * */
    public void cvTextAnalyserKeywords(){
        // Hardcoded keywords, possibility of improving this for user-defined keywords.
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

    /**
     * cvKeywordsScore calculates the score based on keywords that have been extracted within the cvTextAnalyserKeywords method.
     * */
    public void cvKeywordsScore(){
        setCVScore(getCVScore() + (getExtractedKeywords().size()));
    }

    /**
     * cvNLPScore calculates the score based on organisations mentioned within the analysed CV.
     * This disregards the name as it doesn't necessarily make the CV more effective.
     * */
    public void cvNLPScore(){
        setCVScore(getCVScore() + (getExtractedOrganisations().size()));
    }
}