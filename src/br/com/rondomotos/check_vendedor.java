package br.com.rondomotos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class check_vendedor {
	public static String minhaLinha = "";
	

	private static Boolean lerVendedor(String nome) {

		try {

			@SuppressWarnings("resource")

			BufferedReader br = new BufferedReader(new FileReader(main.arquivo+"//vendedor.csv"));
			while ((minhaLinha = br.readLine()) != null) {
				minhaLinha = minhaLinha.replaceAll("\"", ""); // Utilizado Cï¿½digo Regex para
				// remover aspa dupla.
				String[] linhasLer = minhaLinha.split(";");
				if (linhasLer[0].equals(nome)) {
					return true;
				}

			}
			br.close();

		} catch (Exception e) {
			// TODO: handle exception
			if (e.getMessage().contains("O sistema não pode encontrar o arquivo especificado"))

			{

				try {
					File novoArqLote = new File(main.arquivo+"//vendedor.csv");
					novoArqLote.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

		return false;

	}

	public static void lerVendedorProposta() {

	
		try {

		

		

				BufferedReader br = new BufferedReader(new FileReader(main.arquivo+"//Saída - SAÍDA - COMISSAO - PROGRAMA EXTERNO TABELA.csv"));
				while ((minhaLinha = br.readLine()) != null) {
					minhaLinha = minhaLinha.replaceAll("\"", ""); // Utilizado Cï¿½digo Regex para
					// remover aspa dupla.
					String[] linhasLer = minhaLinha.split(";");

					if (!check_vendedor.lerVendedor(linhasLer[6])) {

						addVendedor.lerVendedor();
						//new File(main.arquivo+"//vendedor.csv").deleteOnExit();
						if (linhasLer[6].equals("VILMAR SILVA DO CARMO") || linhasLer[6].equals("EDMAR PIRES SANTIAGO")
								|| linhasLer[6].equals("EDUARDO DOMINGUES LIMA")
								|| linhasLer[6].equals("HILDA JESUS DA SILVA MENEZES")
								|| linhasLer[6].equals("GUIMARAES DE ALMEIDA GONCALVES CARMIM")
								|| linhasLer[6].equals("TIAGO CESAR MAGALHï¿½ES")
								|| linhasLer[6].equals("APARECIDO ANGELO DE FREITAS")
								|| linhasLer[6].equals("CLAUDINEI MACEDO COELHO")
								|| linhasLer[6].equals("DELCIO GOMES DA SILVA")) {
							addVendedor.add(linhasLer[6] + ";INTERNO;" + linhasLer[8]);
							System.out.println(linhasLer[6] + ";INTERNO;" + linhasLer[8]);
						} else {
							if (!linhasLer[6].equals("RONDO MOTOS LTDA")) {

								addVendedor.add(linhasLer[6] + ";EXTERNO;" + linhasLer[8]);

							}
						}

					}

				}
				br.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		
		}

	}

}
