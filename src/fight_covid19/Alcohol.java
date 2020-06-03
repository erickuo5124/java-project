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
		
		Core.sun = Core.sun - super.getCost();//spend sun
		
		TimerTask doATK = new TimerTask(){
			@Override
			public void run() {
				if(!Core.virus.get(getY()).isEmpty())
					spawnbullet();
			}	
		};
		ATKtimer.schedule(doATK, 500, 1000);//do every one sec
	}
	
	public void spawnbullet() {
		Core.bullet.get(this.getY()).add(new Normal_bullet(this.getY(),this.getX()));
	}
	
	public void dead() {
		Core.plant.get(this.getY()).set(this.getX(),new EmptyP(this.getY(),this.getX()));
		ATKtimer.cancel();
		System.gc();
	}
}
