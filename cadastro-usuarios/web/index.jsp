<%-- 
    Document   : view
    Created on : 21/05/2025, 08:26:45
    Author     : Aline
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Usuários</title>
</head>
<body>
    <h1>Cadastro de Usuário</h1>
    <form action="UsuarioController" method="post">
        <input type="hidden" name="id" value="${usuario.id != null ? usuario.id : 0}" />
        <label>Nome:</label>
        <input type="text" name="usuarioNome" value="${usuario.nome != null ? usuario.nome : ''}" />
        <label>Email:</label>
        <input type="email" name="usuarioEmail" value="${usuario.email != null ? usuario.email : ''}" />
        <label>Senha:</label>
        <input type="password" name="usuarioSenha" value="${usuario.senha != null ? usuario.senha : ''}" />
        <label>Nível de Acesso:</label>
        <select name="nivel">
            <option value="1">Admin</option>
            <option value="2">Usuário</option>
        </select>
        <input type="submit" value="Cadastrar" />
    </form>

    <a href="${pageContext.request.contextPath}/controller/UsuarioController?action=listar">Listar Usuários</a>
    <form action="view/login.jsp" method="get">
        <button type="submit">Login</button>
    </form>
</body>
</html>