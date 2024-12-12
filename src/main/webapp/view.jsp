<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home - Spectacle Management System</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
	  <nav>
	    <ul class="menu">
	      <li><a href="index.jsp">Home</a></li>
	      <li><a href="create.jsp">Create</a></li>
	      <li><a href="list.jsp">Products</a></li>
	    </ul>
	  </nav>
</header>
  <main>
    <section>
    	<h2>View Product</h2>
      <table>
      	<tr>
      		<th>Name</th>
      		<th>Value</th>
      	</tr>
      	<%
      	int id = Integer.parseInt(request.getParameter("id"));
      	
      	try {
      		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
  			Connection con = DriverManager.getConnection("jdbc:sqlserver://nuggeteyewear.database.windows.net:1433;database=NuggetEyewear;user=POKEMON@nuggeteyewear;password=Nugget123;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
  			
  			String sql = "SELECT * FROM product WHERE productid = ?";
  			PreparedStatement ps = con.prepareStatement(sql);
  			ps.setInt(1, id);
  			
  			ResultSet rs = ps.executeQuery();
  			while(rs.next()) {
  				out.println("<tr>");
  				out.println("<td>Product Id</td>");
  				out.println("<td>" + rs.getInt(1) + "</td>");
  				out.println("</tr>");
  				out.println("<tr>");
  				out.println("<td>Product Name</td>");
  				out.println("<td>" + rs.getString(2) + "</td>");
  				out.println("</tr>");
  				out.println("<tr>");
  				out.println("<td>Product Brand</td>");
  				out.println("<td>" + rs.getString(3) + "</td>");
  				out.println("</tr>");
  				out.println("<tr>");
  				out.println("<td>Product Price</td>");
  				out.println("<td>" + rs.getDouble(4) + "</td>");
  				out.println("</tr>");
  			}
  			con.close();
  		}
  		catch (Exception e){
  			System.out.println(e);
  		}
      	%>
      </table>
    </section>
  </main>

  <footer>
    <p>&copy; 2024 Spectacle Management System</p>
  </footer>
</body>
</html>