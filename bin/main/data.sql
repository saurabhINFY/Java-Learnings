-- Insert data into Employees
INSERT INTO Employees (EmployeeID, Name, DepartmentID, Salary, HireDate)
VALUES (1, 'John Doe', 101, 80000, '2017-01-15'),
       (2, 'Jane Smith', 102, 120000, '2015-07-12'),
       (3, 'Michael Brown', 101, 90000, '2019-03-21'),
       (4, 'Emma Wilson', 103, 60000, '2020-08-10'),
       (5, 'David Johnson', 101, 80000, '2018-02-25'),
       (6, 'Lisa White', 102, 70000, '2016-05-17');

-- Insert data into Departments
INSERT INTO Departments (DepartmentID, DepartmentName, Location)
VALUES (101, 'IT', 'New York'),
       (102, 'HR', 'Chicago'),
       (103, 'Finance', 'Seattle');

-- Insert data into Orders
INSERT INTO Orders (OrderID, CustomerID, OrderDate, Amount, Region)
VALUES (1, 501, '2023-01-10', 500, 'East Coast'),
       (2, 502, '2023-02-15', 300, 'West Coast'),
       (3, 501, '2023-03-12', 700, 'East Coast'),
       (4, 503, '2023-04-18', 200, 'Midwest'),
       (5, 504, '2023-05-22', 150, 'East Coast'),
       (6, 501, '2023-06-30', 450, 'East Coast'),
       (7, 502, '2023-07-01', 550, 'West Coast');

-- Insert data into Products
INSERT INTO Products (ProductID, Category, Price, StockQuantity)
VALUES ('P101', 'Electronics', 500, 100),
       ('P102', 'Furniture', 1200, 50),
       ('P103', 'Clothing', 200, 500),
       ('P104', 'Electronics', 700, 150),
       ('P105', 'Furniture', 1500, 30);

-- Insert data into Sales
INSERT INTO Sales (SalesID, ProductID, Region, SaleDate, QuantitySold, Revenue)
VALUES ('S001', 'P101', 'East Coast', '2023-01-05', 5, 2500),
       ('S002', 'P102', 'West Coast', '2023-02-12', 3, 3600),
       ('S003', 'P103', 'Midwest', '2023-03-20', 8, 1600),
       ('S004', 'P104', 'East Coast', '2023-04-15', 4, 2800),
       ('S005', 'P105', 'Chicago', '2023-05-22', 1, 1500);

-- Insert data into Customers
INSERT INTO Customers (CustomerID, Name, Region, SignupDate)
VALUES (501, 'Alice Cooper', 'East Coast', '2023-01-01'),
       (502, 'Bob Marley', 'West Coast', '2023-02-01'),
       (503, 'Charlie Watts', 'Midwest', '2023-03-01'),
       (504, 'Diana Ross', 'East Coast', '2023-04-01'),
       (505, 'Eric Clapton', 'South Coast', '2023-07-01');

-- Insert data into Attendance
INSERT INTO Attendance (EmployeeID, AttendanceDate, Status)
VALUES (1, '2023-01-02', 'Present'),
       (2, '2023-01-02', 'Present'),
       (3, '2023-01-02', 'Absent'),
       (4, '2023-01-02', 'Present'),
       (5, '2023-01-02', 'Present'),
       (1, '2023-01-03', 'Absent'),
       (2, '2023-01-03', 'Present'),
       (6, '2023-01-02', 'Absent');

-- Insert data into Projects
INSERT INTO Projects (ProjectID, ProjectName, DepartmentID)
VALUES (201, 'AI Research', 101),
       (202, 'Finance Tech', 103),
       (203, 'CRM Tool', 102);

-- Insert data into EmployeeProjects
INSERT INTO EmployeeProjects (EmployeeID, ProjectID)
VALUES (1, 201),
       (3, 201),
       (4, 203),
       (5, 202);

-- Insert data into StudentMarks
INSERT INTO StudentMarks (StudentID, StudentName, DepartmentID, Marks)
VALUES (301, 'Adam Johnson', 101, 85),
       (302, 'Bella Davis', 102, 90),
       (303, 'Chris Evans', 101, 92),
       (304, 'Daisy Carter', 103, 75),
       (305, 'Evan Smith', 103, 88);