package it.unirc.twd.beans;

public class Corsi {
	private String tipologia;
	private String coach;
	private int durata;
	public Corsi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Corsi(String tipologia, String coach, int durata) {
		super();
		this.tipologia = tipologia;
		this.coach = coach;
		this.durata = durata;
	}
	@Override
	public String toString() {
		return "Corsi [tipologia=" + tipologia + ", coach=" + coach + ", durata=" + durata + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coach == null) ? 0 : coach.hashCode());
		result = prime * result + durata;
		result = prime * result + ((tipologia == null) ? 0 : tipologia.hashCode());
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
		Corsi other = (Corsi) obj;
		if (coach == null) {
			if (other.coach != null)
				return false;
		} else if (!coach.equals(other.coach))
			return false;
		if (durata != other.durata)
			return false;
		if (tipologia == null) {
			if (other.tipologia != null)
				return false;
		} else if (!tipologia.equals(other.tipologia))
			return false;
		return true;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	
}
