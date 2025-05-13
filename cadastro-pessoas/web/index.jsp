<%-- 
    Document   : index
    Created on : 13/05/2025, 11:12:34
    Author     : Aline
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPEhtml>
 <html>
    <head>
        <title>Cadastro de Usuarios</title>
    </head>
    <body>
        <h1>Cadastro</h1>
        <!-- Formula rio para cadastro e ediça o de usua rios-->
        <form action="UsuarioController" method="post">
            <input type="hidden" name="id" value="${usuario.id !=null ? usuario.id : 0}" />
            <label>Nome:</label>
            <input type="text" name="usuarioNome" value="${usuario.nome !=null ?
            usuario.nome : ' ' }"/>
            
            <label>Email:</label>
            <input type="email" name="usuarioEmail" value="${usuario.email !=null ?
            usuario.email : ' ' }"/>
            
            <label>Senha:</label>
            <input type="password" name="usuarioSenha" value="${usuario.senha !=null ?
            usuario.senha : '' }" />
            
            <label>Nível de Acesso:</label>
            <select name="nivel">
                <option value="1" ${usuario.nivel == 1 ? "selected" : ""}>Admin</option>
                <option value="2" ${usuario.nivel == 2 ? "selected" : ""}>Comum</option>
            </select>

            <input type="submit" value="Cadastrar"/>
        </form>
    </body>
 </html>
