package fight_covid19;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UI extends JFrame {
	Background bg;
    public UI() {
        setSize(1012, 785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }
    
    public void menuUI() {
    	// add Background
        bg = new Background(0);
        bg.setLocation(0, 0);
        getLayeredPane().add(bg, -1);
        
        Menu menu = new Menu();
        menu.startMenu();
        menu.setLocation(710,225);
        getLayeredPane().add(menu, 0);
    }
    
    public void gameUI() {
    	bg = new Background(1);
    	bg.setLocation(0, 0);
        getLayeredPane().add(bg, -1);
        
        Shadow s = new Shadow();
        s.setLocation(500, 10);
        getLayeredPane().add(s, 0);
        
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
    
    public void endUI() {
    	bg = new Background(2);
    	bg.setLocation(0, 0);
        getLayeredPane().add(bg, -1);
        
        Menu menu = new Menu();
        menu.endMenu();
        menu.setLocation(470, 528);
        getLayeredPane().add(menu, 0);
    }

    //------------helper------------
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}