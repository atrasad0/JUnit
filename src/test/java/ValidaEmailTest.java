import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @autor Yuri Gonçalves
 * */

public class ValidaEmailTest {

    @Test
    public void testEmailValido() {
        ValidaIPeEmail validaIPeEmail = new ValidaIPeEmail();
        String email = "teste@teste.com";

        assertTrue(validaIPeEmail.isValidEmail(email));
    }

    @Test
    public void testEmailInvalido() {
        ValidaIPeEmail validaIPeEmail = new ValidaIPeEmail();
        String [] emails = {"@teste.com", "@teste.com.br", "teste.com.br", "usuario@", "", "e@.com"};

        for(String email : emails) {
            assertFalse(validaIPeEmail.isValidEmail(email));
        }
    }

    @Test
    public void testEmailNull() {
        ValidaIPeEmail validaIPeEmail = new ValidaIPeEmail();
        assertFalse(validaIPeEmail.isValidEmail(null));
    }

    @Test
    public void testEmailEspaco() {
        ValidaIPeEmail validaIPeEmail = new ValidaIPeEmail();
        String email = "  @  .com";

        assertFalse(validaIPeEmail.isValidEmail(email));
    }

}