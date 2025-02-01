import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class St {

    @Test
    void testContaCarattere() {
        EsempiStringhe esempio = new EsempiStringhe();
        assertEquals(3, esempio.contaCarattere("banana", 'a'));
        assertEquals(0, esempio.contaCarattere("banana", 'z'));
        assertEquals(0, esempio.contaCarattere("", 'a'));
        assertThrows(IllegalArgumentException.class, () -> esempio.contaCarattere(null, 'a'));
    }

    @Test
    void testIsPalindroma() {
        EsempiStringhe esempio = new EsempiStringhe();
        assertTrue(esempio.isPalindroma("anna"));
        assertTrue(esempio.isPalindroma("otto"));
        assertFalse(esempio.isPalindroma("ciao"));
        assertTrue(esempio.isPalindroma("a"));
        assertTrue(esempio.isPalindroma("")); // Una stringa vuota è considerata palindroma
        assertThrows(IllegalArgumentException.class, () -> esempio.isPalindroma(null));
    }

}
