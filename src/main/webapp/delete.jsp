<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Spectacle</title>
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
      <h2>Delete a Spectacle</h2>
      <form action="DeleteServlet" method="post">
        <label for="id">Spectacle ID:</label>
        <input type="number" id="id" name="id" value="<%= Integer.parseInt(request.getParameter("id")) %>" readonly>
        <button type="submit">Delete Spectacle</button>
      </form>
    </section>
  </main>

  <footer>
    <p>&copy; 2024 Spectacle Management System</p>
  </footer>
</body>
</html>