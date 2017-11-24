package entities;

import java.io.Serializable;
import java.util.Random;

public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int id;

	public double velx = 0;
	public double vely = 0;

	public double x = 0;
	public double y = 0;

	public Entity() {
		id = new Random().nextInt();
	}

	public void update() {
		x += velx;
		y += vely;
	}

}
