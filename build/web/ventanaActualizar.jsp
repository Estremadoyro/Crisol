
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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
        <%
                String codigo = request.getParameter("codigo");
                String titulo = request.getParameter("titulo");
                String autor = request.getParameter("autor");
                String precio = (String)request.getParameter("precio") ;
                String imagenURL = (String)request.getParameter("imagenURL") ;
                System.out.println(titulo);
                System.out.println(autor);
       %>

        <main role="main">

            <section class="jumbotron text-center">
                <div class="container">
                    <h1 class="jumbotron-heading"><b>Actualizar</b><i> <%=titulo%></i></h1>
                    <ul class="list-inline">
                        <li class="list-inline-item">Leonardo Estremadoyro</li>
                        <li class="list-inline-item">Andrea Castro</li>
                        <li class="list-inline-item">Giancarlo Sanchez</li>
                        <li class="list-inline-item">Ronald Hualpa</li>
                        <li class="list-inline-item">Sergio Calcina</li>
                    </ul>

                    <p>



                    </p>
                </div>
            </section>
            <section class="jumbotron text-center container pb-2 pt-4" id="crear">
                <form action="s04" class="needs-validation" novalidate>
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="codigo">Código</label>
                            <input type="text" class="form-control" name="codigoAct" id="validationCustom01" placeholder="<%=codigo%>"  readonly onmousedown="return false;" value="<%=codigo%>">

                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="titulo">Título</label>                          
                            <input type="text" class="form-control" id="titulo" name="tituloAct" placeholder="Título" required value="<%=titulo%>">

                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="precio">Precio</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="soles">S/.</span>
                                </div>
                                <input type="text" class="form-control" id="precio" name="precioAct" aria-describedby="soles" required value="<%=precio%>">
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-3 mb-3">
                            <label for="autor">Autor</label>
                            <input type="text" class="form-control" id="autor" name="autorAct" placeholder="Autor" required value="<%=autor%>">
                        </div>
                        <div class="col-md-9 mb-3">
                            <label for="imagen">URL de imagen</label>
                            <div class="input-group">
                                <div class="custom-file">
                                    <input type="text" class="form-control" id="imagenURL" name="imagenURL" placeholder="URL de imagen" required value="<%=imagenURL%>">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">

                        <button class="btn btn-info my-2" type="submit">Actualizar libro </button>
                    </div>
                </form>  
            </section>
            <div class="album py-5">                
                <div class="container" >                     
                     <div class="row justify-content-center row-sm-6">                      
                        <div class="col-md-4">
                            <div class="card mb-4 py-3 shadow-l ">
                                <div align="center"><Strong><h1>Vista Previa</h1></strong></div>
                                <img class="bd-placeholder-img card-img-top" width="100%" height="410" src=<%=imagenURL%>> 
                                <div class="card-body">
                                    <p class="card-text">
                                    <ul class="libro">

                                        <li><strong>Codigo:</strong><span><%= codigo%></span></li>
                                        <li><strong>Titulo: </strong><span><%= titulo%></span></li>
                                        <li><strong>Autor: </strong><span><%= autor%></span></li>
                                        <li><strong>Precio: S/.</strong><span><%= precio%></span></li>


                                    </ul>
                                    </p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <a class="btn btn-sm btn-info disabled" href="ventanaActualizar.jsp?codigo=<%= codigo%>&titulo=<%=titulo%>&autor=<%= autor%>&precio=<%=precio%>" >Editar</a>    
                                            <a class="btn btn-sm btn-danger disabled" href="s02?codigo=<%= codigo%>" >Eliminar</a>
                                            <a class="btn btn-sm btn-success disabled" href=<%= imagenURL%> target="blank_">Ir</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                                        
                        </div>
             
                    </div>     
                </div>
            </div>                                
                                
                                
        </main>
    </body>
</html>