package fight_covid19;

import java.util.Timer;
import java.util.TimerTask;

public class Strong_virus extends Virus{
	private Timer virusmovetimer = new Timer(); //Timer
	public Strong_virus(int y,int x){
		super.setHP(100);
		super.setATK(10);
		super.setMove_speed(1);
		super.setname("S");
		super.setX(x);
		super.setY(y);
		TimerTask movevirus = new TimerTask(){
			@Override
			public void run() {			        	 
					moveforward();	
				}
				        	
		};
		virusmovetimer.schedule(movevirus, 5000, 4000);
	}
	
	public void moveforward() {
		int y = getY();
		int x = getX();
		if(Core.plant.get(y).get(x - getMove_speed()).getname().equals("E")) {
			Core.virus.get(y).set(x,new EmptyV(y,x));
			Core.virus.get(y).set(x - getMove_speed(),this);
			setX(x - getMove_speed());
			if(!Core.virus.get(y).get(x - getMove_speed()).getname().equals("E")) {
				Virus inthefront = Core.virus.get(y).get(x - getMove_speed());
				Core.virus.get(y).set(x,new EmptyV(y,x));
				inthefront.setATK(this.getATK() + inthefront.getATK());
				inthefront.setHP(this.getHP() + inthefront.getHP());
			}
		}
		
	}
	public void dead() {
		if(!super.getname().equals("E") && this.getHP() <= 0) {
			Core.virus.get(this.getY()).set(this.getX(),new EmptyV(this.getY(),this.getX()));
			virusmovetimer.cancel();
			Core.score = Core.score + 30;//get score
		}
	}

}