# Java Web Server - Chain of Responsibility and Observer Design Patterns

This project was created as part of my software engineering coursework.  
The goal is to implement a small web server in Java while applying **Chain of responsibility** and **Observer** patterns.

## Overview

This project is a small web server implemented in **Java 17**.
It receives requests via the `getRequest()` method.

The server follows these rules:

- Valid paths: `/dashboard` and `/home`.
- `/dashboard` is only accessible to admin users.
- `/home` is accessible to any user.
- Responses are printed directly to the console (`System.out.println`).
- All requests are logged to `logs.txt`.

## Prerequisites

- **Java 17**
- **Maven 3.6+** 

## Installation

Clone the repository:

```bash
git clone git@github.com:ilies-sghiar/JavaWebServer.git
```

## Run the Application

```bash
mvn compile exec:java   
```

## Build the Project
```bash
mvn package
```

The compiled artifacts will be in `target/`

## Project Structure

```
├── LICENSE                       # MIT licence
├── logs.txt                      # Log file
├── pom.xml                       # Maven project descriptor
├── README.md                     # This file
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── emse
│   │               └── sghiar
│   │                   ├── ExistingContentCheckRequestHandler.java         # Validates requested paths
│   │                   ├── FileLogger.java                                 # Logs requests to a file
│   │                   ├── Main.java                                       # Application entry point
│   │                   ├── PolicyCheckRequestHandler.java                  # Checks user permissions
│   │                   ├── RenderContentHandler.java                       # Generates responses
│   │                   ├── RequestHandler.java                             # Abstract base class for handlers
│   │                   ├── User.java                                       # Represents a user
│   │                   ├── WebRequest.java                                 # Represents a request
│   │                   ├── WebRequestObservable.java                       # Observable interface
│   │                   ├── WebRequestObserver.java                         # Observer interface
│   │                   └── WebServer.java                                  # Main web server class
```

## Architecture

The project uses **two main design patterns**:

### 1. Chain of Responsibility

Request handling is delegated to a **chain of handlers**:

1. **RequestHandler** (abstract class)  
   - Contains a `successor` member for the next handler.  
   - Abstract method `handleRequest(WebRequest request)`.

2. **ExistingContentCheckRequestHandler**  
   - Checks if the requested path exists.  
   - Returns `404` if the content does not exist, otherwise passes the request to the next handler.

3. **PolicyCheckRequestHandler**  
   - Checks if the user has the required access rights.  
   - Returns `403` if unauthorized, otherwise passes the request to the next handler.

4. **RenderContentHandler**  
   - Generates the response for the request.

5. **WebServer**  
   - Holds the **first handler** in the chain.  
   - `getRequest(WebRequest request)` calls the first handler in the chain.

---

### 2. Observer Pattern

To **log all requests to a file**, the server uses the **Observer pattern**:

1. **WebRequestObservable** (interface)  
   - Methods: `attach()`, `detach()`, `notifyObservers()`.

2. **WebRequestObserver** (interface)  
   - Method: `update(WebRequest request)`.

3. **WebServer**  
   - Implements `WebRequestObservable`.  
   - Notifies all observers on each request.

4. **FileLogger**  
   - Implements `WebRequestObserver`.  
   - Logs each request to a file when notified.


## Licence

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions, you can contact me at `iliesghiar@gmail.com`.
