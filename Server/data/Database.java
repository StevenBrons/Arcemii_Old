import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Database {

	File dataPath = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath()).getParentFile();
	File playerFile = new File(dataPath.getAbsolutePath() + File.separator + "playerData.txt");
	ObjectInputStream input;

	public Database() {
		try {
			input = new ObjectInputStream(new FileInputStream(playerFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	Player getPlayerData() {
		return null;
	}

}
