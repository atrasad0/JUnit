import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @autor Yuri Gonçalves
 * */

public class ValidaCPFTest {

    /**
     * Valida um CPF {@code null} passado para o método "isCpf(String CPF)" da classe {@link ValidaCPF}.
     * @return Como retorno se espera um {@code false} para que este teste esteja ok.
     * */
    @Test
    public void testCPFNull() {
        ValidaCPF validaCPF = new ValidaCPF();
        String cpf = null;

        assertFalse(validaCPF.isCPF(cpf));
    }

    /**
     * Valida um CPF válido sem caracteres especiais passado para o método "isCpf(String CPF)" da classe {@link ValidaCPF}.
     * @return Como retorno se espera um {@code true} para que este teste esteja ok.
     * */
    @Test
    public void testCPFValidoSemCaracteresEspeciais() {
        ValidaCPF validaCPF = new ValidaCPF();
        String cpf = "54352593044";

        assertTrue(validaCPF.isCPF(cpf));
    }

    /**
     * Valida um CPF válido com caracteres especiais passado para o método "isCpf(String CPF)" da classe {@link ValidaCPF}.
     * @return Como retorno se espera um {@code true} para que este teste esteja ok.
     * */
    @Test
    public void testCPFValidoComCaracteresEspeciais() {
        ValidaCPF validaCPF = new ValidaCPF();
        String cpf = "543.525.930-44";

        assertTrue(validaCPF.isCPF(cpf));
    }

    /**
     * Valida um CPF inválido passado para o método "isCpf(String CPF)" da classe {@link ValidaCPF}.
     * @return Como retorno se espera um {@code false} para que este teste esteja ok.
     * */
    @Test
    public void testCPFInvalido() {
        ValidaCPF validaCPF = new ValidaCPF();
        String cpf = "123.456.789-10";

        assertFalse(validaCPF.isCPF(cpf));
    }

    /**
     * Valida um CPF contendo letras passado para o método "isCpf(String CPF)" da classe {@link ValidaCPF}.
     * @return Como retorno se espera um {@code false} para que este teste esteja ok.
     * */
    @Test
    public void testCPFComLetras() {
        ValidaCPF validaCPF = new ValidaCPF();
        String cpf = "123.456.abc-10";

        assertFalse(validaCPF.isCPF(cpf));
    }

    /**
     * Valida um CPFcom menos de 11 caracteres passado para o método "isCpf(String CPF)" da classe {@link ValidaCPF}.
     * @return Como retorno se espera um {@code false} para que este teste esteja ok.
     * */
    @Test
    public void testCPFMenosCaracteres() {
        ValidaCPF validaCPF = new ValidaCPF();
        String cpf = "543.525-44";

        assertFalse(validaCPF.isCPF(cpf));
    }

    /**
     * Valida um CPF com mais de 11 caracteres passado para o método "isCpf(String CPF)" da classe {@link ValidaCPF}.
     * @return Como retorno se espera um {@code false} para que este teste esteja ok.
     * */
    @Test
    public void testCPFMaisCaracteres() {
        ValidaCPF validaCPF = new ValidaCPF();
        String cpf = "543.525.930.123-44";

        assertFalse(validaCPF.isCPF(cpf));
    }

    /**
     * Imprime um CPF sem caracteres especiais passado para o metodo "imprimeCPF(String CPF)" da classe {@link ValidaCPF}.
     * @return Como retorno se espera um CPF com uma "mascara" esperada aplicada para que este teste esteja ok.
     * */
    @Test
    public void testImprimeCPFSemCaracteresEspeciais() {
        ValidaCPF validaCPF = new ValidaCPF();
        String cpfEntrada = "54352593044";
        String cpfSaida = "543.525.930-44";

        /**
         * @param cpfEntrada = CPF contendo apenas numeros.
        * @param cpfSaida = CPF com uma Mascara aplicada.
        * */
        assertEquals(validaCPF.imprimeCPF(cpfEntrada),cpfSaida);
    }

    /**
     * Imprime um CPF com uma mascara ja aplicada passado para o metodo "imprimeCPF(String CPF)" da classe {@link ValidaCPF}.
     * @return Como retorno se espera um CPF sem alterações para que este teste esteja ok.
     * */
    @Test
    public void testImprimeCPFComCaracteresEspeciais() {
        ValidaCPF validaCPF = new ValidaCPF();
        String cpfEntrada = "543.525.930-44";
        String cpfSaida = "543.525.930-44";

        assertEquals(validaCPF.imprimeCPF(cpfEntrada),cpfSaida);
    }

    /**
     * Tenta imprimir um CPF {@code null} passado para o metodo "imprimeCPF(String CPF)" da classe {@link ValidaCPF}.
     * @throws IllegalArgumentException Caso este metodo esteja ok.
     * */
    @Test(expected = IllegalArgumentException.class)
    public void testImprimeCPFNull() {
        ValidaCPF validaCPF = new ValidaCPF();
        String cpf = null;

       validaCPF.imprimeCPF(cpf);
    }

    /**
     * Tenta imprimir um CPF com menos de 11 caracteres passado para o metodo "imprimeCPF(String CPF)" da classe {@link ValidaCPF}.
     * @throws IllegalArgumentException Caso este metodo esteja ok.
     * */
    @Test(expected = IllegalArgumentException.class)
    public void testImprimeCPFMenosCaracteres() {
        ValidaCPF validaCPF = new ValidaCPF();
        String cpf = "543.525-15";

        validaCPF.imprimeCPF(cpf);
    }
}