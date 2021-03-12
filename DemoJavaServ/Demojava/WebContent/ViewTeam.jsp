<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import ="java.util.*,com.ltts.model.*,com.ltts.Dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team</title>
</head>
<body>
<%
TeamDao td=new TeamDao();
List<Team> li=td.getAllTeams();
%>
<table>
<tr>
<th>Team Id</th>
<th>Team Name</th>
<th>Owner Name</th>
<th>Coach Name</th>
<th></th>
</tr>
<%
for(Team t:li){
%>
<tr>
<td><%=t.getTeam_id() %></td>
<td><%=t.getTeamname() %></td>
<td><%=t.getOwnername() %></td>
<td><%=t.getCoachname() %></td>

<td><a href="editTeam.jsp?id=<%=t.getTeam_id()%>">Update</a></td>
</tr>
<%} %>
</table>

</body>
</html>