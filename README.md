# PSL Management System

A console-based Java application for managing Pakistan Super League (PSL)
cricket data including teams, players, match schedules, and standings.

## Author

Ali Farooqi | BSSE012315001
Noor Fatima | BSSE012315002

## How to Run

- Requires Java JDK 8 or above
- Compile and run from project root

## Project Structure

- src/model → Data classes (Person, Player, Batsman, Bowler, AllRounder, Coach, Team, Stadium, Umpire, Match, Schedule)
- src/service → Business logic (PSLSystem, DataLoader, SearchService)
- src/ui → Console menu (MainMenu)
- src/admin → Admin login and management (AdminService)
- data/ → JSON files for all 6 teams, stadiums, umpires, schedule

## Course

Software Construction and Development — Refactoring & Evolution Project

---

## Improvement Log — Before vs After

### Legacy System (Python)

| Metric              | Value                                       |
| ------------------- | ------------------------------------------- |
| Total files         | 2 (.py files)                               |
| Total lines of code | ~650 lines                                  |
| Classes             | 3 (Person, Player, Team)                    |
| Exception handling  | Basic try/except in menu only               |
| Data storage        | 12 CSV files (2 per team)                   |
| OOP structure       | Partial — no inheritance hierarchy          |
| Variable naming     | Abbreviations: dob, batting_avg, t20_runs   |
| Data types          | Stats stored as mixed types, no enforcement |
| Points calculation  | wins \* 2 written inline in multiple places |
| Password handling   | Plain text string comparison                |
| Search              | Not implemented                             |
| Admin module        | Not implemented                             |
| Team comparison     | Hardcoded to two specific teams             |

### Refactored System (Java)

| Metric              | Value                                                 |
| ------------------- | ----------------------------------------------------- |
| Total files         | 15 (.java files)                                      |
| Total lines of code | ~1100 lines                                           |
| Classes             | 13 (full OOP hierarchy)                               |
| Exception handling  | try-catch on every user input, custom messages        |
| Data storage        | 8 JSON files (1 per team + venues + schedule)         |
| OOP structure       | Full — Person → Player → Batsman/Bowler/AllRounder    |
| Variable naming     | Full names: dateOfBirth, battingAverage, totalT20Runs |
| Data types          | All stats correctly typed as double or int            |
| Points calculation  | calculatePoints() method — one place only             |
| Password handling   | hashCode() comparison — no plain text                 |
| Search              | Full player and team search with partial matching     |
| Admin module        | Full login, add/remove players, add umpire/stadium    |
| Team comparison     | Dynamic — works for any two teams                     |

### Refactoring Techniques Applied

| Technique               | Where Applied                                                    |
| ----------------------- | ---------------------------------------------------------------- |
| Rename Variable         | Commit 10 — batting_avg → battingAverage, dob → dateOfBirth etc. |
| Extract Method          | Commit 11 — calculatePoints() extracted from inline wins \* 2    |
| Replace Temp with Query | Commit 11 — getPoints() now calls calculatePoints() directly     |
| Inline Method           | Commit 12 — isValidInput() inlined into searchPlayer/searchTeam  |
| Move Method             | Commits 6-7 — display logic moved into proper service layer      |
| Encapsulate Collection  | Commit 4 — players list made private with controlled access      |
