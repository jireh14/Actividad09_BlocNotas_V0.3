
package main;
import model.ModelCifrado;
import view.ViewCifrado;
import controller.ControllerCifrado;


public class Main {
    private static ViewCifrado viewCifrado;
    private static ModelCifrado modelCifrado;
    private static ControllerCifrado controllerCifrado;
    
    
    public static void main(String[] args) {
        ModelCifrado modelCifrado = new ModelCifrado();
        ViewCifrado viewCifrado = new ViewCifrado();
        ControllerCifrado controllerCifrado = new ControllerCifrado(modelCifrado, viewCifrado);
    
    
    
    }
}




    
        

