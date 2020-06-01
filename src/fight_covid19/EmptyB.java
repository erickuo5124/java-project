package fight_covid19;

public class EmptyB extends Bullet{
	public EmptyB(int y,int x){
		super.setHP(0);
		super.setATK(0);
		super.setMove_speed(0);
		super.setname("E");
		super.setX(x);
		super.setY(y);
	}
}
