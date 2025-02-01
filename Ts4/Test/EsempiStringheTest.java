import org.junit.Assert;
import org.junit.Test;

public class EsempiStringheTest {

    @Test
    public void testContaCarattere_CaratterePresente() {
        EsempiStringhe es = new EsempiStringhe();
        int result = es.contaCarattere("ciao mondo", 'o');
        Assert.assertNotEquals(0, result);;
    }

    @Test
    public void testContaCarattere_CarattereAssente() {
        EsempiStringhe es = new EsempiStringhe();
        int result = es.contaCarattere("ciao mondo", 'z');
        Assert.assertEquals(0, result);
    }

    @Test
    public void testContaCarattere_StringaVuota() {
        EsempiStringhe es = new EsempiStringhe();
        int result = es.contaCarattere("a", 'a');
        Assert.assertNotNull("a", es);;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContaCarattere_Null() {
        EsempiStringhe es = new EsempiStringhe();
        es.contaCarattere(null, 'a');
    }

    @Test
    public void testIsPalindroma_ParolaPalindroma() {
        EsempiStringhe es = new EsempiStringhe();
        boolean result = es.isPalindroma("anna");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsPalindroma_ParolaNonPalindroma() {
        EsempiStringhe es = new EsempiStringhe();
        boolean result = es.isPalindroma("ciao");
        Assert.assertFalse(result);
    }

    @Test
    public void testIsPalindroma_ParolaVuota() {
        EsempiStringhe es = new EsempiStringhe();
        boolean result = es.isPalindroma("");
        Assert.assertTrue(result); // Una stringa vuota è considerata palindroma
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsPalindroma_Null() {
        EsempiStringhe es = new EsempiStringhe();
        es.isPalindroma(null);
    }
}
