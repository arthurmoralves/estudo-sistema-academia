INSERT INTO ENDERECO_ENTITY(cep, logradouro, bairro, cidade, uf, numero, complemento) VALUES('38408090', 'Avenida dos Cabreiros', 'Santa Cecília', 'São Tomé das Letras', 'SP', 30, 'APT808');
INSERT INTO ENDERECO_ENTITY(cep, logradouro, bairro, cidade, uf, numero, complemento) VALUES('27333002', 'Avenida dos Romeiros', 'Ivo Olerio', 'Cuiauzinho', 'AC', 100, 'Casa dos Fundos');
INSERT INTO ENDERECO_ENTITY(cep, logradouro, bairro, cidade, uf, numero) VALUES('38408032', 'Rua Periópolis', 'Marta Helena', 'Divinópolis', 'RS', 2773);

INSERT INTO FUNCIONARIO_ENTITY(cpf, nome, data_nasc, cargo, data_contratacao, salario, endereco_id) VALUES(50810331039, 'Aderbal Vivela', parseDateTime('15-04-1993','dd-MM-yyyy'), 'Recepcionista', parseDateTime('15-08-1950','dd-MM-yyyy'), 3000.25, 1);
INSERT INTO FUNCIONARIO_ENTITY(cpf, nome, data_nasc, cargo, data_contratacao, salario, endereco_id) VALUES(34227256011, 'Luciene Junior', parseDateTime('21-10-1994','dd-MM-yyyy'), 'Treinador', parseDateTime('03-08-2022', 'dd-MM-yyyy'), 4300.20, 3);
INSERT INTO FUNCIONARIO_ENTITY(cpf, nome, data_nasc, cargo, data_contratacao, salario, endereco_id) VALUES(84077799031, 'Francisco Bariotto', parseDateTime('09-02-1979','dd-MM-yyyy'), 'Gerente', parseDateTime('31-07-2022', 'dd-MM-yyyy'), 7237.38, 2);