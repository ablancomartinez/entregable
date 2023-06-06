/*poder*/
CREATE TABLE IF NOT EXISTS public.poder
(
    id_poder integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nombre text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT poder_pk PRIMARY KEY (id_poder)
)
/*universo*/
CREATE TABLE IF NOT EXISTS public.universo
(
    id_universo integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 0 MINVALUE 0 MAXVALUE 2147483647 CACHE 1 ),
    descripcion text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT universo_pkey PRIMARY KEY (id_universo)
)
/*superheroe*/
CREATE TABLE IF NOT EXISTS public.superheroe
(
    id_superheroe integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nombre text COLLATE pg_catalog."default" NOT NULL,
    estado text COLLATE pg_catalog."default" NOT NULL,
    id_universo integer,
    CONSTRAINT superheroe_pkey PRIMARY KEY (id_superheroe),
    CONSTRAINT pertenencia FOREIGN KEY (id_universo)
        REFERENCES public.universo (id_universo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
/*super_poder*/

CREATE TABLE IF NOT EXISTS public.super_poder
(
    id_superpoder integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    id_superheroe integer NOT NULL,
    id_poder integer NOT NULL,
    CONSTRAINT super_poder_pkey PRIMARY KEY (id_superpoder),
    CONSTRAINT super_poder_fk FOREIGN KEY (id_superheroe)
        REFERENCES public.superheroe (id_superheroe) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT super_poder_fk_1 FOREIGN KEY (id_poder)
        REFERENCES public.poder (id_poder) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

