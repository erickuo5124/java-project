package fight_covid19;
import java.util.*;


public class EmptyB extends Bullet{
	private Timer ATKtimer = new Timer();
	public EmptyB(int y,int x){
		super.setHP(0);
		super.setATK(0);
		super.setMove_speed(0);
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
