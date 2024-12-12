<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Spectacle</title>
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
    	
      <h2>Update Existing Spectacle</h2>
      <form action="UpdateServlet" method="post">
        <label for="id">Spectacle ID:</label>
        <input type="number" id="id" name="id" value="<%=Integer.parseInt(request.getParameter("id"))%>" readonly>

        <label for="name">New Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="brand">New Brand:</label>
        <input type="text" id="brand" name="brand" required>

        <label for="price">New Price:</label>
        <input type="number" id="price" name="price" required>

        <button type="submit">Update Spectacle</button>
      </form>
    </section>
  </main>

  <footer>
    <p>&copy; 2024 Spectacle Management System</p>
  </footer>
</body>
</html>