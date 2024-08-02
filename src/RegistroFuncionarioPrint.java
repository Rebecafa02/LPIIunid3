import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RegistroFuncionarioPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("DADOS DO FUNCIONARIO ");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Salario: ");
        double salario = scanner.nextDouble();

        try{
            FileWriter fluxoArquivo = new FileWriter("Funcionarios.txt", true);
            PrintWriter fluxo = new PrintWriter(fluxoArquivo, true);
            fluxo.print(nome);
            fluxo.print(' ');
            fluxo.println(salario);
            fluxoArquivo.close();

            System.out.println("Gravação de dados no arquivo concluida com sucesso! ");

        } catch (IOException e){
            e.printStackTrace();
        }
        scanner.close();
    }
}
