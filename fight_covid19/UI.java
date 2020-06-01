package fight_covid19;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class UI extends JFrame implements MouseMotionListener{

    public UI() {
        setSize(1012, 785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setVisible(true);

        // add Background
        Background bg = new Background();
        bg.setLocation(0, 0);
        getLayeredPane().add(bg, 0);

        // S_object is called from Core.java

        // add sunflower
        Card sunflower = new Card(new ImageIcon(this.getClass().getResource("images/cards/card_sunflower.png")).getImage());
        sunflower.setLocation(110, 8);
        sunflower.setID("sunflower");
        getLayeredPane().add(sunflower, 0);

        // add wallnut
        Card wallnut = new Card(new ImageIcon(this.getClass().getResource("images/cards/card_wallnut.png")).getImage());
        wallnut.setLocation(175, 8);
        wallnut.setID("wallnut");
        getLayeredPane().add(wallnut, 0);

        // add peashooter
        Card peashooter = new Card(new ImageIcon(this.getClass().getResource("images/cards/card_peashooter.png")).getImage());
        peashooter.setLocation(240, 8);
        peashooter.setID("peashooter");
        getLayeredPane().add(peashooter, 0);
    }

    public UI(boolean b) {
        setSize(1012, 785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //getLayeredPane().add(menu, new Integer(0));
        //menu.repaint();
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (State.currentOption.equals(State.PlantType.Peashooter) ||
                State.currentOption.equals(State.PlantType.WallNut) ||
                State.currentOption.equals(State.PlantType.Sunflower)) {
            JPanel panel = new JPanel();
            panel.setSize(10, 10);
            panel.setLocation(e.getX(), e.getY());
        }
    }
}
