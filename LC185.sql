# Write your MySQL query statement below
select * from Employee
(select * from Employee group by DepartmentId order by Salary desc limit 3)