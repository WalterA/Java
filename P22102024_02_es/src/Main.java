public class Main {

	public static void main(String[] args) {

		int[] vint;
		vint = new int[100];

		// inserire nell'array vint i numeri da 0 a 99
		for (int i = 0; i < 100; i++) {
			vint[i] = i;
		}

		// Raddoppiare (moltiplicare per 2) i valori contenuti in vint
		for (int i = 0; i < 100; i++) {
			vint[i] = vint[i] * 2;
		}

		// Assegnare all'array vint i numeri dispari da 1 in poi
		//quindi 1 al posto 0, 3 al posto 1, 5 al posto 2, ecc.
		for (int i=0; i<100; i++) {
			vint[i] = 2*i+1;
		}
		
		// Assegnare all'array vint i numeri pari al quadrato
		// cioè al posto 0 => 4, al posto 1: 16, al posto 2: 36, ...
		//                    2*2            4*4           6*6 ...
		for (int i=0; i<100; i++) {
			int pari = 2*(i+1);
			vint[i] = pari*pari;
		}
		
		// Assegnare all'array vint i numeri crescenti secondo la serie
		// 1, 1, 2, 3, 5, 8, 13, 21
		// dove il numero successivo è pari alla somma dei 
		// due numeri precedenti
		vint[0]=1;
		vint[1]=1;
		for (int i=2; i<100; i++) {
			vint[i] = vint[i-1]+vint[i-2];
		}
		
		//serve per elencare tutti gli elementi di un array, senza
		//doverne precisare o conoscerne la posizione
		for (int v: vint) {
			System.out.println(v);
		}
		
		/* definire un vettore di numeri reali
		* inserire nel vettore la serie armonica (1/1, 1/2, 1/3, 1/4, 
		* 1/5, 1/6, ..., 1/100 e stampare con la foreach
		* */
		double []  vdou = new double[100];
		for (int i=0; i<100; i++) {
			vdou[i] = 1./(i+1);
		}
		for (double v: vdou) {
			System.out.println(v);
		}
		
		/*
		 * inserire nel vettore di numeri reali (vdou) il seno 
		 * dei valori da 0 a 99, supponendo che siano 
		 * gradi sessagesimali e esprimendoli in radianti
		 */
		for (int i=0; i<100; i++) {
			vdou[i] = Math.sin(i*Math.PI*2/360);
		}
		for (double v: vdou) {
			System.out.print(v + " ");
		}
		System.out.println();
		
		
		/*
		 * inserire nel vettore vdou il logaritmo in base 2 
		 * dei numeri da 1 a 100
		 */
		for (int i=1; i<101; i++) {
			vdou[i-1] = Math.log(i)/Math.log(2.0);
		}
		for (double v: vdou) {
			System.out.print(v + " ");
		}
		System.out.println();
		
	}

}