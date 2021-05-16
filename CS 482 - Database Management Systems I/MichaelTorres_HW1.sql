-- Question 1
select s.FirstName, s.LastName, s.StaffID
from staff s
where s.Position = "secretary";

-- Question 2
select B.TripID
from booking B, passengers P
where B.PassengerID = P.PassID and B.BookDate between cast('2019-06-01' as date) and cast('2019-06-30' as date) and P.FirstName = 'James' and P.LastName = 'Bond';

-- Question 3
select P.FirstName, P.LastName, P.PhoneNumber
from flies F, trips T, pilots P
where P.PilotID = F.PilotID and F.TripID = T.TripID and T.DeptDate between cast('2019-01-01' as date) and cast('2019-01-31' as date)
group by F.PilotID
having count(F.TripID) = 1;

-- Question 4
select P.FirstName, P.LastName, P.RewardPoints
from booking B, passengers P, trips T
where B.PassengerID = P.PassID and B.TripID = T.TripID and T.ArrTown = 'El Paso'
having P.RewardPoints > 1000
order by P.RewardPoints;

-- Question 5
select S.*
from departments D, staff S
where D.DeptID = S.DepartmentID and D.Category = 'Finance' and S.Position = 'manager';

-- Question 6
select B.TripID, B.PassengerID
from booking B, passengers P
where B.PassengerID = P.PassID and P.FirstName = 'James' and P.LastName = 'Bond' and B.TripID in (select B.TripID
																									from booking B, passengers P
																									where B.PassengerID = P.PassID and (P.FirstName = 'John' and P.LastName = 'Wick'));
                                                                                                    
-- Question 7
select S.FirstName, S.LastName, S.Birthdate, P.FirstName, P.LastName, P.Birthdate
from staff S
left outer join pilots P on S.FirstName = P.FirstName;

-- Question 8
select FirstName, LastName, PilotID
from pilots 
where Rating < (select avg(Rating) from pilots);

-- Question 9
select P.LastName, T.TripID, T.ArrTown
from pilots P, flies F, trips T
where P.PilotID = F.PilotID and F.TripID = T.TripID and T.Capacity > 450 and T.DeptTown like 'S%';

-- Question 10
select count(S.ServiceID)
from services S, trips T, flies F, pilots P
where S.AirCraftID = T.AirCraftID and T.TripID = F.TripID and F.PilotID = P.PilotID and P.FirstName = 'Parth' and P.LastName = 'Nagarkar'