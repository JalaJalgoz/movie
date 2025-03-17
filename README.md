# Movie Rental Application

This project is a simple Movie Rental application built in Java. It demonstrates the use of design patterns such as Strategy and Decorator, along with robust error handling. The application generates rental reports in Plain Text, JSON, and XML formats and persists them to files.

## Project Structure

The project is organized following a clean, modular architecture (influenced by MVC and DDD principles). Below is an example structure:

```
movie-rental/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │       └── movies/
│   │           ├── models/
│   │           │   ├── Customer.java
│   │           │   ├── Movie.java
│   │           │   ├── Rental.java
│   │           │   └── pricing/
│   │           │               ├── Price.java
│   │           │               ├── RegularPrice.java
│   │           │               ├── NewReleasePrice.java
│   │           │               └── ChildrenPrice.java
│   │           ├── reports/
│   │           │       ├── RentalReport.java
│   │           │       ├── PlainTextRentalReport.java
│   │           │       ├── RentalReportDecorator.java
│   │           │       ├── JSONRentalReportDecorator.java
│   │           │       └── XMLRentalReportDecorator.java
│   │           ├── persist/
│   │           │       └── ReportPersister.java
│   │           └── exceptions/
│   │                   └── ReportException.java
```

## Prerequisites

- **Java Development Kit (JDK) 21** – Ensure you have JDK 21 installed.
- **Apache Maven** – Used for dependency management and building the project.
- (Optional) **Git** – For version control.
