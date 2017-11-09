
public class DungeonCreator {

	TestGenerator test = new TestGenerator();

	public Dungeon createDungeon(String id) {
		Dungeon d = test.generate(new GeneratorSettings(10, 10));
		d.id = id;
		return d;

	}

}
