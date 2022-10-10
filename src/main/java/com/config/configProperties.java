/**
 * 
 */
package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author thilina.karunarathna
 *
 */
public class configProperties {
	
	private static String configPath = "Configuration/ConfigSetting.properties";
	public static Properties property;

	public static void initializeConfigProperty() {
		property= new Properties();
		try {
		InputStream instrm = new FileInputStream(configPath);
		property.load(instrm);
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}