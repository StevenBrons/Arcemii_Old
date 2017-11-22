package entities;

import java.io.Serializable;
import java.util.Random;

public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int id;

	double velx = 0;
	double vely = 0;

	double x = 0;
	double y = 0;

	public Entity() {
		id = new Random().nextInt();
	}

	public void update() {
		x += velx;
		y += vely;
	}

}
