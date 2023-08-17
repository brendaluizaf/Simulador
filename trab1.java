package Simulador;
import java.util.Scanner;
import java.util.Random;

public class trab1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");

        Random random = new Random();
        int numeroSecreto = random.nextInt(10) + 1;
        
        int[] tentativas= new int[100];
        int tentativaAtual = 0;
        int chute;

        while (true) {
            System.out.print("Digite um número entre 1 e 100: ");
            chute = scanner.nextInt();
            tentativas[tentativaAtual] = chute;
            tentativaAtual++;

            if (chute < numeroSecreto) {
                System.out.println("Tente um número maior.");
            } else if (chute > numeroSecreto) {
                System.out.println("Tente um número menor.");
            } else {
                System.out.println("Parabéns! Você acertou o número secreto " + numeroSecreto + " em " + tentativaAtual + " tentativas.");
                break;
            }
        }

        System.out.print("Tentativas: ");
        for(int i=0; i < numeroSecreto; i++){
            System.out.print(tentativas[i] + " ");
        }
        scanner.close();
    }
}
