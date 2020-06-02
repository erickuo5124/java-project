package fight_covid19;
import java.util.*;


public class EmptyV extends Virus{
	public EmptyV(int y,int x){
		super.setHP(0);
		super.setATK(0);
		super.setMove_speed(0);
		super.setname("E");
		super.setX(x);
		super.setY(y);

	}
}
