package fight_covid19;

import java.util.Timer;
import java.util.TimerTask;

public class Normal_virus extends Virus{
	public Normal_virus(int y,int x){
		super.setHP(50);
		super.setATK(10);
		super.setMove_speed(1);
		super.setname("N");
		super.setX(x);
		super.setY(y);
		Timer virusmovetimer = new Timer(); //Timer
		TimerTask movevirus = new TimerTask(){
			@Override
			public void run() {			        	 
					moveforward();	
				}
				        	
		};
		virusmovetimer.schedule(movevirus, 5000, 4000);
	}
	
	public void moveforward() {
		int y = getY();
		int x = getX();
		if(Core.plant.get(y).get(x - getMove_speed()).getname().equals("E")) {
			Core.virus.get(y).set(x,new EmptyV(y,x));
			Core.virus.get(y).set(x - getMove_speed(),this);
			setX(x - getMove_speed());
		}
	}

}