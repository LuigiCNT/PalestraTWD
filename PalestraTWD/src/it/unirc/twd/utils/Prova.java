package it.unirc.twd.utils;
import it.unirc.twd.*;
import it.unirc.twd.beans.Scheda_allenamento;
import it.unirc.twd.beans.Scheda_allenamentoDAO;
public class Prova {

	public static void main(String[] args) {
		Scheda_allenamento sa = new Scheda_allenamento();
		Scheda_allenamentoDAO saDAO = new Scheda_allenamentoDAO();
		
		String us = "demetrio2";
		
		sa = saDAO.getSchedaByString("demetrio2");
		
		System.out.println(sa.toString());
		
	}



}
