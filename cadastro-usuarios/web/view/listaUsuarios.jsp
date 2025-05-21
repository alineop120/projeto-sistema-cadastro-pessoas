<%-- 
    Document   : listaUsuarios
    Created on : 21/05/2025, 08:43:34
    Author     : Aline
--%>

<%@pagecontentType = "text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPEhtml>
<html>
    <head>
        <title>Lista de Usua rios</title>
    </head>
    <body>
        <h1>Usua rios Cadastrados</h1>
        <table class="table table-primary">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Nivel Acesso</th>
                <th colspan="2">Aço es</th>
            </tr>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.email}</td>
                    <td>
                        <c:if test="${usuario.nivelAcesso==1}">
                            Admin
                        </c:if>
                        <c:if test="${usuario.nivelAcesso!=1}">
                            Usuario
                        </c:if>
                    </td>
                    <td><button class="btn btn-warning"
                                onclick="alterarUsuario(${usuario.id})">Editar</button></td>
                    <td><button class="btn btn-danger" onclick="deletarUsuario(${usuario.id})"><i
                                class="fa-solid fa-trash"></i> Excluir</button></td>
                </tr>
            </c:forEach>
        </table>
        <script type="text/javascript">
            function deletarUsuario(id) {
                let confirma =
                        window.confirm(
                                "Deseja excluir o Usuario de idº:" + id + "?");
                if (confirma) {
                    window.location.href =
                            "UsuarioController?action=deletar&id=" + id;
                }
            }
            function alterarUsuario(id) {
                window.location.href = "UsuarioController?action=alterar&id=" + id;
            }
        </script>
    </body>
</html>
