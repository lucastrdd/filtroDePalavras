package model;

import java.io.IOException;

public class FiltroAsterisco extends Base {
	
    public FiltroAsterisco() throws IOException {
        super();
    }
    
    protected String substituirPalavrao(String palavra) {
    	char primeiroCaractere = palavra.charAt(0);
    	String asteriscos = new String(new char[palavra.length() - 1]).replace('\0', '*');
    	return primeiroCaractere + asteriscos;
	}

	@Override
    public String filtrar(String frase) {
        for (String palavrao : palavroes) {
            frase = frase.replaceAll("(?i)" + palavrao, substituirPalavrao(palavrao));
        }
        return frase;
    }
    
    
}
