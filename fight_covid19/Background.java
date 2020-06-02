package fight_covid19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Background extends JPanel implements MouseListener{

    /**
     * Creates new form Menu
     */
    private Image bgImage;

    public Background() {
        setSize(1012, 785);
        setLayout(null);
        bgImage = createImageIcon("images/ui/mainBG.png", "main").getImage();
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int y = (e.getX() - 60) / 100;
        int x = (e.getY() - 250) / 110;

        // when nothing is picked or x and y is out of region
        if (State.currentOption.equals(State.PlantType.None) || (x > 2 || x < 0) || (y > 9 || y < 0)) {
            return;
        }

        // when peashooter is picked, put it on the panel
        if (State.currentOption.equals(State.PlantType.ALCOHOL)) {
            Core.plant.get(x).set(y, new Alcohol(x, y));
            State.setCurrentOption(State.PlantType.None);
        }

        // when wallnut is picked, put it on the panel
        if (State.currentOption.equals(State.PlantType.MASK)) {
            Core.plant.get(x).set(y, new mask(x, y));
            State.setCurrentOption(State.PlantType.None);
        }

        // when sunflower is picked, put it on the panel
        if (State.currentOption.equals(State.PlantType.BOOK)) {
            Core.plant.get(x).set(y, new Book(x, y));
            State.setCurrentOption(State.PlantType.None);
        }
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

    //------------useless------------

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
