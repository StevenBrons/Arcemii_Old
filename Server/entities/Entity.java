

import java.io.Serializable;
import java.util.Random;

public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Ability[] abilities;
	Level level;
	
	public short id;

	public double velx = 0;
	public double vely = 0;

	public double x = 0;
	public double y = 0;

	public Entity(Level level) {
		 this.level = level;
	}

	public void update() {
		x += velx;
		y += vely;
	}
	
	public void invoke() {
	
	}

}
