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

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import fr.upem.capcha.images.vehicules.Vehicules;
import fr.upem.capcha.images.nourriture.Nourriture;


public class Main {
	
	private static ArrayList<URL> selectedImages = new ArrayList<URL>();
	
	/**
	 *  1 - cr�er un algorithme qui choisit al�atoirement la cat�gorie selon la difficult� 
	 *  2 - R�cupp�rer les images de la bonne cat�gorie avec un nombre al�atoire
	 *  3 - R�cuper�rer des img random
	 *  4 - Display les img
	 *  5 - Action Utilisateur
	 *	6 - validation, on regarde si les img font bien partie du bon package
	 *	6 a) Good : " Message de validation "
	 *	6 b) Mauvais : On retourne au 1 avec difficult� + 1
	 */
	private static boolean contain(int[] arr, int number, int index) {
		if (index == 0) return false;
		for (int i = 0; i < index; i++) {
			if (arr[i] == number) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		
		Vehicules categorie1 = new Vehicules();
		System.out.println(categorie1);
		System.out.println(categorie1.isPhotoCorrect(categorie1.getRandomPhotosURL()));
		System.out.println(categorie1.getRandomPhotosURL().getPath());
		
		Nourriture categorie2 = new Nourriture();
		System.out.println(categorie2);
		
		JFrame frame = new JFrame("Capcha"); // Cr�ation de la fen�tre principale
				
		GridLayout layout = createLayout();  // Cr�ation d'un layout de type Grille avec 4 lignes et 3 colonnes
		
		frame.setLayout(layout);  // affection du layout dans la fenêtre.
		frame.setSize(1024, 768); // d�finition de la taille
		frame.setResizable(false);  // On d�finit la fen�tre comme non redimentionnable
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Lorsque l'on ferme la fenêtre on quitte le programme.
		 
		
		JButton okButton = createOkButton();

		
		frame.add(createLabelImage(categorie1.getRandomPhotosURL())); //ajouter des composants � la fen�tre
		frame.add(createLabelImage(categorie1.getRandomPhotosURL()));
		frame.add(createLabelImage(categorie1.getRandomPhotosURL()));
		frame.add(createLabelImage(categorie1.getRandomPhotosURL()));
		frame.add(createLabelImage(categorie1.getRandomPhotosURL()));
		frame.add(createLabelImage(categorie1.getRandomPhotosURL()));
		frame.add(createLabelImage(categorie1.getRandomPhotosURL()));
		frame.add(createLabelImage(categorie1.getRandomPhotosURL()));
		frame.add(createLabelImage(categorie1.getRandomPhotosURL()));
		
		
		
		frame.add(new JTextArea("Cliquez n'importe où ... juste pour tester l'interface !"));
		
		
		frame.add(okButton);
		
		frame.setVisible(true);
		 
	 
	}
	
	
	private static GridLayout createLayout(){
		return new GridLayout(4,3);
	}
	
	private static JButton createOkButton(){
		return new JButton(new AbstractAction("V�rifier") { //ajouter l'action du bouton
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() { // l'interface donc appeler cela dans la queue des �v�nements
				
					@Override
					public void run() { // c'est un runnable
						System.out.println("J'ai cliqué sur Ok");
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
		
		final JLabel label = new JLabel(new ImageIcon(sImage)); // cr�er le composant pour ajouter l'image dans la fenêtre
		
		label.addMouseListener(new MouseListener() { //Ajouter le listener d'�venement de souris
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
}




