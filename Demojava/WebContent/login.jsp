<%@ page import="java.sql.*"%>
<%
    String userName = request.getParameter("username");   
    String password = request.getParameter("password");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project",
            "root", "root");
    PreparedStatement ps= con.prepareStatement("select * from user where username=? and password=? ");
    ps.setString(1, userName);
    ps.setString(2,password);
    ResultSet rs=ps.executeQuery();
    if (rs.next()) {
        session.setAttribute("userid", userName);
        response.sendRedirect("index.html");
    } else {
        out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
%>