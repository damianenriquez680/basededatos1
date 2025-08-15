import java.io.BufferedReader; //Importar el BufferedReader que será el escaner
import java.io.FileNotFoundException;
import java.io.FileReader; //Lo anterior pero para leer el archivo
import java.io.IOException; //Para las excepciones 

public class LeerCSV {
    public static void main(String[] args) {

        try (FileReader fr = new FileReader("codigos_postales_hmo.csv")) {

            BufferedReader br = new BufferedReader(fr);
            String line;

            String cpString;
            int contador = 1;
            int lastCP = 0;
            while ((line = br.readLine()) != null) {

                cpString = line.substring(0, 5);
                int currentCP = Integer.parseInt(cpString);
                if (lastCP == currentCP) {
                    contador++;
                } else {
                    System.out.printf("%d $d\n", lastCP, contador);
                    contador = 1;
                }
            }
                
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}