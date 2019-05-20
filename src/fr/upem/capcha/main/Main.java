package fr.upem.capcha.main;
import java.awt.Color;
import fr.upem.capcha.images.vehicules.camion.*;
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
import fr.upem.capcha.images.nourriture.*;
import fr.upem.capcha.images.vehicules.moto.*;
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
		c.displayCaptcha();
		
		/*Camion m = new Camion();
		Vehicules v = new Vehicules();
		v.initialize();
		System.out.println(v.isPhotoCorrect(m.getPhotos().get(4)));*/
		
	
		 
	}
}




