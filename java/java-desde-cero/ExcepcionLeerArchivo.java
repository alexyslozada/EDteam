import java.io.*;

public class ExcepcionLeerArchivo {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("C:\\test\\a.txt");
            BufferedReader fileInput = new BufferedReader(file);

            // Print first 3 lines of file "C:\test\a.txt"
            for (int counter = 0; counter < 3; counter++)
                System.out.println(fileInput.readLine());

            fileInput.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ioe) {
            System.out.println("No puedo leer el archivo");
        }

        System.out.println("termine");
    }
}