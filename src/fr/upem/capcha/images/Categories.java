package fr.upem.capcha.images;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.File;
import java.net.URL;
import java.util.Random;


import java.lang.reflect.*;

/**
 * @author SEBAOUN Manon 
 * @author SEMINEL Marion
 *
 */

public class Categories implements Images {  
	
	
	private List<URL> photoList;
	private List<Categories> categoryList;
	private List<String> categoryNameList;
	private boolean hasSubdirectories;
	
	/**
	 *  Categories Constructor
	 */
	public Categories() {
		this.fillCategoryNameList();
	}
	
	public List<String> getCategoryNameList() {
		return categoryNameList;
	}
	
	public List<Categories> getCategoryList() {
		return categoryList;
	}
	
	public boolean hasSubdirectories() {
		return hasSubdirectories;
	}
	
	/**
	 * initialize allow to fill category list
	 */
	public void initialize() {
		this.fillCategoryList();
		if (!categoryList.isEmpty()) {
			hasSubdirectories = true;
		}
		else {
			hasSubdirectories = false;
			this.fillPhotoList();
		}
		
	}
	
	/**
	 * fillCategoryNameList
	 * 
	 * Initialize the CategoryList with a String array which contain the name 
	 * of each subdirectories
	 * 
	 */
	private void fillCategoryNameList() {
		File directory = new File(this.getClass().getResource(".").getPath());
        //get all the files from a directory
        File[] fList = directory.listFiles();
        this.categoryNameList = new ArrayList<String>();
        for (File file : fList){
        	if (file.isDirectory()) {
        		if (file.getName() != null) {
            		this.categoryNameList.add(file.getName());
        		}
        	} 
        }
	}
	
	private void fillPhotoList() {
		if (hasSubdirectories) {
			return;
		}
		else {
			this.photoList = new ArrayList<URL>();
			String cap = this.getClass().getSimpleName().substring(0, 1).toLowerCase() + this.getClass().getSimpleName().substring(1);
			for (int i = 1; i < 6; i++ ) {
				photoList.add(this.getClass().getResource("./" + cap + i + ".jpg"));
			}	
			
		}
	}
	
	/**
	 * 
	 * fillCategoryList
	 * 
	 * fill CategoryList by creating new instance of Categories 
	 * Child with the name of the subdirectories.
	 */
	private void fillCategoryList() {
		Object classObject = null;
		this.categoryList = new ArrayList<Categories>();
		for (String str : categoryNameList) {
			String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
			try
		    {
		      classObject = Objects.requireNonNull(Class.forName(this.getClass().getPackageName() + "." + str + "." + cap).getDeclaredConstructor().newInstance());
		      
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
		         categoryList.add((Categories) classObject);
		         ((Categories) classObject).initialize();// add to child categories
			 }
		}
		return;
	}
	
	
	public URL getRandomPhotosURL() {
		if (!hasSubdirectories) {
			Random r = new Random();
			int indexPicture = r.nextInt(photoList.size());
			return this.getPhotos().get(indexPicture);
		}
		Random rand = new Random();
		int catNumber = rand.nextInt(categoryList.size());
		return categoryList.get(catNumber).getRandomPhotosURL();
	}
	
	public Categories getRandomCategory() {
		Random rand = new Random();
		int catNumber = rand.nextInt(categoryList.size());
		return categoryList.get(catNumber);
	}
	
	/**
	 *  Return a URL List of the photo path
	 *  /!\ some elements could be null because of the photoList
	 */
	public List<URL> getRandomPhotosURL(int n) {
		List<URL> selectedPhoto = new ArrayList<URL>();
		for (int i = 0; i < n; i++) {
			URL photo = this.getRandomPhotosURL();
			while (selectedPhoto.contains(photo) != false) {
				photo = this.getRandomPhotosURL();
			}
			selectedPhoto.add(photo);
		}
		return selectedPhoto;
	}
	
	public List<URL> getPhotos() {
		return photoList;
	}
	
	public boolean isPhotoCorrect(URL img) {
		if (!hasSubdirectories) {
			for (URL photo : photoList) {
				if (photo.equals(img)) return true;
			}
			return false;
		}
		else {
			for (Categories c : categoryList) {
				if (c.isPhotoCorrect(img) == true ) {
					return true;
				}
			}
			return false;
		}
	}
	
	public boolean contain(int[] arr, int number, int index) {
		if (index == 0) return false;
		for (int i = 0; i < index; i++) {
			if (arr[i] == number) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}
	
		
} 
