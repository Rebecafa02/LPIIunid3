package Q01;


import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NumerosUtil {
    public static void main(String[] args) {
        int soma = 0 , cont = 0;

        try{
            FileReader fluxoArquivo = new FileReader("Numeros.txt");
            Scanner scanner = new Scanner(fluxoArquivo);
            while(scanner.hasNext()){
                soma += Integer.parseInt(scanner.nextLine());
                cont++;
            }
            scanner.close();
            fluxoArquivo.close();

        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Media = " + (double) soma/cont);
    }
}
