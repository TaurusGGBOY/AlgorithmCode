# Write your MySQL query statement below
select t2.Name as Department, t1.Name as Employee, Salary from Employee t1, Department t2 where t1.DepartmentId=t2.Id
and (t1.DepartmentId, t1.Salary) in (select DepartmentId, max(Salary) from Employee group by DepartmentId)