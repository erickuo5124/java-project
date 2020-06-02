package fight_covid19;

import javax.swing.*;
import java.awt.*;

/**
 * When you click an item, it guides u to where u can put
 */
public class Shadow extends JPanel {

    private Image book;
    private Image mask;
    private Image alcohol;

    public Shadow() {
        setSize(64, 90);
        setBackground(new Color(0,0,0,125));
        book = createImageIcon("images/cards/card_book.jpg", "book").getImage();
        mask = createImageIcon("images/cards/card_mask.jpg", "mask").getImage();
        alcohol = createImageIcon("images/cards/card_alcohol.jpg", "alcohol").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (State.currentOption.equals(State.PlantType.BOOK)) {
            g.drawImage(book, 0, 0, null);
        }

        if (State.currentOption.equals(State.PlantType.ALCOHOL)) {
            g.drawImage(alcohol, 0, 0, null);
        }

        if (State.currentOption.equals(State.PlantType.MASK)) {
            g.drawImage(mask, 0, 0, null);
        }

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
