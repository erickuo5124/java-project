package fight_covid19;
import java.util.*;


public class Book extends Plants{
	
	public Book(int y,int x){
		super.setHP(30);
		super.setATK(0);
		super.setCost(50);
		super.setATK_speed(0);
		super.setname("B");
		super.setX(x);
		super.setY(y);
		
		Timer sunflowertimer = new Timer(); //Timer
		TimerTask addsunflowr = new TimerTask(){
				@Override
				public void run() {
					Core.sun = Core.sun + 30;
				}
		};
		sunflowertimer.schedule(addsunflowr, 5000, 6000);//6 sec yeild 30 sunlight per sunflower 
	}
}
