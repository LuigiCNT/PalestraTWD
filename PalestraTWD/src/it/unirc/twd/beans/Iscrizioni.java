package it.unirc.twd.beans;

public class Iscrizioni {
	private String Username;
	private String nomeCorso;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
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
		result = prime * result + ((Username == null) ? 0 : Username.hashCode());
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
		Iscrizioni other = (Iscrizioni) obj;
		if (Username == null) {
			if (other.Username != null)
				return false;
		} else if (!Username.equals(other.Username))
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
		return "Iscrizioni [Username=" + Username + ", nomeCorso=" + nomeCorso + "]";
	}
	public Iscrizioni() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Iscrizioni(String username, String nomeCorso) {
		super();
		Username = username;
		this.nomeCorso = nomeCorso;
	}
}
