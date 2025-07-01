package backend;

import java.util.Properties;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class NLPInitialLoad {

    private static StanfordCoreNLP pipeline;

    /*
     * Getters and Setters.
     * */
    public StanfordCoreNLP getPipeline() {
        return pipeline;
    }

    public void setPipeline(StanfordCoreNLP pipeline) {
        this.pipeline = pipeline;
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
}
