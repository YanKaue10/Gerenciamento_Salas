CREATE TABLE sala (
    id          UUID         PRIMARY KEY,
    nome        VARCHAR(255) NOT NULL,
    capacidade  INTEGER      NOT NULL CHECK (capacidade >= 1),
    tipo_sala   VARCHAR(30)  NOT NULL CHECK (tipo_sala IN ('SALA_COMUM', 'LABORATORIO', 'AUDITORIO')),
    estado_sala VARCHAR(30)  NOT NULL DEFAULT 'DISPONIVEL'
                             CHECK (estado_sala IN ('DISPONIVEL', 'RESERVADA', 'EM_MANUTENCAO'))
);
