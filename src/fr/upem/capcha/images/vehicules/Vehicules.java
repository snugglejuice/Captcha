package fr.upem.capcha.images.vehicules;
import java.net.URL;
import java.util.List;
import java.util.Random;

import fr.upem.capcha.images.Categories;

public class Vehicules extends Categories {
	
	private List<URL> photoList;
	private List<Categories> categoryList;
	
	public Vehicules(List<URL> photoList, List<Categories> categoryList) {
		super();
		this.photoList = photoList;
		this.categoryList = categoryList;
	}
	
		
	public List<URL> getPhotos() {
		return photoList;
	}
	
	private boolean contain(int[] arr, int number, int index) {
		if (index == 0) return false;
		for (int i = 0; i < index; i++) {
			if (arr[i] == number) return true;
		}
		return false;
	}
	public List<URL> getRandomPhotosURL(int n){
		// n > 6 erreur
		Random rd = new Random();
		int[] arr = new int[n];
		for (int j = 0; j < n; j++) {
			int nb = rd.nextInt();
			while (contain(arr,nb,j) == true) {
				nb = rd.nextInt()
			}
		}
	}
	
	public URL getRandomPhotosURL();
	public boolean isPhotoCorrect(URL img);
	
}
