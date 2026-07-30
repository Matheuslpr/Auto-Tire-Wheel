CREATE TABLE funcionarios(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    tipo_documento VARCHAR(4) NOT NULL,
    numero_documento VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(150),
    telefone VARCHAR(30),
    logradouro VARCHAR(150),
    numero VARCHAR(20),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(2),
    cep VARCHAR(20),
    cargo VARCHAR(100),
    salario NUMERIC(10, 2) CHECK (salario >= 0),
    data_admissao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_desligamento TIMESTAMP,
    CHECK (tipo_documento IN ('CPF', 'CNPJ'))
);
