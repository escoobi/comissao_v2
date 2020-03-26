package br.com.rondomotos;



public class calcularVP {
	public static double executar(double p, int n, double i) {
		double vp = 0;
		try {

			n = n + 1;
			for (int x = 1; x < n; x++) {
				vp = (p / Math.pow((i + 1), x)) + vp;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return vp;
	}

}
