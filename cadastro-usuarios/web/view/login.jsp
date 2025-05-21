<%-- 
    Document   : login
    Created on : 21/05/2025, 08:48:11
    Author     : Aline
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h1>Formulário Login</h1>

        <form method="post" action="${pageContext.request.contextPath}/AuthController">
            <label>Usuário (email):</label>
            <input name="email" type="text" /> <!-- Corrigido para email -->
            <label>Senha:</label>
            <input name="senha" type="password" />
            <input value="Logar" type="submit" />
        </form>

        <a href="${pageContext.request.contextPath}/index.jsp">Não possuo cadastro</a>

        <c:if test="${not empty param.erro}">
            <p style="color:red">${param.erro}</p>
        </c:if>
    </body>
</html>