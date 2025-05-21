<%-- 
    Document   : listaUsuarios
    Created on : 21/05/2025, 08:43:34
    Author     : Aline
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String username = (String) session.getAttribute("u");
    if (username == null) {
        response.sendRedirect("../index.jsp");
    } else {
        out.println("Bem vindo, " + username);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Usuários</title>
</head>
<body>
    <h1>Usuários Cadastrados</h1>
    <table>
        <tr>
            <th>ID</th><th>Nome</th><th>Email</th><th>Acesso</th><th>Ações</th>
        </tr>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.nome}</td>
                <td>${usuario.email}</td>
                <td>
                    <c:choose>
                        <c:when test="${usuario.nivelAcesso == 1}">Admin</c:when>
                        <c:otherwise>Usuário</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="../UsuarioController?action=alterar&id=${usuario.id}">Editar</a>
                    <a href="../UsuarioController?action=deletar&id=${usuario.id}" onclick="return confirm('Excluir?')">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <form action="../AuthController" method="get">
        <input type="hidden" name="acao" value="logoff" />
        <input type="submit" value="Sair" />
    </form>
</body>
</html>