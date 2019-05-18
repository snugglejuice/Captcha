package fr.upem.capcha.images.nourriture;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import fr.upem.capcha.images.Categories;

/**
 * Nourriture Class ( Categories )
 * 
 * 
 * 
 */


public class Nourriture extends Categories {
	
	private List<URL> photoList;
	private List<String> categoryList;
	private boolean hasSubdirectories;
	
	/**
	 * Nourriture constructor
	 * Fill the categoryList with the subdirectories name
	 * Fill the photoList with the path of the pictures of the subdirectories
	 */
	
	public Nourriture() {
		this.fillCategoryList();
		this.fillPhotoList();
	}
	
	/**
	 * fillCategoryList
	 * 
	 * Initialize the CategoryList with a String array which contain the name 
	 * of each subdirectories
	 * 
	 * Initialize hasSubdirectories
	 * 
	 */
	private void fillCategoryList() {
		File directory = new File(Nourriture.class.getResource("../nourriture").getPath());
        //get all the files from a directory
        File[] fList = directory.listFiles();
        this.categoryList = new ArrayList<String>();
        for (File file : fList){
        	if (file.isDirectory()) {
        		if (file.getName() != null) {
            		this.categoryList.add(file.getName());
        		}
        	} 
        }
        if (categoryList.isEmpty()) {
        	this.hasSubdirectories = false;
        	return;
        }
        
        this.hasSubdirectories = true;
        return;
	}
	
	/**
	 * fillPhotoList
	 * 
	 * Initialize the photoList with an URL array which contain the path 
	 * of each photos ( for the moment only the 3 first ) of each categories.
	 * 
	 *  /!\ a photoList's member could be null ( Require non null ? )
	 * 
	 */
	private void fillPhotoList() {
		this.photoList = new ArrayList<URL>();
		for(String category : categoryList) {
			for (int i = 1; i < 4; i++ ) {
				photoList.add(Nourriture.class.getResource("../nourriture/" + category + "/" + category + i + ".jpg"));
			}
		}
	}
	
	@Override
	public String toString() {
		
		return "this category contain " 
				+ photoList.size() 
				+ " pictures and " 
				+ categoryList.size() 
				+ " categories";
	}

	public List<URL> getPhotos() {
		return photoList;
	}
	
	public List<String> getCategories() {
		return categoryList;
	}
	
	public boolean subdirectories() {
		return hasSubdirectories;
	}
	
	/**
	 * 
	 * @param arr
	 * @param number
	 * @param index
	 * @return boolean
	 * 
	 * Watch if the arr contain the number 
	 * return true if the number is contained
	 * else false
	 * */
	
	private boolean contain(int[] arr, int number, int index) {
		if (index == 0) return false;
		for (int i = 0; i < index; i++) {
			if (arr[i] == number) return true;
		}
		return false;
	}
	
	/**
	 *  Return a URL List of the photo path
	 *  /!\ some elements could be null because of the photoList
	 */
	
	public List<URL> getRandomPhotosURL(int n) {
		if (n > photoList.size()-1){
			throw new IllegalArgumentException("n must be < " + photoList.size());
		}
		
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
		Random r = new Random();
		int randomNumber = r.nextInt(photoList.size()-1) + 1;
		return photoList.get(randomNumber);
	}

	public boolean isPhotoCorrect(URL img) {
		for (URL photo : photoList) {
			if (photo.equals(img)) return true;
		}
		return false;
	}

}
