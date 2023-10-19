package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class VentanaRegistroCarrera extends JFrame{
    private JPanel RegistroCarreraPanel;
    public VentanaRegistroCarrera() {
        setContentPane(RegistroCarreraPanel);
        setTitle("Registro de Carrera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}