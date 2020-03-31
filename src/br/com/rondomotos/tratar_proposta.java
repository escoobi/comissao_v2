package br.com.rondomotos;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class tratar_proposta {

	private static String minhaLinha = "";
	public static ArrayList<String> temp_proposta;

	public static void eliminaEspaco() {

		try {

			config_localidade.configLocalidade();

			BufferedReader br = new BufferedReader(new FileReader(
					"c:\\comissao\\Proposta de Venda - PROPOSTA DE VENDA - RELATÓRIO COMISSÃO SISTEMA EXTERNO.csv"));
			temp_proposta = new ArrayList<String>();
			temp_proposta.add(
					"NF;CLIENTE;RECEBIMENTO;PROPOSTA;MODELO;PARCELAS;DESCONTO;VALOR PRESENTE;VALOR VENDA;TABELA;VENDEDOR;TIPO;CIDADE");

			while ((minhaLinha = br.readLine()) != null) {
				minhaLinha = minhaLinha.replaceAll("\"", ""); // Utilizado Código Regex para remover aspa dupla.
				minhaLinha = minhaLinha.replaceAll("\";", ""); // Utilizado Código Regex para remover espaços.
				String[] linhasLer = minhaLinha.split(";");

				switch (linhasLer[0]) {
				case "RONDO MOTOS LTDA":
					// Nada Faz
					break;

				case "Vendedor":
					// Nada Faz
					break;

				default:

					switch (linhasLer[3]) {
					case "CARTÃO":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");

						if (linhasLer[6].equals("False")) {

							temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
									+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
									+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 1,
											Double.parseDouble(linhasLer[7])));

						}
						break;

					}

					switch (linhasLer[3]) {
					case "DINHEIRO":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");

						if (linhasLer[6].equals("False")) {

							temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
									+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
									+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
											Double.parseDouble(linhasLer[7])));

						}
						break;

					}

					switch (linhasLer[3]) {
					case "A RECEBER CHEQUE A VISTA":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");

						if (linhasLer[6].equals("False")) {

							temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
									+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
									+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
											Double.parseDouble(linhasLer[7])));

						}
						break;

					}

					switch (linhasLer[3]) {
					case "FINANCIAMENTO":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");

						if (linhasLer[6].equals("False")) {

							temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
									+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
									+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
											Double.parseDouble(linhasLer[7])));

						}
						break;

					}
					switch (linhasLer[3]) {
					case "DEPÓSITO BANCÁRIO":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");

						if (linhasLer[6].equals("False")) {

							temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
									+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
									+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
											Double.parseDouble(linhasLer[7])));

						}
						break;

					}

					switch (linhasLer[3]) {
					case "CONSÓRCIO":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");
						if (!obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
								Double.parseDouble(linhasLer[7])).contentEquals("nada")) {
							if (linhasLer[6].equals("False")) {

								String teste = linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 1,
												Double.parseDouble(linhasLer[7]));
								String[] linhasLerCompleta = teste.split(";");
								if (linhasLerCompleta[10].equals("RONDO MOTOS LTDA")) {

								} else {
									temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
											+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
											+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]),
													0, Double.parseDouble(linhasLer[7])));
								}
							}
							break;

						}
					}
					switch (linhasLer[3]) {
					case "TROCA DE VEÍCULO":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");

						if (linhasLer[6].equals("False")) {

							temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
									+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
									+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
											Double.parseDouble(linhasLer[7])));

						}
						break;

					}

					switch (linhasLer[3]) {
					case "FINANCIAMENTO PRÓPRIO":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");

						if (linhasLer[6].equals("False")) {

							temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
									+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
									+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 1,
											Double.parseDouble(linhasLer[7])));

						}
						break;

					}

					switch (linhasLer[3]) {
					case "CARTÃO DÉBITO":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");

						if (linhasLer[6].equals("False")) {

							temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
									+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
									+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
											Double.parseDouble(linhasLer[7])));

						}
						break;

					}

					switch (linhasLer[3]) {
					case "PERMUTA":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");

						if (linhasLer[6].equals("False")) {

							temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
									+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
									+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
											Double.parseDouble(linhasLer[7])));

						}
						break;

					}

					switch (linhasLer[3]) {
					case "DUPLICATA MERCATIL":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");

						if (linhasLer[6].equals("False")) {

							temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
									+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
									+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 1,
											Double.parseDouble(linhasLer[7])));

						}
						break;

					}

					switch (linhasLer[3]) {
					case "A RECEBER CHEQUE":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");

						if (linhasLer[6].equals("False")) {

							temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
									+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
									+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 1,
											Double.parseDouble(linhasLer[7])));

						}
						break;

					}
					
					switch (linhasLer[3]) {
					case "A RECEBER CHEQUE - ALIENAÇÃO":
						linhasLer[7] = linhasLer[7].replaceAll(",", ".");

						if (linhasLer[6].equals("False")) {

							temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
									+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
									+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 1,
											Double.parseDouble(linhasLer[7])));

						}
						break;

					}
				}
			}
			br.close();

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.toString());
		}

	}

}
