package mypackage.util.constants;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import mypackage.scene.menu.Menu;

public class FileReaderUtils {

	static final ClassLoader loader = Menu.class.getClassLoader();

	public static File getFile(String path) {
		try {
			return new File(loader.getResource(path).toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static URI getURI(String path) {
		try {
			return loader.getResource(path).toURI();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static URL getURL(String path) {
		try {
			return loader.getResource(path).toURI().toURL();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static InputStream getInputStream(String path) {
		return loader.getResourceAsStream(path);
	}

}
