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

String email = request.getParameter("email");
String password = request.getParameter("password");

String sql = "select * from users where (email ='" + email +"' and password ='" + password + "')";

Connection connection = pool.getConnection();
Statement statement = connection.createStatement();
ResultSet result = statement.executeQuery(sql);

if (result.next()) {
    loggedIn = true;
    // Successfully logged in and redirect to user profile page
} else {
    // Auth failure - Redirect to Login Page
}
