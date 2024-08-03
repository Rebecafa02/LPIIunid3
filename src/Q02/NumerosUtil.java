package Q02;


import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NumerosUtil {
    public static void main(String[] args) {
        int soma = 0 , cont = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a quantidade de  numeros a serem lidos: ");
        int qtd = sc.nextInt();
        sc.close();

        try{
            FileReader fluxoArquivo = new FileReader("Numeros.txt");
            Scanner scanner = new Scanner(fluxoArquivo);

            try{
                for(int i = 0 ; i < qtd ; i++){
                    soma += scanner.nextInt();
                    cont++;
                }
                System.out.println("Media = " + (double) soma / qtd);
            } catch (NoSuchElementException e){
                System.out.println("Quantidade insuficiente de linhas no arquivo ");
            }

        } catch (IOException e){
           throw new RuntimeException(e);
        }
    }
}
