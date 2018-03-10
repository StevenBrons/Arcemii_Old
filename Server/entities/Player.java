

public class Player extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	transient public String playerID;
	transient Client client;

	boolean UP = false;
	boolean DOWN = false;
	boolean LEFT = false;
	boolean RIGHT = false;
	transient Level level = null;
	
	public Player(Client client, String id) {
		super(null);
		abilities = new Ability[]{new UserIdentify(this),new Walk(this)}; 
		this.client = client;
		
	}

	public void output(Object o) {
		client.output(o);
	}

	public void update() {
	}

}