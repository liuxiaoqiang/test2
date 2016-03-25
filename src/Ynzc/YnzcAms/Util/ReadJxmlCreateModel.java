package Ynzc.YnzcAms.Util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadJxmlCreateModel {
	
	public static void main(String args[]) throws Exception{
		String url="D:\\KW的工作目录\\JavaProject\\YnzcAms\\WebRoot\\Report\\tractorScrapApplication.jrxml";
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		Element theBook=null, theElem=null, root=null;
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder db=factory.newDocumentBuilder();
		File file=new File(url);
		Document xmldoc=db.parse(file);
		root=xmldoc.getDocumentElement();
		NodeList fields=root.getElementsByTagName("field");
		String ClassName=file.getName().substring(0,file.getName().indexOf("."));
		ClassName=ClassName.substring(0,1).toUpperCase()+ClassName.substring(1)+"Source";
		System.out.println("package Ynzc.YnzcAms.Model;");
		System.out.println("public class "+ClassName+" {");
		for(int i=0;i<fields.getLength();i++){
			Node node=fields.item(i);
			String type=node.getAttributes().getNamedItem("class").getNodeValue();
			System.out.println(" public "+type.substring(type.lastIndexOf('.')+1)+" "+node.getAttributes().getNamedItem("name").getNodeValue()+";");
		}
		for(int i=0;i<fields.getLength();i++){
			Node node=fields.item(i);
			String type=node.getAttributes().getNamedItem("class").getNodeValue();
			type=type.substring(type.lastIndexOf('.')+1);
			String name=node.getAttributes().getNamedItem("name").getNodeValue();
			String nameTwo=name.substring(0,1).toUpperCase()+name.substring(1);
			System.out.println(" public void set"+nameTwo+"("+type+" "+name+"){");
			System.out.println("\tthis."+name+"="+name+";");
			System.out.println(" }");
			System.out.println(" public "+type+" get"+nameTwo+"(){");
			System.out.println("\treturn "+name+";");
			System.out.println(" }");
		}
		System.out.println("}");
	}

}
