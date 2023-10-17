package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;
	
	public ReadConfig() {
		
		File file= new File("./configuration/config.properties");
		
		try {
			
			FileInputStream fis= new FileInputStream(file);
			pro= new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			
			System.out.println("File not found"+e.getMessage());
			
			
		}
		
		
	}
	
	
	public String getSaasUrl() {
		String saasUrl=pro.getProperty("saasUrl");
		return saasUrl;
	}

	
	public String getSaasUname() {
		String saasUname=pro.getProperty("saasUname");
		return saasUname;
	}
	
	public String getSaasPword() {
		String saasPword=pro.getProperty("saasPword");
		return saasPword;
	}
	
	public String getschlLogin() {
		String schlLogin=pro.getProperty("schlLogin");
		return schlLogin;
	}
	
	
	public String getschlCode() {
		String schlCode=pro.getProperty("schlCode");
		return schlCode;
	}

	
	
	public String getschlUname() {
		String schlUname=pro.getProperty("schlUname");
		return schlUname;
	}
	
	public String getschlPword() {
		String schlPword=pro.getProperty("schlPword");
		return schlPword;
	}
	
	
	//
	
	
	
	public String getTeacherUname() {
		String TeacherUname=pro.getProperty("TeacherUname");
		return TeacherUname;
	}
	
	
	public String getTeacherPword() {
		String TeacherPword=pro.getProperty("TeacherPword");
		return TeacherPword;
	}

	
	
	public String getstdUname() {
		String stdUname=pro.getProperty("stdUname");
		return stdUname;
	}
	
	public String getstdPword() {
		String stdPword=pro.getProperty("stdPword");
		return stdPword;
	}


	public String getBrowser() {
	String browser=pro.getProperty("Browser");
		return browser;
	}
    
}
