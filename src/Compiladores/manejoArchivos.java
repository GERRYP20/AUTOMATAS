package Compiladores;

import java.io.*;
import java.util.logging.*;

public class manejoArchivos {   
    public static void guardarArchivo(String texto){
        FileWriter fichero = null;
        PrintWriter pw = null;

            //Modificar ruta para guardar el archivo y probar 
        try {
            fichero = new FileWriter("datos/archivo.txt");
            pw = new PrintWriter(fichero);
            pw.println(texto);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
public static String cargarArchivo (){
    String cadena = "";
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    
    archivo = new File("datos/archivo.txt");
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            
            while ((linea = br.readLine()) != null){
                cadena = cadena + linea + "\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(manejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(manejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(manejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }  
      return cadena;  
    }
 





}
