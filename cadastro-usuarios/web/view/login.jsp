<%-- 
    Document   : login
    Created on : 21/05/2025, 08:48:11
    Author     : Aline
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f4f7fc;
        }
        .login-box {
            max-width: 400px;
            margin: 100px auto;
            padding: 2rem;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <div class="login-box">
        <h2 class="text-center mb-4">Login do Usuário</h2>

        <!-- Formulário de login -->
        <form method="post" action="${pageContext.request.contextPath}/controller/AuthController">
            <div class="mb-3">
                <label for="email" class="form-label">Usuário</label>
                <input id="email" name="email" type="text" class="form-control" required />
            </div>

            <div class="mb-3">
                <label for="senha" class="form-label">Senha</label>
                <input id="senha" name="senha" type="password" class="form-control" required />
            </div>

            <button type="submit" class="btn btn-primary w-100">Entrar</button>
        </form>

        <!-- Link para cadastro -->
        <div class="text-center mt-3">
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-outline-secondary w-100">Não possuo cadastro</a>
        </div>

        <!-- Exibição de erro -->
        <c:if test="${not empty param.erro}">
            <div class="alert alert-danger mt-3" role="alert">
                ${param.erro}
            </div>
        </c:if>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>