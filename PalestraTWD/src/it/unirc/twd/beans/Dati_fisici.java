package it.unirc.twd.beans;

public class Dati_fisici {
	private String username;
	private double altezza; 
	private double peso;
	private double plicometria;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(altezza);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(plicometria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dati_fisici other = (Dati_fisici) obj;
		if (Double.doubleToLongBits(altezza) != Double.doubleToLongBits(other.altezza))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(plicometria) != Double.doubleToLongBits(other.plicometria))
			return false;
		return true;
	}
	public double getAltezza() {
		return altezza;
	}
	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPlicometria() {
		return plicometria;
	}
	public void setPlicometria(double plicometria) {
		this.plicometria = plicometria;
	}
	@Override
	public String toString() {
		return "Dati_fisici [altezza=" + altezza + ", peso=" + peso + ", plicometria=" + plicometria + "]";
	}
	public Dati_fisici() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dati_fisici(double altezza, double peso, double plicometria) {
		super();
		this.altezza = altezza;
		this.peso = peso;
		this.plicometria = plicometria;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
