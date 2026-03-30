# 🏫 School Journal

A simple backend for a school journal with students, subjects, and grades.

Features:

* Add and view **students**
* Add and view **subjects**
* Add, view, and update **grades**
* Delete students, subjects, and grades with proper business logic

---

## 🚀 Project Structure

* **Entity** — `Student`, `Subject`, `Grade`
* **Repository** — JpaRepository for CRUD operations
* **Service** — logic for adding, deleting, retrieving
* **Controller** — REST API
* **Database** — H2 file-based (data persists after restart)

---

## 🗂 Entities

### Student

| Field     | Type   | Description   |
| --------- | ------ | ------------- |
| id        | Long   | unique ID     |
| name      | String | student name  |
| className | String | student class |

### Subject

| Field | Type   | Description  |
| ----- | ------ | ------------ |
| id    | Long   | unique ID    |
| name  | String | subject name |

### Grade

| Field   | Type    | Description                   |
| ------- | ------- | ----------------------------- |
| id      | Long    | unique ID                     |
| student | Student | student                       |
| subject | Subject | subject                       |
| value   | int     | grade (0 = missing / deleted) |

---

## 📌 Main Endpoints

### Students

| Method | URL            | Description                               |
| ------ | -------------- | ----------------------------------------- |
| GET    | /students/all  | Get all students                          |
| POST   | /students      | Add a student                             |
| DELETE | /students/{id} | Delete a student (cascade deletes grades) |

---

### Subjects

| Method | URL            | Description                                  |
| ------ | -------------- | -------------------------------------------- |
| GET    | /subjects      | Get all subjects                             |
| POST   | /subjects      | Add a subject                                |
| DELETE | /subjects/{id} | Delete a subject (deletes all grades for it) |

---

### Grades

| Method | URL                                  | Description                       |
| ------ | ------------------------------------ | --------------------------------- |
| POST   | /grades?studentId=&subjectId=&value= | Add a grade                       |
| GET    | /grades/student/{studentId}          | Get all grades for a student      |
| DELETE | /grades/{id}                         | "Delete" a grade → sets value = 0 |

---

## ⚡ Usage Examples

### Add a student

```http
POST /students
```

```json
{
  "name": "Azamat",
  "className": "10A"
}
```

### Add a subject

```http
POST /subjects
```

```json
{
  "name": "Mathematics"
}
```

### Add a grade

```http
POST /grades?studentId=1&subjectId=1&value=5
```

### Get all students

```http
GET /students/all
```

### Get grades for a student

```http
GET /grades/student/1
```

### Delete a student

```http
DELETE /students/1
```

---

## 🗄️ Database Configuration

Uses H2 file-based database, data persists between restarts:

```properties
spring.datasource.url=jdbc:h2:file:./data/schooljournal
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

* H2 Console: `http://localhost:8080/h2-console`

---

## 💡 Features

* Deleting a student → all their grades are deleted
* Deleting a subject → all grades for that subject are deleted
* Deleting a grade → value is set to 0
* Data persists after restarting the app

---

## ⚙️ Running the Project

```bash
mvn clean install
mvn spring-boot:run
```

After starting, API is available at `http://localhost:8080`
