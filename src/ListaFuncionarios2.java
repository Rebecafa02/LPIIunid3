import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ListaFuncionarios2 {
    final static String caminhoArquivo = "lista-func.txt";
    final static Collection<Funcionario> quadroFuncionarios = new ArrayList<Funcionario>();
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
        FileReader fluxoLeitura = null;
        Scanner scannerFluxoArquivo = null;

        try{
            fluxoLeitura = new FileReader(caminhoArquivo); //primeiro cria o fluxo de leitura
            scannerFluxoArquivo = new Scanner(fluxoLeitura); //depois passa esse fluxo como paramento para o scanner
            //ao invés do scanner ler o console (system.in) ele vai ler o arquivo (fluxoLeitura)

            for(int i = 1; scannerFluxoArquivo.hasNextLine(); i++){
                try {
                    String linha = scannerFluxoArquivo.nextLine(); //String a ser quebrada para virar o objeto

                    StringTokenizer tokenizer = new StringTokenizer(linha, "|");
                    //primeiro parametro é a string e o segundo é o demilitador

                    String nome = tokenizer.nextToken();
                    int matricula = Integer.parseInt(tokenizer.nextToken());
                    double salario = Double.parseDouble(tokenizer.nextToken());

                    Funcionario func = new Funcionario(nome, matricula, salario);

                    quadroFuncionarios.add(func);
                } catch (Exception e){
                    System.out.printf("Linha %d de arquivo não processada \n", i);
                }

            }

            if(scannerFluxoArquivo != null)
                scannerFluxoArquivo.close();

            if(fluxoLeitura != null)
                fluxoLeitura.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void escreverArquivo(){
        try{
            FileWriter fluxoEscrita = new FileWriter(caminhoArquivo);
            Iterator<Funcionario> it = quadroFuncionarios.iterator();

            while (it.hasNext()){
                Funcionario f = it.next();
                fluxoEscrita.write(f.getNome() + "|" + f.getMatricula()
                        + "|" + f.getSalario() + "\n");
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