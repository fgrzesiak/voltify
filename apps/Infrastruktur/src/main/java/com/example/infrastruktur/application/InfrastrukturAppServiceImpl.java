package com.example.infrastruktur.application;

import com.example.infrastruktur.application.domain.*;
import com.example.infrastruktur.application.dto.AdresseDto;
import com.example.infrastruktur.application.dto.AnsprechpartnerDto;
import com.example.infrastruktur.application.dto.EigentuemerRequest;
import com.example.infrastruktur.application.dto.EigentuemerResponse;
import com.example.infrastruktur.application.dto.LadepunktRequest;
import com.example.infrastruktur.application.dto.LadepunktResponse;
import com.example.infrastruktur.application.port.secondary.LadepunktRepository;
import com.example.infrastruktur.application.port.secondary.GrundstueckseigentuemerRepository;
import com.example.infrastruktur.application.port.primary.InfrastrukturAppService;

import java.util.List;
import java.util.stream.Collectors;

public class InfrastrukturAppServiceImpl implements InfrastrukturAppService {

        private final LadepunktRepository ladepunktRepository;
        private final GrundstueckseigentuemerRepository eigentuemerRepository;
        private final LadepunktDomainService ladepunktDomainService;

        // Konstruktor (jetzt mit ladepunktDomainService)
        public InfrastrukturAppServiceImpl(
                        LadepunktRepository ladepunktRepository,
                        GrundstueckseigentuemerRepository eigentuemerRepository,
                        LadepunktDomainService ladepunktDomainService) {
                this.ladepunktRepository = ladepunktRepository;
                this.eigentuemerRepository = eigentuemerRepository;
                this.ladepunktDomainService = ladepunktDomainService;
        }

        // ------------------------------------------------------
        // Ladepunkt-Funktionen
        // ------------------------------------------------------

        @Override
        public Integer ladepunktAnlegen(LadepunktRequest ladepunkt) {
                Ladepunkt neuerLadepunkt = new Ladepunkt(
                                new LadepunktId(),
                                new EigentuemerId(ladepunkt.getEigentuemerId()),
                                new Adresse(ladepunkt.getAdresse().getStrasse(),
                                                ladepunkt.getAdresse().getHausnummer(),
                                                ladepunkt.getAdresse().getPlz(),
                                                ladepunkt.getAdresse().getOrt()),
                                ladepunkt.getLadeleistungKW(),
                                ladepunkt.getAnschlussart(),
                                ladepunkt.getVerfuegbarkeit(),
                                ladepunkt.getGesamtleistungKWH());
                ladepunktRepository.save(neuerLadepunkt);
                return neuerLadepunkt.getLadepunktId().getId();
        }

        @Override
        public LadepunktResponse ladepunktFinden(Integer ladepunktId) {
                Ladepunkt ladepunkt = ladepunktRepository.findById(new LadepunktId(ladepunktId));
                if (ladepunkt == null) {
                        return null;
                }
                return new LadepunktResponse(
                                ladepunkt.getLadepunktId().getId(),
                                ladepunkt.getEigentuemerId().getId(),
                                new AdresseDto(
                                                ladepunkt.getAdresse().getStrasse(),
                                                ladepunkt.getAdresse().getHausnummer(),
                                                ladepunkt.getAdresse().getPlz(),
                                                ladepunkt.getAdresse().getOrt()),
                                ladepunkt.getLadeleistungKW(),
                                ladepunkt.getAnschlussart(),
                                ladepunkt.getVerfuegbarkeit(),
                                ladepunkt.getGesamtleistungKWH());
        }

        @Override
        public boolean ladepunktAktualisieren(Integer ladepunktId, LadepunktRequest neueDaten) {
                Ladepunkt ladepunktAlt = ladepunktRepository.findById(new LadepunktId(ladepunktId));
                if (ladepunktAlt == null) {
                        return false;
                }
                ladepunktAlt.setEigentuemerId(new EigentuemerId(neueDaten.getEigentuemerId()));
                ladepunktAlt.setAdresse(new Adresse(
                                neueDaten.getAdresse().getStrasse(),
                                neueDaten.getAdresse().getHausnummer(),
                                neueDaten.getAdresse().getPlz(),
                                neueDaten.getAdresse().getOrt()));
                ladepunktAlt.setLadeleistungKW(neueDaten.getLadeleistungKW());
                ladepunktAlt.setAnschlussart(neueDaten.getAnschlussart());
                ladepunktAlt.setVerfuegbarkeit(neueDaten.getVerfuegbarkeit());
                ladepunktAlt.setGesamtleistungKWH(neueDaten.getGesamtleistungKWH());
                ladepunktRepository.save(ladepunktAlt);
                return true;
        }

        @Override
        public boolean ladepunktLoeschen(Integer ladepunktId) {
                Ladepunkt lp = ladepunktRepository.findById(new LadepunktId(ladepunktId));
                if (lp == null) {
                        return false;
                }
                ladepunktRepository.delete(lp.getLadepunktId());
                return true;
        }

        @Override
        public List<LadepunktResponse> alleLadepunkteAnzeigen() {
                List<Ladepunkt> ladepunkte = ladepunktRepository.findAll();
                return ladepunkte
                                .stream()
                                .map(ladepunkt -> new LadepunktResponse(
                                                ladepunkt.getLadepunktId().getId(),
                                                ladepunkt.getEigentuemerId().getId(),
                                                new AdresseDto(
                                                                ladepunkt.getAdresse().getStrasse(),
                                                                ladepunkt.getAdresse().getHausnummer(),
                                                                ladepunkt.getAdresse().getPlz(),
                                                                ladepunkt.getAdresse().getOrt()),
                                                ladepunkt.getLadeleistungKW(),
                                                ladepunkt.getAnschlussart(),
                                                ladepunkt.getVerfuegbarkeit(),
                                                ladepunkt.getGesamtleistungKWH()))
                                .collect(Collectors.toList());
        }

        /**
         * NEU: Beispielmethode, die einen Ladevorgang verbucht.
         * Ruft den Domain Service auf, der dann Events etc. publiziert.
         */
        public boolean ladevorgangVerbuchen(LadepunktId ladepunktId, double geladeneKWh) {
                Ladepunkt lp = ladepunktRepository.findById(ladepunktId);
                if (lp == null) {
                        return false;
                }
                // Fachlogik über DomainService aufrufen
                ladepunktDomainService.verarbeiteLadevorgang(lp, geladeneKWh);
                // geänderten Ladepunkt speichern
                ladepunktRepository.save(lp);
                return true;
        }

        // ------------------------------------------------------
        // Eigentümer-Funktionen
        // ------------------------------------------------------

        @Override
        public Integer eigentuemerAnlegen(EigentuemerRequest eigentuemer) {
                Grundstueckseigentuemer neu = new Grundstueckseigentuemer(
                                new GrundstueckseigentuemerId(),
                                eigentuemer.getName(),
                                new Adresse(eigentuemer.getAdresse().getStrasse(),
                                                eigentuemer.getAdresse().getHausnummer(),
                                                eigentuemer.getAdresse().getPlz(),
                                                eigentuemer.getAdresse().getOrt()));
                eigentuemerRepository.save(neu);
                return neu.getEigentuemerId().getId();
        }

        @Override
        public EigentuemerResponse eigentuemerFinden(Integer eigentuemerId) {
                Grundstueckseigentuemer eigentuemer = eigentuemerRepository
                                .findById(new GrundstueckseigentuemerId(eigentuemerId));
                if (eigentuemer == null) {
                        return null;
                }
                return new EigentuemerResponse(
                                eigentuemer.getEigentuemerId().getId(),
                                eigentuemer.getName(),
                                new AdresseDto(
                                                eigentuemer.getAdresse().getStrasse(),
                                                eigentuemer.getAdresse().getHausnummer(),
                                                eigentuemer.getAdresse().getPlz(),
                                                eigentuemer.getAdresse().getOrt()),
                                eigentuemer.getAnsprechpartner()
                                                .stream()
                                                .map((ap) -> new AnsprechpartnerDto(
                                                                ap.getName(),
                                                                new AdresseDto(
                                                                                ap.getAdresse().getStrasse(),
                                                                                ap.getAdresse().getHausnummer(),
                                                                                ap.getAdresse().getPlz(),
                                                                                ap.getAdresse().getOrt()),
                                                                ap.getTelefon(),
                                                                ap.getEmail()))
                                                .collect(Collectors.toList()));
        }

        @Override
        public boolean eigentuemerAktualisieren(Integer eigentuemerId, EigentuemerRequest neueDaten) {
                Grundstueckseigentuemer alt = eigentuemerRepository
                                .findById(new GrundstueckseigentuemerId(eigentuemerId));
                if (alt == null) {
                        return false;
                }
                alt.setName(neueDaten.getName());
                alt.setAdresse(new Adresse(neueDaten.getAdresse().getStrasse(),
                                neueDaten.getAdresse().getHausnummer(),
                                neueDaten.getAdresse().getPlz(),
                                neueDaten.getAdresse().getOrt()));
                alt.setAnsprechpartner(neueDaten.getAnsprechpartner()
                                .stream()
                                .map(ap -> new Ansprechpartner(
                                                ap.getName(),
                                                new Adresse(
                                                                ap.getAdresse().getStrasse(),
                                                                ap.getAdresse().getHausnummer(),
                                                                ap.getAdresse().getPlz(),
                                                                ap.getAdresse().getOrt()),
                                                ap.getTelefon(),
                                                ap.getEmail()))
                                .collect(Collectors.toList()));
                eigentuemerRepository.save(alt);
                return true;
        }

        @Override
        public boolean eigentuemerLoeschen(Integer eigentuemerId) {
                Grundstueckseigentuemer eig = eigentuemerRepository
                                .findById(new GrundstueckseigentuemerId(eigentuemerId));
                if (eig == null) {
                        return false;
                }
                eigentuemerRepository.delete(eig.getEigentuemerId());
                return true;
        }

        @Override
        public List<EigentuemerResponse> alleEigentuemerAnzeigen() {
                List<Grundstueckseigentuemer> eigentuemer = eigentuemerRepository.findAll();
                return eigentuemer
                                .stream()
                                .map(e -> new EigentuemerResponse(
                                                e.getEigentuemerId().getId(),
                                                e.getName(),
                                                new AdresseDto(
                                                                e.getAdresse().getStrasse(),
                                                                e.getAdresse().getHausnummer(),
                                                                e.getAdresse().getPlz(),
                                                                e.getAdresse().getOrt()),
                                                e.getAnsprechpartner()
                                                                .stream()
                                                                .map(ap -> new AnsprechpartnerDto(
                                                                                ap.getName(),
                                                                                new AdresseDto(
                                                                                                ap.getAdresse().getStrasse(),
                                                                                                ap.getAdresse().getHausnummer(),
                                                                                                ap.getAdresse().getPlz(),
                                                                                                ap.getAdresse().getOrt()),
                                                                                ap.getTelefon(),
                                                                                ap.getEmail()))
                                                                .collect(Collectors.toList())))
                                .collect(Collectors.toList());
        }
}
