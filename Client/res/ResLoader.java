import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ResLoader {
	static ResLoader rl = new ResLoader();

	static HashMap<String, BufferedImage> textures = new HashMap<>();

	public static BufferedImage getTexture(String name) {
		BufferedImage i = textures.get(name);
		if (i == null) {
			try {
				i = ImageIO.read(rl.getClass().getResource("/Textures/" + name + ".png"));
				textures.put(name, i);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return i;
	}

	public static InputStream getStream(String name) {
		InputStream is = ResLoader.class.getClassLoader().getResourceAsStream(name);
		return is;
	}

	public static URL getResource(String name) {
		URL is = ResLoader.class.getResource(name);
		return is;
	}

}
