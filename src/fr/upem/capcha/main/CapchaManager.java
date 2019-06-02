package fr.upem.capcha.main;
import java.net.URL;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import fr.upem.capcha.images.vehicules.Vehicules;
import fr.upem.capcha.images.nourriture.Nourriture;
<<<<<<< HEAD
import fr.upem.capcha.images.Categories;
=======
import fr.upem.capcha.images.batiments.Batiments;
import fr.upem.capcha.images.panneaux.Panneaux;
import fr.upem.capcha.images.*;
>>>>>>> dev-categories

/**
 * @author SEBAOUN Manon 
 * @author SEMINEL Marion
 *
 */
public class CapchaManager {
	
	private static Categories selectedCategorie;
	private static List<URL> selectedPhoto;
	private static ArrayList<URL> selectedImages = new ArrayList<URL>();
	private static int level;
	private static JFrame frame = new JFrame("Capcha");
	
	/**
	 * Constructor of CapchaManager
	 * Initialize to level 1 and select randomly one category
	 * Then, select a random number of photos of this category (between 1 and 4)
	 * Complete the captcha with pictures of others categories
	 */
	public CapchaManager() {
		level = 1;
		Categories categoryManager = new Categories();
		categoryManager.initialize();
		selectedCategorie = categoryManager.getRandomCategory();
		selectedCategorie.initialize();
		if (selectedCategorie instanceof Vehicules) {
			
			selectedCategorie.initialize();
			List<Categories> categoriesList = categoryManager.getCategoryList();
			categoriesList.remove(selectedCategorie); 
<<<<<<< HEAD
=======
			
			selectedPhoto = new ArrayList<URL>();
			Random rand = new Random();
			int nb = rand.nextInt(4) + 1;
			selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
			
			while (selectedPhoto.size() < 9) {
				Random rand2 = new Random();
				int n = rand2.nextInt(categoriesList.size());
				selectedPhoto.add(categoriesList.get(n).getRandomPhotosURL());
			}
		}
		
		if (selectedCategorie instanceof Nourriture) {
			
			
			selectedCategorie.initialize();
			List<Categories> categoriesList = categoryManager.getCategoryList();
			categoriesList.remove(selectedCategorie); 
			
			selectedPhoto = new ArrayList<URL>();
			Random rand = new Random();
			int nb = rand.nextInt(4) + 1;
			selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
			
			while (selectedPhoto.size() < 9) {
				Random rand2 = new Random();
				int n = rand2.nextInt(categoriesList.size());
				selectedPhoto.add(categoriesList.get(n).getRandomPhotosURL());
			}
		}
		
		if (selectedCategorie instanceof Batiments) {
			
			selectedCategorie.initialize();
			List<Categories> categoriesList = categoryManager.getCategoryList();
			categoriesList.remove(selectedCategorie); 
			
			selectedPhoto = new ArrayList<URL>();
			Random rand = new Random();
			int nb = rand.nextInt(4) + 1;
			selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
			
			while (selectedPhoto.size() < 9) {
				Random rand2 = new Random();
				int n = rand2.nextInt(categoriesList.size());
				selectedPhoto.add(categoriesList.get(n).getRandomPhotosURL());
			}
		}
		
		if (selectedCategorie instanceof Panneaux) {
			
			selectedCategorie.initialize();
			List<Categories> categoriesList = categoryManager.getCategoryList();
			categoriesList.remove(selectedCategorie); 
>>>>>>> dev-categories
			
			selectedPhoto = new ArrayList<URL>();
			Random rand = new Random();
			int nb = rand.nextInt(4) + 1;
			selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
			
			while (selectedPhoto.size() < 9) {
				Random rand2 = new Random();
				int n = rand2.nextInt(categoriesList.size());
				selectedPhoto.add(categoriesList.get(n).getRandomPhotosURL());
			}
		}
<<<<<<< HEAD
		
		if (selectedCategorie instanceof Nourriture) {
			
			
			selectedCategorie.initialize();
			List<Categories> categoriesList = categoryManager.getCategoryList();
			categoriesList.remove(selectedCategorie); 
			
			selectedPhoto = new ArrayList<URL>();
			Random rand = new Random();
			int nb = rand.nextInt(4) + 1;
			selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
			
			while (selectedPhoto.size() < 9) {
				Random rand2 = new Random();
				int n = rand2.nextInt(categoriesList.size());
				selectedPhoto.add(categoriesList.get(n).getRandomPhotosURL());
			}
		}
	}
	
=======
	}
	
	/**
	 * Generate a new level of difficulty
	 * Select a subcategory and a random number of pictures from the subcategory
	 */
>>>>>>> dev-categories
	public static void nextLevel() {
		selectedImages = new ArrayList<URL>();
		level += 1;
		
<<<<<<< HEAD
=======
		/**
		 * Check if the selected category has subdirectories
		 * Then, select a subcategory
		 */
>>>>>>> dev-categories
		if (selectedCategorie.hasSubdirectories()) {
			if (selectedCategorie instanceof Vehicules) {
				
				selectedCategorie.initialize();
				List<Categories> categoriesList = ((Vehicules) selectedCategorie).getCategoryList();
				selectedCategorie = ((Vehicules) selectedCategorie).getRandomCategory();
				categoriesList.remove(selectedCategorie);
				
				selectedPhoto = new ArrayList<URL>();
				Random rand = new Random();
				int nb = rand.nextInt(4) + 1;
				selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
				
				while (selectedPhoto.size() < 9) {
					Random rand2 = new Random();
					int n = rand2.nextInt(categoriesList.size());
					selectedPhoto.add(categoriesList.get(n).getRandomPhotosURL());
				}
			}
			
			if (selectedCategorie instanceof Nourriture) {
				
				
				selectedCategorie.initialize();
				List<Categories> categoriesList = ((Nourriture) selectedCategorie).getCategoryList();
				selectedCategorie = ((Nourriture) selectedCategorie).getRandomCategory();
				categoriesList.remove(selectedCategorie);
				
				selectedPhoto = new ArrayList<URL>();
				Random rand = new Random();
				int nb = rand.nextInt(4) + 1;
				selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
				
				while (selectedPhoto.size() < 9) {
					Random rand2 = new Random();
					int n = rand2.nextInt(categoriesList.size());
					selectedPhoto.add(categoriesList.get(n).getRandomPhotosURL());
				}
			}
<<<<<<< HEAD
=======
			
			if (selectedCategorie instanceof Batiments) {
				
				
				selectedCategorie.initialize();
				List<Categories> categoriesList = ((Batiments) selectedCategorie).getCategoryList();
				selectedCategorie = ((Batiments) selectedCategorie).getRandomCategory();
				categoriesList.remove(selectedCategorie);
				
				selectedPhoto = new ArrayList<URL>();
				Random rand = new Random();
				int nb = rand.nextInt(4) + 1;
				selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
				
				while (selectedPhoto.size() < 9) {
					Random rand2 = new Random();
					int n = rand2.nextInt(categoriesList.size());
					selectedPhoto.add(categoriesList.get(n).getRandomPhotosURL());
				}
			}
			
			if (selectedCategorie instanceof Panneaux) {
				
				
				selectedCategorie.initialize();
				List<Categories> categoriesList = ((Panneaux) selectedCategorie).getCategoryList();
				selectedCategorie = ((Panneaux) selectedCategorie).getRandomCategory();
				categoriesList.remove(selectedCategorie);
				
				selectedPhoto = new ArrayList<URL>();
				Random rand = new Random();
				int nb = rand.nextInt(4) + 1;
				selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
				
				while (selectedPhoto.size() < 9) {
					Random rand2 = new Random();
					int n = rand2.nextInt(categoriesList.size());
					selectedPhoto.add(categoriesList.get(n).getRandomPhotosURL());
				}
			}
>>>>>>> dev-categories
			displayCaptcha();
			return;
		}
		
		else {
			if (selectedCategorie instanceof Vehicules) {
				Vehicules v = new Vehicules();
				v.initialize();
				List<Categories> categoriesList = ((Vehicules) v).getCategoryList();
				categoriesList.remove(selectedCategorie);
				
				selectedPhoto = new ArrayList<URL>();
				Random rand = new Random();
				int nb = rand.nextInt(4) + 1;
				selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
				
				while (selectedPhoto.size() < 9 + level) {
					Random rand2 = new Random();
					int n = rand2.nextInt(categoriesList.size());
					selectedPhoto.add(categoriesList.get(n).getRandomPhotosURL());
				}
				
				displayCaptcha();
				return;
			}
			
			if (selectedCategorie instanceof Nourriture) {
				Nourriture n = new Nourriture();
				n.initialize();
				List<Categories> categoriesList = ((Nourriture) n).getCategoryList();
				categoriesList.remove(selectedCategorie);
				
				selectedPhoto = new ArrayList<URL>();
				Random rand = new Random();
				int nb = rand.nextInt(4) + 1;
				selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
				
				while (selectedPhoto.size() < 9 + level) {
					Random rand2 = new Random();
					int nb2 = rand2.nextInt(categoriesList.size());
					selectedPhoto.add(categoriesList.get(nb2).getRandomPhotosURL());
<<<<<<< HEAD
				}
=======
				}	
>>>>>>> dev-categories
				
				displayCaptcha();
				return;
			}
			
<<<<<<< HEAD
			
=======
			if (selectedCategorie instanceof Batiments) {
				Batiments b = new Batiments();
				b.initialize();
				List<Categories> categoriesList = ((Batiments) b).getCategoryList();
				categoriesList.remove(selectedCategorie);
				
				selectedPhoto = new ArrayList<URL>();
				Random rand = new Random();
				int nb = rand.nextInt(4) + 1;
				selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
				
				while (selectedPhoto.size() < 9 + level) {
					Random rand2 = new Random();
					int nb2 = rand2.nextInt(categoriesList.size());
					selectedPhoto.add(categoriesList.get(nb2).getRandomPhotosURL());
				}	
				
				displayCaptcha();
				return;
			}
			
			if (selectedCategorie instanceof Panneaux) {
				Panneaux p = new Panneaux();
				p.initialize();
				List<Categories> categoriesList = ((Panneaux) p).getCategoryList();
				categoriesList.remove(selectedCategorie);
				
				selectedPhoto = new ArrayList<URL>();
				Random rand = new Random();
				int nb = rand.nextInt(4) + 1;
				selectedPhoto = selectedCategorie.getRandomPhotosURL(nb);
				
				while (selectedPhoto.size() < 9 + level) {
					Random rand2 = new Random();
					int nb2 = rand2.nextInt(categoriesList.size());
					selectedPhoto.add(categoriesList.get(nb2).getRandomPhotosURL());
				}	
				
				displayCaptcha();
				return;
			}
>>>>>>> dev-categories
		}
	}
	
	/**
	 * @return the actual level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * @return the category selected
	 */
	public Categories getSelectedCategorie() {
		return selectedCategorie;
	}
	
	/**
	 * @return the photo selected
	 */
	public List<URL> getSelectedPhoto() {
		return selectedPhoto;
	}
	
<<<<<<< HEAD
=======
	/**
	 * Create a grid with 4 rows and 3 columns
	 * @return a layout with 4 rows and 3 columns
	 */
>>>>>>> dev-categories
	private static GridLayout createLayout(){
		return new GridLayout(4,3);
	}
	
<<<<<<< HEAD
	private  static JButton createOkButton(){
		return new JButton(new AbstractAction("VÈrifier") { //ajouter l'action du bouton
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() { // l'interface donc appeler cela dans la queue des ÈvËnements
				
					@Override
					public void run() { // c'est un runnable
=======
	/**
	 * Create a JButton
	 * React according to what the user select
	 * If the user selects all the good answers, a message is displayed and the window is closed - end of the program
	 * Else, the level increases (+1)
	 * @return
	 */
	private  static JButton createOkButton(){
		return new JButton(new AbstractAction("V√©rifier") { //ajouter l'action du bouton
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() { // l'interface donc appeler cela dans la queue des √©v√©nements
				
					@Override
					public void run() {
>>>>>>> dev-categories
						int nb_answer = 0;
						int nb_given = 0;
						for (URL img : selectedImages) {
							if (!selectedCategorie.isPhotoCorrect(img)) {
<<<<<<< HEAD
								JOptionPane.showMessageDialog(null, "Vous n'avez pas sÈlectionnÈ les bonnes images", "Information", JOptionPane.INFORMATION_MESSAGE);
=======
								JOptionPane.showMessageDialog(null, "Vous n'avez pas s√©lectionn√© les bonnes images", "Information", JOptionPane.INFORMATION_MESSAGE);
>>>>>>> dev-categories
								nextLevel();
								return;
							}
							else {
								nb_given ++;
							}
						}
						
						for (URL img : selectedPhoto) {
							if (selectedCategorie.isPhotoCorrect(img)) {
								nb_answer ++;
							}
						}
						
						if (nb_answer == nb_given) {
<<<<<<< HEAD
							JOptionPane.showMessageDialog(null, "Vous n'Ítes pas un robot ! ", "Information", JOptionPane.INFORMATION_MESSAGE);
=======
							JOptionPane.showMessageDialog(null, "Vous n'√™tes pas un robot ! ", "Information", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
>>>>>>> dev-categories
							return;
						}
						
						else {
<<<<<<< HEAD
							JOptionPane.showMessageDialog(null, "Vous n'avez pas sÈlectionnÈ les bonnes images", "Information", JOptionPane.INFORMATION_MESSAGE);
=======
							JOptionPane.showMessageDialog(null, "Vous n'avez pas s√©lectionn√© les bonnes images", "Information", JOptionPane.INFORMATION_MESSAGE);
>>>>>>> dev-categories
							nextLevel();
							return;
						}
						
					}
				});
			}
		});
	}
	
<<<<<<< HEAD
=======
	/**
	 * Create a label for a photo
	 * Detect if the user clicked on the photo
	 * 
	 * @param url
	 * 	the url of the photo
	 * @return a JLabel
	 * @throws IOException
	 */
>>>>>>> dev-categories
	private static JLabel createLabelImage(URL url) throws IOException{
		
		//final URL url = Main.class.getResource(imageLocation); //Aller chercher les images !! IMPORTANT 
		
		BufferedImage img = ImageIO.read(url); //lire l'image
		Image sImage = img.getScaledInstance(1024/3,768/4, Image.SCALE_SMOOTH); //redimentionner l'image
		
<<<<<<< HEAD
		final JLabel label = new JLabel(new ImageIcon(sImage)); // crÈer le composant pour ajouter l'image dans la fen√™tre
		
		label.addMouseListener(new MouseListener() { //Ajouter le listener d'Èvenement de souris
			private boolean isSelected = false;
			
			
=======
		final JLabel label = new JLabel(new ImageIcon(sImage)); // cr√©er le composant pour ajouter l'image dans la fen√™tre
		
		label.addMouseListener(new MouseListener() { //Ajouter le listener d'√©v√©nement de souris
			private boolean isSelected = false;
			
			/**
			 * Events of the mouse
			 */
>>>>>>> dev-categories
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
		
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) { //ce qui nous int√©resse c'est lorsqu'on clique sur une image, il y a donc des choses √† faire ici
				EventQueue.invokeLater(new Runnable() { 
<<<<<<< HEAD
					
=======
					/**
					 * If the user clicks on an unselected photo, a red border appears
					 */
>>>>>>> dev-categories
					@Override
					public void run() {
						if(!isSelected){
							label.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
							isSelected = true;
							selectedImages.add(url);
						}
<<<<<<< HEAD
=======
						/**
						 * If the user clicks on a selected photo, the red border disappears
						 */
>>>>>>> dev-categories
						else {
							label.setBorder(BorderFactory.createEmptyBorder());
							isSelected = false;
							selectedImages.remove(url);
						}
						
					}
				});
				
			}
		});
		
		return label;
	}
	
<<<<<<< HEAD
	public static void displayCaptcha() {
		frame.getContentPane().removeAll();
		frame.repaint();
		GridLayout layout = createLayout();  // CrÈation d'un layout de type Grille avec 4 lignes et 3 colonnes
		frame.setLayout(layout);  // affection du layout dans la fen√™tre.
		frame.setSize(1024, 768); // dÈfinition de la taille
		frame.setResizable(false);  // On dÈfinit la fenÍtre comme non redimentionnable
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Lorsque l'on ferme la fen√™tre on quitte le programme.
		JButton okButton = createOkButton();
		 //ajouter des composants ‡† la fenÍtre
=======
	/**
	 * Display the captcha with photos, the button and what the user has to select
	 * Size is 1024*768 px, window no resizable
	 */
	public static void displayCaptcha() {
		frame.getContentPane().removeAll();
		frame.repaint();
		GridLayout layout = createLayout();  // Cr√©ation d'un layout de type Grille avec 4 lignes et 3 colonnes
		frame.setLayout(layout);  // affection du layout dans la fen√™tre.
		frame.setSize(1024, 768); // d√©finition de la taille
		frame.setResizable(false);  // On d√©finit la fen√™tre comme non redimentionnable
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Lorsque l'on ferme la fen√™tre on quitte le programme.
		JButton okButton = createOkButton();
		 //ajouter des composants √† la fen√™tre
>>>>>>> dev-categories
		for (int i = 0; i < selectedPhoto.size(); i++) {
			try {
				frame.add(createLabelImage(selectedPhoto.get(i)));	
			}
			catch (IOException e) {
				
			}
		}
<<<<<<< HEAD
		frame.add(new JTextArea("Veuillez sÈllectionner les images qui contiennent des \n" + selectedCategorie.toString()));
=======
		frame.add(new JTextArea("Veuillez s√©lectionner les images qui contiennent des \n" + selectedCategorie.toString()));
>>>>>>> dev-categories
		frame.add(okButton);
		frame.setVisible(true);
	}
	
}
