package br.com.rondomotos;

import java.io.File;

import javax.swing.JFileChooser;

public class main {

	
	public static File arquivo;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		config_localidade.configLocalidade();
		
		JFileChooser file = new JFileChooser();
		file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		file.setDialogTitle("Selecione o diretorios das comissões.");
		int i = file.showSaveDialog(null);
		
		arquivo = file.getSelectedFile();
		
      
		
		
		
		
		check_vendedor.lerVendedorProposta();
		tratar_proposta.eliminaEspaco();
		
		comissao.executar();
		
	
	}

}
