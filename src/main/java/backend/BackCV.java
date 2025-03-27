package backend;

import java.util.ArrayList;
import java.util.Properties;

import edu.stanford.nlp.pipeline.*;


public class BackCV {
    private String cvFileType = null;
    private String cvFile = null;
    private Boolean cvSubmit = false;

    public void CVTextAnalyser(){
        String text = "github data scientist Microsoft skilled in Python, machine learning, and NLP. "
                + "Worked at XYZ Corp developing software models and programming improving data pipelines."
                + "Proficient in TensorFlow, Matt Landeryou, and SQL.";

        ArrayList<String> cvKeywords = new ArrayList<>();
        cvKeywords.add("python");
        cvKeywords.add("Java");
        cvKeywords.add("Programming");
        cvKeywords.add("Software");
        cvKeywords.add("github");

        // Stanford NLP
        Properties properties = new Properties();
        properties.setProperty("annotators", "tokenize,pos,lemma,ner");
        StanfordCoreNLP pipeLine = new StanfordCoreNLP(properties);

        CoreDocument document = new CoreDocument(text);
        pipeLine.annotate(document);

        ArrayList<String> extractedName = new ArrayList<>();
        ArrayList<String> extractedOrganisations = new ArrayList<>();
        ArrayList<String> extractedKeyWords = new ArrayList<>();

        ArrayList<String> falsePositives = new ArrayList<>();
        falsePositives.add("Python");

        for(CoreEntityMention nameEntity : document.entityMentions()){
            if(nameEntity.entityType().equals("PERSON") && !falsePositives.contains(nameEntity.text())){
                extractedName.add(nameEntity.text());
            }
        }

        for(CoreEntityMention organisation : document.entityMentions()) {
            if (organisation.entityType().equals("ORGANIZATION")) {
                extractedOrganisations.add(organisation.text());
            }


            System.out.println(extractedName);
            System.out.println(extractedOrganisations);
            System.out.println(extractedKeyWords);
        }
    }
}

