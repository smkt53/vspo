package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SettingPanel extends JPanel implements MouseListener, KeyListener{
    private static final long serialVersionUID = 1L;

    static JLabel returnButtonLabel;

    SettingPanel(){
        this.setLayout(null);
        this.setBackground(Color.PINK);
        this.addKeyListener(this);
    }

    public void prepareComponents(){
        returnButtonLabel = new JLabel();
        returnButtonLabel.setBackground(Color.WHITE);
        returnButtonLabel.setOpaque(true);
        returnButtonLabel.setBounds(1820, 40, 50, 50);
        returnButtonLabel.addMouseListener(this);
        this.add(returnButtonLabel);
    }

    public void returnAction(){
        System.out.println("return to " + Main.str + " screen");
        if(Main.str == "GAME")
            Main.mainWindow.setFrontScreenAndFocus(Main.Scene.GAME);
        else if(Main.str == "TITLE")
            Main.mainWindow.setFrontScreenAndFocus(Main.Scene.TITLE);
        else
            System.out.println("error");
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            returnAction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
    }

    @Override
    public void keyTyped(KeyEvent e){
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == returnButtonLabel){
            returnAction();
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


