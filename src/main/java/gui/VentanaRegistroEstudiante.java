package gui;
import javax.swing.*;

public class VentanaRegistroEstudiante extends JFrame {
    private JPanel RegistroEstudiantePanel;

    public VentanaRegistroEstudiante() {
        setContentPane(RegistroEstudiantePanel);
        setTitle("Registro de Estudiante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}