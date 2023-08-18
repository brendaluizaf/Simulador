package Simulador;

import java.util.Random;
import java.util.Scanner;

public class trab2 {
    public static void main(String[] args) { /*Método principal */
        String[] listaPalavras = { "JAVA", "PYTHON", "CPLUSPLUS", "JAVASCRIPT", "RUBY", "PHP" }; /*Lista do array */
        Random random = new Random(); /*Biblioteca que permite gerar dados aleatórios */
        Scanner entrada = new Scanner(System.in);/*Permite a inserção dos dados pelo usuário */
        System.out.println("1-Iniciar");
        System.out.println("2-Verificar pontos");
        System.out.println("3-Sair");
        int pontos = 0; /*Váriavel indicativa da forma como iniciará a contagem dos pontos */
        int opcoes = entrada.nextInt();/*escolha das opções do switch case */
        System.out.println("Digite seu nome: ");
        boolean jogarNovamente = true; 

        String nome = entrada.next();

        switch (opcoes) {
            case 1:
                System.out.println("Iniciar novo jogo");/*opção 1 iniciar o jogo */
                while (jogarNovamente) {
                    String palavraSecreta = listaPalavras[random.nextInt(listaPalavras.length)];
                    int vidas = 6;
                    char[] letrasDescobertas = new char[palavraSecreta.length()];
                    for (int i = 0; i < letrasDescobertas.length; i++) {/*Loop que permite descoberta das letras */
                        letrasDescobertas[i] = '_';
                    }

                    while (vidas > 0) { /*permite que o usuário tenha tentativas para descobrir as letras */
                        System.out.println("Palavra: " + new String(letrasDescobertas));
                        System.out.println("Vidas restantes: " + vidas);
                        System.out.print("Digite uma letra: ");
                        char letra = entrada.next().toUpperCase().charAt(0);/*Deixa a letra maiúscula */

                        boolean letraEncontrada = false;
                        for (int i = 0; i < palavraSecreta.length(); i++) {
                            if (palavraSecreta.charAt(i) == letra) {
                                letrasDescobertas[i] = letra;
                                letraEncontrada = true;/* Descoberta da letra correta preencherá o espaço */
                            }
                        }

                        if (!letraEncontrada) {
                            vidas--;
                            System.out.println("Letra não encontrada. Vidas restantes: " + vidas);/*Se letra errada perde uma vida */
                        }

                        if (new String(letrasDescobertas).equals(palavraSecreta)) {
                            System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
                            pontos++; /*A palavra completa corretamente retorna o aviso  */
                            break;
                        }
                    }

                    if (vidas == 0) {
                        System.out.println("Você perdeu! A palavra era: " + palavraSecreta);
                    } /*Se o número de tentativas exceder perde o jogo */

                    System.out.print("Deseja jogar novamente? (S/N): ");
                    String resposta = entrada.next().toUpperCase();
                    jogarNovamente = resposta.equals("S"); /*Opção de o jogador tentar novamente */
                }
                break;
            case 2:
                System.out.println(" Verificar pontuações");
                System.out.println(pontos);/*verifica a pontuação feita */
                break;
            case 3:
                System.out.println("Sair do jogo");/*sai do jogo e mostra quantos pontos foram feitos */
                break;
            default:
                System.out.println("Opção inválida!");
        }

        System.out.println("Obrigado por jogar! Você conseguiu o total de : " + pontos + "ponto(s) " + nome);
        entrada.close(); /*Se a opção de continuar for negada pelo usuário emitira o comunicado */

    }

}
