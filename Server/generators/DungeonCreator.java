public class DungeonCreator {

	TestGenerator test = new TestGenerator();

	public Level createDungeon(String id) {
		Level d = test.generate(new GeneratorSettings(10, 10));
		d.id = id;
		d.entities.add(new Entity(d));
		
		return d;

	}

}
