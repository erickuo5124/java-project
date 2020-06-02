package fight_covid19;

import java.util.TimerTask;

public class Strong_virus extends Virus{
	public Strong_virus(int y,int x){
		setLocation(x * 100 + 50);
		super.setHP(100);
		super.setATK(10);
		super.setMove_speed(1);
		super.setname("S");
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