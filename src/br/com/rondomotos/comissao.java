package br.com.rondomotos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class comissao {

	public static String linha;
	public static ArrayList<String> alistVP;

	public static void executar() {

		try {
			carregarListaVendedor();
			for (String proposta : tratar_proposta.temp_proposta) {
				String[] linhasProposta = proposta.split(";");
				if (consultaVendedor(linhasProposta[10]).contentEquals("INTERNO")) {
					//System.out.println(linhasProposta[3] + ";" + linhasProposta[1] + ";" + linhasProposta[10] + ";" + linhasProposta[4] + ";" + linhasProposta[9] + ";" + linhasProposta[8] + ";" + linhasProposta[7] + ";" + linhasProposta[6]);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static String consultaVendedor(String vendedor) {
		

		for (String roda : alistVP) {
			String[] linhasVendedor = roda.split(";");
			if (vendedor.contentEquals(linhasVendedor[0])) {
				vendedor = linhasVendedor[1];
			}
		}
		return vendedor;

	}

	private static void carregarListaVendedor() {

		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader((new FileReader("c:\\comissao\\vendedor.csv")));
			alistVP = new ArrayList<>();

			while ((linha = br.readLine()) != null) {
				linha = linha.replaceAll("\"", ""); // Cod Regex para remover aspa dupla
				String[] linhasLer = linha.split(";");
				alistVP.add(linhasLer[0] + ";" + linhasLer[1] + ";" + linhasLer[2]);
			}

		} catch (

		Exception e) {
			// TODO: handle exception
		}
	}
}
