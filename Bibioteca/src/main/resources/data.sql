INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Publica Municipal Professor Geminiano Cardoso');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Municipal Professor Cial Brito');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca do Centro Cultural Anatolio Oliveira');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Ines Maroja');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Livro Livre');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Marcia Ruiz');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Pessoal Jailma Bulhoes');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Philadelphia');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Professor Osvaldo de Oliveira Serra');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Distrital Professora Sonia Regina Mossin Garcia');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Publica Infantil Monteiro Lobato');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Aguas Marinhas');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Tertuliana Gomes da Silva');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Zequiel Oliveira Machado');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Cinthia Mello Picanco');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Daniel Oliveira');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Sucursal Delfina Fonseca Lima');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Professora Raimunda Maria Barbosa Chimbinha');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Costa Norte');
INSERT INTO BIBLIOTECA(nome) VALUES('Biblioteca Professora Elvidia');

INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(1,'Travessa Marechal Deodoro da Fonseca', 00, 'Centro', 'Colares', 'PA');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(2,'Rua Getúlio Vargas',51, 'Centro','Nova Iguacu','RJ');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(3,'Rua Alcindo Bueno de Assis', 500, 'Araci','Sao Paulo','SP');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(4, 'Passeio Nossa Senhora da Guia',795,'Barreiro','Belem','PA');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(5, 'Rua dos Cabanos',61,'Marambaia','Belem','PA');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(6, 'Travessa 9 de Janeiro',2698,'Cremacao','Belem','PA');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(7, 'Rua dos Pariquis',2843,'Cremacao','Belem','PA');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(8, 'Rua 8 de maio',523,'Icoaraci','Belem','PA');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(9, 'Travessa Quintino Bocaiuva',1808,'Nazare','Belem','PA');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(10, 'Rua Tenente Isaias',872,'Centro do Distrito De Cruz das Posses','Sertãozinho','SP');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(11, 'Rua Albano de Almeida Lima',00,'Guanabara','Campinas','SP');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(12, 'Mayrink Veiga',28,'Centro','Rio de Janeiro','RJ');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(13, 'Rua Jose Jo de Souza',581,'Centro','Pedra Branca','PB');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(14, 'Rua Padre Amancio Leite',00,'Centro','Condado','PB');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(15, 'Avenida Pedro Miranda',792,'Campina','Belem','PA');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(16, 'Vila Esteves Cortez',26,'Fundos','Nazare','PA');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(17, 'Rua Marilia',631,'Benfica','Juiz de Fora', 'MG');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(18, 'Rua Manoel Lopes',00,'Centro','Itaja','RN');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(19, 'Praça João Eduardo de Moraes',00,'Enseada','Sao Sebastiao','SP');
INSERT INTO ENDERECO(biblioteca_id, rua, numero, bairro, cidade, estado) VALUES(20, 'Avenida Antonio Torquato',00,'Centro','Ouvidor','GO');


INSERT INTO LIVRO(biblioteca_id, nome, categoria, autor, editora, lancamento, status_livro) VALUES(1,'O Senhor dos Aneis', 'AVENTURA', 'J R R Tolkien', 'Allen & Unwin', '1954-07-29', 'DISPONIVEL'	);

INSERT INTO REGISTRO(data_locacao, data_vencimento, status_registro, biblioteca_id, id_usuario, multa_gerada) VALUES('2022-02-14', '2022-02-18', 'FINALIZADO', 1, 1,0);
INSERT INTO REGISTRO(data_locacao, data_vencimento, status_registro, biblioteca_id, id_usuario, multa_gerada) VALUES('2022-02-14', '2022-02-26', 'EM_ANDAMENTO', 1, 2,0);

INSERT INTO PERFIL (nome) VALUES ('ROLE_USUARIO');
INSERT INTO USER(email, senha) VALUES('user@email.com', '$2a$10$fCgVs3Asfej.65RIsBmQ6.9eFUIKqBAOz/rkjAZleVgzp2bIViIum');
INSERT INTO USER_PERFIS (user_id, perfis_id) VALUES (1,1);

INSERT INTO PERFIL (nome) VALUES ('ROLE_BIBLIOTECA');
INSERT INTO USER(email, senha) VALUES('biblioteca@email.com', '$2a$10$fCgVs3Asfej.65RIsBmQ6.9eFUIKqBAOz/rkjAZleVgzp2bIViIum');
INSERT INTO USER_PERFIS (user_id, perfis_id) VALUES (2,2);

