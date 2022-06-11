CREATE VIEW deporte_view AS
SELECT hora,count(hora) AS frecuencia FROM deporte GROUP BY (hora);

CREATE VIEW cancha_view AS
SELECT cancha,count(cancha) AS frecuencia FROM deporte GROUP BY (cancha);