package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SettingPanel extends JPanel implements MouseListener{
    private static final long serialVersionUID = 1L;

    static JLabel returnButtonLabel;

    SettingPanel(){
        this.setLayout(null);
        this.setBackground(Color.PINK);
    }

    public void prepareComponents(){
        returnButtonLabel = new JLabel();
        returnButtonLabel.setBackground(Color.WHITE);
        returnButtonLabel.setOpaque(true);
        returnButtonLabel.setBounds(1820, 40, 50, 50);
        returnButtonLabel.addMouseListener(this);
        this.add(returnButtonLabel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == returnButtonLabel){
            if(Main.str == "GAME")
                Main.mainWindow.setFrontScreenAndFocus(Main.Scene.GAME);
            else if(Main.str == "TITLE")
                Main.mainWindow.setFrontScreenAndFocus(Main.Scene.TITLE);
            else
                System.out.println("error");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}


