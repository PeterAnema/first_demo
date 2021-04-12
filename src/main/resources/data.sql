INSERT INTO students (voornaam, achternaam, studienummer, woonplaats, telefoonnummer)
VALUES ('Peter', 'Anema', '11111', 'Lhee', '0699999387');

INSERT INTO cursussen (naam, docent)
VALUES
('Springboot', 'Peter Anema'),
('Java', 'Frits');

INSERT INTO students_cursussen (student_id, cursussen_id)
VALUES (1, 1), (1, 2);

INSERT INTO cursussen_studenten (studenten_id, cursus_id)
VALUES (1, 1), (1, 2);