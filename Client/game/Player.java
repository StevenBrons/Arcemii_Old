import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Player {

	private ObjectOutputStream out;
	private ObjectInputStream in;

	public Player(ObjectOutputStream out) {
		this.out = out;
	}

	public void input(Object o) {
		switch (o.getClass().getName()) {
		default:
			System.err.println(o.getClass().getName());
			break;
		}
	}

	public void output(Object o) {
		try {
			out.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
