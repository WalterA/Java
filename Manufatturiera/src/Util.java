import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.util.*;

public class Util {

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
        	Path path = Path.of(nomeFile);
            BufferedWriter writer = Files.newBufferedWriter(
                    path,
                    Files.exists(path)?StandardOpenOption.TRUNCATE_EXISTING:StandardOpenOption.CREATE);
            return writer;
        } catch (Exception ex) {
            return null;
        }
    }
    public static BufferedWriter OpenFileForAppend(String nomeFile) {
        try {
        	Path path = Path.of(nomeFile);
            BufferedWriter writer = Files.newBufferedWriter(
                    path,
                    Files.exists(path)?StandardOpenOption.APPEND:StandardOpenOption.CREATE);
            return writer;
        } catch (Exception ex) {
            return null;
        }
    }
	
}