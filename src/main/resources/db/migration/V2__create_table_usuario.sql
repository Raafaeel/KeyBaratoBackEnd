CREATE TABLE `usuario` (
 `cpf` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `regiao` varchar(255) DEFAULT NULL,
 `nome` varchar(255) NOT NULL,
 `telefone` varchar(255) DEFAULT NULL
);