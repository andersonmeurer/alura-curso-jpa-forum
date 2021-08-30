CREATE TABLE usuario (
	id int not null,
	nome varchar not null,
	email varchar not null,
	senha varchar not null
);

CREATE TABLE curso (
	id int not null,
	nome varchar not null,
	categoria varchar not null
);

CREATE TABLE topico (
	id int not null,
	titulo varchar not null,
	mensagem varchar not null,
	data_criacao timestamp not null,
	status varchar not null,
	autor_id int not null,
	curso_id int not null
);

ALTER TABLE curso ADD CONSTRAINT curso_pk PRIMARY KEY (id);
ALTER TABLE topico ADD CONSTRAINT topico_pk PRIMARY KEY (id);
ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY (id);

INSERT INTO USUARIO(id, nome, email, senha) VALUES(1, 'Usuario', 'usuario@email.com', '123456');

INSERT INTO CURSO(id, nome, categoria) VALUES(1, 'Spring Boot', 'Programação');
INSERT INTO CURSO(id, nome, categoria) VALUES(2, 'HTML 5', 'Front-end');

INSERT INTO TOPICO(id, titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES(1, 'Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(id, titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES(2, 'Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(id, titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES(3, 'Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);