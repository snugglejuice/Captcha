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
import fr.upem.capcha.images.batiments.Batiments;
import fr.upem.capcha.images.panneaux.Panneaux;
import fr.upem.capcha.images.*;

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
	
	public static void nextLevel() {
		selectedImages = new ArrayList<URL>();
		level += 1;
		
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
				}
				
				displayCaptcha();
				return;
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
	
	private static GridLayout createLayout(){
		return new GridLayout(4,3);
	}
	
	private  static JButton createOkButton(){
		return new JButton(new AbstractAction("Vérifier") { //ajouter l'action du bouton
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() { // l'interface donc appeler cela dans la queue des événements
				
					@Override
					public void run() {
						int nb_answer = 0;
						int nb_given = 0;
						for (URL img : selectedImages) {
							if (!selectedCategorie.isPhotoCorrect(img)) {
								JOptionPane.showMessageDialog(null, "Vous n'avez pas sélectionné les bonnes images", "Information", JOptionPane.INFORMATION_MESSAGE);
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
							JOptionPane.showMessageDialog(null, "Vous n'êtes pas un robot ! ", "Information", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
							return;
						}
						
						else {
							JOptionPane.showMessageDialog(null, "Vous n'avez pas sélectionné les bonnes images", "Information", JOptionPane.INFORMATION_MESSAGE);
							nextLevel();
							return;
						}
						
					}
				});
			}
		});
	}
	
	private static JLabel createLabelImage(URL url) throws IOException{
		
		//final URL url = Main.class.getResource(imageLocation); //Aller chercher les images !! IMPORTANT 
		
		BufferedImage img = ImageIO.read(url); //lire l'image
		Image sImage = img.getScaledInstance(1024/3,768/4, Image.SCALE_SMOOTH); //redimentionner l'image
		
		final JLabel label = new JLabel(new ImageIcon(sImage)); // créer le composant pour ajouter l'image dans la fenêtre
		
		label.addMouseListener(new MouseListener() { //Ajouter le listener d'événement de souris
			private boolean isSelected = false;
			
			
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
			public void mouseClicked(MouseEvent arg0) { //ce qui nous intéresse c'est lorsqu'on clique sur une image, il y a donc des choses à faire ici
				EventQueue.invokeLater(new Runnable() { 
					
					@Override
					public void run() {
						if(!isSelected){
							label.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
							isSelected = true;
							selectedImages.add(url);
						}
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
	
	public static void displayCaptcha() {
		frame.getContentPane().removeAll();
		frame.repaint();
		GridLayout layout = createLayout();  // Création d'un layout de type Grille avec 4 lignes et 3 colonnes
		frame.setLayout(layout);  // affection du layout dans la fenêtre.
		frame.setSize(1024, 768); // définition de la taille
		frame.setResizable(false);  // On définit la fenêtre comme non redimentionnable
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Lorsque l'on ferme la fenêtre on quitte le programme.
		JButton okButton = createOkButton();
		 //ajouter des composants à la fenêtre
		for (int i = 0; i < selectedPhoto.size(); i++) {
			try {
				frame.add(createLabelImage(selectedPhoto.get(i)));	
			}
			catch (IOException e) {
				
			}
		}
		frame.add(new JTextArea("Veuillez sélectionner les images qui contiennent des \n" + selectedCategorie.toString()));
		frame.add(okButton);
		frame.setVisible(true);
	}
	
}
