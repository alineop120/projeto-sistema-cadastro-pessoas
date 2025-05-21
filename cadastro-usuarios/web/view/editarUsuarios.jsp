<%-- 
    Document   : editarUsuarios
    Created on : 21/05/2025, 11:10:07
    Author     : Aline
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Editar Usuário</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 600px;
            margin: 80px auto;
            background-color: white;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2 class="mb-4 text-center">Editar Usuário</h2>

        <form action="${pageContext.request.contextPath}/controller/UsuarioController" method="post">
            <input type="hidden" name="id" value="${usuario.id}" />

            <div class="mb-3">
                <label for="nome" class="form-label">Nome</label>
                <input type="text" id="nome" name="usuarioNome" class="form-control" value="${usuario.nome}" required />
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" id="email" name="usuarioEmail" class="form-control" value="${usuario.email}" required />
            </div>

            <div class="mb-3">
                <label for="senha" class="form-label">Senha</label>
                <input type="password" id="senha" name="usuarioSenha" class="form-control" value="${usuario.senha}" required />
            </div>

            <div class="mb-4">
                <label for="nivel" class="form-label">Nível de Acesso</label>
                <select id="nivel" name="nivel" class="form-select" required>
                    <option value="1" ${usuario.nivelAcesso == 1 ? "selected" : ""}>Admin</option>
                    <option value="2" ${usuario.nivelAcesso == 2 ? "selected" : ""}>Usuário</option>
                </select>
            </div>

            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-primary">Salvar Alterações</button>
                <a href="${pageContext.request.contextPath}/controller/UsuarioController?action=listar" class="btn btn-secondary">Cancelar</a>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>