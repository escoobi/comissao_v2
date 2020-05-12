package br.com.rondomotos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class addVendedor {

	public static String linha;

	public static FileWriter escreve;
	public static BufferedWriter bw;
	public static ArrayList<String> alistVP;

	public static void lerVendedor() {

		try {

			BufferedReader br = new BufferedReader((new FileReader(main.arquivo + "//vendedor.csv")));
			alistVP = new ArrayList<>();
			try {
				while ((linha = br.readLine()) != null) {
					linha = linha.replaceAll("\"", ""); // Cod Regex para remover aspa dupla
					String[] linhasLer = linha.split(";");
					alistVP.add(linhasLer[0] + ";" + linhasLer[1] + ";" + linhasLer[2]);

				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			try {
				File novoArqLote = new File(main.arquivo + "//vendedor.csv");
				novoArqLote.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public static void add(String vendedor) {

		try {

			File novoArqLote = new File(main.arquivo + "//vendedor.csv");
			novoArqLote.createNewFile();
			escreve = new FileWriter(novoArqLote);
			BufferedWriter bw = new BufferedWriter(escreve);
			alistVP.add(vendedor);
			for (String linha : alistVP) {
				bw.write(linha);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
