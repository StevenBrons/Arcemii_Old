import tiles.Tile;

public class TestGenerator extends Generator {

	public Dungeon generate(GeneratorSettings s) {
		Dungeon d = new Dungeon();
		d.tiles = new Tile[s.width][s.height];
		for (int x = 0; x < s.width; x++) {
			for (int y = 0; y < s.height; y++) {
				d.tiles[x][y] = new Tile();
				d.tiles[x][y].posx = x;
				d.tiles[x][y].posy = y;
			}
		}
		return d;
	}

}
