
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModelCifrado;
import view.ViewCifrado;

public final class ControllerCifrado implements ActionListener{
    ModelCifrado modelCifrado;
    ViewCifrado viewCifrado;
    
    public ControllerCifrado(ModelCifrado modelCifrado, ViewCifrado viewCifrado){
        this.modelCifrado = modelCifrado;
        this.viewCifrado = viewCifrado;
        this.viewCifrado.jMI_abrir.addActionListener(this);
        this.viewCifrado.jMI_guardar.addActionListener(this);
        this.viewCifrado.jMI_cifrar.addActionListener(this);
        this.viewCifrado.jMI_descifrar.addActionListener(this);
        initComponets();
       
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewCifrado.jMI_abrir){
            jMI_abrir_action_performed();
    }
        if(e.getSource() == viewCifrado.jMI_cifrar){
            jMI_cifrar_action_performed();
            
        }
        if(e.getSource() == viewCifrado.jMI_descifrar){
            jMI_descifrar_action_performed();
            
    }
        if(e.getSource() == viewCifrado.jMI_guardar){
            jMI_guardar_action_performed();
        }
    }
    
    private void jMI_abrir_action_performed(){
        modelCifrado.setTexto(String.valueOf(viewCifrado.jTA_areas.getText()));
        modelCifrado.readFile();
        
    }
    private void jMI_cifrar_action_performed(){
        modelCifrado.setTexto(String.valueOf(viewCifrado.jTA_areas.getText()));
        modelCifrado.setTexto(String.valueOf(viewCifrado.jMI_cifrar.getText()));
        modelCifrado.readFile();
        
    }
    private void jMI_descifrar_action_performed(){
        modelCifrado.setTexto(String.valueOf(viewCifrado.jTA_areas.getText()));
        modelCifrado.setTexto(String.valueOf(viewCifrado.jMI_descifrar.getText()));
        modelCifrado.readFile();
        
    }
    private void jMI_guardar_action_performed(){
        modelCifrado.setGuardar(String.valueOf(viewCifrado.jTA_areas.getText()));
        modelCifrado.writeFile();
        
    }
    public void initComponets(){
        viewCifrado.setVisible(true);
        viewCifrado.jTA_areas.setText(String.valueOf(modelCifrado.getTexto()));
        
    }
    }
    
    

