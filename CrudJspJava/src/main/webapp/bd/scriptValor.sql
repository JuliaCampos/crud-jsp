--Criação do sql do sistema de estacionamento
--Autor: Julia Madalena Miranda Campos
--data: 06/11/2021

-- seleciona a base de dados de estacionamento
use estacionamento;

--criação da tabela de valor
create  table tbl_valor(
	id integer not null primary key AUTO_INCREMENT,
	valor_primeira_hora DOUBLE,
	valor_demais_horas DOUBLE,
	data_fim DATE	
);
