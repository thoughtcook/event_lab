import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cnt.Security.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.StringBuffer;
import java.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SQLTest extends HttpJspBase {
	public static void sqlTest1 (Connection conn, HttpServletRequest request) {
		ResultSet rs = null;
		Statement stmt = null;

		String userInput = request.getParameter('user');

		String query = "SELECT * " +
        	"FROM TABLE " +
        	"WHERE 1=1 ";
	
		if (!userInput.equals("")){
			query+=(" AND ID=" + userInput + " ");
		}
	
	 	try {
			conn = DriverManager.getConnection("http://sql", "userName", "user");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	public static void sqlTest2 (Connection con, HttpServletRequest request) {
		ResultSet rs = null;
		Statement stmt = null;

		String userInput = request.getParameter('user');

		StringBuffer strBuf = new StringBuffer("SELECT * FROM foo WHERE 1=1"); 
		strBuf.append("&variable=" + userInput); 

		String query=strBuf.toString(); 

		try {
			conn = DriverManager.getConnection("http://sql", "userName", "userCode");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	public static void sqlTest2 (String userId, String userCode, Connection con) {
		String query = "SELECT * FROM users WHERE userid ='"+ userid + "'" + " AND userCode='" + 
						userCode + "'";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}
}
