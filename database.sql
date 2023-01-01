insert into department_entity (department_id, abbr, department_name, location, student_number)
values (11, 'CS', 'Computer Engineering', 'Main C',900),
       (33, 'MATH', 'Mathematics', 'Main S',300),
       (44, 'PHYS', 'Physics', 'Main SA',200),
       (55, 'IR', 'International Relations', 'Main A',1200),
       (66, 'MAN', 'Management', 'Main AT',780);

insert into advisor_entity (advisor_id, advisor_name, email, department_id)
values (11, 'Jone', 'joh@gmail.com', 11),
       (33, 'Kim',  'kim@gmail.com', 33),
       (44, 'Smith', 'smith@gmail.com', 44),
       (55, 'William', 'william@gmail.com', 55),
       (66, 'Paule', 'paule@gmail.com', 66),
       (77, 'Robert',  'robert@gmail.com', 33);

insert into student_entity (student_id, student_name, enrollment_year, department_id, CGPA, advisor_id, email)
values (111, 'Ugur', 2022, 11, 2.50, 11, 'ugur@gmail.com'),
       (333, 'Rose', 2019, 33, 3.87, 33, 'rose@gmail.com'),
       (444, 'Niya', 2019, 44, 4.00, 33,'niya@gmail.com'),
       (555, 'Goerge',2021, 55, 2.58,44, 'george@gmail.com'),
       (666, 'Rasil',2018, 66, 3.22,55, 'rasil@gmail.com'),
       (777, 'Jenny', 2019, 33, 2.1, 66, 'jenny@gmail.com'),
       (888, 'Gemma',2020, 11, 1.6, 77,'gemma@gmail.com');
