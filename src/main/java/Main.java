import frontend.FrontMainFrame;
import frontend.pages.FrontMainMenu;

public class Main {
    public static void main(String[] args){
        try{
            FrontMainFrame.mainFrame();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
