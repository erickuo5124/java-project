package fight_covid19;
import java.util.*;
public class Core {
	
		static ArrayList<ArrayList<Plants>> plant = new ArrayList<ArrayList<Plants>>(3);
		static ArrayList<ArrayList<Virus>> virus = new ArrayList<ArrayList<Virus>>(3);
		static ArrayList<ArrayList<Bullet>> bullet = new ArrayList<ArrayList<Bullet>>(3);
		static int score = 0;
		static int sun = 150;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		plant.get(1).add(0, new Book(1,0));
		checkboardP(plant);
		checkboardV(virus);
		checkboardB(bullet);
		
		//basic sun get 5 every 5 sec
		Timer suntimer = new Timer(); //Timer
		TimerTask addsun = new TimerTask(){
				@Override
				public void run() {
					sun = sun + 5;
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
				virus.get(y).set(9, new Normal_virus(y,9));
			}	
		};
		virustimer.schedule(spawnvirus, 0, 5000);
										
		//repaint the board every 1 sec 
		Timer repainttimer = new Timer(); //Timer
		TimerTask repaint = new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("plant");
				checkboardP(plant);
				System.out.println("virus");
				checkboardV(virus);
				System.out.println("bullet");
				checkboardB(bullet);
				System.out.println("sunlight");
				System.out.println(sun);
			}	
		};
		repainttimer.schedule(repaint, 0, 1000);
	
	}
	
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
}
