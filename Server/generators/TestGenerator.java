import tiles.Tile;

public class TestGenerator {

	public TestGenerator() {
		System.out.println("Generator gemaakt");
	}
	
	public Level makeLevel(int width, int height) {
		Level l = new Level();
		System.out.println("makeLevel wordt aangeroepen");
		l.tiles = new Tile[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				l.tiles[x][y] = new Tile();
				l.tiles[x][y].posx = x;
				l.tiles[x][y].posy = y;
			}
		}
		return l;
}
	
}
