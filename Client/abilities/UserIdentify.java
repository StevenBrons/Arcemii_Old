import java.nio.ByteBuffer;

public class UserIdentify extends Ability{
	public UserIdentify(Entity exEntity) {
		super(exEntity);
	}

	public void execute(ByteBuffer bb) {
		executor.level.player = (Player) executor.level.getEntity(bb.getShort());
	}

	public void invoke() {
		send(ByteBuffer.allocate(0));
	}

}
