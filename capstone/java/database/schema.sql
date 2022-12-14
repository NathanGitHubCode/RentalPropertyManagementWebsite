BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, available_properties, maintenance_requests;
DROP USER IF EXISTS final_capstone_owner, final_capstone_appuser;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS available_properties;
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
	is_available boolean,
	renter_id int,
	status varchar(15),
	balance int,
	due_date date
);

CREATE TABLE maintenance_requests(
	request_id SERIAL,
	renter_id int,
	property_id int,
	address varchar(100),
	date date,
	description varchar(1000),
	maintenance_status_id int,
	employee_id int,
	contact_phone varchar(15)
);



DROP TABLE IF EXISTS rent, maintenance_status_id;



COMMIT TRANSACTION;

-- ROLLBACK;


GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;


GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;

