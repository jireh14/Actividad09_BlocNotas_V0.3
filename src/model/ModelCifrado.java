
package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import java.util.Scanner;

public class ModelCifrado {
    private String abrir;
    private String cifrar;
    private String descifrar;
    private String guardar;
    private String texto=" ";
    

    public String getAbrir() {
        return abrir;
    }

    public void setAbrir(String abrir) {
        this.abrir = abrir;
    }

    public String getCifrar() {
        return cifrar;
    }

    public void setCifrar(String cifrar) {
        this.cifrar = cifrar;
    }

    public String getDescifrar() {
        return descifrar;
    }

    public void setDescifrar(String descifrar) {
        this.descifrar = descifrar;
    }

    public String getGuardar() {
        return guardar;
    }

    public void setGuardar(String guardar) {
        this.guardar = guardar;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public void cifrar(String[] args){
    Scanner S = new Scanner(System.in);
        String cifrado1, cifrado2;
        int desplazamiento;
        cifrado2= " ";
        
        String minus = "abcdefghijklmnopqrstuvwxyz";
        String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        System.out.print("Introduzca un texto:");
        cifrado1 = S.nextLine();
        
        System.out.print("Introduzca la clave del desplazamiento: ");
        desplazamiento = S.nextInt();
        
        for(int i = 0; i < cifrado1.length(); i++){
            for(int j = 0; j < minus.length(); j++){
                if(cifrado1.charAt(i) == minus.charAt(j)){
                    if(j + desplazamiento >= minus.length()){
                        cifrado2 += minus.charAt((j + desplazamiento) % minus.length());
                    }
                    else{
                         cifrado2 += minus.charAt(j + desplazamiento);
                    }
                }
                else if(cifrado1.charAt(i) == mayus.charAt(j)){
                    if(j + desplazamiento >= mayus.length()){
                        cifrado2 += mayus.charAt((j + desplazamiento) % mayus.length());
                    }
                    else{
                         cifrado2 += mayus.charAt(j + desplazamiento);
                    }
                }
            }
        }
        
        System.out.print(cifrado1);
        System.out.print(cifrado2);
    }
    public void descifrar(String[] args){
    Scanner S = new Scanner(System.in);
        String cifrado1, cifrado2;
        int desplazamiento;
        cifrado2= " ";
        
        String minus = "abcdefghijklmnopqrstuvwxyz";
        String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        System.out.print("Introduzca un texto:");
        cifrado1 = S.nextLine();
        
        System.out.print("Introduzca la clave del desplazamiento: ");
        desplazamiento = S.nextInt();
        
        for(int i = 0; i < cifrado1.length(); i++){
            for(int j = 0; j < minus.length(); j++){
                if(cifrado1.charAt(i) == minus.charAt(j)){
                    if(j + desplazamiento >= minus.length()){
                        cifrado2 += minus.charAt((j - desplazamiento) % minus.length());
                    }
                    else{
                         cifrado2 += minus.charAt(j - desplazamiento);
                    }
                }
                else if(cifrado1.charAt(i) == mayus.charAt(j)){
                    if(j + desplazamiento >= mayus.length()){
                        cifrado2 += mayus.charAt((j - desplazamiento) % mayus.length());
                    }
                    else{
                         cifrado2 += mayus.charAt(j - desplazamiento);
                    }
                }
            }
        }
        
        System.out.print(cifrado1);
        System.out.print(cifrado2);
    }
    
    public void readFile(){
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(jfc);
        try{
            String row;
            String path = jfc.getSelectedFile().getAbsolutePath();
            
            try (FileReader file = new FileReader(path)){
                BufferedReader bufferedReader = new BufferedReader(file);
                while((row = bufferedReader.readLine()) !=null){
                    System.out.println(row);
                }
                
                bufferedReader.close();    
            }   
            }
            catch(FileNotFoundException err){
                System.err.println("El archivo no ha sido encontrado:" + err.getMessage()); 
            }//catch
            catch(IOException err){
                System.err.println("Error de entrada y salida:" + err.getMessage());
            }
        }//readFile
            public void writeFile(){
            JFileChooser jfc = new JFileChooser();
            jfc.showSaveDialog(jfc);
            
            try{
                String path = jfc.getSelectedFile().getAbsolutePath();
                
                File file = new File(path);
                FileWriter fileWriter = new FileWriter (file, true);
                
                try(PrintWriter printWriter = new PrintWriter (fileWriter))
                {
                    printWriter.println(texto);
                    printWriter.close();
                }
                }//try
                catch(FileNotFoundException err){
                    System.err.println("El archivo no ha sido encontrado:" + err.getMessage());
                }
                catch(IOException err){
                    System.err.println("Error de Entrada y Salida: " + err.getMessage());
                
                }
    
   }         
}
    

