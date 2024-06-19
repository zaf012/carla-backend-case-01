#Average compensation of roles where the role is some kind of engineer:
SELECT AVG(Salary) as AvgEngineerSalary
FROM Compensation c
         JOIN Role r ON c.RoleID = r.RoleID
WHERE r.RoleName ILIKE '%engineer%';


---Average, min, and max compensation per city:
SELECT City, AVG(Salary) as AvgSalary, MIN(Salary) as MinSalary, MAX(Salary) as MaxSalary
FROM Compensation c
GROUP BY City;

#Interesting query of your choice (average compensation by gender):
SELECT g.GenderName, AVG(c.Salary) as AvgSalary
FROM Compensation c
         JOIN Employee e ON c.EmployeeID = e.EmployeeID
         JOIN Gender g ON e.GenderID = g.GenderID
GROUP BY g.GenderName;
