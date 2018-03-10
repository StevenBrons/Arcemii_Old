import java.io.Serializable;
import java.nio.ByteBuffer;

public class Ability implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Entity executor;

	public Ability(Entity exEntity) {
		this.executor = exEntity;
	}

	public void execute(ByteBuffer bb) {
	}

	public void send(ByteBuffer bb) {
	    ByteBuffer buffer = ByteBuffer.allocate(bb.capacity()* + 3);
	    buffer.putShort(executor.id);
	    for (int j = 0; j < executor.abilities.length; j++) {
	    	if (executor.abilities[j].equals(this)) {
	    		buffer.put((byte)(j - 128));
	    	    break;
	    	}
	    }
	    buffer.put(bb);
	    executor.level.update.append(buffer);
	}

	public void invoke(ByteBuffer bb) {
		send(bb);
	}

	public void invoke() {
		invoke(ByteBuffer.allocate(0));
	}

}
