package Simulador;
import java.util.Random;
import java.util.Scanner;

public class trab2 {
    public static void main(String[] args) { //Método principal
        String[] listaPalavras = { "CACAU", "PEIXE", "MACARRAO", "CHOCOLATE", "RABANETE", "RISOTO" };
        Random random = new Random();
        Scanner entrada = new Scanner(System.in);

        int[] pontuacoes = new int[10]; // Vetor para armazenar pontuações
        String[] nomes = new String[10]; // Vetor para armazenar nomes
        int indice = 0; // Índice para inserção de pontuações e nomes
        
        System.out.print("Digite a quantidade de jogadores: ");
        int numJogadores = entrada.nextInt();
        entrada.nextLine(); // Limpa o buffer de entrada
        
        for (int jogador = 0; jogador < numJogadores; jogador++) {
            System.out.print("Digite o nome do jogador " + (jogador + 1) + ": ");
            String nome = entrada.nextLine();
            nomes[jogador] = nome;
        }

        boolean jogarNovamente = true;
        
        while (true) { // Loop infinito para o menu principal
            System.out.println("1-Iniciar");
            System.out.println("2-Verificar pontos");
            System.out.println("3-Sair");
            System.out.print("Escolha uma opção:");

            int opcoes = entrada.nextInt();

            switch (opcoes) {
                case 1:
                    for (int jogador = 0; jogador < numJogadores; jogador++) {
                        jogarNovamente = true; // Reinicia a variável a cada jogador
                        System.out.println("\nJogador " + nomes[jogador]);

                        String palavraSecreta = listaPalavras[random.nextInt(listaPalavras.length)];
                        int vidas = 6;
                        char[] letrasDescobertas = new char[palavraSecreta.length()];
                        for (int i = 0; i < letrasDescobertas.length; i++) {
                            letrasDescobertas[i] = '_';
                        }

                        while (vidas > 0) { // permite que o usuário tenha tentativas para descobrir as letras 
                            System.out.println("Palavra: " + new String(letrasDescobertas));
                            System.out.println("Vidas restantes: " + vidas);
                            System.out.print("Digite uma letra: ");
                            char letra = entrada.next().toUpperCase().charAt(0);// Deixa a letra maiúscula 

                            boolean letraEncontrada = false;
                            for (int i = 0; i < palavraSecreta.length(); i++) {
                                if (palavraSecreta.charAt(i) == letra) {
                                    letrasDescobertas[i] = letra;
                                    letraEncontrada = true;// Descoberta da letra correta preencherá o espaço
                                }
                            }

                            if (!letraEncontrada) {
                                vidas--;
                                System.out.println("Letra não encontrada. Vidas restantes: " + vidas);//Se letra errada perde uma vida
                            }

                            if (new String(letrasDescobertas).equals(palavraSecreta)) {
                                System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
                                pontuacoes[jogador]++; // Incrementa a pontuação
                                break;
                            }
                        }

                        if (vidas == 0) {
                            System.out.println("Você perdeu! A palavra era: " + palavraSecreta);
                        } // Se o número de tentativas exceder perde o jogo 

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
}