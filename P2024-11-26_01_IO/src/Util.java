import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class Util {
	private static Random rng = new Random();
	private static String alfabeto = "abcdefghijklmnopqrdtuvwxuz";
	private static String digit = "0123456789";
	private static String simboli="-_-:,;!?£%";

	public static String GetRandomAuthProto() {
		int i = rng.nextInt(4);
		String[] vp = new String[] { "WEP", "WPA", "WPA2", "WPA3" };
		return vp[i];
	}

	// Genera una frequenza (DOuble) compreso tra 1.0 *10_9 e 5.0 *10-9
	public static Double getFrequenza() {
		Double k = rng.nextDouble(1000000000.0, 5000000000.0);
		return k;
	}

	public static String getPassword(Boolean isPassword) {
		String all = alfabeto + alfabeto.toUpperCase() + digit;
		if(isPassword) {
			all+=simboli;
		}
		// password tra 8 e i 12 a 24
		String ret = "";
		int len = rng.nextInt(12, 25);
		for (int i = 0; i < len; i++) {
			ret += all.charAt(rng.nextInt(all.length()));
		}
		return ret;

	}
	public static BufferedReader OpenFileForReading(String nomeFile) {
        try {
            BufferedReader reader = Files.newBufferedReader(Path.of(nomeFile));
            return reader;
        } catch (IOException e) {
            return null;
        }
    }
	public static BufferedWriter OpenFileForWriting(String nomeFile) {
		
        try {
            BufferedWriter writer = Files.newBufferedWriter(
                    Path.of(nomeFile),
                    StandardOpenOption.TRUNCATE_EXISTING);
            return writer;
        } catch (Exception ex) {
            return null;
        }
    }
    public static BufferedWriter OpenFileForAppend(String nomeFile) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(
                    Path.of(nomeFile),
                    StandardOpenOption.APPEND);
            return writer;
        } catch (Exception ex) {
            return null;
        }
    }
    

	
}
