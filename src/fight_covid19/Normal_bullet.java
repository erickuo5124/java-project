package fight_covid19;

import java.util.Timer;
import java.util.TimerTask;

public class Normal_bullet extends Bullet{
	private Timer walktimer = new Timer();
	public Normal_bullet(int y,int x){
		super.setHP(10);
		super.setATK(10);
		super.setMove_speed(1);
		super.setname("N");
		super.setX(x);
		super.setY(y);
		
		TimerTask dowalk = new TimerTask(){
			@Override
			public void run() {
				moveforward();
			}	
		};
		walktimer.schedule(dowalk, 0, 1000);//move every 1 sec
	}
	
	public void moveforward() {
		int y = getY();
		int x = getX();
		if(x < 9) {
			Core.bullet.get(y).set(x + getMove_speed(), this);
			Core.bullet.get(y).set(x,new EmptyB(y,x));
			setX(x + getMove_speed());
			this.attack();//deal damage with bullet hit virus
		}
		else {//reach end of map delete itself
			Core.bullet.get(y).set(x,new EmptyB(y,x));
		}
		
	}
	public void dead() {
		Core.bullet.get(this.getY()).set(this.getX(), new EmptyB(this.getY(),this.getX()));
		walktimer.cancel();
	}
	
}
