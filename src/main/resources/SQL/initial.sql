INSERT INTO authors (firstName, lastName) VALUES ('Jan', 'Kowalski');
INSERT INTO authors (firstName, lastName) VALUES ('Adam', 'Nowak');
INSERT INTO authors (firstName, lastName) VALUES ('Piotr', 'Malinowski');

INSERT INTO categories (name, description) VALUES ('Kategoria1', 'Opis kategorii 1');
INSERT INTO categories (name, description) VALUES ('Kategoria2', 'Opis kategorii 2');
INSERT INTO categories (name, description) VALUES ('Kategoria3', 'Opis kategorii 3');
INSERT INTO categories (name, description) VALUES ('Kategoria4', 'Opis kategorii 4');

INSERT INTO articles (content, title, author_id, created) VALUES ('Tekst pierwszego artukułu', 'Tytuł 1', 1, '2019-10-25');
INSERT INTO articles (content, title, author_id, created) VALUES ('Tekst drugiego artukułu', 'Tytuł 2', 2, '2019-10-24');
INSERT INTO articles (content, title, author_id, created) VALUES ('Tekst trzeciego artukułu', 'Tytuł 3', 3, '2019-10-23');
INSERT INTO articles (content, title, author_id, created) VALUES ('Tekst czwartego artukułu', 'Tytuł 4', 1, '2019-10-22');
INSERT INTO articles (content, title, author_id, created) VALUES ('Tekst piątego artukułu', 'Tytuł 5', 2, '2019-10-21');
INSERT INTO articles (content, title, author_id, created) VALUES ('Tekst szóstego artukułu', 'Tytuł 6', 3, '2019-10-20');
INSERT INTO articles (content, title, author_id, created) VALUES ('Tekst siódmego artukułu', 'Tytuł 7', 1, '2019-10-19');
INSERT INTO articles (content, title, author_id, created) VALUES ('Tekst ósmego artukułu', 'Tytuł 8', 2, '2019-10-21');
INSERT INTO articles (content, title, author_id, created) VALUES ('Tekst dziewiątego artukułu', 'Tytuł 9', 3, '2019-10-25');

INSERT INTO article_categories (categories_id, articles_id) VALUES (1, 1);
INSERT INTO article_categories (categories_id, articles_id) VALUES (2, 2);
INSERT INTO article_categories (categories_id, articles_id) VALUES (3, 3);
INSERT INTO article_categories (categories_id, articles_id) VALUES (4, 4);
INSERT INTO article_categories (categories_id, articles_id) VALUES (1, 5);
INSERT INTO article_categories (categories_id, articles_id) VALUES (2, 6);
INSERT INTO article_categories (categories_id, articles_id) VALUES (3, 7);
INSERT INTO article_categories (categories_id, articles_id) VALUES (4, 8);
INSERT INTO article_categories (categories_id, articles_id) VALUES (1, 9);


select * from articles order by created desc limit 5;
select title, created, content from articles order by created desc limit 5;