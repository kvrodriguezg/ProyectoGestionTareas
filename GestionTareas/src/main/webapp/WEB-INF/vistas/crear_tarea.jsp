<%@ page import="Proyecto.GestionTareas.model.entity.Usuario"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Tarea</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="bg-light">

<%-- Incluimos el menú. --%>
<%@ include file='menu.jsp'%>

<%-- Formulario para crear tarea. --%>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header bg-primary text-white text-center">
                    <h4>Ingrese datos de la tarea</h4>
                </div>
                <div class="card-body">
                    <form action="tareaCreada" method="post">
                        <div class="mb-3">
                            <label for="usuario_id" class="form-label">ID Usuario</label>
                            <select name="usuario_id" id="usuario_id" class="form-select">
                                <option value="0" selected>ID Usuario</option>
                                <%
                                ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
                                for(Usuario usuario : usuarios){
                                %>
                                    <option><%= usuario.getId() %></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre">
                        </div>
                        <div class="mb-3">
                            <label for="descripcion" class="form-label">Descripción</label>
                            <input type="text" class="form-control" id="descripcion" name="descripcion">
                        </div>
                        <div class="mb-3">
                            <label for="fecha" class="form-label">Fecha</label>
                            <input type="text" class="form-control" id="fecha" name="fecha">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Enviar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
