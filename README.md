Author: Abanilla, Krizea Gabrielle C.
        Aungon, Kyla Marie P.
        Guitierrez, Jouana Joy J.
Course: Object-Oriented Programming (Java)
Project Title: OOP Quest: Javenture

OOP Quest: Java Learning Adventure

OOP Quest is a console-based Java learning application designed to help beginners understand fundamental Java concepts through interactive modules. The program allows users to explore lessons, view questions and answers, and take quizzes on core Java topics such as the main method, syntax and printing, and string handling. It applies Object-Oriented Programming (OOP) principles to create a structured, modular, and extensible learning experience while tracking user progress and scores.

OOP Concepts Applied

1. Encapsulation
    -Encapsulation is implemented in the Player class, where data such as name, score, and completedModules are declared as private. Access to these variables is controlled through public getter and method functions, ensuring data protection and controlled modification.

2. Abstraction
    -Abstraction is demonstrated through the abstract class LearningModule. It defines abstract methods such as ask(), learn(), and playQuiz() that must be implemented by all module subclasses, allowing a common structure while hiding implementation details.

3. Inheritance
    -Inheritance is used by having specific learning modules (MainFunctionModule, SyntaxPrintingModule, and StringHandlingModule) extend the LearningModule abstract class. This allows shared behavior and properties while enabling specialized content per module.

4. Polymorphism
    -Polymorphism is applied when the program stores different module objects inside a LearningModule[] array. The program calls overridden methods (ask, learn, playQuiz) at runtime based on the selected module, allowing dynamic behavior.

5. Exception Handling
    -Custom exception handling is implemented using InvalidInputException to manage invalid user inputs and prevent program crashes. Built-in exceptions like InputMismatchException are also handled.

Program Structure
Main Classes and Their Roles

OOPQuestFinal
  The main driver class
  Handles program flow, menus, user input, and game execution

Player
  Stores player name, score, and completed modules
  Manages scoring and progress tracking

LearningModule (Abstract Class)
  Serves as a blueprint for all learning modules
  Defines common methods and shared functionality

MainFunctionModule
  Teaches Java’s main() method
  Includes Q&A, lesson content, and a quiz

SyntaxPrintingModule
  Covers Java syntax rules and printing methods
  Includes interactive learning and quizzes

StringHandlingModule
  Focuses on Java String concepts and methods
  Provides examples and quizzes

InvalidInputException
  Custom exception class for handling invalid numeric input

How to Run the Program
 Requirements
   Java Development Kit (JDK) 8 or higher
   Command Prompt / Terminal or an IDE (VS Code)

Steps to Run
1.Save the file as OOPQuestFinal.java
2.Open a terminal or command prompt
3.Navigate to the directory containing the file
4.Compile the program:
     'java OOPQuestFinal.java'
5.Run the program:
     'java OOPQuestFinal'

Sample Output


<img width="599" height="312" alt="Screenshot 2025-12-16 131900" src="https://github.com/user-attachments/assets/9c18574b-5db8-4365-9b29-c94aaccd1d53" />

<img width="615" height="298" alt="Screenshot 2025-12-16 132021" src="https://github.com/user-attachments/assets/6363a241-64f0-40b7-b037-ec095bbb6811" />

<img width="590" height="255" alt="image" src="https://github.com/user-attachments/assets/c0b4fb32-5b57-4851-b95b-ac5ca933f81e" />

<img width="598" height="435" alt="image" src="https://github.com/user-attachments/assets/4b2d4947-293e-4d0f-8803-7f8063fa8f99" />

<img width="603" height="680" alt="image" src="https://github.com/user-attachments/assets/a9a99e63-70d9-4236-a8bc-3f9f7ed5d687" />

<img width="674" height="904" alt="image" src="https://github.com/user-attachments/assets/2dd9a7c3-257b-4f15-b45a-5bd165dbde4e" />

<img width="587" height="266" alt="image" src="https://github.com/user-attachments/assets/0fe33f2e-b64e-4ad0-85f9-e096e5ab49bf" />

<img width="576" height="173" alt="image" src="https://github.com/user-attachments/assets/d8fb893b-ba35-43c3-baad-e02412674ccb" />



Acknowledgement
    The authors would like to express sincere gratitude to the course instructor for guidance and feedback throughout the development of this project. Appreciation is also extended to classmates and peers who provided ideas, motivation, and support during the implementation process. Additionally, online Java documentation and learning resources were instrumental in reinforcing the concepts applied in this project.

Future Enhancements
    1. The following improvements may be considered for future versions of the program:
    2. Add more learning modules covering advanced Java topics such as arrays, inheritance, interfaces, and file handling
    3. Implement a graphical user interface (GUI) using JavaFX or Swing
    4. Add user account saving and loading using file handling or databases
    5. Include a difficulty level system for quizzes
    6. Improve input validation and feedback for user answers
    7. Add a leaderboard or achievement system

