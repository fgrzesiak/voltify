-------------------------
-- Tabelle: GRUNDSTUECKSEIGENTUEMER
-------------------------
CREATE TABLE grundstueckseigentuemer (
    eigentuemer_id        INT AUTO_INCREMENT PRIMARY KEY,
    name                  VARCHAR(255) NOT NULL,
    firmenadresse         VARCHAR(255) NOT NULL
);

-------------------------
-- Tabelle: ANSPRECHPARTNER
-------------------------
-- Um mehrere Ansprechpartner pro Eigentümer zu verwalten, 
-- legen wir eine eigene Tabelle an und verknüpfen sie über eigentuemer_id.
-------------------------
CREATE TABLE ansprechpartner (
    ansprechpartner_id    INT AUTO_INCREMENT PRIMARY KEY,
    eigentuemer_id        INT NOT NULL,
    name                  VARCHAR(255) NOT NULL,
    adresse               VARCHAR(255),
    telefon               VARCHAR(50),
    email                 VARCHAR(255),
    FOREIGN KEY (eigentuemer_id) REFERENCES grundstueckseigentuemer(eigentuemer_id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

-------------------------
-- Tabelle: LADEPUNKT
-------------------------
CREATE TABLE ladepunkt (
    ladepunkt_id          INT AUTO_INCREMENT PRIMARY KEY,
    standort_adresse      VARCHAR(255) NOT NULL,
    eigentuemer_id        INT,  -- optionaler FK, falls Ladepunkt einem Eigentümer zugeordnet ist
    ladeleistung_kw       DECIMAL(5,2) NOT NULL,       -- z.B. 22.00
    anschlussart          VARCHAR(50) NOT NULL,         -- z.B. "Typ 2", "CCS", ...
    verfuegbarkeit        VARCHAR(50) NOT NULL,         -- z.B. "verfügbar", "in Wartung"
    gesamtleistung_kwh    DECIMAL(10,2) DEFAULT 0.0,
    FOREIGN KEY (eigentuemer_id) REFERENCES grundstueckseigentuemer(eigentuemer_id)
      ON DELETE SET NULL
      ON UPDATE CASCADE
);