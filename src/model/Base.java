package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Base implements interfaceFiltro {
    protected String fraseCompleta;
    protected List<String> palavroes;

    public Base(String fraseCompleta) throws IOException {
        this.fraseCompleta = fraseCompleta;
        this.palavroes = carregarPalavroes("./src/palavroes.txt");
    }

    private List<String> carregarPalavroes(String fileName) throws IOException {
        List<String> listaPalavroes = new ArrayList<>();
        BufferedReader arquivo = new BufferedReader(new FileReader(fileName));
        String linha;
        while ((linha = arquivo.readLine()) != null) {
            listaPalavroes.add(linha.trim().toLowerCase());
        }
        arquivo.close();
        return listaPalavroes;
    }

    protected String substituirPalavrao() {
        return null;
    }

    @Override
    public String toString() {
        return this.fraseCompleta;
    }

    @Override
    public abstract String filtrar(String frase);

}
