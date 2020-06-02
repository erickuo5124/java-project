package fight_covid19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class S_object extends JPanel {
    private Image bookImage;
    private Image maskImage;
    private Image alcoholImage;
    private Image normalVirusImage;
    private Image strongVirusImage;
    private Image bulletImage;
    private JLabel scoreBoard = new JLabel();
    private JLabel sunLight = new JLabel();

    public S_object() {
        setSize(1200, 785);
        setBackground(null);
        setOpaque(false);
        setLayout(null);

        // load all necessary image
        bookImage = createImageIcon("images/plants/book.gif", "book").getImage();
        maskImage = createImageIcon("images/plants/mask.gif", "mask").getImage();
        alcoholImage = createImageIcon("images/plants/alcohol.gif", "alcoohl").getImage();
        normalVirusImage = createImageIcon("images/virus/normal_virus.gif", "normal_virus").getImage();
        strongVirusImage = createImageIcon("images/virus/strong_virus.gif", "strong_virus").getImage();
        bulletImage = createImageIcon("images/plants/bullet.png", "bullet").getImage();

        // add score
        scoreBoard.setText("Score : " + Core.score);
        scoreBoard.setFont(new Font("Serif", Font.BOLD, 28));
        scoreBoard.setForeground( Color.BLACK );
        scoreBoard.setSize(1000, 30);
        scoreBoard.setLocation(320, 50);
        add(scoreBoard);

        // add sunlight
        sunLight.setText("Power : " + Core.sun);
        sunLight.setFont(new Font("Serif", Font.BOLD, 28));
        sunLight.setForeground( Color.BLACK );
        sunLight.setSize(1000, 30);
        sunLight.setLocation(320, 20);
        add(sunLight);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // decide peashooter(sanitizer)
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                if (Core.plant.get(i).get(j).getname().equals("A")) {
                    g.drawImage(alcoholImage, j * 105 + 55, i * 110 + 220, null);
                }
            }
        }

        // decide wallnut(face mask)
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                if (Core.plant.get(i).get(j).getname().equals("M")) {
                    g.drawImage(maskImage, j * 100 + 50, i * 110 + 255, null);
                }
            }
        }

        // decide sunflower(book)
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                if (Core.plant.get(i).get(j).getname().equals("B")) {
                    g.drawImage(bookImage, j * 100 + 50, i * 115 + 225, null);
                }
            }
        }

        // decide zombie1(virus)
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                if (Core.virus.get(i).get(j).getname().equals("N")) {
                    g.drawImage(normalVirusImage, j * 100 + 50, i * 110 + 240, null);
                }
            }
        }

        // decide zombie2(virus with shell)
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                if (Core.virus.get(i).get(j).getname().equals("S")) {
                    g.drawImage(strongVirusImage, j * 100 + 50, i * 115 + 230, null);
                }
            }
        }

        // decide pea(alcohol)
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                if (Core.bullet.get(i).get(j).getname().equals("N")) {
                    g.drawImage(bulletImage, j * 100 + 60, i * 120 + 250, null);
                }
            }
        }
    }

    // clear the old one
    public void refresh() {
        bookImage = null;
        maskImage = null;
        alcoholImage = null;
        normalVirusImage = null;
        strongVirusImage = null;
        bulletImage = null;
        scoreBoard.setText("");
        sunLight.setText("");
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
