# Library Management System

## Project Overview
This is a simple console-based Library Management System built using Java and JDBC (without JPA). The system allows you to:
- Add new books  
- View all books  
- Search books by ID or title  
- Update book details  
- Delete a book  
- Exit the system  

## Prerequisites
Before running the project, make sure you have:
- Java JDK 8 or above installed  
- MySQL database installed and running  
- JDBC Driver for MySQL  
- Any IDE (IntelliJ, Eclipse) or terminal  

## Database Setup

### 1. Create Database  
Run the following in MySQL:
```sql
CREATE DATABASE library_db;
USE library_db;
### 2. Create Table
CREATE TABLE books (
    id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(100),
    availability ENUM('Available', 'Checked Out') NOT NULL
);

##Project Setup


### 1. Clone or Download the Project
git clone https://github.com/your-repo/library-management.git
cd library-management
### 2.Configure Database Connection
Go to BookDAO.java and update:
private static final String URL = "jdbc:mysql://localhost:3306/library_db";
private static final String USER = "your_mysql_username";
private static final String PASSWORD = "your_mysql_password";
### 3. Compile & Run
- open the project
- Run LibraryApplication.java