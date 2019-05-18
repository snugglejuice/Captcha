package fr.upem.capcha.main;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import fr.upem.capcha.images.vehicules.Vehicules;
import fr.upem.capcha.images.Categories;

import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.io.File;


public class Main {
	
	private static ArrayList<URL> selectedImages = new ArrayList<URL>();
	
	/**
	 *  1 - créer un algorithme qui choisit aléatoirement la catégorie selon la difficulté 
	 *  2 - Récuppérer les images de la bonne catégorie avec un nombre aléatoire
	 *  3 - Récuperérer des img random
	 *  4 - Display les img 
	 *  5 - Action Utilisateur
	 *	6 - validation, on regarde si les img font bien partie du bon package
	 *	6 a) Good : " Message de validation "
	 *	6 b) Mauvais : On retourne au 1 avec difficulté + 1
	 */
	
	public static void main(String[] args) throws IOException {
		
		CapchaManager c = new CapchaManager();
		List<URL> selected = c.getSelectedPhoto();
		
		
		JFrame frame = new JFrame("Capcha"); // Création de la fenêtre principale	
		GridLayout layout = createLayout();  // Création d'un layout de type Grille avec 4 lignes et 3 colonnes
		frame.setLayout(layout);  // affection du layout dans la fenÃªtre.
		frame.setSize(1024, 768); // définition de la taille
		frame.setResizable(false);  // On définit la fenêtre comme non redimentionnable
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Lorsque l'on ferme la fenÃªtre on quitte le programme.
		JButton okButton = createOkButton();
		 //ajouter des composants à  la fenêtre
		for (int i = 0; i < selected.size(); i++) {
			frame.add(createLabelImage(selected.get(i)));
		}
		frame.add(new JTextArea("Sélectionner tous les véhicules"));
		frame.add(okButton);
		frame.setVisible(true);
		 
	}
	
	
	private static GridLayout createLayout(){
		return new GridLayout(4,3);
	}
	
	private static JButton createOkButton(){
		return new JButton(new AbstractAction("Vérifier") { //ajouter l'action du bouton
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() { // l'interface donc appeler cela dans la queue des évènements
				
					@Override
					public void run() { // c'est un runnable
						System.out.println("J'ai cliquÃ© sur Ok");
					}
				});
			}
		});
	}
	
	private static JLabel createLabelImage(URL url) throws IOException{
		
		//final URL url = Main.class.getResource(imageLocation); //Aller chercher les images !! IMPORTANT 
		
		System.out.println(url); 
		
		BufferedImage img = ImageIO.read(url); //lire l'image
		Image sImage = img.getScaledInstance(1024/3,768/4, Image.SCALE_SMOOTH); //redimentionner l'image
		
		final JLabel label = new JLabel(new ImageIcon(sImage)); // créer le composant pour ajouter l'image dans la fenÃªtre
		
		label.addMouseListener(new MouseListener() { //Ajouter le listener d'évenement de souris
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
			public void mouseClicked(MouseEvent arg0) { //ce qui nous intÃ©resse c'est lorsqu'on clique sur une image, il y a donc des choses Ã  faire ici
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
}




