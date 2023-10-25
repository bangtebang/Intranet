package gui;
import controller.EstudianteController;
import controller.CarreraController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class VentanaBusquedaEstudiante extends JFrame {
    private JPanel BusquedaEstudiantePanel;
    private JTextField campoNombre;
    private JComboBox<String> listaCarrera;
    private JButton buscarEstudianteButton;
    private JButton regresarButton;
    private JTextField campoApellido;

    public VentanaBusquedaEstudiante(){
        setContentPane(BusquedaEstudiantePanel);
        setTitle("Busqueda de Estudiante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                dispose();
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
        buscarEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] nombreColumnas={"Nombre estudiante","N° de matricula","Carrera","CodigoCarrera"};
try{
                    String[][] datos = exportarDatos();
                    if (datos.length == 0) {
                        JOptionPane.showMessageDialog(null, "No se encontraron estudiantes");
                    } else {
                        VentanaTabla ventanaTabla = new VentanaTabla(datos, nombreColumnas);
                        dispose();
                    }
                }
                catch (ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos");
                }
            }
        });
    }
    private String[][] exportarDatos() throws ClassNotFoundException {
        if (campoNombre.getText().length() == 0 && listaCarrera.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Ingrese datos válidos");
            return new String[0][0];
        } else if (campoNombre.getText().length() == 0) {
            return EstudianteController.mostrarEstudiantesPorCarrera(listaCarrera.getSelectedItem().toString());
        } else {
            return EstudianteController.mostrarEstudiantesPorNombre(
                    listaCarrera.getSelectedItem().toString(),
                    campoNombre.getText()
            );
        }
    }

}

        /*
        otra opcion sin tabla es:

        buscarEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String nombre = campoNombre.getText();
                    String carrera = listaCarrera.getSelectedItem().toString();
                    String rut = controller.EstudianteController.getRutEstudiante(nombre,carrera);
                    String matricula = controller.EstudianteController.getMatriculaEstudiante(nombre,carrera);
                    String apellido = campoApellido.getText();
                    JOptionPane.showMessageDialog(null,"Rut: "+rut+"\nMatricula: "+matricula+"\nApellido: "+apellido);
                }
                catch (ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos");
                }
            }
        });

        */