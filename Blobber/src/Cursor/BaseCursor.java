package Cursor;

public class BaseCursor  implements ICursor{
	private int damage;
	private final int BASE_DAMAGE_CURSOR = 1;
	
	
	public BaseCursor() {
		damage = BASE_DAMAGE_CURSOR;
	}
	
	@Override
	public int getDamage() {
		return damage;
	}
}
