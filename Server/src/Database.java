import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Database {

	File dataPath = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath()).getParentFile();
	ArrayList<PlayerData> players = new ArrayList<>();

	public Database() {
		initPlayerData();
	}

	@SuppressWarnings("unchecked")
	private void initPlayerData() {
		File playerFile = new File(dataPath.getAbsolutePath() + File.separator + "playerData.txt");

		try { // One try-catch to rule them all!!! (try stop me)
			if (!playerFile.exists()) {
				playerFile.createNewFile();
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(playerFile));
				output.writeObject(players);
				output.close();
			}

			ObjectInputStream input = new ObjectInputStream(new FileInputStream(playerFile));
			players = (ArrayList<PlayerData>) input.readObject();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public PlayerData getPlayerData(String id) {
		for (PlayerData playerData : players) {
			if (playerData.id.equals(id)) {
				return playerData;
			}
		}
		return null;
	}
}
