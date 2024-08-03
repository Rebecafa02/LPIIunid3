package ListaAvaliativa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CinemaUtil {
    public static final Set<String> cadeirasReservadas = new HashSet<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int op = 0;
        do{
           menu();
           System.out.println("Escolha o número da opção desejada: ");
           op = scanner.nextInt();
           scanner.nextLine();

           switch (op){
               case 1:
                   reservarPoltrona();
                   break;
               case 2:
                   poltronasDisponiveis();
                   break;
               case 3:
                   System.out.println("Encerrando programa.");
           }
        } while (op!=3);

    }

    public static void menu() {
        System.out.println("-------- MENU DE OPERAÇÕES -------");
        System.out.println("1 - Reservar nova poltrona");
        System.out.println("2 - Verificar quantidade de poltronas disponiveis");
        System.out.println("3 - Encerrar operação");
    }

    public static final void reservarPoltrona() {
        System.out.println("Nossas fileiras são: A, B, C e D e cada fileira possui cadeiras de 1 a 8.");
        System.out.println("Digite a letra e numero da poltrona desejada: ");
        String poltrona = scanner.nextLine().toUpperCase();
        if(poltrona.length() < 2 || poltrona.length() > 3){
            System.out.println("Formato inválido, tente novamente");
        } else {
            char fileira = poltrona.charAt(0);
            String num = poltrona.substring(1);
            if (fileira >= 'A' && fileira <= 'D') {
                try {
                    int numero = Integer.parseInt(num);
                    if (numero >= 1 && numero <= 8) {
                        cadeirasReservadas.add(poltrona);
                        System.out.println("Poltrona " + poltrona + " reservada com sucesso!");
                    } else {
                        System.out.println("Formato inválido, tente novamente");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Formato inválido!");
                }
            } else {
                System.out.println("Formato inválido, tente novamente");
            }
        }
    }
    public static final void poltronasDisponiveis() {
        int qtdPoltronasReservadas = cadeirasReservadas.size();
        int qtdPoltronasDisponiveis = 32 - qtdPoltronasReservadas;
        System.out.println("Ainda há " + qtdPoltronasDisponiveis + " poltronas disponíveis.");
    }
}
