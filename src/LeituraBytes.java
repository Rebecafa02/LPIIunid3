import java.io.FileInputStream;
import java.io.IOException;

public class LeituraBytes {
    public static void main(String[] args) {
        try{
            FileInputStream fluxo = new FileInputStream("arquivo.bin");
            byte byteLido;
            //leitura dos bytes enquanto não se alcançar o final do arquivo
            do{
                byteLido = (byte) fluxo.read(); //leitura de byte
                if(byteLido != -1){
                    System.out.print((char)byteLido);
                }
            } while (byteLido != -1);
            fluxo.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
