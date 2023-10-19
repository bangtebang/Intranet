package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class VentanaTabla extends JFrame{
    private JPanel TablaPanel;
    public VentanaTabla() {
        setContentPane(TablaPanel);
        setTitle("Tabla de Estudiantes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}