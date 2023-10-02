package Simulador;

import java.util.Random;
import java.util.Scanner;

public class Forca {
    public static void main(String[] args) {
        String[] listaPalavras = {
            "ALGORITMO", "PROGRAMACAO", "VARIÁVEL", "FUNCAO", "CLASSE",
            "OBJETO", "INTERFACE", "HERANCA", "POLIMORFISMO", "ENCAPSULAMENTO",
            "DEBUGAGEM", "COMPILACAO", "DESENVOLVIMENTO", "CODIGO", "LOGICA",
            "LOOP", "ARMAZENAMENTO", "ALOCACAO", "FRONTEND", "BACKEND"
        };
        Random random = new Random();
        Scanner entrada = new Scanner(System.in);

        int[] pontuacoes = new int[10];
        String[] nomes = new String[10];

        System.out.print("Digite a quantidade de jogadores: ");
        int numJogadores = entrada.nextInt();
        entrada.nextLine();

        for (int jogador = 0; jogador < numJogadores; jogador++) {
            System.out.print("Digite o nome do jogador " + (jogador + 1) + ": ");
            String nome = entrada.nextLine();
            nomes[jogador] = nome;
        }

        boolean jogarNovamente = true;

        while (true) {
            System.out.println("1-Iniciar");
            System.out.println("2-Verificar pontos");
            System.out.println("3-Sair");
            System.out.print("Escolha uma opção:");

            int opcoes = entrada.nextInt();

            switch (opcoes) {
                case 1:
                    for (int jogador = 0; jogador < numJogadores; jogador++) {
                        jogarNovamente = true;
                        System.out.println("\nJogador " + nomes[jogador]);

                        String palavraSecreta = listaPalavras[random.nextInt(listaPalavras.length)];
                        int vidas = 6;
                        char[] letrasDescobertas = new char[palavraSecreta.length()];
                        for (int i = 0; i < letrasDescobertas.length; i++) {
                            letrasDescobertas[i] = '_';
                        }

                        while (vidas > 0) {
                            System.out.println("Palavra: " + new String(letrasDescobertas));
                            System.out.println("Vidas restantes: " + vidas);
                            printForca(6 - vidas);

                            System.out.print("Digite uma letra: ");
                            char letra = entrada.next().toUpperCase().charAt(0);

                            boolean letraEncontrada = false;
                            for (int i = 0; i < palavraSecreta.length(); i++) {
                                if (palavraSecreta.charAt(i) == letra) {
                                    letrasDescobertas[i] = letra;
                                    letraEncontrada = true;
                                }
                            }

                            if (!letraEncontrada) {
                                vidas--;
                                System.out.println("Letra não encontrada. Vidas restantes: " + vidas);
                                printForca(6 - vidas);
                            }

                            if (new String(letrasDescobertas).equals(palavraSecreta)) {
                                System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
                                pontuacoes[jogador]++;
                                break;
                            }
                        }

                        if (vidas == 0) {
                            System.out.println("Você perdeu! A palavra era: " + palavraSecreta);
                        }

                        System.out.print("Deseja jogar novamente? (S/N): ");
                        String resposta = entrada.next().toUpperCase();
                        jogarNovamente = resposta.equals("S");
                    }
                    break;
                case 2:
                    System.out.println("Verificar pontuações");
                    for (int i = 0; i < numJogadores; i++) {
                        System.out.println("Nome: " + nomes[i] + " | Pontuação: " + pontuacoes[i]);
                    }
                    break;
                case 3:
                    System.out.println("Sair do jogo.");
                    entrada.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! Escolha um dos itens abaixo.");
                    break;
            }
        }
    }

    public static void printForca(int erros) {
    String[] forca = {
        "  +---+\n"
      + "  |   |\n"
      + "      |\n"
      + "      |\n"
      + "      |\n"
      + "      |\n"
      + "=========",

        "  +---+\n"
      + "  |   |\n"
      + "  O   |\n"
      + "      |\n"
      + "      |\n"
      + "      |\n"
      + "=========",

        "  +---+\n"
      + "  |   |\n"
      + "  O   |\n"
      + "  |   |\n"
      + "      |\n"
      + "      |\n"
      + "=========",

        "  +---+\n"
      + "  |   |\n"
      + "  O   |\n"
      + " /|   |\n"
      + "      |\n"
      + "      |\n"
      + "=========",

        "  +---+\n"
      + "  |   |\n"
      + "  O   |\n"
      + " /|\\  |\n"
      + "      |\n"
      + "      |\n"
      + "=========",

        "  +---+\n"
      + "  |   |\n"
      + "  O   |\n"
      + " /|\\  |\n"
      + " /    |\n"
      + "      |\n"
      + "=========",

        "  +---+\n"
      + "  |   |\n"
      + "  O   |\n"
      + " /|\\  |\n"
      + " / \\  |\n"
      + "      |\n"
      + "========="
    };

    System.out.println(forca[erros]);
}
}