CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    # Write your MySQL query statement below.
    SELECT DISTINCT t1.salary FROM Employee t1 WHERE N-1=(SELECT COUNT(*) FROM Employee t2 WHERE t1.salary > t2.salary);
  );
END