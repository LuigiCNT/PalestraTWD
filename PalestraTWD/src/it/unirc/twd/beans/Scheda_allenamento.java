package it.unirc.twd.beans;

import java.sql.Blob;
import java.sql.Date;

public class Scheda_allenamento {
	private String Username;
	private String Tipologia;
	private int   Durata;
	private String Link;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getTipologia() {
		return Tipologia;
	}
	public void setTipologia(String tipologia) {
		Tipologia = tipologia;
	}
	public int getDurata() {
		return Durata;
	}
	public void setDurata(int durata) {
		Durata = durata;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Durata;
		result = prime * result + ((Link == null) ? 0 : Link.hashCode());
		result = prime * result + ((Tipologia == null) ? 0 : Tipologia.hashCode());
		result = prime * result + ((Username == null) ? 0 : Username.hashCode());
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
		Scheda_allenamento other = (Scheda_allenamento) obj;
		if (Durata != other.Durata)
			return false;
		if (Link == null) {
			if (other.Link != null)
				return false;
		} else if (!Link.equals(other.Link))
			return false;
		if (Tipologia == null) {
			if (other.Tipologia != null)
				return false;
		} else if (!Tipologia.equals(other.Tipologia))
			return false;
		if (Username == null) {
			if (other.Username != null)
				return false;
		} else if (!Username.equals(other.Username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Scheda_allenamento [Username=" + Username + ", Tipologia=" + Tipologia + ", Durata=" + Durata
				+ ", Link=" + Link + "]";
	}
	public Scheda_allenamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Scheda_allenamento(String username, String tipologia, int durata, String link) {
		super();
		Username = username;
		Tipologia = tipologia;
		Durata = durata;
		Link = link;
	}
	
	
}
