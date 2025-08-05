-- Table des donateurs
CREATE TABLE donor (
    id UUID PRIMARY KEY,
    email TEXT NOT NULL UNIQUE,
    full_name TEXT NOT NULL
);

-- Table des bénéficiaires
CREATE TABLE beneficiary (
    id UUID PRIMARY KEY,
    email TEXT NOT NULL UNIQUE,
    full_name TEXT NOT NULL
);

-- Table des paiements
CREATE TABLE payment (
    id UUID PRIMARY KEY,
    date DATE NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    method TEXT NOT NULL,
    status TEXT DEFAULT 'VERIFYING'
);

-- Table des dons
CREATE TABLE donation (
    id UUID PRIMARY KEY,
    donor_id UUID NOT NULL REFERENCES donor(id),
    payment_id UUID NOT NULL REFERENCES payment(id)
);

-- Table des aides
CREATE TABLE help (
    id UUID PRIMARY KEY,
    beneficiary_id UUID NOT NULL REFERENCES beneficiary(id),
    payment_id UUID NOT NULL REFERENCES payment(id),
    description TEXT NOT NULL
);
