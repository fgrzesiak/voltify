# Fallbeispiel: "Managementsystem für Ladeinfrastruktur" (Gruppe 1)

Das Unternehmen „LadenLeichtGemacht“ betreibt verschiedene Ladepunkte. Das Unternehmen braucht eine Anwendung für die Verwaltung der Ladepunkte und die Abwicklung der Ladevorgänge.

## Anforderungen

### Verwaltung der Ladepunkte

- **Als Betreiber von Ladeinfrastruktur** möchte ich Ladepunkte verwalten, um sicherzustellen, dass die Ladeeinrichtungen immer verfügbar und funktionstüchtig sind.
  - Das System soll folgende Informationen zu einem Ladepunkt verwalten:
    - Ladepunkt-ID
    - Standort (Adresse)
    - Grundstückeigentümer
    - Ladeleistung (z.B. 22 kW, 50 kW)
    - Anschlussart (Typ 2, CCS)
    - Verfügbarkeit (verfügbar, in Wartung)
    - Gesamtladeleistung seit Installation

### Verwaltung der Grundstückeigentümer

- **Als Anlagenbetreiber** möchte ich die Daten zu Grundstückeigentümern verwalten, um zu wissen, wen ich ggf. ansprechen kann.
  - Das System soll folgende Informationen zu einem Grundstückeigentümer verwalten:
    - Eigentümer-ID
    - Name
    - Firmenadresse
    - Liste von Ansprechpartnern (mit Name, Adresse, üblichen Kontaktdaten)

### Verwaltung der Nutzung der Ladepunkte

- **Als Betreiber von Ladeinfrastruktur** möchte ich die Nutzung der Ladepunkte verwalten, um eine Grundlage für die Abrechnung von Nutzungen der Ladepunkte zu haben und die Nutzung zu bewerten.
  - Das System soll folgende Informationen zu einer Nutzung eines Ladepunkts verwalten:
    - Ladepunkt-ID
    - Datum
    - Ladezeit (in Minuten)
    - Ladeleistung (kWh)
    - Fahrzeughalter

### Verwaltung der Fahrzeughalter

- **Als Anlagenbetreiber** möchte ich die Daten zu Fahrzeughaltern verwalten, um Nutzung der Ladepunkte mit den Kunden abrechnen zu können.
  - Das System soll folgende Informationen zu einem Fahrzeughalter verwalten:
    - Name
    - Adresse
    - Bankverbindung

### Einsicht in die Ladehistorie

- **Als Anlagenbetreiber** möchte ich die Ladehistorie eines Kunden einsehen, um eine Grundlage für mein Kundenmanagement zu haben.

# Befehle zum Ausführen der Anwendung

Einfacher Start: `docker compose up -d`
Datenbankschema initialisieren: `docker compose down -v` und `docker compose up -d`
Docker neuer Build: `docker compose build --no-cache`
Docker Recreate: `docker compose up -d --force-recreate`
