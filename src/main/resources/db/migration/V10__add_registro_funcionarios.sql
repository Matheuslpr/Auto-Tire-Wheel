ALTER TABLE funcionarios ADD COLUMN registro VARCHAR(20);
ALTER TABLE funcionarios ADD CONSTRAINT uk_funcionarios_registro UNIQUE (registro);