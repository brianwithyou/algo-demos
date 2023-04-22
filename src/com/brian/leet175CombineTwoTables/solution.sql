# Write your MySQL query statement below

create table PERSON
(
    FirstName int not null,
    LastName  int not null,
    PersonId  int not null
);
create table Address
(
    city     int not null,
    state    int not null,
    PersonId int not null
);

SELECT p.FirstName, p.LastName, a.city, a.state FROM PERSON p
    left join Address a on p.PersonId = a.PersonId