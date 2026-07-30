CREATE TABLE produtos(
    id BIGSERIAL PRIMARY KEY,
    marca_id BIGINT NOT NULL REFERENCES marcas(id),
    codigo VARCHAR(50) NOT NULL UNIQUE,
    nome VARCHAR(150) NOT NULL,
    descricao TEXT,
    preco_custo NUMERIC(10, 2) NOT NULL CHECK (preco_custo >= 0),
    preco_venda NUMERIC(10, 2) NOT NULL CHECK (preco_venda >= 0),
    estoque INTEGER NOT NULL DEFAULT 0 CHECK (estoque >= 0),
    data_cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP
);
