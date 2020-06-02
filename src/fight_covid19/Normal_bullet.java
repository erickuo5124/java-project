package fight_covid19;

public class Normal_bullet extends Bullet{
	public Normal_bullet(int y,int x){
		setLocation(x * 100 + 90);
		super.setHP(10);
		super.setATK(10);
		super.setMove_speed(1);
		super.setname("N");
		super.setX(x);
		super.setY(y);
	}	
}
