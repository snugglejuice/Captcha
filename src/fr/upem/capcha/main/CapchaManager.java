package fr.upem.capcha.main;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import fr.upem.capcha.images.*;

public class CapchaManager {
	
	int level;
	Categories selectedCategorie;
	List<URL> selectedPhoto;
	
	public CapchaManager() {
		this.level = 1;
		Categories categoryManager = new Categories();
		categoryManager.initialize();
		this.selectedCategorie = categoryManager.getRandomCategory();
		
		this.selectedPhoto = new ArrayList<URL>();
		Random rand = new Random();
		int nb = rand.nextInt(9) + 1;
		System.out.println(nb);
		selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
	}
	
	public int getLevel() {
		return level;
	}
	
	public Categories getSelectedCategorie() {
		return selectedCategorie;
	}
	
	public List<URL> getSelectedPhoto() {
		return selectedPhoto;
	}
	
}
