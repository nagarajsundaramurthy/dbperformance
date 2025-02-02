package com.dbperformance;

public class QueryConstants {

    // Query 1: Count the Number of Orders per Department
    public static final String oracleQuery1 =
            "SELECT e.Department, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.Department";

    public static final String postgresQuery1 =
            "SELECT e.Department, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.Department";

    // Query 2: Total Sales Per Product
    public static final String oracleQuery2 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "GROUP BY ProductID";

    public static final String postgresQuery2 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "GROUP BY ProductID";

    // Query 3: Employees Who Joined in the Last Year
    public static final String oracleQuery3 =
            "SELECT EmployeeID, FirstName, LastName " +
                    "FROM Employee " +
                    "WHERE HireDate >= SYSDATE - 365";

    public static final String postgresQuery3 =
            "SELECT EmployeeID, FirstName, LastName " +
                    "FROM Employee " +
                    "WHERE HireDate >= CURRENT_DATE - INTERVAL '1 year'";

    // Query 4: Total Sales for a Specific Product (Last 90 Days)
    public static final String oracleQuery4 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate BETWEEN SYSDATE - 90 AND SYSDATE " +
                    "GROUP BY ProductID";

    public static final String postgresQuery4 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate BETWEEN CURRENT_DATE - INTERVAL '90 days' AND CURRENT_DATE " +
                    "GROUP BY ProductID";

    // Query 5: Average Salary by Department
    public static final String oracleQuery5 =
            "SELECT Department, AVG(Salary) AS AverageSalary " +
                    "FROM Employee " +
                    "GROUP BY Department";

    public static final String postgresQuery5 =
            "SELECT Department, AVG(Salary) AS AverageSalary " +
                    "FROM Employee " +
                    "GROUP BY Department";

    // Query 6: Employees with Orders Greater Than 10
    public static final String oracleQuery6 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.EmployeeID, e.FirstName " +
                    "HAVING COUNT(o.OrderID) > 10";

    public static final String postgresQuery6 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.EmployeeID, e.FirstName " +
                    "HAVING COUNT(o.OrderID) > 10";

    // Query 7: Sales for Each Product and Department
    public static final String oracleQuery7 =
            "SELECT e.Department, s.ProductID, SUM(s.Amount) AS TotalSales " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "JOIN Sales s ON s.ProductID = o.ProductID " +
                    "GROUP BY e.Department, s.ProductID";

    public static final String postgresQuery7 =
            "SELECT e.Department, s.ProductID, SUM(s.Amount) AS TotalSales " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "JOIN Sales s ON s.ProductID = o.ProductID " +
                    "GROUP BY e.Department, s.ProductID";

    // Query 8: Top 10 Products Sold by Total Sales
    public static final String oracleQuery8 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "GROUP BY ProductID " +
                    "ORDER BY TotalSales DESC " +
                    "FETCH NEXT 10 ROWS ONLY";

    public static final String postgresQuery8 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "GROUP BY ProductID " +
                    "ORDER BY TotalSales DESC " +
                    "LIMIT 10";

    // Query 9: Employees with No Orders
    public static final String oracleQuery9 =
            "SELECT e.EmployeeID, e.FirstName " +
                    "FROM Employee e " +
                    "LEFT JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE o.OrderID IS NULL";

    public static final String postgresQuery9 =
            "SELECT e.EmployeeID, e.FirstName " +
                    "FROM Employee e " +
                    "LEFT JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE o.OrderID IS NULL";

    // Query 10: Top 3 Departments by Employee Count
    public static final String oracleQuery10 =
            "SELECT Department, COUNT(EmployeeID) AS TotalEmployees " +
                    "FROM Employee " +
                    "GROUP BY Department " +
                    "ORDER BY TotalEmployees DESC " +
                    "FETCH NEXT 3 ROWS ONLY";

    public static final String postgresQuery10 =
            "SELECT Department, COUNT(EmployeeID) AS TotalEmployees " +
                    "FROM Employee " +
                    "GROUP BY Department " +
                    "ORDER BY TotalEmployees DESC " +
                    "LIMIT 3";

    // Query 11: Employees in the Engineering Department with More Than 10 Orders
    public static final String oracleQuery11 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE e.Department = 'Engineering' " +
                    "GROUP BY e.EmployeeID, e.FirstName " +
                    "HAVING COUNT(o.OrderID) > 10";

    public static final String postgresQuery11 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE e.Department = 'Engineering' " +
                    "GROUP BY e.EmployeeID, e.FirstName " +
                    "HAVING COUNT(o.OrderID) > 10";

    // Query 12: Find Employees with Orders from Specific Date Range
    public static final String oracleQuery12 =
            "SELECT e.EmployeeID, e.FirstName, o.OrderID " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE o.OrderDate BETWEEN SYSDATE - 30 AND SYSDATE";

    public static final String postgresQuery12 =
            "SELECT e.EmployeeID, e.FirstName, o.OrderID " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE o.OrderDate BETWEEN CURRENT_DATE - INTERVAL '30 days' AND CURRENT_DATE";

    // Query 13: Sales for Each Department (Subquery Example)
    public static final String oracleQuery13 =
            "SELECT e.Department, " +
                    "(SELECT SUM(s.Amount) FROM Sales s WHERE s.ProductID = 1 AND s.SaleDate > SYSDATE - 365) AS TotalSales " +
                    "FROM Employee e";

    public static final String postgresQuery13 =
            "SELECT e.Department, " +
                    "(SELECT SUM(s.Amount) FROM Sales s WHERE s.ProductID = 1 AND s.SaleDate > CURRENT_DATE - INTERVAL '1 year') AS TotalSales " +
                    "FROM Employee e";

    // Query 14: Find Employees Who Have Placed Orders Exceeding Average Order Value
    public static final String oracleQuery14 =
            "SELECT e.EmployeeID, e.FirstName, SUM(o.Amount) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.EmployeeID " +
                    "HAVING SUM(o.Amount) > (SELECT AVG(Amount) FROM Orders)";

    public static final String postgresQuery14 =
            "SELECT e.EmployeeID, e.FirstName, SUM(o.Amount) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.EmployeeID " +
                    "HAVING SUM(o.Amount) > (SELECT AVG(Amount) FROM Orders)";

    // Query 15: Products Sold with More Than Average Sales
    public static final String oracleQuery15 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "GROUP BY ProductID " +
                    "HAVING SUM(Amount) > (SELECT AVG(Amount) FROM Sales)";

    public static final String postgresQuery15 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "GROUP BY ProductID " +
                    "HAVING SUM(Amount) > (SELECT AVG(Amount) FROM Sales)";

    // Query 16: Employees with Orders in Last 7 Days
    public static final String oracleQuery16 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE o.OrderDate > SYSDATE - 7 " +
                    "GROUP BY e.EmployeeID, e.FirstName";

    public static final String postgresQuery16 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE o.OrderDate > CURRENT_DATE - INTERVAL '7 days' " +
                    "GROUP BY e.EmployeeID, e.FirstName";

    // Query 17: Total Salary Expenditure by Department
    public static final String oracleQuery17 =
            "SELECT Department, SUM(Salary) AS TotalSalary " +
                    "FROM Employee " +
                    "GROUP BY Department";

    public static final String postgresQuery17 =
            "SELECT Department, SUM(Salary) AS TotalSalary " +
                    "FROM Employee " +
                    "GROUP BY Department";

    // Query 18: Orders for a Specific Employee (EmployeeID = 100)
    public static final String oracleQuery18 =
            "SELECT o.OrderID, o.OrderDate, o.Amount " +
                    "FROM Orders o " +
                    "WHERE o.EmployeeID = 100";

    public static final String postgresQuery18 =
            "SELECT o.OrderID, o.OrderDate, o.Amount " +
                    "FROM Orders o " +
                    "WHERE o.EmployeeID = 100";

    // Query 19: Sales in the Last 30 Days by Product
    public static final String oracleQuery19 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate > SYSDATE - 30 " +
                    "GROUP BY ProductID";

    public static final String postgresQuery19 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate > CURRENT_DATE - INTERVAL '30 days' " +
                    "GROUP BY ProductID";

    // Query 20: Average Order Amount per Employee
    public static final String oracleQuery20 =
            "SELECT e.EmployeeID, AVG(o.Amount) AS AvgOrderAmount " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.EmployeeID";

    public static final String postgresQuery20 =
            "SELECT e.EmployeeID, AVG(o.Amount) AS AvgOrderAmount " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.EmployeeID";

    // Query 21: Employees in Sales Department with More Than 5 Orders
    public static final String oracleQuery21 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE e.Department = 'Sales' " +
                    "GROUP BY e.EmployeeID, e.FirstName " +
                    "HAVING COUNT(o.OrderID) > 5";

    public static final String postgresQuery21 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE e.Department = 'Sales' " +
                    "GROUP BY e.EmployeeID, e.FirstName " +
                    "HAVING COUNT(o.OrderID) > 5";

    // Query 22: Total Sales by Product for Last 180 Days
    public static final String oracleQuery22 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate BETWEEN SYSDATE - 180 AND SYSDATE " +
                    "GROUP BY ProductID";

    public static final String postgresQuery22 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate BETWEEN CURRENT_DATE - INTERVAL '180 days' AND CURRENT_DATE " +
                    "GROUP BY ProductID";

    // Query 23: Number of Orders Placed by Each Employee
    public static final String oracleQuery23 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS OrderCount " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.EmployeeID, e.FirstName";

    public static final String postgresQuery23 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS OrderCount " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.EmployeeID, e.FirstName";

    // Query 24: Products with No Sales
    public static final String oracleQuery24 =
            "SELECT ProductID " +
                    "FROM Sales s " +
                    "WHERE NOT EXISTS (SELECT 1 FROM Orders o WHERE o.ProductID = s.ProductID)";

    public static final String postgresQuery24 =
            "SELECT ProductID " +
                    "FROM Sales s " +
                    "WHERE NOT EXISTS (SELECT 1 FROM Orders o WHERE o.ProductID = s.ProductID)";

    // Query 25: Employees with Salaries Above Average
    public static final String oracleQuery25 =
            "SELECT EmployeeID, FirstName, Salary " +
                    "FROM Employee " +
                    "WHERE Salary > (SELECT AVG(Salary) FROM Employee)";

    public static final String postgresQuery25 =
            "SELECT EmployeeID, FirstName, Salary " +
                    "FROM Employee " +
                    "WHERE Salary > (SELECT AVG(Salary) FROM Employee)";

    // Query 26: Find Orders for Products in the Engineering Department
    public static final String oracleQuery26 =
            "SELECT o.OrderID, o.Amount " +
                    "FROM Orders o " +
                    "JOIN Employee e ON e.EmployeeID = o.EmployeeID " +
                    "WHERE e.Department = 'Engineering'";

    public static final String postgresQuery26 =
            "SELECT o.OrderID, o.Amount " +
                    "FROM Orders o " +
                    "JOIN Employee e ON e.EmployeeID = o.EmployeeID " +
                    "WHERE e.Department = 'Engineering'";

    // Query 27: Total Orders in Each Department
    public static final String oracleQuery27 =
            "SELECT e.Department, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.Department";

    public static final String postgresQuery27 =
            "SELECT e.Department, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.Department";

    // Query 28: Total Sales for Products Sold in Last 60 Days
    public static final String oracleQuery28 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate BETWEEN SYSDATE - 60 AND SYSDATE " +
                    "GROUP BY ProductID";

    public static final String postgresQuery28 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate BETWEEN CURRENT_DATE - INTERVAL '60 days' AND CURRENT_DATE " +
                    "GROUP BY ProductID";

    // Query 29: Employee Salary Distribution (Less than, equal to, greater than 50K)
    public static final String oracleQuery29 =
            "SELECT CASE WHEN Salary < 50000 THEN 'Less than 50K' " +
                    "WHEN Salary = 50000 THEN 'Equal to 50K' " +
                    "ELSE 'Greater than 50K' END AS SalaryRange, " +
                    "COUNT(EmployeeID) AS EmployeeCount " +
                    "FROM Employee " +
                    "GROUP BY CASE WHEN Salary < 50000 THEN 'Less than 50K' " +
                    "WHEN Salary = 50000 THEN 'Equal to 50K' " +
                    "ELSE 'Greater than 50K' END";

    public static final String postgresQuery29 =
            "SELECT CASE WHEN Salary < 50000 THEN 'Less than 50K' " +
                    "WHEN Salary = 50000 THEN 'Equal to 50K' " +
                    "ELSE 'Greater than 50K' END AS SalaryRange, " +
                    "COUNT(EmployeeID) AS EmployeeCount " +
                    "FROM Employee " +
                    "GROUP BY CASE WHEN Salary < 50000 THEN 'Less than 50K' " +
                    "WHEN Salary = 50000 THEN 'Equal to 50K' " +
                    "ELSE 'Greater than 50K' END";

    // Query 30: Number of Orders Placed by Department
    public static final String oracleQuery30 =
            "SELECT e.Department, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.Department";

    public static final String postgresQuery30 =
            "SELECT e.Department, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.Department";

    // Query 31: Total Sales for Products in Last Year
    public static final String oracleQuery31 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate > SYSDATE - 365 " +
                    "GROUP BY ProductID";

    public static final String postgresQuery31 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate > CURRENT_DATE - INTERVAL '1 year' " +
                    "GROUP BY ProductID";

    // Query 32: Average Order Amount per Department
    public static final String oracleQuery32 =
            "SELECT e.Department, AVG(o.Amount) AS AvgOrderAmount " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.Department";

    public static final String postgresQuery32 =
            "SELECT e.Department, AVG(o.Amount) AS AvgOrderAmount " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "GROUP BY e.Department";

    // Query 33: Sales for Products Exceeding $1000
    public static final String oracleQuery33 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE Amount > 1000 " +
                    "GROUP BY ProductID";

    public static final String postgresQuery33 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE Amount > 1000 " +
                    "GROUP BY ProductID";

    // Query 34: Number of Orders Above $1000
    public static final String oracleQuery34 =
            "SELECT COUNT(OrderID) AS HighValueOrders " +
                    "FROM Orders " +
                    "WHERE Amount > 1000";

    public static final String postgresQuery34 =
            "SELECT COUNT(OrderID) AS HighValueOrders " +
                    "FROM Orders " +
                    "WHERE Amount > 1000";

    // Query 35: Average Salary of Employees by Department
    public static final String oracleQuery35 =
            "SELECT Department, AVG(Salary) AS AvgSalary " +
                    "FROM Employee " +
                    "GROUP BY Department";

    public static final String postgresQuery35 =
            "SELECT Department, AVG(Salary) AS AvgSalary " +
                    "FROM Employee " +
                    "GROUP BY Department";

    // Query 36: Products with Sales in Last 30 Days
    public static final String oracleQuery36 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate > SYSDATE - 30 " +
                    "GROUP BY ProductID";

    public static final String postgresQuery36 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate > CURRENT_DATE - INTERVAL '30 days' " +
                    "GROUP BY ProductID";

    // Query 37: Employees in IT Department with Orders
    public static final String oracleQuery37 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE e.Department = 'IT' " +
                    "GROUP BY e.EmployeeID, e.FirstName";

    public static final String postgresQuery37 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS TotalOrders " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE e.Department = 'IT' " +
                    "GROUP BY e.EmployeeID, e.FirstName";

    // Query 38: Sales with Amount Above Average
    public static final String oracleQuery38 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "GROUP BY ProductID " +
                    "HAVING SUM(Amount) > (SELECT AVG(Amount) FROM Sales)";

    public static final String postgresQuery38 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "GROUP BY ProductID " +
                    "HAVING SUM(Amount) > (SELECT AVG(Amount) FROM Sales)";

    // Query 39: Find Orders for Employees with Department 'Sales'
    public static final String oracleQuery39 =
            "SELECT o.OrderID, o.Amount " +
                    "FROM Orders o " +
                    "JOIN Employee e ON e.EmployeeID = o.EmployeeID " +
                    "WHERE e.Department = 'Sales'";

    public static final String postgresQuery39 =
            "SELECT o.OrderID, o.Amount " +
                    "FROM Orders o " +
                    "JOIN Employee e ON e.EmployeeID = o.EmployeeID " +
                    "WHERE e.Department = 'Sales'";

    // Query 40: Employee with Maximum Salary
    public static final String oracleQuery40 =
            "SELECT EmployeeID, FirstName, Salary " +
                    "FROM Employee " +
                    "WHERE Salary = (SELECT MAX(Salary) FROM Employee)";

    public static final String postgresQuery40 =
            "SELECT EmployeeID, FirstName, Salary " +
                    "FROM Employee " +
                    "WHERE Salary = (SELECT MAX(Salary) FROM Employee)";

    // Query 41: Products with Total Sales Above $5000
    public static final String oracleQuery41 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "GROUP BY ProductID " +
                    "HAVING SUM(Amount) > 5000";

    public static final String postgresQuery41 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "GROUP BY ProductID " +
                    "HAVING SUM(Amount) > 5000";

    // Query 42: Total Salary for Employees in Department 'HR'
    public static final String oracleQuery42 =
            "SELECT SUM(Salary) AS TotalSalary " +
                    "FROM Employee " +
                    "WHERE Department = 'HR'";

    public static final String postgresQuery42 =
            "SELECT SUM(Salary) AS TotalSalary " +
                    "FROM Employee " +
                    "WHERE Department = 'HR'";

    // Query 43: Employees Working in Engineering and Sales Department
    public static final String oracleQuery43 =
            "SELECT e.EmployeeID, e.FirstName " +
                    "FROM Employee e " +
                    "WHERE e.Department IN ('Engineering', 'Sales')";

    public static final String postgresQuery43 =
            "SELECT e.EmployeeID, e.FirstName " +
                    "FROM Employee e " +
                    "WHERE e.Department IN ('Engineering', 'Sales')";

    // Query 44: Find Orders from Last Year
    public static final String oracleQuery44 =
            "SELECT * FROM Orders " +
                    "WHERE OrderDate BETWEEN SYSDATE - 365 AND SYSDATE";

    public static final String postgresQuery44 =
            "SELECT * FROM Orders " +
                    "WHERE OrderDate BETWEEN CURRENT_DATE - INTERVAL '1 year' AND CURRENT_DATE";

    // Query 45: Employees with Orders in Last 30 Days
    public static final String oracleQuery45 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS OrderCount " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE o.OrderDate > SYSDATE - 30 " +
                    "GROUP BY e.EmployeeID, e.FirstName";

    public static final String postgresQuery45 =
            "SELECT e.EmployeeID, e.FirstName, COUNT(o.OrderID) AS OrderCount " +
                    "FROM Employee e " +
                    "JOIN Orders o ON e.EmployeeID = o.EmployeeID " +
                    "WHERE o.OrderDate > CURRENT_DATE - INTERVAL '30 days' " +
                    "GROUP BY e.EmployeeID, e.FirstName";

    // Query 46: Sales in Last 60 Days by Product
    public static final String oracleQuery46 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate BETWEEN SYSDATE - 60 AND SYSDATE " +
                    "GROUP BY ProductID";

    public static final String postgresQuery46 =
            "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "WHERE SaleDate BETWEEN CURRENT_DATE - INTERVAL '60 days' AND CURRENT_DATE " +
                    "GROUP BY ProductID";

    // Query 47: Find Orders Above $500
    public static final String oracleQuery47 =
            "SELECT OrderID, Amount " +
                    "FROM Orders " +
                    "WHERE Amount > 500";

    public static final String postgresQuery47 =
            "SELECT OrderID, Amount " +
                    "FROM Orders " +
                    "WHERE Amount > 500";

    // Query 48: Average Order Amount for Engineering Department
    public static final String oracleQuery48 =
            "SELECT AVG(o.Amount) AS AvgOrderAmount " +
                    "FROM Orders o " +
                    "JOIN Employee e ON e.EmployeeID = o.EmployeeID " +
                    "WHERE e.Department = 'Engineering'";

    public static final String postgresQuery48 =
            "SELECT AVG(o.Amount) AS AvgOrderAmount " +
                    "FROM Orders o " +
                    "JOIN Employee e ON e.EmployeeID = o.EmployeeID " +
                    "WHERE e.Department = 'Engineering'";

    // Query 49: Top 10 Highest Sales for Each Product
    public static final String oracleQuery49 =
            "SELECT * FROM (" +
                    "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "GROUP BY ProductID " +
                    "ORDER BY TotalSales DESC" +
                    ") WHERE ROWNUM <= 10";

    public static final String postgresQuery49 =
            "SELECT * FROM (" +
                    "SELECT ProductID, SUM(Amount) AS TotalSales " +
                    "FROM Sales " +
                    "GROUP BY ProductID " +
                    "ORDER BY TotalSales DESC" +
                    ") AS t LIMIT 10";

    // Query 50: Employees who Have Not Placed Any Orders
    public static final String oracleQuery50 =
            "SELECT e.EmployeeID, e.FirstName " +
                    "FROM Employee e " +
                    "WHERE NOT EXISTS (SELECT 1 FROM Orders o WHERE o.EmployeeID = e.EmployeeID)";

    public static final String postgresQuery50 =
            "SELECT e.EmployeeID, e.FirstName " +
                    "FROM Employee e " +
                    "WHERE NOT EXISTS (SELECT 1 FROM Orders o WHERE o.EmployeeID = e.EmployeeID)";

    public static final String oracleQuery51 = "SELECT e.Department, COUNT(o.OrderID) AS TotalOrders, SUM(o.Amount) AS TotalAmount FROM Employee e \n" +
            "JOIN Orders o ON e.EmployeeID = o.EmployeeID \n" +
            "WHERE e.HireDate < SYSDATE - 365 \n" +
            "GROUP BY e.Department";
    public static final String postgresQuery51 = "SELECT e.Department, COUNT(o.OrderID) AS TotalOrders, SUM(o.Amount) AS TotalAmount\n" +
            "FROM Employee e\n" +
            "JOIN Orders o ON e.EmployeeID = o.EmployeeID\n" +
            "WHERE e.HireDate < CURRENT_DATE - INTERVAL '1 year'\n" +
            "GROUP BY e.Department";
    public static final String oracleQuery52 = "SELECT ProductID, SUM(Amount) AS TotalSales \n" +
            "FROM Sales \n" +
            "WHERE SaleDate BETWEEN SYSDATE - 90 AND SYSDATE \n" +
            "GROUP BY ProductID";
    public static final String postgresQuery52 = "SELECT ProductID, SUM(Amount) AS TotalSales\n" +
            "FROM Sales\n" +
            "WHERE SaleDate BETWEEN CURRENT_DATE - INTERVAL '90 days' AND CURRENT_DATE\n" +
            "GROUP BY ProductID";
    public static final String oracleQuery53 = "SELECT e.EmployeeID, e.FirstName, e.LastName, \n" +
            "       (SELECT SUM(s.Amount) FROM Sales s WHERE s.ProductID = 1 AND s.SaleDate > SYSDATE - 365) AS TotalSales \n" +
            "FROM Employee e";
    public static final String postgresQuery53 = "SELECT e.EmployeeID, e.FirstName, e.LastName, \n" +
            "       (SELECT SUM(s.Amount) FROM Sales s WHERE s.ProductID = 1 AND s.SaleDate > CURRENT_DATE - INTERVAL '1 year') AS TotalSales\n" +
            "FROM Employee e";

}

