CREATE TABLE `usuario` (
 `cpf` bigint NOT NULL PRIMARY KEY,
 `regiao` varchar(255) DEFAULT NULL,
 `nome` varchar(255) NOT NULL,
 `telefone` varchar(255) DEFAULT NULL,
 `email` varchar(255) NOT NULL UNIQUE ,
 `senha` varchar(255) NOT NULL,
 `role` varchar(10) DEFAULT "USER"

);