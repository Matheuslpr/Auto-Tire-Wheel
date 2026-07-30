CREATE TABLE itens_venda(
    id BIGSERIAL PRIMARY KEY,
    venda_id BIGINT NOT NULL REFERENCES vendas(id),
    tipo_item VARCHAR(10) NOT NULL,
    item_id BIGINT NOT NULL,
    quantidade INTEGER NOT NULL CHECK (quantidade > 0),
    preco_unitario NUMERIC(10, 2) NOT NULL CHECK (preco_unitario >= 0),
    subtotal NUMERIC(10, 2) NOT NULL CHECK (subtotal >= 0),
    CHECK (tipo_item IN ('PRODUTO', 'RODA', 'PNEU')),
    UNIQUE (venda_id, tipo_item, item_id)
);
