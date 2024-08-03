package Q04;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NomesUtil {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<String>();
        List<String> sobrenomes = new ArrayList<String>();
        List<String> nomeCompleto = new ArrayList<>();
        int qtdPessoas = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantas pessoas você deseja gerar? ");
        qtdPessoas = scanner.nextInt();

        try {
            FileReader fluxoNomes = new FileReader("CodigoDeAula/src/Q04/nomes.txt");
            FileReader fluxoSobrenomes = new FileReader("CodigoDeAula/src/Q04/sobrenomes.txt");

            scanner = new Scanner(fluxoNomes);
            while (scanner.hasNextLine()) {
                nomes.add(scanner.nextLine());
            }

            scanner = new Scanner(fluxoSobrenomes);
            while (scanner.hasNextLine()) {
                sobrenomes.add(scanner.nextLine());
            }

            Random random = new Random();
            for (int i = 0; i < qtdPessoas; i++) {
                nomeCompleto.add(nomes.get(random.nextInt(nomes.size())) + " " +
                        sobrenomes.get(random.nextInt(sobrenomes.size())) + ", " +
                        (random.nextInt(100) + 1));
            }

            fluxoNomes.close();
            fluxoSobrenomes.close();
            scanner.close();

        } catch (IOException e){
            e.printStackTrace();
        }

       for(int i = 0; i < nomeCompleto.size(); i++){
           String nomeTemp = nomeCompleto.get(i);
           int j = i - 1;
           while (j >= 0 && nomes.get(j).compareTo(nomeTemp) > 0){
               nomeCompleto.set(j+1, nomeCompleto.get(j));
               j--;
           }
           nomeCompleto.set(j+1, nomeTemp);
       }
        for (String nomesCompleto : nomeCompleto) {
            // listagem de nomes
            System.out.println(nomesCompleto);
        }

        try{
            FileWriter fileWriter = new FileWriter("nomesCompletos.txt");
            for(String nome : nomeCompleto){
                fileWriter.write(nome + "\n");
            }
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
