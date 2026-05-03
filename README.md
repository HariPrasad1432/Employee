# employee_hierarchy
##  Overview

This project analyzes a company's organizational structure based on employee data provided in a CSV file.

It validates:

* Manager salary rules
* Reporting line depth

---

##  Problem Statement

The company wants to ensure:

### 1. Salary Rules

Each manager must earn:

* **At least 20% more** than the average salary of their direct subordinates
* **At most 50% more** than the average salary of their direct subordinates

The application reports:

* Managers earning **less than expected**
* Managers earning **more than expected**

---

### 2. Reporting Line Rules

* An employee should not have **more than 4 managers** between them and the CEO
* The application identifies employees violating this rule

---

##  Input Format

CSV file structure:

```
id,first_name,last_name,salary,manager_id
```

Example:

```
id,first_name,last_name,salary,manager_id
1,CEO,Boss,150000,
2,CTO,TechLead,120000,1
3,CFO,FinanceHead,115000,1
4,Manager1,Ops,90000,2
5,Manager2,HR,85000,3
6,Lead1,TeamA,70000,4
7,Lead2,TeamB,68000,5
```

* CEO has no `manager_id`
* Each employee has at most one manager

---

##  Tech Stack

* Java (JDK 17)
* Maven
* JUnit 5

---

##  How to Run

### 1. Clone the repository

```
git clone <your-repo-url>
cd employee
```

### 2. Build the project

```
mvn  install
```

### 3. Run the application

```
mvn spring-boot:run
```

---

##  Run Tests

```
mvn test
```

---

##  Approach

### 1. Data Structure

* Employees are stored in a `Map<Integer, Employee>`
* Hierarchy is built as a **tree structure**

### 2. Salary Validation

* For each manager:

  * Calculate average salary of direct subordinates
  * Compare with allowed range (120% – 150%)

### 3. Reporting Depth

* Perform DFS traversal
* Track depth from CEO
* Flag employees with depth > 4

---

##  Time Complexity

* Building hierarchy: **O(n)**
* Traversal: **O(n)**
* Overall: **O(n)**

---

##  Assumptions

* Input CSV is valid
* No cyclic relationships
* One CEO exists
* Each employee has only one manager

---

##  Possible Improvements

* Add logging instead of console output
* Export results to a file (CSV/JSON)
* Add validation for malformed input
* Improve test coverage
* Support large datasets efficiently

---

##  Author

Your Name
Baligi Durga Ram Prasad
