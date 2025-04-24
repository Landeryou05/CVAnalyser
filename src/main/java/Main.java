import frontend.FrontMainFrame;

/**
 * Main holds the main method.
 * */
public class Main {

    /**
     * main is the entry point to the program.
     * It calls the main frame, so that the panels can be added to the main frame.
     * */
    public static void main(String[] args){
        FrontMainFrame frame = new FrontMainFrame();
        frame.mainFrame();
    }
}
