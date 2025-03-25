package frontend;

import frontend.pages.FrontMainMenu;

import javax.swing.*;
import java.awt.*;

public class FrontQuit{
    public static void quitConfirm(JFrame parentFrame){
        JDialog quitConfirmFrame = new JDialog(parentFrame, true);
        quitConfirmFrame.setSize(250,150);
        quitConfirmFrame.setLocationRelativeTo(null);
        quitConfirmFrame.setTitle("Quit?");
        Image favicon = Toolkit.getDefaultToolkit().getImage("Resources/Logo.jpg");
        quitConfirmFrame.setIconImage(favicon);
        quitConfirmFrame.setResizable(false);
        quitConfirmFrame.setVisible(true);

    }

    public static void quitProgram(){
        System.exit(0);
    }
}
