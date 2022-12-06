BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, properties;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE properties (
    property_id SERIAL,
    name varchar(50),
    landlord_id int,
    address varchar(100),
    description varchar(500),
    price decimal(13, 2),
    isAvailable boolean,
    renter_id int
);

COMMIT TRANSACTION;
