insert into teams values (3149, 'Hawks', 'Las Cruces');
insert into teams values (2675, 'Tigers', 'El Paso');
insert into teams values (3821, 'Wolves', 'Albuquerque');
insert into teams values (4497, 'Snakes', 'Santa Fe');
insert into teams values (5623, 'Rhinos', 'Silver City');

insert into players values (1162, 'Shawn', 'Brown', 3149, 'QB', 5, 1000, 800000);
insert into players values (2743, 'Nathan', 'Hogan', 2675, 'RB', 10, 1500, 750000);
insert into players values (3211, 'Harvey', 'Luna', 3821, 'WR', 7, 1350, 660000);
insert into players values (4085, 'Jose', 'Gusler', 4497, 'RB', 15, 1800, 780000);
insert into players values (5670, 'Andrew', 'Foster', 5623, 'QB', 8, 1200, 590000);

insert into games values (11245, '2020-8-16', 'NRG Stadium', 'W', 70000, 7000000);
insert into games values (32658, '2020-9-18', 'Nissan Stadium', 'L', 85000, 7250000);
insert into games values (18756, '2020-10-25', 'Arrowhead Stadium', 'T', 60000, 6575000);
insert into games values (25684, '2020-11-10', 'Ford Field', 'W', 75000, 7100000);
insert into games values (45862, '2020-12-29', 'MetLife Stadium', 'L', 90000, 7500000);

insert into play values (1162, 11245);
insert into play values (2743, 32658);
insert into play values (3211, 18756);
insert into play values (4085, 25684);
insert into play values (5670, 45862);