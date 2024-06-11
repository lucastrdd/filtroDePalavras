package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Base implements PalavraFiltro {
    protected List<String> palavroes;

    public Base() throws IOException {
        palavroes = carregarPalavroes("palavroes.txt");
    }

    private List<String> carregarPalavroes(String fileName) throws IOException {
        List<String> listaPalavroes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String linha;
        while ((linha = br.readLine()) != null) {
            listaPalavroes.add(linha.trim());
        }
        br.close();
        return listaPalavroes;
    }

    protected String substituirPalavrao(String palavra) {
        return "****";
    }

    @Override
    public abstract String filtrar(String frase);
}
