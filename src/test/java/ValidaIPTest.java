import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @autor Yuri Gonçalves
 * */

public class ValidaIPTest {

    @Test
    public void testIpValido() {
        ValidaIPeEmail validaIPeEmail = new ValidaIPeEmail();
        String ip = "172.16.0.2";

        assertTrue(validaIPeEmail.isValidIP(ip));
    }

    @Test
    public void testIpNull() {
        ValidaIPeEmail validaIPeEmail = new ValidaIPeEmail();
        assertFalse(validaIPeEmail.isValidIP(null));
    }

    @Test
    public void testIpInvalidio() {
        ValidaIPeEmail validaIPeEmail = new ValidaIPeEmail();
        String ip = "172.1666.0.2";

        assertFalse(validaIPeEmail.isValidIP(ip));
    }

    @Test
    public void testIpInvalidoLetras() {
        ValidaIPeEmail validaIPeEmail = new ValidaIPeEmail();
        String [] ips = {"172.166.a.2", "aaaaa", "172.16.300.2", "52.45.258.2"};

        for(String ip : ips) {
            assertFalse(validaIPeEmail.isValidIP(ip));
        }
    }

    @Test
    public void testIpInvalidoForaRange() {
        ValidaIPeEmail validaIPeEmail = new ValidaIPeEmail();
        String [] ips = {" 256.0.0.0", "-127.0.0.1", "000.168.1.1"};

        for(String ip : ips) {
            assertFalse(validaIPeEmail.isValidIP(ip));
        }

    }



}