# Movie Management System

JavaFX-based client application for browsing and managing a movie catalog by production company. The UI connects to a socket server for live data transfer and operations such as adding or transferring movies.

## Features
- Company login that loads a curated catalog for the selected production company.
- Full movie catalog view with sortable table columns for year, genres, runtime, budget, and revenue.
- Analytics views for the most recent releases and the single highest-revenue title per company.
- Instant total profit calculation based on budget vs. revenue across the company catalog.
- Add new movies to the company list with validation for duplicates and input format.
- Transfer a movie to another production company via the socket server for real-time updates.

## Architecture
- JavaFX desktop client with FXML views.
- Socket-based client-server protocol using serialized DTOs.
- Data model stored in a `Movie` object and transferred via `DataWrapper`.

## Tech Stack
- Java 11 (source/target compatibility)
- JavaFX 17.0.2
- Gradle (with wrapper)

## Project Structure
```
Movie-Database-System/
	Movie-App/
		MovieApplication/          # JavaFX client (Gradle project)
		MovieServer/               # Server-side code (socket-based)
	Assets/
		movies.txt                 # Sample movie dataset
		Supporting_Codes/          # Reference utilities/examples
	Problem.pdf                  # Assignment/problem statement
```

## Getting Started
### Prerequisites
- JDK 11 installed and on PATH
- JavaFX 17.0.2 (handled by Gradle via plugin)

### Run the JavaFX Client
1. Open a terminal in:
	 `Movie-Database-System/Movie-App/MovieApplication`
2. Run:
	 `gradlew run`

> Note: The Gradle config currently points to `com.example.movieapplication.HelloApplication`. If the app does not start, update `mainClass` in [Movie-Database-System/Movie-App/MovieApplication/build.gradle](Movie-Database-System/Movie-App/MovieApplication/build.gradle) to `com.example.movieapplication.MovieApplication`.

### Server Requirement
The client expects a socket server at `127.0.0.1:3000` that understands the `DataWrapper` protocol and returns company-specific movie data. If you do not have the server running, the login flow will not succeed.

## Data Format
The sample dataset in [Movie-Database-System/Assets/movies.txt](Movie-Database-System/Assets/movies.txt) follows:
```
Title,Year,Genre1,Genre2,Genre3,Runtime,ProductionCompany,Budget,Revenue
```

## Key UI Screens
- Login: enter production company name.
- Main Menu: navigation for list, recent, max revenue, total profit, add movie, transfer.
- Movie List: full table view of company movies.

## Notes
- [Movie-Database-System/Assets/Supporting_Codes](Movie-Database-System/Assets/Supporting_Codes) contains standalone reference utilities and is not part of the app runtime.
- Examples there include [Movie-Database-System/Assets/Supporting_Codes/FileOperations.java](Movie-Database-System/Assets/Supporting_Codes/FileOperations.java) and [Movie-Database-System/Assets/Supporting_Codes/StudentList.java](Movie-Database-System/Assets/Supporting_Codes/StudentList.java).
- The app uses Java serialization for socket messages, so client and server must share compatible DTOs.
