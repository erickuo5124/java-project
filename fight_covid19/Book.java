package fight_covid19;
import java.util.*;


public class Book extends Plants{
	private Timer sunflowertimer = new Timer(); //Timer
	public Book(int y,int x){
		super.setHP(30);
		super.setATK(0);
		super.setCost(50);
		super.setATK_speed(0);
		super.setname("B");
		super.setX(x);
		super.setY(y);
		
		Core.sun = Core.sun - super.getCost();//spend sun 
		
		
		TimerTask addsunflowr = new TimerTask(){
				@Override
				public void run() {
					Core.sun = Core.sun + 30;
				}
		};
		sunflowertimer.schedule(addsunflowr, 5000, 6000);//6 sec yeild 30 sunlight per sunflower 
	}
	
	public void dead() {
		if(!super.getname().equals("E") && this.getHP() <= 0) {
			Core.plant.get(this.getY()).set(this.getX(),new EmptyP(this.getY(),this.getX()));
			sunflowertimer.cancel();
		}
	}
}
