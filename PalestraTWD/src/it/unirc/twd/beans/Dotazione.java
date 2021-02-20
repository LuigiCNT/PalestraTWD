package it.unirc.twd.beans;

import java.io.Serializable;

public class Dotazione implements Serializable{
	private String attrezzo;
	private String nomeCorso;
	public String getAttrezzo() {
		return attrezzo;
	}
	public void setAttrezzo(String attrezzo) {
		this.attrezzo = attrezzo;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attrezzo == null) ? 0 : attrezzo.hashCode());
		result = prime * result + ((nomeCorso == null) ? 0 : nomeCorso.hashCode());
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
		Dotazione other = (Dotazione) obj;
		if (attrezzo == null) {
			if (other.attrezzo != null)
				return false;
		} else if (!attrezzo.equals(other.attrezzo))
			return false;
		if (nomeCorso == null) {
			if (other.nomeCorso != null)
				return false;
		} else if (!nomeCorso.equals(other.nomeCorso))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dotazione [attrezzo=" + attrezzo + ", nomeCorso=" + nomeCorso + "]";
	}
	public Dotazione(String attrezzo, String nomeCorso) {
		super();
		this.attrezzo = attrezzo;
		this.nomeCorso = nomeCorso;
	}
	public Dotazione() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
