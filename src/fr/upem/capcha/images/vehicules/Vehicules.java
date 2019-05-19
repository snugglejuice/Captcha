package fr.upem.capcha.images.vehicules;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Random;



import fr.upem.capcha.images.*;

/**
 * Vehicules Class ( Categories )
 * 
 * 
 * 
 */

public class Vehicules extends Categories implements Images { 
	

	private List<URL> photoList;
	private List<String> categoryList;
	private List<Categories> subCategoryList;
	private boolean hasSubdirectories;
	
	
	/**
	 * Vehicules constructor
	 * Fill the categoryList with the subdirectories name
	 * Fill the photoList with the path of the pictures of the subdirectories
	 */
	public Vehicules() {
		this.fillCategoryList();
	}
	
	public void initialize() {
		this.fillPhotoList();
		this.fillSubCategoryList();
	}
	
	public List<Categories> getSubCategoryList() {
		return subCategoryList;
	}
	
	public Categories getRandomSubCategory() {
		Random rand = new Random();
		int catNumber = rand.nextInt(subCategoryList.size());
		return subCategoryList.get(catNumber);
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
		File directory = new File(Vehicules.class.getResource("../vehicules").getPath());
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
			for (int i = 1; i < 6; i++ ) {
				photoList.add(Vehicules.class.getResource("../vehicules/" + category + "/" + category + i + ".jpg"));
			}
		}
	}
	
	private void fillSubCategoryList() {
		this.subCategoryList = new ArrayList<Categories>();
		for (String str : categoryList) {
			Object classObject = null;
			String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
			try
		    {
		      classObject = Objects.requireNonNull(Class.forName("fr.upem.capcha.images.vehicules." + str + "." + cap).getDeclaredConstructor().newInstance());
		    }
		    catch (ClassNotFoundException e)
		    {
		      // La classe n'existe pas
		    }
		    catch (InstantiationException e)
		    {
		      // La classe est abstract ou est une interface ou n'a pas de constructeur accessible sans paramètre
		    }
		    catch (IllegalAccessException e)
		    {
		      // La classe n'est pas accessible
		    }
			catch (NoSuchMethodException e)
			{
				
			}
			catch (InvocationTargetException e)
			{
				
			}
			 if (this.getClass().isInstance(classObject)) {
		         subCategoryList.add((Categories) classObject); // add to child categories
			 }
		}
		return;
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
	 */
	public boolean contain(int[] arr, int number, int index) {
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
		return "véhicules";
	}
	
	
}
