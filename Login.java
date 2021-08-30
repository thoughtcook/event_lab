import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cnt.Security.*;

import java.lang.StringBuffer;
import java.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

// Class Declaration
class Login
{
    public static void main(String[] args)   
    {
        try {
            String email = request.getParameter("email");
            String token = request.getParameter("password");

            String sql = "select * from users where (email ='" + email +"' and password ='" + token + "')";

            Connection connection = pool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                loggedIn = true;
                // Successfully logged in and redirect to user profile page
            
            } else {
             // Auth failure - Redirect to Login Page
            }
            
            connection.close();
        }
        catch (e) {
            System.out.println(e);
            connection.close();
        }
    }
} 
