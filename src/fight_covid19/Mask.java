package fight_covid19;


public class Mask extends Plants{
	
	public Mask(int y,int x){
		super.setHP(100);
		super.setATK(0);
		super.setCost(50);
		super.setATK_speed(0);
		super.setname("M");
		super.setX(x);
		super.setY(y);
		
		Core.sun = Core.sun - super.getCost();//spend sun
	}

	public void dead() {
		Core.plant.get(this.getY()).set(this.getX(),new EmptyP(this.getY(),this.getX()));
	}
}
