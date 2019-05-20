package fr.upem.capcha.images.vehicules.voiture;

import fr.upem.capcha.images.vehicules.Vehicules;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.upem.capcha.images.*;

/**
 * @author SEBAOUN Manon 
 * @author SEMINEL Marion
 *
 */

public class Voiture extends Vehicules implements Images{
	private List<URL> photoList;
	private boolean hasSubdirectories;
	
	public Voiture() {
		this.fillPhotoList();
		hasSubdirectories = false;
	}
	
	private void fillPhotoList() {
		this.photoList = new ArrayList<URL>();
		for (int i = 1; i < 6; i++ ) {
			photoList.add(Vehicules.class.getResource("../vehicules/Voiture/voiture"+ i + ".jpg"));
		}	
	}
	
	@Override
	public List<URL> getPhotos() {
		return photoList;
	}
	
	public boolean hasSubdirectories() {
		return hasSubdirectories;
	}
	
	public List<URL> getRandomPhotosURL(int n) {
		if (n > photoList.size()-1) throw new IllegalArgumentException("n must be < " + photoList.size());
		
		List<URL> rdPhoto = new ArrayList<>();
		int[] arr = new int[n];
		Random rand = new Random();		
		for (int j = 0; j < n-1; j++) {
			int nb = rand.nextInt(photoList.size()-1) + 1;
			while (contain(arr,nb,j) == true) {
				nb = rand.nextInt(photoList.size()-1) + 1;;
			}
			arr[j] = nb;
			
		}
		 for(int i : arr) {
			 rdPhoto.add(photoList.get(i));
		 }
		 return rdPhoto;
	}
	
	public URL getRandomPhotosURL() {
		Random rand = new Random();		
		int nb = rand.nextInt(photoList.size()-1) + 1;
		return photoList.get(nb);
	}
	
	public boolean isPhotoCorrect(URL img) {
		for (URL photo : photoList) {
			if (photo.equals(img)) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "voitures";
	}
	
	
	
	
}
