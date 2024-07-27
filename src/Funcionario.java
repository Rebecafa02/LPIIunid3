import java.io.Serializable;

public class Funcionario implements Serializable {
    //Serializable indica se a classe está apta para ser gravada em um fluxo
    private String nome;
    private int matricula;
    private double salario;

    public Funcionario (String n, int m, double s){
        nome = n;
        matricula = m;
        salario = s;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String n){
        nome = n;
    }

    public double getSalario(){
        return salario;
    }

    public void setSalario(double salario){
        if (salario > 0)
        this.salario = salario;
    }

    public int getMatricula(){
        return matricula;
    }

    public void setMatricula(int m){
        matricula = m;
    }

    public void reajustarSalario(double percentual){
        double reajuste = salario * percentual/100;
        salario += reajuste;
    }

    public String toString(){
        return "Nome: " + nome + ", Matricula: " + matricula + ", Salario: " + salario;
    }

}
