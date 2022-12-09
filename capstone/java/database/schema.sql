BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, available_properties;
DROP USER IF EXISTS final_capstone_owner, final_capstone_appuser;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE available_properties (
    property_id SERIAL,
    address varchar(100),
    property_image varchar(1000),
    has_image boolean,
    bathrooms int,
	bedrooms int,
	living_area int,
    price int,
	landlord_id int,
	is_available boolean
);

CREATE TABLE maintenance_requests(
	request_id SERIAL,
	renter_id int,
	property_id int,
	date date,
	description varchar(1000),
	maintenance_status_id int
);

COMMIT TRANSACTION;

