package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LeitorProperties {
	File arquivo;
	public LeitorProperties(String arq){
		arquivo = new File(arq);
	}
	/**
	 * M�todo para obter properties do arquivo
	 * @author Carlos Henrique
	 */
	public Properties getProperties() {
		Properties props = new Properties();
		try{
			FileInputStream fis = new FileInputStream(arquivo.getAbsolutePath());
			props.load(fis);
			fis.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return props;
	}
}
