package Q03;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NomesUtil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> nomes = new ArrayList<String>();
        List<String> sobrenome = new ArrayList<>();
        List<String> nomeCompleto = new ArrayList<>();
        int qtdDePessoas = 0;

        System.out.println("Quantas pessoas você deseja gerar?");
        qtdDePessoas = scanner.nextInt();
        try {
            FileReader fluxoNomes = new FileReader("CodigoDeAula/src/Q03/nomes.txt");
            FileReader fluxoSobrenomes = new FileReader("CodigoDeAula/src/Q03/sobrenomes.txt");

            scanner = new Scanner(fluxoNomes);
            while (scanner.hasNextLine()) {
                nomes.add(scanner.nextLine());
            }

            scanner = new Scanner(fluxoSobrenomes);
            while (scanner.hasNextLine()) {
                sobrenome.add(scanner.nextLine());
            }

            Random random = new Random();
            for(int i = 0; i < qtdDePessoas; i++) {
                nomeCompleto.add("Nome: " + nomes.get(random.nextInt(nomes.size())) + " " +
                        sobrenome.get(random.nextInt(sobrenome.size())) + " Idade: " +
                        (random.nextInt(100)+1) );
            }

            scanner.close();
            fluxoNomes.close();
            fluxoSobrenomes.close();

            nomeCompleto.forEach(System.out::println);

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
