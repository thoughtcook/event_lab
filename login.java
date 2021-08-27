import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartServlet.
 * 
 */
public class StartServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */

    protected void processRequest(HttpServletRequest request) throws ServletException, IOException {
        
        String user = request.getParameter("user");

        Connection conn = null;
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String dbName = "sql_inject";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
    
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);

            Statement st = conn.createStatement();
            String query = "SELECT * FROM  User where userid='" + user + "'";
            ResultSet res = st.executeQuery(query);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     protected void processRequest_2(HttpServletRequest request) throws ServletException, IOException {
        
        String id = request.getParameter("id");

        Connection conn = null;
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String dbName = "sql_inject";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
    
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);

            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM TABLE WHERE 1=1 ";
            if (!id.equals("")) {
                query += (" AND ID="+ id +" ");
            }
            ResultSet rs = stmt.executeQuery(query);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void processRequest_3 (HttpServletRequest request) throws ServletException, IOException {
        
        String input = request.getParameter("input");

        StringBuffer strBuf = new StringBuffer("SELECT * FROM foo WHERE 1=1");
        strBuf.append ("&variable=" + input); 
        String query = strBuf.toString(); 

        Connection conn = null;
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String dbName = "sql_inject";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
    
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);

            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
