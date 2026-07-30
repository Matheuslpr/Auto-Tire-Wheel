CREATE TABLE rodas(
    id BIGSERIAL PRIMARY KEY,
    marca_id BIGINT NOT NULL REFERENCES marcas(id),
    codigo VARCHAR(50) NOT NULL UNIQUE,
    nome VARCHAR(150) NOT NULL,
    aro INTEGER NOT NULL CHECK (aro > 0),
    largura_polegadas NUMERIC(4, 2) NOT NULL CHECK (largura_polegadas > 0),
    furos INTEGER NOT NULL CHECK (furos > 0),
    diametro_furacao_mm NUMERIC(6, 2) NOT NULL CHECK (diametro_furacao_mm > 0),
    offset_et_mm INTEGER,
    material VARCHAR(20) NOT NULL,
    cor_acabamento VARCHAR(50),
    preco_custo NUMERIC(10, 2) NOT NULL CHECK (preco_custo >= 0),
    preco_venda NUMERIC(10, 2) NOT NULL CHECK (preco_venda >= 0),
    estoque INTEGER NOT NULL DEFAULT 0 CHECK (estoque >= 0),
    data_cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP,
    CHECK (material IN ('LIGA_LEVE', 'ACO'))
);
