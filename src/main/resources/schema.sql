-- Table: Employees
CREATE TABLE Employees
(
    EmployeeID   INT PRIMARY KEY,
    Name         VARCHAR(50),
    DepartmentID INT,
    Salary       DECIMAL(10, 2),
    HireDate     DATE
);

-- Table: Departments
CREATE TABLE Departments
(
    DepartmentID   INT PRIMARY KEY,
    DepartmentName VARCHAR(50),
    Location       VARCHAR(50)
);

-- Table: Orders
CREATE TABLE Orders
(
    OrderID    INT PRIMARY KEY,
    CustomerID INT,
    OrderDate  DATE,
    Amount     DECIMAL(10, 2),
    Region     VARCHAR(50)
);

-- Table: Products
CREATE TABLE Products
(
    ProductID     VARCHAR(10) PRIMARY KEY, -- Product ID as a VARCHAR to handle unique product codes
    Category      VARCHAR(50),
    Price         DECIMAL(10, 2),
    StockQuantity INT
);

-- Table: Sales
CREATE TABLE Sales
(
    SalesID      VARCHAR(10) PRIMARY KEY, -- Sales ID as a VARCHAR to handle unique sales codes
    ProductID    VARCHAR(10),             -- Foreign key referencing Products
    Region       VARCHAR(50),
    SaleDate     DATE,
    QuantitySold INT,
    Revenue      DECIMAL(10, 2),
    FOREIGN KEY (ProductID) REFERENCES Products (ProductID)
);

-- Table: Customers
CREATE TABLE Customers
(
    CustomerID INT PRIMARY KEY,
    Name       VARCHAR(50),
    Region     VARCHAR(50),
    SignupDate DATE
);

-- Table: Attendance
CREATE TABLE Attendance
(
    EmployeeID     INT,
    AttendanceDate DATE,
    Status         VARCHAR(10), -- Status as 'Present' or 'Absent'
    FOREIGN KEY (EmployeeID) REFERENCES Employees (EmployeeID)
);

-- Table: Projects
CREATE TABLE Projects
(
    ProjectID    INT PRIMARY KEY,
    ProjectName  VARCHAR(50),
    DepartmentID INT, -- Foreign key referencing Departments
    FOREIGN KEY (DepartmentID) REFERENCES Departments (DepartmentID)
);

-- Table: EmployeeProjects
CREATE TABLE EmployeeProjects
(
    EmployeeID INT, -- Foreign key referencing Employees
    ProjectID  INT, -- Foreign key referencing Projects
    FOREIGN KEY (EmployeeID) REFERENCES Employees (EmployeeID),
    FOREIGN KEY (ProjectID) REFERENCES Projects (ProjectID)
);

-- Table: StudentMarks
CREATE TABLE StudentMarks
(
    StudentID    INT PRIMARY KEY,
    StudentName  VARCHAR(50),
    DepartmentID INT, -- Foreign key referencing Departments
    Marks        INT,
    FOREIGN KEY (DepartmentID) REFERENCES Departments (DepartmentID)
);