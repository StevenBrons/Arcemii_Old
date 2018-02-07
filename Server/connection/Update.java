import java.io.Serializable;
import java.nio.ByteBuffer;

public class Update implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	byte[] data = new byte[0];
	
	public Update() {
	}
	
	public Update(byte[] data) {
		this.data = data;
	}
	
	public void append(ByteBuffer buffer) {
		ByteBuffer bb = ByteBuffer.allocate(buffer.capacity() + data.length);
		bb.put(buffer);
		bb.put(data);
		data = bb.array();
	}
}
