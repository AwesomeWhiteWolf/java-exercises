CREATE TABLE films (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL,
    country VARCHAR(255) NOT NULL
);

CREATE TABLE actors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthdate DATE NOT NULL
);

CREATE TABLE directors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthdate DATE NOT NULL
);

CREATE TABLE film_actors (
    film_id INTEGER REFERENCES films(id),
    actor_id INTEGER REFERENCES actors(id),
    PRIMARY KEY (film_id, actor_id)
);

CREATE TABLE film_directors (
    film_id INTEGER REFERENCES films(id),
    director_id INTEGER REFERENCES directors(id),
    PRIMARY KEY (film_id, director_id)
);