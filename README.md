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
   
============================================================
          OOP QUEST: JAVA LEARNING ADVENTURE
     Master Java Fundamentals Through Interactive Learning!
============================================================

Enter your name: Jouana

Welcome, Jouana! Let's begin your Java journey!

============================================================
                        MAIN MENU
============================================================
Player: Jouana | Score: 0
------------------------------------------------------------
1. Module 1: Main Function of Java
2. Module 2: Java Syntax & Printing
3. Module 3: String Handling
4. View Score
5. Exit
============================================================

============================================================
  Main Function of Java
============================================================
1. Ask -View Q&A
2. Learn - Educational contents
3. Play Quiz - Test your knowledges
4. Return to Main Menu
============================================================

Enter your choice (1-4): 2

============================================================
  LEARN: Main Function of Java
============================================================

Every Java program must have a main() method:

Syntax:
  public static void main(String[] args) {
      // Your code here
  }

Breaking it down:
  • public    - Access modifier
  • static    - Can be called without creating an object
  • void      - Returns nothing
  • main      - Entry point of the program

Press Enter to continue...

============================================================
  QUIZ: Main Function of Java
============================================================

Question 1/3:
What keyword allows the JVM to call main() without creating an object?
a. public
b. static
c. void
d. main

Your answer: b
Correct! 'static' allows calling without an object.

Question 2/3:
What does 'void' mean in the main method?
Your answer: b
Correct! 'void' means no return value.

Question 3/3:
What happens if you don't include main() in your program?
Your answer: c
Correct! You'll get a runtime error.

------------------------------------------------------------
Quiz Complete! Score: 30/30
------------------------------------------------------------

Press Enter to continue...

============================================================
                    YOUR PROGRESS
============================================================
Player: Alex
Total Score: 30 points

Completed Modules:
Main Function of Java
============================================================

Press Enter to continue...

============================================================
              THANK YOU FOR PLAYING!
============================================================
Final Score: 30 points
Modules Completed: 1

Keep learning Java! Goodbye, Alex!
============================================================


Author and Acknowledgement
Author: Abanilla, Krizea Gabrielle C.
        Aungon, Kyla Marie P.
        Guitierrez, Jouana Joy J.
Course: Object-Oriented Programming (Java)
Project Title: OOP Quest: Javenture

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

