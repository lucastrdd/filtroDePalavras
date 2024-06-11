package application;

import java.io.IOException;
import java.util.Scanner;

import model.FiltroAsterisco;
import model.FiltroPalavra;
import model.PalavraFiltro;

public class SistemaFiltro {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner (System.in);
        PalavraFiltro filtro1 = new FiltroAsterisco();
        PalavraFiltro filtro2 = new FiltroPalavra();
        
        System.out.print("Qual a frase que vai substituir os palavrões? ");
        FiltroPalavra.palavraSubstituta = sc.next(); // TIPO ASSIM

        SistemaFiltro sistema1 = new SistemaFiltro(filtro1);
        SistemaFiltro sistema2 = new SistemaFiltro(filtro2);

        String fraseOriginal = "Isso é um merda e outro porra.";
        System.out.println("Frase Original: " + fraseOriginal);
        System.out.println("Filtro Asterisco: " + sistema1.processarFrase(fraseOriginal));
        System.out.println("Filtro Palavra Específica: " + sistema2.processarFrase(fraseOriginal));
        sc.close();
    }

    private PalavraFiltro filtro;

    public SistemaFiltro(PalavraFiltro filtro) {
        this.filtro = filtro;
    }

    public String processarFrase(String frase) {
        return filtro.filtrar(frase);
    }

}