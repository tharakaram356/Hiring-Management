
CREATE SEQUENCE applicant_sequence

CREATE TABLE IF NOT EXISTS public."applicants"(
    id integer NOT NULL DEFAULT nextval('applicant_sequence'::regclass),
    full_name character varying(255) NOT NULL,
    gender character varying(255) NOT NULL,
    mobile character varying(255) NOT NULL,
    current_location character varying(255) NOT NULL,
    higher_qualification character varying(255) NOT NULL,
    course character varying(255) NOT NULL,
    skills character varying(255) NOT NULL,
    passed_year character varying(255) NOT NULL,
    type_of_application character varying(255) NOT NULL,
    experience character varying(255) NOT NULL,
    address character varying(255) NOT NULL,
    resume  bo
)