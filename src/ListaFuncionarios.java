import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class ListaFuncionarios {
    final static String caminhoArquivo = "lista-func.txt";
    final static Collection<Funcionario> quadroFuncionarios = new ArrayList<Funcionario>();
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        do{
            menu();
            System.out.println("Digite o numero da operação desejada:");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op){
                case 1: inserir(); break;
                case 2: rejustarSalario(); break;
                case 3: listar(); break;
            }

        } while (op != 4);
        escreverArquivo();
    }
    public static void escreverArquivo(){
        try{
            FileWriter fluxoEscrita = new FileWriter(caminhoArquivo);
            Iterator<Funcionario> it = quadroFuncionarios.iterator();

            while (it.hasNext()){
                Funcionario f = it.next();
                fluxoEscrita.write(f.getNome() + " " + f.getMatricula()
                        + " " + f.getSalario() + "\n");
            }
            System.out.println("Arquivo gravado");
            fluxoEscrita.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void menu(){
        System.out.println("------- OPERAÇÕES --------");
        System.out.println("1- Inserir Funcionário");
        System.out.println("2- Reajustar salário de todos os Funcionários");
        System.out.println("3- Listar Funcionário");
        System.out.println("4- Encerrar operações");
    }

    public static void inserir(){
    System.out.println("Insira o nome do funcionário: ");
    String nome = scanner.nextLine().toUpperCase();
    System.out.println("Insira o número de matrícula: ");
    int matricula = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Insira o salário: ");
    double salario = scanner.nextDouble();
    scanner.nextLine();

    Funcionario f = new Funcionario(nome, matricula, salario);

    quadroFuncionarios.add(f);
    }

    public static void rejustarSalario(){
        System.out.println("Digite o percentual de reajuste: ");
        double percentual = scanner.nextDouble();
        scanner.nextLine();

        Iterator<Funcionario> it = quadroFuncionarios.iterator();
        while (it.hasNext()){
            Funcionario f = it.next();
            f.reajustarSalario(percentual);
        }
    }

    public static void listar(){
        Iterator<Funcionario> it = quadroFuncionarios.iterator();

        System.out.println("Listar: ");

        for(int i = 1; it.hasNext(); i++){
            Funcionario f = it.next();
            System.out.println("Funcionário (" + i + "): " + f);
        }
    }
}