package fr.upem.capcha.images;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.File;
import java.net.URL;
import java.util.Random;
import java.lang.reflect.*;

public class Categories implements Images {  
	
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
		hasSubdirectories = true;
		
	}
	
	/**
	 * fillCategoryNameList
	 * 
	 * Initialize the CategoryList with a String array which contain the name 
	 * of each subdirectories
	 * 
	 */
	private void fillCategoryNameList() {
		File directory = new File(Categories.class.getResource("../Images").getPath());
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
		      classObject = Objects.requireNonNull(Class.forName("fr.upem.capcha.images." + str + "." + cap).getDeclaredConstructor().newInstance());
		      
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
		return new ArrayList<URL>();
	}
	
	public boolean isPhotoCorrect(URL img) {
		return true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "catégories";
	}
	
		
} 
