package gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        registrarCarreraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistroCarrera ventanaRegistroCarrera = new VentanaRegistroCarrera();
                dispose();
            }
        });
        registrarEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistroEstudiante ventanaRegistroEstudiante = new VentanaRegistroEstudiante();
                dispose();
            }
        });
        buscarEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaBusquedaEstudiante ventanaBusquedaEstudiante = new VentanaBusquedaEstudiante();
                dispose();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }}