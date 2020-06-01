package fight_covid19;
import java.util.*;
public class Core {
	
		static ArrayList<ArrayList<Plants>> plant = new ArrayList<ArrayList<Plants>>(3);
		static ArrayList<ArrayList<Virus>> virus = new ArrayList<ArrayList<Virus>>(3);
		static ArrayList<ArrayList<Bullet>> bullet = new ArrayList<ArrayList<Bullet>>(3);
		static int score = 0;
		static int sun = 150;
		static UI ui;
		
	public static void main(String[] args) {

		// in care we want to build a menu
		ui = new UI(true);

		// since there is no menu so just start the game
		begin();

		//initialize three board
		for(int i = 0; i < 3; i++)  {
	        plant.add(new ArrayList<Plants>(10));
	    }
		for(int i = 0; i < 3; i++)  {
	        virus.add(new ArrayList<Virus>(10));
	    }
		for(int i = 0; i < 3; i++)  {
	        bullet.add(new ArrayList<Bullet>(10));
	    }
		
		for(int i = 0; i < 3; i++)  {
			for(int j = 0; j < 10; j++)  {
		        plant.get(i).add(j, new EmptyP(i,j));
		    }
	    }
		for(int i = 0; i < 3; i++)  {
			for(int j = 0; j < 10; j++)  {
		        virus.get(i).add(j, new EmptyV(i,j));
		    }
	    }
		for(int i = 0; i < 3; i++)  {
			for(int j = 0; j < 10; j++)  {
		        bullet.get(i).add(j, new EmptyB(i,j));
		    }
	    }
		//test zone
		//plant.get(0).set(4, new Alcohol(0,4));//test shooter
		/*plant.get(1).set(2, new Alcohol(1,2));//test shooter
		plant.get(2).set(2, new Alcohol(2,2));//test shooter
		plant.get(0).set(3, new Alcohol(0,2));//test shooter
		plant.get(1).set(3, new Alcohol(1,2));//test shooter
		plant.get(2).set(3, new Alcohol(2,2));//test shooter
		plant.get(0).set(4, new Alcohol(0,2));//test shooter
		plant.get(1).set(4, new Alcohol(1,2));//test shooter
		plant.get(2).set(4, new Alcohol(2,2));//test shooter*/
		
		//testzone end
		checkboardP(plant);
		checkboardV(virus);
		checkboardB(bullet);
		
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
					virus.get(y).set(9, new Normal_virus(y,9));
				}
				else { //chance of spawn strong virus is 0.3
					virus.get(y).set(9, new Strong_virus(y,9));
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
				virus_attack();//virus attack speed is atk/1sec
				System.gc();//free memory
			}	
		};
		detectiontimer.schedule(moniterstate, 0, 1000);

		//repaint the board every 1 sec 
		Timer repainttimer = new Timer(); //Timer
		TimerTask repaint = new TimerTask(){
			S_object s_object;
			@Override
			public void run() {

				// clear the old one before start
				if (s_object != null) {
					s_object.refresh();
				}
				s_object = new S_object();
				s_object.setLocation(0, 0);
				ui.getLayeredPane().add(s_object, 0);
				// ---------------------------------

				// test
				System.out.println("plant");
				checkboardP(plant);
				System.out.println("virus");
				checkboardV(virus);
				System.out.println("bullet");
				checkboardB(bullet);
				System.out.println("sunlight");
				System.out.println(sun);
				System.out.println("score");
				System.out.println(score);
				System.out.println(State.currentOption);
			}
		};
		repainttimer.schedule(repaint, 0, 1000);
	
	}//end of main
	
	public static void checkboardP(ArrayList<ArrayList<Plants>> board) {
		for(int i = 0; i < 3; i++)  {
			for(int j = 0; j < 10; j++)  {
		        System.out.print(board.get(i).get(j).getname());
		        System.out.print(" ");
		    }
			System.out.println(" ");
	    }
		System.out.println(" ");
	}
	
	public static void checkboardV(ArrayList<ArrayList<Virus>> board) {
		for(int i = 0; i < 3; i++)  {
			for(int j = 0; j < 10; j++)  {
		        System.out.print(board.get(i).get(j).getname());
		        System.out.print(" ");
		    }
			System.out.println(" ");
	    }
		System.out.println(" ");
	}
	
	public static void checkboardB(ArrayList<ArrayList<Bullet>> board) {
		for(int i = 0; i < 3; i++)  {
			for(int j = 0; j < 10; j++)  {
		        System.out.print(board.get(i).get(j).getname());
		        System.out.print(" ");
		    }
			System.out.println(" ");
	    }
		System.out.println(" ");
	}
	
	public static void checklose() {
		for(int i = 0;i < 3;i++) {
			if(!virus.get(i).get(0).getname().equals("E")) {
				System.out.println("you lose");
				System.exit(0);
			}
		}
	}
	
	public static void virus_attack(){
		for(int i = 0; i < 3; i++)  {
			for(int j = 0; j < 10; j++)  {
				if(!virus.get(i).get(j).getname().equals("E")) {
					if(!plant.get(i).get(j - 1).getname().equals("E")) {
						Virus currentvirus = virus.get(i).get(j);
						currentvirus.attack();
					}
				}
		    }
	    }
	}

	public static void begin() {
		ui.dispose();
		ui = new UI();
	}
}
