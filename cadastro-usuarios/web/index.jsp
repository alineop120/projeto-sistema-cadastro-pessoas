<%-- 
    Document   : index
    Created on : 21/05/2025, 08:26:45
    Author     : Aline
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Usuários</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5" style="max-width: 600px;">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 class="h3">Cadastro de Usuário</h1>
            <form action="${pageContext.request.contextPath}/view/login.jsp" method="get">
                <button type="submit" class="btn btn-outline-secondary">Login</button>
            </form>
        </div>

        <!-- Formulário de Cadastro ou Edição -->
        <form action="${pageContext.request.contextPath}/controller/UsuarioController" method="post">
            <input type="hidden" name="id" value="${usuario != null ? usuario.id : 0}" />

            <div class="mb-3">
                <label for="usuarioNome" class="form-label">Nome</label>
                <input type="text" id="usuarioNome" name="usuarioNome" class="form-control" value="${usuario != null ? usuario.nome : ''}" required />
            </div>

            <div class="mb-3">
                <label for="usuarioEmail" class="form-label">Email</label>
                <input type="email" id="usuarioEmail" name="usuarioEmail" class="form-control" value="${usuario != null ? usuario.email : ''}" required />
            </div>

            <div class="mb-3">
                <label for="usuarioSenha" class="form-label">Senha</label>
                <input type="password" id="usuarioSenha" name="usuarioSenha" class="form-control" value="${usuario != null ? usuario.senha : ''}" required />
            </div>

            <div class="mb-4">
                <label for="nivel" class="form-label">Nível de Acesso</label>
                <select id="nivel" name="nivel" class="form-select" required>
                    <option value="1" ${usuario != null && usuario.nivelAcesso == 1 ? "selected" : ""}>Admin</option>
                    <option value="2" ${usuario != null && usuario.nivelAcesso == 2 ? "selected" : ""}>Usuário</option>
                </select>
            </div>

            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-primary">Cadastrar ou Editar</button>
                <a href="${pageContext.request.contextPath}/controller/UsuarioController?action=listar" class="btn btn-secondary">Listar Usuários</a>
            </div>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
