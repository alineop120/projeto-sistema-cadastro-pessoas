<%-- 
    Document   : view
    Created on : 21/05/2025, 08:26:45
    Author     : Aline
--%>

<%@pagecontentType = "text/html" pageEncoding = "UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPEhtml>
<html>
    <head>
        <title>Cadastro de Usua rios</title>
    </head>
    <body>
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
            <label>Ní vel de Acesso:</label>
            <select name="nivel">
                <option value="1">Comum</option>
                <option value="2"}>Admin</option>
            </select>
            <input type="submit" value="Cadastrar"/>
        </form>
    </body>
</html>