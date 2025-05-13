CREATE DATABASE cadastrosbd;
USE cadastrosbd;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    nivelAcesso INT NOT NULL
);

INSERT INTO usuarios (nome, email, senha, nivelAcesso) VALUES
	('João da Silva', 'joao.silva@email.com', 'senha1', 1),
	('Maria Oliveira', 'maria.oliveira@email.com', 'senha2', 2),
	('Carlos Souza', 'carlos.souza@email.com', 'senha3', 1),
	('Ana Pereira', 'ana.pereira@email.com', 'senha4', 2);

select * from usuarios;

-- DROP DATABASE cadastrosbd;


