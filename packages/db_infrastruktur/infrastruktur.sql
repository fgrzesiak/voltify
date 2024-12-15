#-------------------------
#-- Tabelle: GRUNDSTUECKSEIGENTUEMER
#-------------------------
CREATE TABLE grundstueckseigentuemer_entity (
    eigentuemer_id        INT AUTO_INCREMENT PRIMARY KEY,
    name                  VARCHAR(255) NOT NULL,
    strasse               VARCHAR(255) NOT NULL,
    hausnummer            VARCHAR(10) NOT NULL,
    plz                   VARCHAR(10) NOT NULL,
    ort                   VARCHAR(255) NOT NULL
);

#-------------------------
#-- Tabelle: ANSPRECHPARTNER
#-------------------------
#-- Um mehrere Ansprechpartner pro Eigentümer zu verwalten, 
#-- legen wir eine eigene Tabelle an und verknüpfen sie über eigentuemer_id.
#-------------------------
CREATE TABLE ansprechpartner_entity (
    ansprechpartner_id    INT AUTO_INCREMENT PRIMARY KEY,
    eigentuemer_id        INT NOT NULL,
    name                  VARCHAR(255) NOT NULL,
    telefon               VARCHAR(50),
    email                 VARCHAR(255),
    strasse               VARCHAR(255) NOT NULL,
    hausnummer            VARCHAR(10) NOT NULL,
    plz                   VARCHAR(10) NOT NULL,
    ort                   VARCHAR(255) NOT NULL,
    FOREIGN KEY (eigentuemer_id) REFERENCES grundstueckseigentuemer_entity(eigentuemer_id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

#-------------------------
#-- Tabelle: LADEPUNKT
#-------------------------
CREATE TABLE ladepunkt_entity (
    ladepunkt_id          INT AUTO_INCREMENT PRIMARY KEY,
    eigentuemer_id        INT,  #-- optionaler FK, falls Ladepunkt einem Eigentümer zugeordnet ist
    ladeleistung_kw       DECIMAL(5,2) NOT NULL,       #-- z.B. 22.00
    anschlussart          VARCHAR(50) NOT NULL,         #-- z.B. "Typ 2", "CCS", ...
    verfuegbarkeit        VARCHAR(50) NOT NULL,         #-- z.B. "verfügbar", "in Wartung"
    gesamtleistung_kwh    DECIMAL(10,2) DEFAULT 0.0,
    strasse               VARCHAR(255) NOT NULL,
    hausnummer            VARCHAR(10) NOT NULL,
    plz                   VARCHAR(10) NOT NULL,
    ort                   VARCHAR(255) NOT NULL,
    FOREIGN KEY (eigentuemer_id) REFERENCES grundstueckseigentuemer_entity(eigentuemer_id)
      ON DELETE SET NULL
      ON UPDATE CASCADE
);