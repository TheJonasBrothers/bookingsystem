# Softwarekravspecifikation – Book a Room bookingsystem

## 1. Introduktion

### 1.1 Formål

Formålet med dette dokument er at beskrive kravene til et nyt bookingsystem for hotelkæden “Book a Room”. Systemet skal gøre det nemt for brugere at søge efter, booke og administrere hotelværelser samt give administratorer mulighed for at vedligeholde systemets data.

### 1.2 Systemoversigt

Systemet skal fungere som en webbaseret platform, hvor brugere kan:

* Søge efter ledige værelser
* Oprette og annullere bookinger
* Se tidligere og kommende bookinger
* Modtage bookingbekræftelser via e-mail

Administratorer og superbrugere skal kunne administrere:

* Brugere
* Værelser
* Rabattilbud og værdikuponer
* Bookinger

---

# 2. Funktionelle krav

## 2.1 Brugerfunktioner

### 2.1.1 Søgning efter værelser

Systemet skal gøre det muligt for brugeren at søge efter ledige værelser baseret på:

* Pris
* Dato
* Værelsestype
* Antal personer
* Kun voksne

### 2.1.2 Filtrering

Systemet skal understøtte filtrering af søgeresultater, så brugeren hurtigt kan finde relevante værelser.

### 2.1.3 Booking af værelser

Brugeren skal kunne:

* Booke et ledigt værelse
* Modtage en bookingbekræftelse via e-mail
* Se detaljer om bookingen

### 2.1.4 Annullering af booking

Brugeren skal kunne annullere egne bookinger.

### 2.1.5 Oversigt over bookinger

Brugeren skal kunne se:

* Kommende bookinger
* Tidligere bookinger
* Annullerede bookinger

---

# 3. Administrative funktioner

## 3.1 Administration af brugere

En administrator eller superuser skal kunne:

* Se alle brugere
* Se alle bookinger

## 3.2 Administration af værelser

En superuser skal kunne:

* Oprette værelser
* Redigere værelser
* Opdatere oplysninger om værelser
* Slette værelser

## 3.3 Administration af tilbud

En superuser skal kunne:

* Oprette rabattilbud
* Oprette værdikuponer
* Aktivere og deaktivere tilbud

---

# 4. Ikke-funktionelle krav

## 4.1 Brugervenlighed

Systemet skal:

* Være nemt at bruge
* Have et overskueligt design
* Understøtte hurtig navigation

## 4.2 Performance

Systemet skal:

* Svare hurtigt på brugerforespørgsler
* Minimere ventetid ved søgning og booking

## 4.3 Datasikkerhed

Systemet skal implementere:

* Authentication (brugergodkendelse)
* Authorization (rolle- og rettighedsstyring)

Kun autoriserede brugere må få adgang til administrative funktioner.

## 4.4 Dataintegritet

Systemet må ikke tillade:

* Dobbeltbooking af værelser
* Ugyldige bookingperioder

---

# 5. E-mailfunktionalitet

Systemet skal kunne sende:

* Bookingbekræftelser
* Annulleringsbekræftelser
* Nyhedsbreve (valgfrit for brugeren)

---

# 6. Roller og rettigheder

| Rolle     | Rettigheder                                         |
| --------- | --------------------------------------------------- |
| Bruger    | Søge, booke, annullere og se egne bookinger         |
| Admin     | Se alle brugere og bookinger                        |
| Superuser | Administrere værelser, tilbud, brugere og bookinger |

---

# 7. Teknologiske krav

Systemet skal:

* Være webbaseret
* Understøtte moderne browsere
* Kunne håndtere flere samtidige brugere

---

# 8. Fremtidige udvidelser

Mulige fremtidige funktioner:

* Integration med betalingsgateway
* Mobilapplikation
* Loyalitetsprogram
* Flersproget understøttelse
* Integration med eksterne bookingsider
