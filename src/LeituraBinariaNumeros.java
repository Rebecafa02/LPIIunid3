import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class LeituraBinariaNumeros {
    public static void main(String[] args) {
        try {
            FileInputStream fluxoArquivos = new FileInputStream("numeros.bin");
            DataInputStream fluxoDados = new DataInputStream(fluxoArquivos);

            boolean finalArquivo = false;
            while (!finalArquivo) {
                try{
                    int numLido = fluxoDados.readInt();
                    System.out.println(numLido);
                } catch (EOFException e){
                    finalArquivo = true;
                    System.out.println("Arquivo totalmente lido");
                }
            }
            fluxoDados.close();
            fluxoArquivos.close();
        } catch (IOException e) { //exceção por inexistencia de arquivos
            e.printStackTrace();
        }
    }
}
