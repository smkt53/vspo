package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GamePanel extends JPanel implements MouseListener{
    private JLabel titleLabel;
    private JLabel testlabel;

    public GamePanel() {
        setLayout(null);
        setBackground(Color.YELLOW);
    }

    public void prepareComponents() {
        titleLabel = new JLabel("Game Panel");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(100, 200, 200, 50);
        add(titleLabel);

        testlabel = new JLabel("test");
        testlabel.setBounds(100, 300, 200, 100);
        testlabel.setOpaque(true);
        testlabel.setHorizontalAlignment(SwingConstants.CENTER);
        testlabel.setBackground(Color.WHITE);
        add(testlabel);
        testlabel.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == testlabel) {
            Main.str = "GAME";
            Main.mainWindow.setFrontScreenAndFocus(Main.Scene.SETTING);
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