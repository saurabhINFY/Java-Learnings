-- 1. Department Analysis: Find departments with highest average salary
SELECT
    d.DepartmentName,
    COUNT(e.EmployeeID) as employee_count,
    AVG(e.Salary) as avg_salary
FROM Departments d
LEFT JOIN Employees e ON d.DepartmentID = e.DepartmentID
GROUP BY d.DepartmentName
ORDER BY avg_salary DESC;

-- 2. Complex Employee Report: Get employees with their department, salary rank within department
SELECT
    e.Name,
    d.DepartmentName,
    e.Salary,
    DENSE_RANK() OVER (PARTITION BY e.DepartmentID ORDER BY e.Salary DESC) as salary_rank
FROM Employees e
JOIN Departments d ON e.DepartmentID = d.DepartmentID;

-- 3. Regional Sales Analysis: Find top performing regions by order value
SELECT
    o.Region,
    COUNT(DISTINCT o.OrderID) as total_orders,
    SUM(o.Amount) as total_amount,
    AVG(o.Amount) as avg_order_value
FROM Orders o
GROUP BY o.Region
HAVING COUNT(o.OrderID) >= 2
ORDER BY total_amount DESC;

-- 4. Product Stock Analysis: Find products with critical stock levels
SELECT
    p.ProductID,
    p.Category,
    p.StockQuantity,
    COUNT(s.SalesID) as total_sales
FROM Products p
LEFT JOIN Sales s ON p.ProductID = s.ProductID
GROUP BY p.ProductID, p.Category, p.StockQuantity
HAVING p.StockQuantity < 50
ORDER BY total_sales DESC;

-- 5. Employee Hire Date Analysis: Find hiring trends by department
SELECT
    d.DepartmentName,
    EXTRACT(YEAR FROM e.HireDate) as hire_year,
    COUNT(*) as hires_in_year,
    AVG(e.Salary) as avg_salary_for_year
FROM Employees e
JOIN Departments d ON e.DepartmentID = d.DepartmentID
GROUP BY d.DepartmentName, EXTRACT(YEAR FROM e.HireDate)
ORDER BY d.DepartmentName, hire_year;

-- 6. Complex Multi-Table Analysis: Department performance by region
SELECT
    d.DepartmentName,
    o.Region,
    COUNT(DISTINCT e.EmployeeID) as employee_count,
    COUNT(DISTINCT o.OrderID) as order_count,
    SUM(o.Amount) as total_revenue
FROM Departments d
JOIN Employees e ON d.DepartmentID = e.DepartmentID
JOIN Orders o ON o.Region = d.Location
GROUP BY d.DepartmentName, o.Region
HAVING COUNT(DISTINCT o.OrderID) > 0
ORDER BY total_revenue DESC;

-- 7. Time-based Analysis: Month-over-month order growth
WITH MonthlyOrders AS (
    SELECT
        DATE_TRUNC('month', OrderDate) as month,
        COUNT(*) as order_count,
        SUM(Amount) as monthly_amount
    FROM Orders
    GROUP BY DATE_TRUNC('month', OrderDate)
)
SELECT
    month,
    order_count,
    monthly_amount,
    LAG(monthly_amount) OVER (ORDER BY month) as prev_month_amount,
    CASE
        WHEN LAG(monthly_amount) OVER (ORDER BY month) IS NOT NULL
        THEN ((monthly_amount - LAG(monthly_amount) OVER (ORDER BY month)) / LAG(monthly_amount) OVER (ORDER BY month)) * 100
        ELSE 0
    END as growth_percentage
FROM MonthlyOrders
ORDER BY month;

-- 8. Advanced Customer Analysis: Customer order frequency and value
WITH CustomerStats AS (
    SELECT
        o.CustomerID,
        COUNT(*) as order_count,
        AVG(Amount) as avg_order_value,
        MAX(Amount) as highest_order_value,
        MIN(OrderDate) as first_order_date,
        MAX(OrderDate) as last_order_date
    FROM Orders o
    GROUP BY o.CustomerID
)
SELECT
    cs.*,
    EXTRACT(DAY FROM (last_order_date - first_order_date)) as customer_lifetime_days,
    order_count::FLOAT / NULLIF(EXTRACT(DAY FROM (last_order_date - first_order_date)), 0) * 30 as monthly_order_frequency
FROM CustomerStats cs
ORDER BY monthly_order_frequency DESC;
