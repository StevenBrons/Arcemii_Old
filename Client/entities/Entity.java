

import java.io.Serializable;

public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	transient Level level;
	Ability[] abilities;

	short id;
	double velx = 0;
	double vely = 0;
	double x = 0;
	double y = 0;

}
