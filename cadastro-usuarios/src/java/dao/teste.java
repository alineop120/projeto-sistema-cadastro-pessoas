package dao;

public class teste {

    public static void main(String[] args) {
        
        // Crie uma instância do UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        // Defina o email e senha para testar o login
        String email = "joao.silva@email.com";
        String senha = "senha1";
        
        // Imprimir as credenciais para depuração
        System.out.println("Tentando logar com:");
        System.out.println("Email: " + email);
        System.out.println("Senha: " + senha);
        
        // Teste a função de login
        boolean resultadoLogin = usuarioDAO.login(email, senha);
        
        // Exibir o resultado no terminal
        if (resultadoLogin) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Falha na autenticação!");
        }
    }
}

