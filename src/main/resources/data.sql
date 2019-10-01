-- users SENHA admin
INSERT INTO usuario (id, nome, email, senha) values (1, 'Administrador', 'admin@admin.com', '$2a$10$3y4RPg/.MZOCz9bsKoHtbOWmBlg4L43rLyU1ee/r0UeOg0Sa5SvzO');
INSERT INTO usuario (id, nome, email, senha) values (2, 'Usuario', 'usuario@usuario.com', '$2a$10$3y4RPg/.MZOCz9bsKoHtbOWmBlg4L43rLyU1ee/r0UeOg0Sa5SvzO');

-- roles
INSERT INTO permissao (id, descricao) values (1, 'ROLE_INCLUIR_LIVRO');
INSERT INTO permissao (id, descricao) values (2, 'ROLE_ALTERAR_LIVRO');
INSERT INTO permissao (id, descricao) values (3, 'ROLE_EXCLUIR_LIVRO');
INSERT INTO permissao (id, descricao) values (4, 'ROLE_PESQUISAR_POR_ID_LIVRO');
INSERT INTO permissao (id, descricao) values (5, 'ROLE_LISTAR_LIVRO');

INSERT INTO permissao (id, descricao) values (6, 'ROLE_INCLUIR_GENERO');
INSERT INTO permissao (id, descricao) values (7, 'ROLE_ALTERAR_GENERO');
INSERT INTO permissao (id, descricao) values (8, 'ROLE_EXCLUIR_GENERO');
INSERT INTO permissao (id, descricao) values (9, 'ROLE_PESQUISAR_POR_ID_GENERO');
INSERT INTO permissao (id, descricao) values (10, 'ROLE_LISTAR_GENERO');

INSERT INTO permissao (id, descricao) values (11, 'ROLE_INCLUIR_AUTOR');
INSERT INTO permissao (id, descricao) values (12, 'ROLE_ALTERAR_AUTOR');
INSERT INTO permissao (id, descricao) values (13, 'ROLE_EXCLUIR_AUTOR');
INSERT INTO permissao (id, descricao) values (14, 'ROLE_PESQUISAR_POR_ID_AUTOR');
INSERT INTO permissao (id, descricao) values (15, 'ROLE_LISTAR_AUTOR');

INSERT INTO permissao (id, descricao) values (16, 'ROLE_INCLUIR_CLIENTE');
INSERT INTO permissao (id, descricao) values (17, 'ROLE_ALTERAR_CLIENTE');
INSERT INTO permissao (id, descricao) values (18, 'ROLE_EXCLUIR_CLIENTE');
INSERT INTO permissao (id, descricao) values (19, 'ROLE_PESQUISAR_POR_ID_CLIENTE');
INSERT INTO permissao (id, descricao) values (20, 'ROLE_LISTAR_CLIENTE');

INSERT INTO permissao (id, descricao) values (21, 'ROLE_INCLUIR_EDITORA');
INSERT INTO permissao (id, descricao) values (22, 'ROLE_ALTERAR_EDITORA');
INSERT INTO permissao (id, descricao) values (23, 'ROLE_EXCLUIR_EDITORA');
INSERT INTO permissao (id, descricao) values (24, 'ROLE_PESQUISAR_POR_ID_EDITORA');
INSERT INTO permissao (id, descricao) values (25, 'ROLE_LISTAR_EDITORA');

INSERT INTO permissao (id, descricao) values (26, 'ROLE_INCLUIR_EMPRESTIMO');
INSERT INTO permissao (id, descricao) values (27, 'ROLE_ALTERAR_EMPRESTIMO');
INSERT INTO permissao (id, descricao) values (28, 'ROLE_EXCLUIR_EMPRESTIMO');
INSERT INTO permissao (id, descricao) values (29, 'ROLE_PESQUISAR_POR_ID_EMPRESTIMO');
INSERT INTO permissao (id, descricao) values (30, 'ROLE_LISTAR_EMPRESTIMO');

INSERT INTO permissao (id, descricao) values (31, 'ROLE_INCLUIR_ENDERECO');
INSERT INTO permissao (id, descricao) values (32, 'ROLE_ALTERAR_ENDERECO');
INSERT INTO permissao (id, descricao) values (33, 'ROLE_EXCLUIR_ENDERECO');
INSERT INTO permissao (id, descricao) values (34, 'ROLE_PESQUISAR_POR_ID_ENDERECO');
INSERT INTO permissao (id, descricao) values (35, 'ROLE_LISTAR_ENDERECO');

-- ADMIN
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,1);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,3);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,4);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,5);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,6);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,7);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,8);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,9);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,10);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,11);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,12);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,13);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,14);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,15);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,16);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,17);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,18);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,19);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,20);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,21);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,22);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,23);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,24);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,25);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,26);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,27);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,28);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,29);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,30);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,31);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,32);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,33);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,34);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,35);


-- Usuario
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2,9);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2,10);
