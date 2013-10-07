package edu.faqi.pocs.properties;

import java.io.IOException;
import java.util.Properties;

public class LeProperties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties prop = new Properties();

		try {
			// load a properties file from class path, inside static method
			prop.load(LeProperties.class.getClassLoader().getResourceAsStream(
					"edu/faqi/dcoo/nota/regiaosul/sc_impostos.properties"));

			// get the property value and print it out
			String icmsProp = prop.getProperty("icms.sc.valor");
			Double icms = Double.parseDouble(icmsProp);
			System.out.println(icms);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
