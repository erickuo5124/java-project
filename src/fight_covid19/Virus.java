package fight_covid19;

public class Virus extends D_object{
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
	
	public void attack() {
		Plants plant_in_the_front = Core.plant.get(this.getY()).get(this.getX() - 1);
		plant_in_the_front.setHP(plant_in_the_front.getHP() - this.getATK());
		plant_in_the_front.dead();
	}
	
	public void dead() {}//implement in each plants for stopping different timer
		
}
