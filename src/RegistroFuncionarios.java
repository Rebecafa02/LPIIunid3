import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegistroFuncionarios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("DADOS DO FUNCIONARIO ");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Salario: ");
        double salario = scanner.nextDouble();

        try{
            FileWriter fluxoArquivo = new FileWriter("funcionario.txt", true);
            fluxoArquivo.write(nome + ' ' + salario + System.lineSeparator());
            fluxoArquivo.close();
            System.out.println("Gravação de dados no arquivo concluida com sucesso! ");

        } catch (IOException e){
            e.printStackTrace();
        }
        scanner.close();
    }
}
