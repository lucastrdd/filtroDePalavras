package application;

import java.io.IOException;
import java.util.Scanner;

import model.FiltroAsterisco;
import model.FiltroPalavra;
import model.Menu;

public class Application {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Scanner scInteiros = new Scanner(System.in);
        Boolean continuarExecutando = true;
        Boolean modoAsterisco = true;
        String novaPalavraFiltro = "";

        do {
            Menu.exibirMenu();
            System.out.print(">>> ");
            int opcao = scInteiros.nextInt();
            switch (opcao) {
                case 1:
                    Menu.limparTela();
                    System.out.println("Seja bem vindo!\nDigite uma frase para que seja filtrada.");
                    String inputFrase = sc.nextLine();
                    if (modoAsterisco) {
                        FiltroAsterisco novoFiltro = new FiltroAsterisco(inputFrase);
                        novoFiltro.filtrar();
                        System.out.println("Frase limpa: " + novoFiltro.toString());
                    } else {
                        FiltroPalavra novoFiltro = new FiltroPalavra(inputFrase);
                        novoFiltro.palavraSubstituta = novaPalavraFiltro;
                        novoFiltro.filtrar();
                        System.out.println("Frase limpa: " + novoFiltro.toString());
                    }
                    break;
                case 2:
                    Menu.limparTela();
                    System.out.println(
                            "Configurações:\n1. Filtro de Asteriscos (Padrão)\n2. Filtro com Palavra Customizada");
                    int config = scInteiros.nextInt();
                    switch (config) {
                        case 1:
                            modoAsterisco = true;
                            System.out.println("Filtro de asteriscos: ativado!");
                            break;
                        case 2:
                            modoAsterisco = false;
                            System.out.println("Qual palavra deseja usar?");
                            novaPalavraFiltro = sc.nextLine();
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;
                case 3:
                    Menu.limparTela();
                    System.out.println("Encerrando...");
                    continuarExecutando = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (continuarExecutando);

        sc.close();
        scInteiros.close();
    }
}