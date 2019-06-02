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
	
<<<<<<< HEAD
	
	private List<URL> photoList;
=======
	/**
	 * A list of the URL of the photos
	 */
	private List<URL> photoList;
	/**
	 * A list of Categories
	 */
>>>>>>> dev-categories
	private List<Categories> categoryList;
	/**
	 * A list of the category's name, in the form of String
	 */
	private List<String> categoryNameList;
<<<<<<< HEAD
=======
	/**
	 * A boolean which says if a category has subdirectories
	 */
>>>>>>> dev-categories
	private boolean hasSubdirectories;
	
	/**
	 *  Categories Constructor
	 */
	public Categories() {
		this.fillCategoryNameList();
	}
	
	/**
	 * Return a list of category's name
	 * @return the list of String of category's name
	 */
	public List<String> getCategoryNameList() {
		return categoryNameList;
	}
	
	/**
	 * Return a list of categories
	 * @return a list of Categories of the categories
	 */
	public List<Categories> getCategoryList() {
		return categoryList;
	}
	
	public boolean hasSubdirectories() {
		return hasSubdirectories;
	}
	
	/**
	 * To check if the category has subdirectories
	 * @return true if the category has subdirectories, else false
	 */
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
<<<<<<< HEAD
		File directory = new File(this.getClass().getResource("").getPath());
        System.out.println(directory);
=======
		File directory = new File(this.getClass().getResource(".").getPath());
        //get all the files from a directory
>>>>>>> dev-categories
        File[] fList = directory.listFiles();
        if (fList == null) {
        	System.out.println("PROBLEME : " + this.getClass().getResource("").getPath());
        	return;
        }
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
<<<<<<< HEAD
				photoList.add(this.getClass().getResource(cap + i + ".jpg"));
=======
				photoList.add(this.getClass().getResource("./" + cap + i + ".jpg"));
>>>>>>> dev-categories
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
		      // La classe est abstract ou est une interface ou n'a pas de constructeur accessible sans param�tre
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
	
	/**
	 * Return the URL of a photo selected randomly
	 * @return the URL of a photo
	 */
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
	
	/**
	 * Return a category selected randomly
	 * @return a Categories category
	 */
	public Categories getRandomCategory() {
		Random rand = new Random();
		int catNumber = rand.nextInt(categoryList.size());
		return categoryList.get(catNumber);
	}
	
	/**
	 *  Return an URL List of the photo path
	 *  /!\ some elements could be null because of the photoList
	 *  @param n
	 *  	the number of photo URL wanted in the list
	 *  @return an URL list (size n) of the photo path
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
	
	/**
	 * Return an URL list
	 * @return an URL list of photos
	 */
	public List<URL> getPhotos() {
		return photoList;
	}
	
	/**
	 * Check if the img matched the photo or the category
	 * @param img
	 * 
	 * @return true is img matches the photo or the category, else false
	 */
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
	
<<<<<<< HEAD
=======
	/**
	 * @return the name of the class
	 */
>>>>>>> dev-categories
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}
	
		
} 
