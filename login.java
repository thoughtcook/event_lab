String username = request.getParameter("username");
String password = request.getParameter("password");
boolean loggedIn = false;

String sql = "select * from users where (username ='" + username +"' and password ='" + password + "')";

Connection connection = pool.getConnection();
Statement statement = connection.createStatement();
ResultSet result = statement.executeQuery(sql);

if (result.next()) {
    loggedIn = true;
    // Successfully logged in and redirect to user profile page

} else {
    // Auth failure - Redirect to Login Page
}
