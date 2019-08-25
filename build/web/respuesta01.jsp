
<%@page import="edu.ulima.bean.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="key01" class="java.util.ArrayList" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todos los libros</title>
    </head>
    <body>
        <h1>Listado de libros</h1>
        <table>
        <% for (int i=0; i < key01.size(); i++ )  { 
            Libro l = (Libro)key01.get(i);
        %>
        <tr>
            <td><a href=<%= l.getUrl() %>><%= l.getCodigo() %></a></td> <%//Este podría ser un "Ver mas" %>
            <td><%= l.getTitulo() %></td>
            <td><%= l.getAutor() %></td>
            <td><image src=<%= l.getImagen() %>>  </td>
            <td><%= l.getPrecio() %></td>
        </tr>
        <% } %>
        </table>
    </body>
</html>
