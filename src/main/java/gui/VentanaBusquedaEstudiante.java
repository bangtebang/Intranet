package gui;
import javax.swing.*;

public class VentanaBusquedaEstudiante extends JFrame {
    private JPanel BusquedaEstudiantePanel;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton buscarEstudianteButton;
    private JButton regresarButton;

    public VentanaBusquedaEstudiante() {
        setContentPane(BusquedaEstudiantePanel);
        setTitle("Busqueda de Estudiante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}