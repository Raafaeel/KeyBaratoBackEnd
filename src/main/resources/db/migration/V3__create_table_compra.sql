CREATE TABLE `compra` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `data` datetime(6) NOT NULL,
 `jogo_id` bigint NOT NULL,
 `usuario_cpf` bigint NOT NULL,
 FOREIGN KEY (`jogo_id`) REFERENCES `jogo` (`id`),
 FOREIGN KEY (`usuario_cpf`) REFERENCES `usuario` (`cpf`)
);