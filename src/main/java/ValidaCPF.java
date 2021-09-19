public class ValidaCPF {

    public boolean isCPF(String cpfOriginal) {

        String CPF;

        if(cpfOriginal == null) {
            return (false);
        }

        CPF = canonizaCPF(cpfOriginal);

         if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
                || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
                || CPF.equals("99999999999") || (CPF.length() != 11))
            return (false); // considera-se erro CPF's formados por uma sequencia de numeros iguais


        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        // Calculo do 1o. Digito Verificador
        sm = 0;
        peso = 10;
        for (i = 0; i < 9; i++) {
            // converte o i-esimo caractere do CPF em um numero:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posicao de '0' na tabela ASCII)
            num = (int) (CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else
            dig10 = (char) (r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 11;
        for (i = 0; i < 10; i++) {
            num = (int) (CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig11 = '0';
        else
            dig11 = (char) (r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
        if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
            return (true);
        else
            return (false);
    }

    public String imprimeCPF(String cpfOriginal) {

        String CPF;

        if(cpfOriginal == null) {
            throw new IllegalArgumentException("CPF não pode seu null.");
        }
        //Garante que o CPF passado não terá nenhum caractere especial
        CPF = canonizaCPF(cpfOriginal);

        if (CPF.length() != 11) {
            throw new IllegalArgumentException("CPF deve conter 11 caracteres.");
        }

        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-"
                + CPF.substring(9, 11));
    }


    /**
     * Transforma um CPF em sua versão "canônica", removendo todos os caracteres que não devem afetar a validade
     * do mesmo.
     * @param CPF = o CPF com caracteres especiais como "." e "-".
     */
    private String canonizaCPF(String CPF) {
        return CPF.replaceAll("\\D", "");
    }
}