
<%@page import="edu.ulima.bean.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="key01" class="java.util.ArrayList" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <title>Crisol ULima</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel="shortcut icon" type="image/png" href="http://www.ulima.edu.pe/sites/default/files/favicon.png">

        <!-- No tocar, parte de Popper y Bootstrap-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="css/mdb.min.css" rel="stylesheet">
        <!-- Your custom styles (optional) -->
        <link href="css/style.css" rel="stylesheet">

    </head>

    <body>


        <main role="main">

            <section class="jumbotron text-center">
                <div class="container">
                    <h1 class="jumbotron-heading"><b>CRUD Libros Crisol</b></h1>
                    <ul class="list-inline">
                        <li class="list-inline-item">Leonardo Estremadoyro</li>
                        <li class="list-inline-item">Andrea Castro</li>
                        <li class="list-inline-item">Giancarlo Sanchez</li>
                        <li class="list-inline-item">Ronald Hualpa</li>
                        <li class="list-inline-item">Sergio Calcina</li>
                    </ul>

                    <p>

                    <form action="s05" class="form-inline justify-content-center md-form mr-auto mb-4">
                        <input class="form-control mr-sm-2 rounded border-info px-6" type="text" name="tituloBusqueda" placeholder="Titulo" aria-label="Search">
                        <button class="btn btn-info my-2" type="submit">BUSCAR</button>

                    </form>
                    <br>
                    <a class="btn btn-info my-2" href="ventanaCrearLibro.html" >CREAR LIBRO</a>
                       
                    </p>
                </div>
            </section>
            
            <div class="album py-5">
                <div class="container">

                    <div class="row row-sm-6">
                        <% for (int i = 0; i < key01.size(); i++) {
                                Libro l = (Libro) key01.get(i);
                        %> 
                        <div class="col-md-4">
                            <div class="card mb-4 py-3 shadow-l">
                                <img class="bd-placeholder-img card-img-top" width="100%" height="410" src=<%= l.getImagen()%>> 
                                <div class="card-body">
                                    <p class="card-text">
                                    <ul class="libro">

                                        <li><strong>Codigo: </strong><span><%= l.getCodigo()%></span></li>
                                        <li><strong>Titulo: </strong><span><%= l.getTitulo()%></span></li>
                                        <li><strong>Autor: </strong><span><%= l.getAutor()%></span></li>
                                        <li><strong>Precio: S/.</strong><span><%= l.getPrecio()%></span></li>


                                    </ul>
                                    </p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <a class="btn btn-sm btn-info" href="ventanaActualizar.jsp?codigo=<%= l.getCodigo()%>&titulo=<%= l.getTitulo()%>&autor=<%= l.getAutor()%>&precio=<%= l.getPrecio()%>&imagenURL=<%= l.getImagen()%>" >Editar</a>    
                                            <a class="btn btn-sm btn-danger" href="s02?codigo=<%= l.getCodigo()%>" >Eliminar</a>
                                            <a class="btn btn-sm btn-success" href=<%= l.getUrl()%> target="blank_">Ir</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                                        
                        </div>
                        <% }%> 
                    </div>
                </div>
            </div>

        </main>

        <!-- No tocar, parte de Popper y Bootstrap-->

        <script type="text/javascript" src="js/jquery-3.4.0.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
    </body>
</html>