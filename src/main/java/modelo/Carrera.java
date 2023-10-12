package modelo;

public class Carrera {
	private String nombre;
	private String codigo;
	private int cantidadSemestres;

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCantidadSemestres() {
		return this.cantidadSemestres;
	}

	public void setCantidadSemestres(int cantidadSemestres) {
		this.cantidadSemestres = cantidadSemestres;
	}

	public Carrera(String nombre, String codigo, int cantidadSemestres) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.cantidadSemestres = cantidadSemestres;
	}
}