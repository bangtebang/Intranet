package gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistroCarrera extends JFrame{
    private JPanel RegistroCarreraPanel;
    private JTextField campoNombre;
    private JTextField campoCarrera;
    private JTextField campoSemestre;
    private JButton registrarButton;
    private JButton cancelarButton;

    public VentanaRegistroCarrera() {
        setContentPane(RegistroCarreraPanel);
        setTitle("Registro de Carrera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String carrera = campoCarrera.getText();
                String semestre = campoSemestre.getText();
                if (nombre.equals("") || carrera.equals("") || semestre.equals("")){
                    JOptionPane.showMessageDialog(null,"Por favor, llene todos los campos");
                }
                else{
                    try{
                        int semestreInt = Integer.parseInt(semestre);
                        if (semestreInt < 1){
                            JOptionPane.showMessageDialog(null,"El número de semestres debe ser mayor a 0");
                        }
                        else{
                            try{
                                boolean carreraAgregada = controller.CarreraController.añadirCarrera(nombre,carrera,semestreInt);
                                if (!carreraAgregada){
                                    JOptionPane.showMessageDialog(null,"Ya existe una carrera con ese código");
                                }
                            }
                            catch (ClassNotFoundException ex){
                                JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos");
                            }
                            JOptionPane.showMessageDialog(null,"Carrera registrada con éxito");
                            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                            dispose();
                        }
                    }
                    catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null,"El número de semestres debe ser un número entero");
                    }
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                dispose();
            }
        });
    }
}