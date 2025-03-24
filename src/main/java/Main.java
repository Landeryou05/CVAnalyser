import frontend.FrontError;
import frontend.FrontMainFrame;

public class Main {
    public static void main(String[] args){
        try{
            FrontMainFrame.mainFrame();
        }catch (Exception e){
            FrontError.errorFrame();
        }
    }
}
