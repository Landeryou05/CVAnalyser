import ui.UIError;
import ui.pages.UIMainFrame;

public class Main {
    public static void main(String[] args){
        try{
            UIMainFrame.mainFrame();
        }catch (Exception e){
            UIError.errorFrame();
        }
    }
}
