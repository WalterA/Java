// Classe EsempiStringhe
public class EsempiStringhe {

    // Metodo per contare quante volte un carattere appare in una frase
    public int contaCarattere(String frase, char carattere) {
        if (frase == null) {
            throw new IllegalArgumentException("La frase non può essere null");
        }
        int count = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == carattere) {
                count++;
            }
        }
        return count;
    }

    // Metodo per verificare se una parola è palindroma
    public boolean isPalindroma(String parola) {
        if (parola == null) {
            throw new IllegalArgumentException("La parola non può essere null");
        }
        int start = 0;
        int end = parola.length() - 1;
        while (start < end) {
            if (parola.charAt(start) != parola.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}