package br.com.rondomotos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;

public class altaCC {
	public static String minhaLinha = "";

	public static boolean carregar(String modelo) {
		try {
			@SuppressWarnings("resource")
		
			BufferedReader br = new BufferedReader(new FileReader(main.arquivo+"//modelos.csv"));
			while ((minhaLinha = br.readLine()) != null) {
				minhaLinha = minhaLinha.replaceAll("\"", ""); // Utilizado C�digo Regex para
				// remover aspa dupla.
				String[] linhasLer = minhaLinha.split(";");
				if (linhasLer[0].equals(modelo)) {
					return true;
				}

			}
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
