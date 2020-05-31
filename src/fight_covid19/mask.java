package fight_covid19;
import java.util.*;


public class mask extends Plants{
	
	public mask(int y,int x){
		super.setHP(100);
		super.setATK(0);
		super.setCost(50);
		super.setATK_speed(0);
		super.setname("M");
		super.setX(x);
		super.setY(y);
		
		Core.sun = Core.sun - super.getCost();//spend sun 
		
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
