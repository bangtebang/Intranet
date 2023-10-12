package modelo;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String rut;
	private String numeroMatricula;
	private Carrera carrera;

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNumeroMatricula() {
		return this.numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public Estudiante(String nombre, String apellido, String rut, String numeroMatricula) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.numeroMatricula = numeroMatricula;
	}
	public String toString(){
		return this.rut+","+this.nombre+","+this.numeroMatricula;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}
}