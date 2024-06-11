package model;

import java.io.IOException;

public class FiltroPalavra extends Base{
	
	public static String palavraSubstituta; 		// TENTA FAZER PALAVRA SUBSTITUTA SER DEFINIDA NA MAIN

	public FiltroPalavra() throws IOException {
		super();
	}
	
	protected String substituirPalavrao(String palavra) {
		return palavraSubstituta;
	}

	@Override
	public String filtrar(String frase) {
        for (String palavrao : palavroes) {
            frase = frase.replaceAll("(?i)" + palavrao, substituirPalavrao(palavrao));
        }
        return frase;
	}

}
