package fight_covid19;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class UI extends JFrame {

    public UI() {
        setSize(1012, 785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setVisible(true);

        Shadow s = new Shadow();
        s.setLocation(500, 10);
        getLayeredPane().add(s, 0);

        // add Background
        Background bg = new Background();
        bg.setLocation(0, 0);
        getLayeredPane().add(bg, -1);

        // S_object is called from Core.java

        // add sunflower card on the topleft mainscreen
        Card sunflower = new Card(createImageIcon("images/cards/card_book.jpg", "book").getImage());
        sunflower.setLocation(110, 8);
        sunflower.setID("book");
        getLayeredPane().add(sunflower, 0);

        // add wallnut card on the topleft mainscreen
        Card wallnut = new Card(createImageIcon("images/cards/card_mask.jpg", "mask").getImage());
        wallnut.setLocation(175, 8);
        wallnut.setID("mask");
        getLayeredPane().add(wallnut, 0);

        // add peashooter card on the topleft mainscreen
        Card peashooter = new Card(createImageIcon("images/cards/card_alcohol.jpg", "alcohol").getImage());
        peashooter.setLocation(240, 8);
        peashooter.setID("alcohol");
        getLayeredPane().add(peashooter, 0);

    }

    public UI(boolean b) {
        setSize(1012, 785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        Menu menu = new Menu();
        getLayeredPane().add(menu, 0);
    }

    //------------helper------------
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            System.out.println(imgURL);
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
