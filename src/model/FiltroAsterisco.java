package model;

import java.io.IOException;

public class FiltroAsterisco extends Base {

    public FiltroAsterisco(String fraseCompleta) throws IOException {
        super(fraseCompleta);
    }

    protected String substituirPalavrao(String palavra) {
        char primeiroCaractere = palavra.charAt(0);
        String asteriscos = new String(new char[palavra.length() - 1]).replace('\0', '*');
        return primeiroCaractere + asteriscos;
    }

    public String filtrar() {
        for (String palavrao : palavroes) {
            fraseCompleta = this.fraseCompleta.replaceAll("(?i)" + palavrao, substituirPalavrao(palavrao));
        }
        return fraseCompleta;
    }

    @Override
    public String filtrar(String frase) {
        for (String palavrao : palavroes) {
            frase = frase.replaceAll("(?i)" + palavrao, substituirPalavrao(palavrao));
        }
        return frase;
    }
}
