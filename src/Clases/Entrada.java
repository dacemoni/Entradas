package Clases;

import java.util.Objects;

public class Entrada implements Comparable<Entrada>{

	private int id;
	private String zona;
	private String tipo;
	private String nombreComprador;

	public Entrada(int id, String zona, String tipo, String nombreComprador) {
		this.id = id;
		this.zona = zona;
		this.tipo = tipo;
		this.nombreComprador = nombreComprador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return id == other.id && Objects.equals(nombreComprador, other.nombreComprador) && zona == other.zona;
	}

	@Override
	public String toString() {
		return "Entrada con id = " + id + ", zona = " + zona + ", tipo = " + tipo + ", nombreComprador = " + nombreComprador;
	}

	@Override
	public int compareTo(Entrada o){
		if (id == o.id){
			return nombreComprador.compareTo(o.getNombreComprador());
		}
		else{
			return Integer.compare(o.getId(), id);
		}
	}


}
