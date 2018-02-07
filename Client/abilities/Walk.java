import java.nio.ByteBuffer;

public class Walk extends Ability{
	public Walk(Entity exEntity) {
		super(exEntity);
	}

	
	public int execute(Entity e, byte[] bytes) {
		return 0;
	}

	public void invoke() {
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.put((byte) 22);
		bb.put((byte) 122);
		send(bb);
	}
	
}
