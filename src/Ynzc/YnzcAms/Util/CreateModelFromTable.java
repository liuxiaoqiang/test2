package Ynzc.YnzcAms.Util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class CreateModelFromTable {

	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/ynzcams";
		String tableName="ynzc_tractorinfo_view";
		String ClassName="ynzc_tractorinfoTest";
		Connection con;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		try {
			con = (Connection) DriverManager.getConnection(url, "rabbit", "rabbit"); 
			Statement stmt = (Statement) con.createStatement();			
			ResultSet data = (ResultSet) stmt.executeQuery("show columns from "+tableName+";");
			System.out.println("package Ynzc.YnzcAms.Model;");
			System.out.println("import javax.persistence.*;");
			System.out.println("import java.util.*;");
			System.out.println("@Entity");
			System.out.println("@Table(name = \""+tableName+"\")");
			System.out.println("public class "+ClassName+" {");
			while (data.next()) {
				String fieldName=data.getString("Field");
				String type=getType(data.getString("Type"));
				System.out.println(" public "+type+" "+fieldName+";");
			}		
			data.first();
			System.out.println(" @id");
			System.out.println(" @GeneratedValue(strategy = GenerationType.AUTO)");
			CreateGetSet(data);
			while (data.next()) {
				CreateGetSet(data);
			}		
			System.out.println("}");
			con.close();		
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
	
	public static String getType(String dataType){

		if(dataType.equals("date")){
			return "Date";
		}else{
			dataType=dataType.substring(0,dataType.indexOf('('));
		}
		if(dataType.equals("int")){
			return "int";
		}else
		if(dataType.equals("varchar")){
			return "String";
		}else{		
			return null;
		}
	}
	
	public static void CreateGetSet(ResultSet data) throws SQLException{
		String fieldName=data.getString("Field");
		String fieldNameTwo=data.getString("Field").substring(0,1).toUpperCase()+data.getString("Field").substring(1);
		String type=getType(data.getString("Type"));
		System.out.println(" public "+type+" get"+fieldNameTwo+"(){");
		System.out.println("\treturn "+fieldName+";");
		System.out.println(" }");
		System.out.println(" public void set"+fieldNameTwo+"("+type+" "+fieldName+"){");
		System.out.println("\tthis."+fieldName+"="+fieldName+";");
		System.out.println(" }");
	}
	
}
