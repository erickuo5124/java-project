package fight_covid19;
import java.util.*;
public class Core {
	
	static ArrayList<ArrayList<Plants>> plant;
	static ArrayList<ArrayList<Virus>> virus;
	static ArrayList<ArrayList<Bullet>> bullet;
	static int score;
	static int sun;
	static UI ui = null;
	static Timer suntimer, virustimer, detectiontimer, repainttimer;
	static TimerTask addsun, spawnvirus, moniterstate, repaint;
		
	public static void main(String[] args) {
		gameMenu();
	}
	
	public static void gameMenu() {
		if(ui != null) ui.dispose();
		ui = new UI();
		ui.menuUI();
	}
	
	public static void start() {
		if(ui != null) ui.dispose();
		ui = new UI();
		ui.gameUI();
		
		reset();

		//basic sun get 10 every 5 sec
		suntimer = new Timer(); //Timer
		addsun = new TimerTask(){
				@Override
				public void run() {
					sun = sun + 10;
				}
		};
		suntimer.schedule(addsun, 0, 5000);

		//spawn virus every 5 sec
		virustimer = new Timer(); //Timer
		spawnvirus = new TimerTask(){
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
		detectiontimer = new Timer(); //Timer
		moniterstate = new TimerTask(){
			@Override
			public void run() {
				checklose();//check if virus reach end
				System.gc();//free memory
			}
		};
		detectiontimer.schedule(moniterstate, 0, 100);

		//repaint the board every 1 sec
		repainttimer = new Timer(); //Timer
		S_object s_object = new S_object();
		repaint = new TimerTask(){
			@Override
			public void run() {
				s_object.setLocation(0, 0);
				ui.getLayeredPane().add(s_object, 0);
			}
			
		};
		repainttimer.schedule(repaint, 0, 100);
	}
	
	public static void gameover() {
		reset();
		if(ui != null) ui.dispose();
		ui = new UI();
		ui.endUI();
	}
	
	public static void reset() {
		
		sun = 1500;
		score = 0;
		
		plant =  new ArrayList<ArrayList<Plants>>(3);
		virus = new ArrayList<ArrayList<Virus>>(3);
		bullet = new ArrayList<ArrayList<Bullet>>(3);
		
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
		
		if(suntimer != null)suntimer.cancel();
		if(virustimer != null)virustimer.cancel();
		if(detectiontimer != null)detectiontimer.cancel(); 
		if(repainttimer != null)repainttimer.cancel();
		
		if(addsun != null) addsun.cancel();
		if(spawnvirus != null) spawnvirus.cancel();
		if(moniterstate != null) moniterstate.cancel();
		if(repaint != null) repaint.cancel();

		System.gc();
		}
	
	public static void checklose() {
		for(ArrayList<Virus> row : virus) {
			Iterator<Virus> it = row.iterator();
	        while (it.hasNext()) {
	        	Virus v = it.next();
	        	if(v.locationX < 0) {
        			System.out.println("you lose");
        			gameover();
        		}
	        }
		}
	}
}
