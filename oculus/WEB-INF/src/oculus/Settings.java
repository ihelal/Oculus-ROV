package oculus;

import java.io.*;

public class Settings {
	
	String filename = System.getenv("RED5_HOME")+"\\webapps\\oculus\\settings.txt";

	public String readSetting(String str) {
		// read through whole file line by line, extract result
		FileInputStream filein;	
		String result=null;
		try
		{
			filein = new FileInputStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(filein));
			String line = "";
		    while ((line = reader.readLine()) != null) {
		    	String items[] = line.split(" ");
		    	if ((items[0].toUpperCase()).equals(str.toUpperCase())) { result = items[1]; }		        
		    }
		    filein.close();		
		}
		catch (Exception e) { e.printStackTrace(); }
		return result;
	}
	
	public void writeSettings(String setting, String value) { // modify value of existing setting
		// read whole file, replace line while you're at it, write whole file
		value = value.replaceAll("\\s+$", ""); // remove trailing whitespace
		FileInputStream filein;
		String[] lines = new String[999];
		try
		{
			filein = new FileInputStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(filein));			
			int i=0;
		    while ((lines[i] = reader.readLine()) != null) { 
		    	String items[] = lines[i].split(" ");
		    	if ((items[0].toUpperCase()).equals(setting.toUpperCase())) {
		    		lines[i] = setting+" "+value;
		    	}
		    	i++;
		    }
		    filein.close();
		}
		catch (Exception e) { e.printStackTrace(); }
		
		FileOutputStream fileout;
		try
		{
			fileout = new FileOutputStream (filename);
			for (int n=0; n<lines.length; n++) {
				if (lines[n] != null) {
					new PrintStream(fileout).println (lines[n]);
				}
			}
		    fileout.close();		
		}
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public void newSetting(String setting, String value) {
		//read whole file, add single line, write whole file
		setting = setting.replaceAll("\\s+$", ""); // remove trailing whitespace
		value = value.replaceAll("\\s+$", ""); 
		
		FileInputStream filein;
		String[] lines = new String[999];
		try
		{
			filein = new FileInputStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(filein));			
			int i=0;
		    while ((lines[i] = reader.readLine()) != null) { 
	    		lines[i] = lines[i].replaceAll("\\s+$", ""); 
	    		if (!lines[i].equals("")) { i++; }
		    }
		    filein.close();
		}
		catch (Exception e) { e.printStackTrace(); }
		
		FileOutputStream fileout;
		try
		{
			fileout = new FileOutputStream (filename);
			for (int n=0; n<lines.length; n++) {
				if (lines[n] != null) {
					new PrintStream(fileout).println (lines[n]);
				}
			}
			new PrintStream(fileout).println (setting+" "+value);
		    fileout.close();		
		}
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public void deleteSetting(String setting) {
		//read whole file, remove offending line, write whole file
		setting = setting.replaceAll("\\s+$", ""); // remove trailing whitespace
		FileInputStream filein;
		String[] lines = new String[999];
		try
		{
			filein = new FileInputStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(filein));			
			int i=0;
		    while ((lines[i] = reader.readLine()) != null) { 
		    	String items[] = lines[i].split(" ");
		    	if ((items[0].toUpperCase()).equals(setting.toUpperCase())) {
		    		lines[i] = null;
		    	} 
	    		i++;
		    }
		    filein.close();
		}
		catch (Exception e) { e.printStackTrace(); }
		
		FileOutputStream fileout;
		try
		{
			fileout = new FileOutputStream (filename);
			for (int n=0; n<lines.length; n++) {
				if (lines[n] != null) {
					new PrintStream(fileout).println (lines[n]);
				}
			}
		    fileout.close();		
		}
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public String readRed5Setting(String str) {
		String filenm = System.getenv("RED5_HOME")+"\\conf\\red5.properties";
		FileInputStream filein;	
		String result=null;
		try
		{
			filein = new FileInputStream(filenm);
			BufferedReader reader = new BufferedReader(new InputStreamReader(filein));
			String line = "";
		    while ((line = reader.readLine()) != null) {
				String s[] = line.split("=");
				if (s[0].equals(str)) { result = s[1]; }
		    }
		    filein.close();
		}
		catch (Exception e) { e.printStackTrace(); }
		return result;
	}
	
	public void writeRed5Setting(String setting, String value) { // modify value of existing setting
		// read whole file, replace line while you're at it, write whole file
		String filenm = System.getenv("RED5_HOME")+"\\conf\\red5.properties";
		value = value.replaceAll("\\s+$", ""); // remove trailing whitespace
		FileInputStream filein;
		String[] lines = new String[999];
		try
		{
			filein = new FileInputStream(filenm);
			BufferedReader reader = new BufferedReader(new InputStreamReader(filein));			
			int i=0;
		    while ((lines[i] = reader.readLine()) != null) { 
		    	String items[] = lines[i].split("=");
		    	if ((items[0].toUpperCase()).equals(setting.toUpperCase())) {
		    		lines[i] = setting+"="+value;
		    	}
		    	i++;
		    }
		    filein.close();
		}
		catch (Exception e) { e.printStackTrace(); }
		
		FileOutputStream fileout;
		try
		{
			fileout = new FileOutputStream (filenm);
			for (int n=0; n<lines.length; n++) {
				if (lines[n] != null) {
					new PrintStream(fileout).println (lines[n]);
				}
			}
		    fileout.close();		
		}
		catch (Exception e) { e.printStackTrace(); }
	}
}

