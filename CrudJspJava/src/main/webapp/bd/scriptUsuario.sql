--Criação do sql de usuario do sistema de estacionamento
--Autor: Julia Madalena Miranda Campos
--data: 06/11/2021

-- seleciona a base de dados de estacionamento
use estacionamento;

--criação da tabela de usuario  
create table tbl_usuario(
	id integer not null primary key AUTO_INCREMENT,
	nome varchar(255),
	usuario varchar(255),
	senha varchar(255)
);