package fight_covid19;

import java.util.TimerTask;

public class Normal_virus extends Virus{
	public Normal_virus(int y,int x){
		setLocation(x * 100 + 50);
		super.setHP(40);
		super.setATK(10);
		super.setMove_speed(1);
		super.setname("N");
		super.setX(x);
		super.setY(y);
		TimerTask movevirus = new TimerTask(){
			@Override
			public void run() {			        	 
					moveforward();	
			}        	
		};
		virusmovetimer.schedule(movevirus, 0, 100);
	}
}