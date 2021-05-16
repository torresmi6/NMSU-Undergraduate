-- Question 1
select D.Name, max(S.Salary)
from staff S, departments D
where S.DepartmentID = D.DeptID
group by D.Name;

-- Question 2
select avg(P.Salary)
from pilots P;

-- Question 3
select P.FirstName, T.TripID, T.DeptDate
from pilots P, trips T, flies F
where P.PilotID = F.PilotID and T.TripID = F.TripID and T.DeptTown = 'San Jose' and (T.ArrTown = 'New York' or T.ArrTown = 'El Paso');

-- Question 4
select T.AirCraftID
from trips T
where T.DeptTown = 'New York'
union
select T.AircraftID
from trips T
where T.ArrTown = 'New York';

-- Question 5
select distinct S.LastName, S.StaffID, S.Salary
from staff S
where S.Salary > (select avg(P.Salary) from pilots P);