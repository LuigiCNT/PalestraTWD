package it.unirc.twd.beans;

import java.sql.Date;

public class Pagamento {
	private String username;
	private Date data;
	private String metodo;
	private int importo;
	public Pagamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pagamento(String username, Date data, String metodo, int importo) {
		super();
		this.username=username;
		this.data = data;
		this.metodo = metodo;
		this.importo = importo;
	}
	@Override
	public String toString() {
		return "Pagamento [username=" + username + ", data=" + data + ", metodo=" + metodo + ", importo=" + importo
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + importo;
		result = prime * result + ((metodo == null) ? 0 : metodo.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Pagamento other = (Pagamento) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (importo != other.importo)
			return false;
		if (metodo == null) {
			if (other.metodo != null)
				return false;
		} else if (!metodo.equals(other.metodo))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public int getImporto() {
		return importo;
	}
	public void setImporto(int importo) {
		this.importo = importo;
	}
}
