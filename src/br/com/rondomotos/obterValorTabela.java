package br.com.rondomotos;

import java.io.BufferedReader;
import java.io.FileReader;

public class obterValorTabela {

	public static String minhaLinha = "";

	public static String valorTabela(String proposta, int parcela, int x, double valor) {
		try {
			config_localidade.configLocalidade();

			BufferedReader br = new BufferedReader(
					new FileReader("c:\\comissao\\Sa�da - SA�DA - COMISSAO - PROGRAMA EXTERNO TABELA.csv"));
			while ((minhaLinha = br.readLine()) != null) {

				minhaLinha = minhaLinha.replaceAll("\"", ""); // Utilizado C�digo Regex para
																// remover aspa dupla.

				String[] linhasLer = minhaLinha.split(";");

				linhasLer[2] = linhasLer[2].replaceAll(",", ".");
				linhasLer[3] = linhasLer[3].replaceAll(",", ".");
				if (!linhasLer[6].contentEquals("RONDO MOTOS LTDA")) {
					if (linhasLer[1].contentEquals(proposta) && x == 1) {
						proposta = String.format("%.2f",
								100 - 100 * Double.parseDouble(linhasLer[2])
										/ calcularVP.executar(Double.parseDouble(linhasLer[3]) / parcela, parcela,
												0.025))
								+ ";" + String.format("%.2f", calcularVP.executar(valor / parcela, parcela, 0.025))
								+ ";" + String.format("%.2f", Double.parseDouble(linhasLer[3])) + ";"
								+ String.format("%.2f", Double.parseDouble(linhasLer[2])) + ";" + linhasLer[6] + ";"
								+ linhasLer[7] + ";" + linhasLer[8];
						break;
					}
					
					
					if (linhasLer[1].contentEquals(proposta) && x == 0) {
						proposta = String.format("%.2f",
								100 - 100 * Double.parseDouble(linhasLer[2]) / Double.parseDouble(linhasLer[3])) + ";"
								+ String.format("%.2f", valor) + ";"
								+ String.format("%.2f", Double.parseDouble(linhasLer[3])) + ";"
								+ String.format("%.2f", Double.parseDouble(linhasLer[2])) + ";" + linhasLer[6] + ";"
								+ linhasLer[7] + ";" + linhasLer[8];

						break;
					}

				}
				else {
					proposta = "nada";
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return proposta;
	}

}