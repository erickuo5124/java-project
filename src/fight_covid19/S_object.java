package fight_covid19;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

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

        // plant
        for(int i = 0; i < 3; i++)  {
            for(int j = 0; j < 10; j++)  {
                switch(Core.plant.get(i).get(j).getname()) {
                	case"A": g.drawImage(alcoholImage, j * 105 + 55, i * 110 + 230, null); break;
                	case"M": g.drawImage(maskImage, j * 100 + 50, i * 110 + 255, null); break;
                	case"B": g.drawImage(bookImage, j * 100 + 50, i * 115 + 225, null); break;
                }
            }
        }
        // virus
        for(ArrayList<Virus> row : Core.virus) {
        	for(Virus v : row) {
        		if(v instanceof Normal_virus) g.drawImage(normalVirusImage, v.locationX, v.getY() * 110 + 240, null);
        		else if(v instanceof Strong_virus) g.drawImage(strongVirusImage, v.locationX, v.getY() * 110 + 240, null);
        	}
        }

        // bullet
        for(ArrayList<Bullet> row : Core.bullet) {
        	Iterator<Bullet> it = row.iterator();
            while (it.hasNext()) {
                Bullet b = it.next();
                
                if(b instanceof Normal_bullet) g.drawImage(bulletImage, b.locationX+10, b.getY() * 120 + 250, null);
        		int y = b.getY();
        		int nextX = b.locationX+24;
        		if(!Core.virus.get(y).isEmpty()) {
        			for(Virus v : Core.virus.get(b.getY())) {
	        			if(v.locationX < nextX) {
	        				b.attack(v);
	        				it.remove();
	        				break;
	        			}
        			}
        		}
        		b.locationX = nextX;
        		if(b.locationX > 1000) it.remove();
            }
        	
        }
        
        scoreBoard.setText("Score : " + Core.score);
        sunLight.setText("Power : " + Core.sun);
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
