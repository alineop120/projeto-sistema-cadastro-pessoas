<%-- 
    Document   : index
    Created on : 13/05/2025, 11:12:34
    Author     : Aline
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Usuário</title>

    <!-- Link para o CSS do Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Optional: Link para ícones do FontAwesome, caso queira usar ícones -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    
    <style>
        /* Adicionando um pouco de personalização */
        body {
            padding: 30px;
        }
        .form-container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .form-container h1 {
            text-align: center;
        }
        .form-container label {
            font-weight: bold;
        }
        .form-container input,
        .form-container select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .form-container input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .form-container a {
            text-decoration: none;
            color: #007bff;
            display: block;
            text-align: center;
        }
        .form-container a:hover {
            text-decoration: underline;
        }
        .login-btn {
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
        }
        .login-btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Cadastro de Usuário</h1>
        <!-- Formulário para cadastro e edição de usuários -->
        <form action="UsuarioController" method="post">
            <input type="hidden" name="id" value="${usuario.id != null ? usuario.id : 0}" />
            
            <label for="usuarioNome">Nome:</label>
            <input type="text" id="usuarioNome" name="usuarioNome" value="${usuario.nome != null ? usuario.nome : ''}" required/>
            
            <label for="usuarioEmail">Email:</label>
            <input type="email" id="usuarioEmail" name="usuarioEmail" value="${usuario.email != null ? usuario.email : ''}" required/>
            
            <label for="usuarioSenha">Senha:</label>
            <input type="password" id="usuarioSenha" name="usuarioSenha" value="${usuario.senha != null ? usuario.senha : ''}" required/>
            
            <label for="nivel">Nível de Acesso:</label>
            <select name="nivel" id="nivel" required>
                <option value="1" ${usuario.nivel == 1 ? "selected" : ""}>Admin</option>
                <option value="2" ${usuario.nivel == 2 ? "selected" : ""}>Usuário</option>
            </select>

            <input type="submit" value="Cadastrar"/>
        </form>
        <!-- Link para visualizar a lista de usuários -->
        <a href="./UsuarioController?action=listar">Listar Usuários</a>
        
        <!-- Botão de Login -->
        <form action="./login.jsp" method="get">
            <button type="submit" class="login-btn">Login</button>
        </form>
    </div>

    <!-- Link para o JS do Bootstrap (opcional para algumas funcionalidades) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
