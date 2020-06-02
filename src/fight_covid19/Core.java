package fight_covid19;
import java.util.*;
public class Core {
	
	static ArrayList<ArrayList<Plants>> plant = new ArrayList<ArrayList<Plants>>(3);
	static ArrayList<ArrayList<Virus>> virus = new ArrayList<ArrayList<Virus>>(3);
	static ArrayList<ArrayList<Bullet>> bullet = new ArrayList<ArrayList<Bullet>>(3);
	static int score = 0;
	static int sun = 15000;
	static UI ui;
		
	public static void main(String[] args) {
		start();
	}
	
	public static void menu() {
		ui = new UI();
		ui.menuUI();
	}
	
	public static void start() {
		ui = new UI();
		ui.gameUI();
		//initialize three board
		for(int i = 0; i < 3; i++)  {
	        plant.add(new ArrayList<Plants>(10));
	        bullet.add(new ArrayList<Bullet>());
	        virus.add(new ArrayList<Virus>());
	    }
		for(int i = 0; i < 3; i++)  {
			for(int j = 0; j < 10; j++)  {
		        plant.get(i).add(j, new EmptyP(i,j));
		    }
	    }

		//basic sun get 10 every 5 sec
		Timer suntimer = new Timer(); //Timer
		TimerTask addsun = new TimerTask(){
				@Override
				public void run() {
					sun = sun + 10;
				}
		};
		suntimer.schedule(addsun, 0, 5000);

		//spawn virus every 5 sec
		Timer virustimer = new Timer(); //Timer
		TimerTask spawnvirus = new TimerTask(){
			@Override
			public void run() {
				Random rnd = new Random();
				int y = rnd.nextInt(3);
				int viruskind = rnd.nextInt(10);
				if(viruskind > 2 ) {
					virus.get(y).add(new Normal_virus(y,9));
				}
				else { //chance of spawn strong virus is 0.3
					virus.get(y).add(new Strong_virus(y,9));
				}
			}
		};
		virustimer.schedule(spawnvirus, 0, 5000);

		//moniter state
		Timer detectiontimer = new Timer(); //Timer
		TimerTask moniterstate = new TimerTask(){
			@Override
			public void run() {
				checklose();//check if virus reach end
				System.gc();//free memory
			}
		};
		detectiontimer.schedule(moniterstate, 0, 100);

		//repaint the board every 1 sec
		Timer repainttimer = new Timer(); //Timer
		S_object s_object = new S_object();
		TimerTask repaint = new TimerTask(){
			@Override
			public void run() {
				s_object.setLocation(0, 0);
				ui.getLayeredPane().add(s_object, 0);
			}
			
		};
		repainttimer.schedule(repaint, 0, 100);
	}
	
	public static void checklose() {
		for(ArrayList<Virus> row : Core.virus) {
        	for(Virus v : row) {
        		if(v.locationX == 0) {
        			System.out.println("you lose");
        		}
        	}
		}
	}
}
