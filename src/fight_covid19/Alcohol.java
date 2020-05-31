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
				spawnbullet();
			}	
		};
		ATKtimer.schedule(doATK, 0, 1000);//do every one sec
	}
	
	public void spawnbullet() {
		if(Core.bullet.get(this.getY()).get(this.getX()).getname().equals("E")) {//clean can spawn bullet
			Core.bullet.get(this.getY()).set(this.getX(),new Normal_bullet(this.getY(),this.getX()));
		}
		else {//exsit bullet already so add atk
			Core.bullet.get(this.getY()).get(this.getX()).setATK(this.getATK() + Core.bullet.get(this.getY()).get(this.getX()).getATK());
		}
	}
	
	public void dead() {
		if(!super.getname().equals("E") && this.getHP() <= 0) {
			Core.plant.get(this.getY()).set(this.getX(),new EmptyP(this.getY(),this.getX()));
			ATKtimer.cancel();
		}
	}
}
