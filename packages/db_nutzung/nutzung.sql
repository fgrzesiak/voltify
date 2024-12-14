-------------------------
-- Tabelle: FAHRZEUGHALTER
-------------------------
CREATE TABLE fahrzeughalter (
    halter_id        INT AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(255) NOT NULL,
    adresse          VARCHAR(255) NOT NULL,
    bankverbindung   VARCHAR(255) NOT NULL
    -- weitere Felder nach Bedarf
);

-------------------------
-- Tabelle: NUTZUNG
-------------------------
CREATE TABLE nutzung (
    nutzungs_id      INT AUTO_INCREMENT PRIMARY KEY,
    ladepunkt_id     INT NOT NULL,       -- Referenz auf Ladepunkt-ID aus anderem System
    datum            DATE NOT NULL,
    ladezeit_min     INT NOT NULL,
    ladeleistung_kwh DECIMAL(10,2) NOT NULL,
    halter_id        INT NOT NULL,
    FOREIGN KEY (halter_id) REFERENCES fahrzeughalter(halter_id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);