package gui;
import controller.EstudianteController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class VentanaRegistroEstudiante extends JFrame {
    private JPanel RegistroEstudiantePanel;
    private JTextField campoNombre;
    private JTextField campoRut;
    private JTextField campoMatricula;
    private JButton registrarButton;
    private JButton cancelarButton;
    private JComboBox<String> listaCarrera;
    private JTextField campoApellido;

    public VentanaRegistroEstudiante() {
        setContentPane(RegistroEstudiantePanel);
        setTitle("Registro de Estudiante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
            }
        });
        listaCarrera.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                try{
                    listaCarrera.removeAllItems();
                    for (Object carrera : controller.CarreraController.getCodigoCarreras()){
                        listaCarrera.addItem((String) carrera);
                    }
                }
                catch (ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos");
                }
            }
        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(registrarEstudiante()) {
                        JOptionPane.showMessageDialog(registrarButton,"Estudiante registrado correctamente");
                        VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(registrarButton,"Ingrese datos validos");
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
    private boolean registrarEstudiante() throws ClassNotFoundException {
        if(this.campoMatricula.getText().length()==0 || this.campoNombre.getText().length()==0 || this.campoRut.getText().length()==0 || listaCarrera.getSelectedItem() == null || this.campoApellido.getText().length()==0){
            return false;
        }
        else{
            return EstudianteController.registrarEstudiante(this.campoNombre.getText(),this.campoApellido.getText(),this.campoRut.getText(), this.campoMatricula.getText(),this.listaCarrera.getSelectedItem().toString());
        }
    }
}