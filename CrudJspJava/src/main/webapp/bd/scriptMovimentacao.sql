--Criação do sql do sistema de estacionamento
--Autor: Julia Madalena Miranda Campos
--data: 06/11/2021

-- seleciona a base de dados de estacionamento
use estacionamento;

--criação da tabela de movimentação
create table tbl_movimentacao(
	id integer not null primary key auto_increment,
	placa varchar(30), 
	modelo varchar(255),
	data_entrada date,
	data_saida date,
	tempo time,
	valor_pago double
);