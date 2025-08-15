import java.io.BufferedReader; //Importar el BufferedReader que será el escaner
import java.io.FileReader; //Lo anterior pero para leer el archivo
import java.io.IOException; //Para las excepciones 
import java.util.HashMap; //Para el HashMap, ahorita lo explicaré

public class codigos_postales {
    public static void main(String[] args) {

        System.out.println("\033[H\033[2J"); //Este codigo es para que en la consola, se limpie cada que se repita el archivo, aprendido en primer semestre
        System.out.flush();

        //DECLARACIÓN DE VARIABLES
        String linea; //Para guardar mas adelante las lineas del archivo
        HashMap<String, Integer> conteo = new HashMap<>(); //Esto hara el conteo de cuantas veces se repite un codigo postal

        try (BufferedReader br = new BufferedReader(new FileReader("codigos_postales_hmo.csv"))) {  //Declarar el Buffered Reader dentro de un try an catch para en caso de excepción
            while ((linea = br.readLine()) != null) { //Esto leerá línea por línea hasta que encuentre una vacia y las guardará
                String[] datos = linea.split(","); //Este arreglo separa los datos de cada linea, la coma se encuentra en el documento para dividirlos
                if (datos.length >= 1) { //El if es solo para asegurarse que la linea tenga al menos un caracter (que no esté vacio)
                    String codigoPostal = datos[0].trim(); //Obtiene el codigo postal, que es el primer elemento de cada linea

                    conteo.put(codigoPostal, conteo.getOrDefault(codigoPostal, 0) + 1); // Esto es para contar cuántas veces aparece cada código postal
                }
            }

            for (String codigo : conteo.keySet()) {
                System.out.println("El código postal " + codigo + " tiene " + conteo.get(codigo) + " colonias");
            }
            //El foreach es para imprimir los codigos postales con las veces que se repite.

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage()); //Esta atrapa los errores (es necesario al usar el BufferedReader)
        }
    }
}