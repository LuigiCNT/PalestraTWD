package it.unirc.twd.beans;

public class Attrezzi {
	private String  nome;
	private int id;
	private String gruppo_muscolare;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGruppo_muscolare() {
		return gruppo_muscolare;
	}
	public void setGruppo_muscolare(String gruppo_muscolare) {
		this.gruppo_muscolare = gruppo_muscolare;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gruppo_muscolare == null) ? 0 : gruppo_muscolare.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Attrezzi other = (Attrezzi) obj;
		if (gruppo_muscolare == null) {
			if (other.gruppo_muscolare != null)
				return false;
		} else if (!gruppo_muscolare.equals(other.gruppo_muscolare))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Attrezzi [nome=" + nome + ", id=" + id + ", gruppo_muscolare=" + gruppo_muscolare + "]";
	}
	public Attrezzi(String nome, int id, String gruppo_muscolare) {
		super();
		this.nome = nome;
		this.id = id;
		this.gruppo_muscolare = gruppo_muscolare;
	}
	public Attrezzi() {
		super();
		// TODO Auto-generated constructor stub
	}
}
