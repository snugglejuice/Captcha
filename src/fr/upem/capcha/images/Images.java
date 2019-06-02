package fr.upem.capcha.images;
import java.util.List;
import java.net.URL;

/**
 * @author SEBAOUN Manon 
 * @author SEMINEL Marion
 *
 */

public interface Images {
	
	public List<URL> getPhotos();
	public List<URL> getRandomPhotosURL(int i);
	public URL getRandomPhotosURL();
	public boolean isPhotoCorrect(URL img);

}