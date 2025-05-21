package model;

/**
 *
 * @author Aline
 */
 public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private int nivelAcesso;
    
    public Usuario() {}
    
    public Usuario(int id, String nome, String email, String senha, int nivelAcesso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }
    
    @Override
        public String toString() {
            return "Usuario{" + 
                    "id= " + getId() + 
                    ", nome= " + getNome() + 
                    ", email= " + getEmail() + 
                    ", senha= " + getSenha() + 
                    ", nivelAcesso= " + getNivelAcesso() + 
                    '}';
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}