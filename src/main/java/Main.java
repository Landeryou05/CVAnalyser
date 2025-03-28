import backend.BackCV;
import backend.BackCVRanking;
import frontend.FrontMainFrame;

public class Main {
    public static void main(String[] args){
        BackCVRanking CV = new BackCVRanking();

        CV.cvNLPScore();
        CV.cvKeywordsScore();
    }
}
