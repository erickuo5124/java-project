package fight_covid19;
import java.util.*;


public class EmptyP extends Plants{
	private Timer ATKtimer = new Timer();
	public EmptyP(int y,int x){
		super.setHP(0);
		super.setATK(0);
		super.setCost(0);
		super.setATK_speed(0);
		super.setname("E");
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
