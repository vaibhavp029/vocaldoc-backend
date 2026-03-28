VOCALDOC BACKEND

Backend service for the VocalDoc mini project. This project allows users to upload documents (TXT, PDF, DOCX), extract the text content, and later convert it into speech.

This project is mainly focused on learning backend development concepts like layered architecture, API design, file handling, and database integration using Spring Boot.


##TECH STACK

Backend:
Java
Spring Boot
Spring Data JPA

Database:
PostgreSQL

Libraries:
Apache PDFBox (PDF text extraction)
Apache POI (DOCX text extraction)

Tools:
Maven
Postman
Git
IntelliJ IDEA


##FEATURES

User Module:
- Add User API
- Login User API
- Get Users API
- Duplicate email validation
- DTO pattern implementation
- Layered architecture (Controller → Service → Repository)

Document Module:
- Document upload API
- File validation (TXT, PDF, DOCX only)
- Text extraction from TXT files
- Text extraction from PDF files
- Text extraction from DOCX files
- Document metadata stored in PostgreSQL
- Upload directory auto creation


##PROJECT STRUCTURE

controller
UserController

service
UserService
DocumentService

repository
UserRepository
DocumentRepository

model
User
Document

dto
UserRequestDTO
UserResponseDTO
LoginRequestDTO


##SETUP

1. Set environment variables:

DB_URL=
DB_USERNAME=
DB_PASSWORD=

2. Make sure PostgreSQL is running.

3. Run VocaldocApplication.java

Server runs on:
http://localhost:8080


##API ENDPOINTS

Add User:
POST /adduser

Login:
POST /login

Get Users:
GET /users

Upload Document:
POST /upload

Upload requires:
file → document file
userId → existing user id

##Supported formats:
TXT
PDF
DOCX


##IMPORTANT NOTES

Only TXT, PDF and DOCX files are supported.
Unsupported files are rejected.
Uploaded files are stored in uploads folder.
uploads folder is ignored from git.
Database must be running before project start.
Environment variables must be configured.


##CURRENT STATUS

Completed:
User module
Document upload system
Text extraction system

##In Progress:
Text to Speech conversion
Audio generation
Voice selection
Document history


##FUTURE IMPROVEMENTS

JWT authentication
Cloud storage
Frontend integration
Multiple voices
Audio download

Backend learning project using Spring Boot.
