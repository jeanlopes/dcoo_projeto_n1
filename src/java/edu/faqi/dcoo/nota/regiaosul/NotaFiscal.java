package edu.faqi.dcoo.nota.regiaosul;

import java.util.ArrayList;
import java.util.Date;

public class NotaFiscal {

	int codigo;
	Date data;
	String uf;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	
	public static boolean AdicionarItem(ArrayList<ItemNota> ItensNotaList, int quantidade){
		
		return false;
		
	}
	
	public static Float CalcularTotal(){
		return null;
	
	}
	
	public static Double CalcularTotalSemImposto(){
		return null;
	
	}
	
	
	
	
}
