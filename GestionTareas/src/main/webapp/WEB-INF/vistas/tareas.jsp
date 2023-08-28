<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Proyecto.GestionTareas.model.entity.Tarea" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tareas</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%--Incluimos el menú.--%>
	<%@ include file='menu.jsp'%>
    <div class="container">
        <h1>Listado de Tareas</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Fecha</th>
                    <th>Usuario</th>
                </tr>
            </thead>
            <tbody>
                <% List<Tarea> tareas = (List<Tarea>) request.getAttribute("tareas");
                for (Tarea tarea : tareas) { %>
                    <tr>
                        <td><%= tarea.getId() %></td>
                        <td><%= tarea.getNombre() %></td>
                        <td><%= tarea.getDescripcion() %></td>
                        <td><%= tarea.getFecha() %></td>
                        <td><%= tarea.getUsuario().getUsername() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
