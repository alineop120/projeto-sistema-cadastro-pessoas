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
        return;
    }
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuários</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .table th, .table td {
            vertical-align: middle;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Cabeçalho -->
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>Usuários Cadastrados</h2>
            <div>
                <span class="me-3 text-muted">Bem-vindo, <strong><%= username %></strong></span>
                <form action="${pageContext.request.contextPath}/controller/AuthController" method="get" class="d-inline">
                    <input type="hidden" name="action" value="logoff" />
                    <button type="submit" class="btn btn-outline-danger btn-sm">Sair</button>
                </form>
            </div>
        </div>

        <!-- Tabela de usuários -->
        <table class="table table-bordered table-hover table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Acesso</th>
                    <th class="text-center">Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="u" items="${usuarios}">
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.nome}</td>
                        <td>${u.email}</td>
                        <td>
                            <c:choose>
                                <c:when test="${u.nivelAcesso == 1}">Admin</c:when>
                                <c:otherwise>Usuário</c:otherwise>
                            </c:choose>
                        </td>
                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/controller/UsuarioController?action=alterar&id=${u.id}" class="btn btn-sm btn-warning me-2">Editar</a>
                            <a href="${pageContext.request.contextPath}/controller/UsuarioController?action=deletar&id=${u.id}" 
                               class="btn btn-sm btn-danger"
                               onclick="return confirm('Tem certeza que deseja excluir?');">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Voltar para cadastro -->
        <div class="text-end mt-4">
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary">Novo Cadastro</a>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>