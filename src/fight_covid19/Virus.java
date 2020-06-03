package fight_covid19;

import java.util.Timer;

public class Virus extends D_object{
	protected Timer virusmovetimer = new Timer(); //Timer
	private int HP = 0;
	private int ATK = 0;
	private int Move_speed = 0;


	public int getHP() {
		return HP;
	}
	public void setHP(int HP) {
		this.HP = HP;
	}
	
	public int getATK() {
		return ATK;
	}
	public void setATK(int ATK) {
		this.ATK = ATK;
	}	
	
	public int getMove_speed() {
		return Move_speed;
	}
	public void setMove_speed(int Move_speed) {
		this.Move_speed = Move_speed;
	}
	
	public void attack(int x) {
		Plants plant_in_the_front = Core.plant.get(this.getY()).get(x);
		plant_in_the_front.setHP(plant_in_the_front.getHP() - this.getATK());
		plant_in_the_front.dead();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void dead() {
		virusmovetimer.cancel();
		Core.score = Core.score + 10;
		Core.virus.get(getY()).remove(0);
		System.gc();
	}
	
	public void moveforward() {
		int y = getY();
		int nextX = locationX-10;
		if(nextX<0) {
			locationX = nextX;
			return;
		}
		if(Core.plant.get(y).get(nextX/100).getname().equals("E"))
			locationX = nextX;
		else
			this.attack(nextX/100);
		
	}
		
}
