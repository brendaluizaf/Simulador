package Simulador;
import java.util.Random;
import java.util.Scanner;

public class trab2 {
    public static void main(String[] args) {
        String[] listaPalavras = {"JAVA", "PYTHON", "CPLUSPLUS", "JAVASCRIPT", "RUBY", "PHP"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean jogarNovamente = true;
        
        while (jogarNovamente) {
            String palavraSecreta = listaPalavras[random.nextInt(listaPalavras.length)];
            int vidas = 6;
            char[] letrasDescobertas = new char[palavraSecreta.length()];
            for (int i = 0; i < letrasDescobertas.length; i++) {
                letrasDescobertas[i] = '_';
            }

            while (vidas > 0) {
                System.out.println("Palavra: " + new String(letrasDescobertas));
                System.out.println("Vidas restantes: " + vidas);
                System.out.print("Digite uma letra: ");
                char letra = scanner.next().toUpperCase().charAt(0);

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
                }

                if (new String(letrasDescobertas).equals(palavraSecreta)) {
                    System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
                    break;
                }
            }

            if (vidas == 0) {
                System.out.println("Você perdeu! A palavra era: " + palavraSecreta);
            }

            System.out.print("Deseja jogar novamente? (S/N): ");
            String resposta = scanner.next().toUpperCase();
            jogarNovamente = resposta.equals("S");
        }

        System.out.println("Obrigado por jogar!");
        scanner.close();
    }
}
