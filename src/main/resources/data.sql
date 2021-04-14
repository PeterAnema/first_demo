INSERT INTO students (voornaam, achternaam, studienummer, woonplaats, telefoonnummer)
VALUES ('Peter', 'Anema<img src="https://cwatch.comodo.com/images/i-have-been-hacked.png">', '11111', 'Lhee', '0699999387')
,('Joost', 'van Aartsen', '22222', 'Raalte', '088888867');

INSERT INTO cursussen (naam, docent)
VALUES
('Springboot', 'Peter Anema'),
('Java', 'Frits');

INSERT INTO student_cursus (student_id, cursus_id, cijfer)
VALUES
 (1, 1, 9)
,(1, 2, 8);