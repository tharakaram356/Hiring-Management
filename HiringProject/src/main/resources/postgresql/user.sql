CREATE SEQUENCE user_sequence

CREATE TABLE IF NOT EXISTS public."user_info"
(
    id integer NOT NULL DEFAULT nextval('user_sequence'::regclass),
    user_name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    email_id character varying(255) NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT user_name_unique_index UNIQUE (user_name),
    CONSTRAINT email_id_unique_index UNIQUE (email_id)
)

INSERT INTO "user_info"(ID, USER_NAME, PASSWORD,first_name,last_name,email_id)
  VALUES (1, 'superadmin@demo.com', /*admin*/'$2a$08$WhflkbQx9CwspjvWr2gGu.Mc9zGUshO5u70R.b2rCvjc91DS2ABbK', 
		  'Super', 'Admin','ctharakaramudu356@gmail.com');
