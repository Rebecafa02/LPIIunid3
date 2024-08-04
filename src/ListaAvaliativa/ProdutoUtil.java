package ListaAvaliativa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProdutoUtil {
    public static List<Produto> carrinhoDeCompras = new ArrayList<Produto>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int op = 0;
        do{
            menu();
            System.out.println("Escolha o número da opção desejada: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op){
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    valorTotal();
                    break;
                case 3:
                    System.out.println("Encerrando programa.");
            }

        }while (op!=3);
    }

    public static final void menu() {
        System.out.println("-------- MENU DE OPERAÇÕES -------");
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Verificar valor total do carrinho de compras");
        System.out.println("3 - Encerrar operação");
    }

    public static final void adicionarProduto(){
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o preço unitario do produto: ");
        double precoUnitario = scanner.nextDouble();
        for (int i = 1; i <= quantidade; i++){
            carrinhoDeCompras.add(new Produto(nome, precoUnitario));
            System.out.println(nome + " adicionado ao carrinho com sucesso.");
        }
    }

    public static final void valorTotal(){
        Iterator<Produto> it = carrinhoDeCompras.iterator();
        double total = 0;

        while (it.hasNext()){
            Produto p = it.next();
            total += p.getPrecoUnitario();
        }
        if(total > 100){
            int num = (int) total/100;
            double desconto = ((num*5) * total)/100;
            System.out.println("O valor total do carrinho de compras é R$" + (total-desconto) + " e você obteve R$" +
                    desconto + " de desconto.");
        } else {
            System.out.println("O valor total do carrinho de compras é R$" + total);
        }
    }
}
