BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO properties(property_id, name, landlord_id, address, description, price, is_available, renter_id) VALUES (1, 'me', 3, '212', 'descript', 200.0, false, 20);

COMMIT TRANSACTION;

SELECT * FROM properties;
