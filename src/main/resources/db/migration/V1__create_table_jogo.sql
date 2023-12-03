CREATE TABLE `jogo` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `regiao` varchar(2) NOT NULL,
 `chave` varchar(30) NOT NULL,
 `preco` double NOT NULL,
 `descricao` varchar(255) NOT NULL,
 `status` enum('PREVENDA',
                    'DISP',
                    'ESGOTADO') DEFAULT NULL
);