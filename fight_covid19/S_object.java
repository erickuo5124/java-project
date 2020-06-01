package fight_covid19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class S_object extends JPanel {
    private Image sunFlowerImage;
    private Image wallNutImage;
    private Image peashooterImage;
    private Image zombie1Image;
    private Image zombie2Image;
    private Image peaImage;
    private JLabel scoreBoard = new JLabel();

    public S_object() {
        setSize(1200, 785);
        setBackground(null);
        setOpaque(false);
        setLayout(null);

        // load all necessary image
        sunFlowerImage = createImageIcon("images/plants/sunflower.gif", "sunflower").getImage();
        wallNutImage = createImageIcon("images/plants/wallnut.gif", "wallnut").getImage();
        peashooterImage = createImageIcon("images/plants/peashooter.gif", "peashooter").getImage();
        zombie1Image = createImageIcon("images/zombies/zombie1.png", "zombie1").getImage();
        zombie2Image = createImageIcon("images/zombies/zombie2.png", "zombie2").getImage();
        peaImage = createImageIcon("images/plants/pea.png", "pea").getImage();

        // add score
        scoreBoard.setText("Score : " + Core.score + "  Power : " + Core.sun);
        scoreBoard.setFont(new Font("Serif", Font.BOLD, 28));
        scoreBoard.setForeground( Color.BLACK );
        scoreBoard.setSize(1000, 30);
        scoreBoard.setLocation(310, 30);
        add(scoreBoard);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // decide peashooter(sanitizer)
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                if (Core.plant.get(i).get(j).getname().equals("A")) {
                    g.drawImage(peashooterImage, j * 100 + 60, i * 110 + 250, null);
                }
            }
        }

        // decide wallnut(face mask)
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                if (Core.plant.get(i).get(j).getname().equals("M")) {
                    g.drawImage(wallNutImage, j * 100 + 60, i * 100 + 255, null);
                }
            }
        }

        // decide sunflower(book)
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                if (Core.plant.get(i).get(j).getname().equals("B")) {
                    g.drawImage(sunFlowerImage, j * 100 + 60, i * 100 + 255, null);
                }
            }
        }

        // decide zombie1(virus)
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                if (Core.virus.get(i).get(j).getname().equals("N")) {
                    g.drawImage(zombie1Image, j * 100 + 60, i * 100 + 255, null);
                }
            }
        }

        // decide zombie2(virus with shell)
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                if (Core.virus.get(i).get(j).getname().equals("S")) {
                    g.drawImage(zombie2Image, j * 100 + 60, i * 120 + 250, null);
                }
            }
        }

        // decide pea(alcohol)
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                if (Core.bullet.get(i).get(j).getname().equals("N")) {
                    g.drawImage(peaImage, j * 100 + 60, i * 120 + 250, null);
                }
            }
        }
    }

    public void refresh() {

        // clear the old one
        sunFlowerImage = null;
        wallNutImage = null;
        peashooterImage = null;
        zombie1Image = null;
        zombie2Image = null;
        peaImage = null;
        scoreBoard.setText("");
        return;
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
