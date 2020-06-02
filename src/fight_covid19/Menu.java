package fight_covid19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static fight_covid19.Core.end;

public class Menu extends JPanel{
    private Image menu;

    public Menu() {
    	setSize(1012, 785);
        menu = createImageIcon("images/ui/startBG.jpg", "menu").getImage();
        JButton button = new JButton();
        button.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                end();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(menu, 0, 0, null);

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
