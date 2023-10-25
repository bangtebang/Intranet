package principal;

import gui.VentanaBienvenida;
import modelo.data.DBGenerator;

public class Principal {
    public static void main(String[] args) throws ClassNotFoundException {
        DBGenerator.iniciarBD("Universidad");
        new VentanaBienvenida();
    }
}