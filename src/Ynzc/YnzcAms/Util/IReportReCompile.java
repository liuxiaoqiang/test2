package Ynzc.YnzcAms.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.w3c.dom.Document;

public class IReportReCompile {

	public static JasperReport getJasperReport(String jxmlPath,String topMargin,String bottomMargin,String leftMargin,String rightMargin) throws Exception{
		InputStream input = new FileInputStream(new File(jxmlPath));
		JasperDesign design=JRXmlLoader.load(input);
		design.setTopMargin(Integer.parseInt(topMargin));
		design.setBottomMargin(Integer.parseInt(bottomMargin));
		design.setLeftMargin(Integer.parseInt(leftMargin));
		design.setRightMargin(Integer.parseInt(rightMargin));
		JasperReport report= JasperCompileManager.compileReport(design);
		return report;
	}
	
}
