import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// Costruire un set insieme di oggetti di tipo wifi e inserire 100 wifi casuali

		Set<WI_FI> Wifi = new HashSet<WI_FI>();
		for (int i = 0; i < 100; i++) {
			Wifi.add(WI_FI.MakeWifi());
		}
		System.out.println(Wifi);
	}

}
