package fr.upem.capcha.main;

import java.io.IOException;

/**
 * @author SEBAOUN Manon 
 * @author SEMINEL Marion
 *
 */

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("unused")
		CapchaManager c = new CapchaManager();
		CapchaManager.displayCaptcha(); 
	}
}




