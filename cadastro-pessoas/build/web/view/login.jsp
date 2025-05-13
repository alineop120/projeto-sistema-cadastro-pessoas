<%-- 
    Document   : login
    Created on : 13/05/2025, 14:24:02
    Author     : 364975
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Formulário Login</h1>
        <form method="post" action="AuthController">
            <div class="mb-3">
            <label class="form-label">Usuário: </label>
            <input name="nome" class="form-control" type="text"/>
            </div>
            <div class="mb-3">
            <label class="form-label">Senha:</label>
            <input name="senha" class="form-control"
            type="password"/>
            </div>
            <input value="Logar" class="btn btn-primary" type="submit"/>
        </form>
        <a href="./index.jsp">Não possuo cadastro</a> 
    </body>
</html>
