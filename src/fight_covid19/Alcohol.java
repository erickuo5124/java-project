package fight_covid19;
import java.util.*;


public class Alcohol extends Plants{
	private Timer ATKtimer = new Timer();
	public Alcohol(int y,int x){
		super.setHP(50);
		super.setATK(10);
		super.setCost(100);
		super.setATK_speed(1);
		super.setname("A");
		super.setX(x);
		super.setY(y);
		
		TimerTask doATK = new TimerTask(){
			@Override
			public void run() {
				//TODO spawn a bullet
			}	
		};
		ATKtimer.schedule(doATK, 0, 1000);//do every one sec
	}
}
