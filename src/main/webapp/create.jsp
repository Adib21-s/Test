<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Spectacle</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
    <nav>
      <div class="container">
        <ul class="menu">
          <li><a href="index.jsp">Home</a></li>
          <li><a href="create.jsp">Create</a></li>
          <li><a href="list.jsp">Products</a></li>
        </ul>
      </div>
    </nav>
  </header>

  <main>
    <section>
      <h2>Add New Spectacle</h2>
      <form action="CreateServlet" method="post">
        <label for="name">Spectacle Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="brand">Brand:</label>
        <input type="text" id="brand" name="brand" required>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" required>

        <button type="submit">Add Spectacle</button>
      </form>
    </section>
  </main>

  <footer>
    <p>&copy; 2024 Spectacle Management System</p>
  </footer>
</body>
</html>