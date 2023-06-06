/*universo*/
INSERT INTO public.universo(
	 descripcion)
	VALUES ("marvel");
	INSERT INTO public.universo(
	 descripcion)
	VALUES ("DC");

/* superheroes*/
INSERT INTO public.superheroe(
	 nombre, estado, id_universo)
	VALUES ( "iron man", "vivo", "1");
	INSERT INTO public.superheroe(
	 nombre, estado, id_universo)
	VALUES ( "batman", "vivo", "2");
	INSERT INTO public.superheroe(
	 nombre, estado, id_universo)
	VALUES ( "superman", "vivo", "2");
	
/*poderes*/
	INSERT INTO public.poder(
	 nombre)
	VALUES ( "volar");
	INSERT INTO public.poder(
	 nombre)
	VALUES ( "rayos laser");
	
/*super_poder*/
INSERT INTO public.super_poder(
	 id_superheroe, id_poder)
	VALUES ( ?, ?);	