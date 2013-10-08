package edu.faqi.dcoo.nota.regiaosul;

import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import edu.faqi.pocs.properties.LeProperties;

public class NotaFiscal {

	private int codigo;
	private Date data;
	private String uf;
	private ArrayList<ItemNota> ItensNotaList;

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

	public ArrayList<ItemNota> getItensNotaList() {
		return ItensNotaList;
	}

	public void setItensNotaList(ArrayList<ItemNota> itensNotaList) {
		ItensNotaList = itensNotaList;
	}

	public boolean AdicionarItem(Produto produto, int quantidade) {
		try {

			ItemNota itemNota = new ItemNota(produto, quantidade);
			itemNota.codNotaFiscal = 1;

			return ItensNotaList.add(itemNota);
		} catch (Exception e) {
			return false;
		}
	}

	public float CalcularTotal() {
		try {
			double valorTotal = 0.0;
			double icms = 0.0;
			double iEstadual1 = 0.0;
			double iEstadual2 = 0.0;
			
			for (ItemNota item : this.ItensNotaList) {
				valorTotal += item.getValorParcial();
			}

			
			if("RS".equalsIgnoreCase(this.uf))
			{
			   icms = valorTotal* 0.15;
			   iEstadual1 = valorTotal * 0.003;
			   iEstadual2 = valorTotal * 0.003;
			}
			
			if("SC".equalsIgnoreCase(this.uf))
			{
				Properties prop = new Properties();

					// load a properties file from class path, inside static method
					prop.load(LeProperties.class.getClassLoader().getResourceAsStream(
							"edu/faqi/dcoo/nota/regiaosul/sc_impostos.properties"));

					// get the property value and print it out
					String icmsProp = prop.getProperty("icms.sc.valor");
					icms = Double.parseDouble(icmsProp);
					
			}
			
			if("PR".equalsIgnoreCase(this.uf))
			{
				icms = valorTotal* 0.13;
			}
			valorTotal = valorTotal+ icms + iEstadual1 + iEstadual2;
			return (float) valorTotal;

		} catch (Exception e) {
			return 0.0f;
		}
	}

	public Double CalcularTotalSemImposto() {
		try {
			double valorTotal = 0.0;

			for (ItemNota item : this.ItensNotaList) {

				valorTotal += item.getValorParcial();
			}

			return (double) valorTotal;

		} catch (Exception e) {
			return 0.0d;
		}
	}

}
