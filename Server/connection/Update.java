import java.nio.ByteBuffer;
import java.util.ArrayList;
import entities.Entity;

public class Update {

	byte[][] data;

	public Update(ArrayList<Entity> e) {
		data = new byte[e.size()][8 * 4];

		for (int i = 0; i < e.size(); i++) {
			byte[] b = new byte[4 + 8 * 4];
			ByteBuffer.wrap(b).putInt(e.get(i).id);
			ByteBuffer.wrap(b).putDouble(e.get(i).x);
			ByteBuffer.wrap(b).putDouble(e.get(i).y);
			ByteBuffer.wrap(b).putDouble(e.get(i).velx);
			ByteBuffer.wrap(b).putDouble(e.get(i).vely);
			data[i] = b;
		}

	}

}
