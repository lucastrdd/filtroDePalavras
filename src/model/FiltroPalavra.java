package model;

import java.io.IOException;

public class FiltroPalavra extends Base {

	public String palavraSubstituta; // TENTA FAZER PALAVRA SUBSTITUTA SER DEFINIDA NA MAIN

	public FiltroPalavra(String fraseCompleta) throws IOException {
		super(fraseCompleta);
	}

	protected String substituirPalavrao(String palavra) {
		return palavraSubstituta;
	}

	public String filtrar() {
		for (String palavrao : palavroes) {
			this.fraseCompleta = fraseCompleta.replaceAll("(?i)" + palavrao, substituirPalavrao(palavrao));
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
