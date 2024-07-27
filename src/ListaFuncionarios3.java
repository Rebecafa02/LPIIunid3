import java.io.*;
import java.util.*;

public class ListaFuncionarios3 {
    final static String caminhoArquivo = "lista-func-obj.txt";
    static Collection<Funcionario> quadroFuncionarios = new ArrayList<Funcionario>();
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int op;

        lerArquivo();

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

    public static void lerArquivo(){
        FileInputStream fluxoLeitura = null; //primeiro cria o fluxo de arquivo
        ObjectInputStream fluxoLeituraObjetos = null; //depois cria o fluxo de leitura de objeto

        try{
            fluxoLeitura = new FileInputStream(caminhoArquivo); //primeiro cria o fluxo de leitura
            fluxoLeituraObjetos = new ObjectInputStream(fluxoLeitura);

            quadroFuncionarios = (Collection<Funcionario>)fluxoLeituraObjetos.readObject();
            //transforma o objeto recebido como um objeto da lista, casting

            if(fluxoLeituraObjetos != null)
                fluxoLeituraObjetos.close();
            if (fluxoLeitura != null)
                fluxoLeitura.close();

        } catch (IOException e){
            e.printStackTrace();
            }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        }

    public static void escreverArquivo(){
        FileOutputStream fluxoEscrita; //primeiro o fluxo do arquivo
        ObjectOutputStream fluxoEscritaObjetos; //depois o fluxo do objeto
        try{
            fluxoEscrita = new FileOutputStream(caminhoArquivo);
            fluxoEscritaObjetos = new ObjectOutputStream(fluxoEscrita);

           fluxoEscritaObjetos.writeObject(quadroFuncionarios);

           fluxoEscritaObjetos.close();
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
