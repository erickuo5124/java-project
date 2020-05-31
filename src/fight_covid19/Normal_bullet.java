package fight_covid19;

import java.util.Timer;
import java.util.TimerTask;

public class Normal_bullet extends Bullet{
	private Timer walktimer = new Timer();
	public Normal_bullet(){
		super.setHP(10);
		super.setATK(10);
		super.setMove_speed(1);
		super.setname("N");
		
		TimerTask dowalk = new TimerTask(){
			@Override
			public void run() {
				//TODO move forward
			}	
		};
		walktimer.schedule(dowalk, 0, 1000);//move every 1 sec
	}
}
