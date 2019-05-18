package fr.upem.capcha.main;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import fr.upem.capcha.images.*;
import fr.upem.capcha.images.vehicules.Vehicules;

public class CapchaManager {
	
	int level;
	Categories selectedCategorie;
	List<URL> selectedPhoto;
	
	public CapchaManager() {
		this.level = 1;
		Categories categoryManager = new Categories();
		categoryManager.initialize();
		this.selectedCategorie = categoryManager.getRandomCategory();
		if (selectedCategorie instanceof Vehicules) {
			
			selectedCategorie.initialize();
			List<Categories> categoriesList = ((Vehicules) selectedCategorie).getSubCategoryList();
			selectedCategorie = ((Vehicules) selectedCategorie).getRandomSubCategory();
			categoriesList.remove(selectedCategorie);
			System.out.println(categoriesList);
			
			this.selectedPhoto = new ArrayList<URL>();
			Random rand = new Random();
			int nb = rand.nextInt(5) + 1;
			System.out.println(selectedCategorie);
			selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
			
			while (selectedPhoto.size() < 9) {
				Random rand2 = new Random();
				int n = rand2.nextInt(categoriesList.size());
				selectedPhoto.add(categoriesList.get(n).getRandomPhotosURL());
			}
		}		
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
