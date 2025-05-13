<%-- 
    Document   : listaUsuarios
    Created on : 13/05/2025, 11:14:23
    Author     : Aline
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Usuários</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body class="container mt-4">
        <h1>Usuários Cadastrados</h1>

        <c:if test="${empty usuarios}">
            <p class="alert alert-warning">Nenhum usuário cadastrado.</p>
        </c:if>

        <c:if test="${not empty usuarios}">
            <table class="table table-bordered table-striped">
                <thead class="table-primary">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Nível de Acesso</th>
                        <th colspan="2">Ações</th>
                    </tr>
                </thead>
                <tbody>
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
                                <button class="btn btn-warning" onclick="alterarUsuario(${usuario.id})">
                                    Editar
                                </button>
                            </td>
                            <td>
                                <button class="btn btn-danger" onclick="deletarUsuario(${usuario.id})">
                                    Excluir
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <script type="text/javascript">
            function deletarUsuario(id) {
                if (confirm("Deseja excluir o Usuário de ID: " + id + "?")) {
                    window.location.href = "UsuarioController?action=deletar&id=" + id;
                }
            }

            function alterarUsuario(id) {
                window.location.href = "UsuarioController?action=alterar&id=" + id;
            }
        </script>
    </body>
</html>
