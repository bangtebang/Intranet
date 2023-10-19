package gui;
import javax.swing.*;

public class VentanaBienvenida  extends JFrame{

    private JPanel BienvenidaPanel;
    private JButton registrarCarreraButton;
    private JButton registrarEstudianteButton;
    private JButton buscarEstudianteButton;
    private JButton salirButton;

    public VentanaBienvenida() {
    setContentPane(BienvenidaPanel);
    setTitle("Bienvenido");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500,500);
    setLocationRelativeTo(null);
    setVisible(true);
}}