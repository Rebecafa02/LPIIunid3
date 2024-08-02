import java.io.FileInputStream;
import java.io.IOException;

public class LeituraArray {
    public static void main(String[] args) {
        try{
            FileInputStream fluxo = new FileInputStream("arquivo.bin");
            int qtdBytes = fluxo.available(); //obtenção da quantidade de bytes disponivel para leitura no arquivo

            byte[] bytesLidos = new byte[qtdBytes]; //array baseado na qtd de bytes no arquivo
            if(fluxo.read(bytesLidos) != -1){ //leitura usando como parametro o array
                String texto = new String(bytesLidos); //String a partir da decodificação dos bytes lidos
                System.out.println(texto);
            }
            fluxo.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
