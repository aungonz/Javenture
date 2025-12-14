import java.util.Scanner;
import java.util.InputMismatchException;

//main application class
public class OOPQuestFinal {
    private static Scanner scanner = new Scanner(System.in);
    private static Player player;
    private static LearningModule[] modules;
    
    public static void main(String[] args) {
        initializeGame();
        showWelcome();
        runGame();
        showGoodbye();
        scanner.close();
    }
    
    private static void initializeGame() {
        modules = new LearningModule[3];
        modules[0] = new MainFunctionModule();
        modules[1] = new SyntaxPrintingModule();
        modules[2] = new StringHandlingModule();
    }
    
    private static void showWelcome() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          OOP QUEST: JAVA LEARNING ADVENTURE");
        System.out.println("     Master Java Fundamentals Through Interactive Learning!");
        System.out.println("=".repeat(60));
        
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Enter your name: ");
            name = scanner.nextLine().trim();
        }
        
        player = new Player(name);
        System.out.println("\nWelcome, " + player.getName() + "! Let's begin your Java journey!");
        pause();
    }
    
    private static void runGame() {
        boolean running = true;
        
        while (running) {
            showMainMenu();
            
            try {
                int choice = getIntInput("Enter your choice (1-5): ");
                
                switch (choice) {
                    case 1:
                    case 2:
                    case 3:
                        handleModule(choice - 1);
                        break;
                    case 4:
                        showScore();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Please select 1-5.");
                        pause();
                }
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
                pause();
            }
        }
    }
    
    private static void showMainMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                        MAIN MENU");
        System.out.println("=".repeat(60));
        System.out.println("Player: " + player.getName() + " | Score: " + player.getScore());
        System.out.println("-".repeat(60));
        System.out.println("1. Module 1: Main Function of Java");
        System.out.println("2. Module 2: Java Syntax & Printing");
        System.out.println("3. Module 3: String Handling");
        System.out.println("4. View Score");
        System.out.println("5. Exit");
        System.out.println("=".repeat(60));
    }
    
    private static void handleModule(int index) {
        LearningModule module = modules[index];
        boolean inModule = true;
        
        while (inModule) {
            showModuleMenu(module);
            
            try {
                int choice = getIntInput("Enter your choice (1-4): ");
                
                switch (choice) {
                    case 1:
                        module.ask();
                        pause();
                        break;
                    case 2:
                        module.learn();
                        pause();
                        break;
                    case 3:
                        int score = module.playQuiz();
                        player.addScore(score);
                        player.completeModule(module.getModuleName());
                        pause();
                        break;
                    case 4:
                        inModule = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Please select 1-4.");
                        pause();
                }
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
                pause();
            }
        }
    }
    
    private static void showModuleMenu(LearningModule module) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  " + module.getModuleName());
        System.out.println("=".repeat(60));
        System.out.println("1. Ask -View Q&A");
        System.out.println("2. Learn - Educational contents");
        System.out.println("3. Play Quiz - Test your knowledges");
        System.out.println("4. Return to Main Menu");
        System.out.println("=".repeat(60));
    }
    
    private static void showScore() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    YOUR PROGRESS");
        System.out.println("=".repeat(60));
        System.out.println("Player: " + player.getName());
        System.out.println("Total Score: " + player.getScore() + " points");
        System.out.println("\nCompleted Modules:");
        
        String[] completed = player.getCompletedModules();
        if (completed.length == 0) {
            System.out.println("  - No modules completed yet");
        } else {
            for (String module : completed) {
                System.out.println(module);
            }
        }
        System.out.println("=".repeat(60));
        pause();
    }
    
    private static void showGoodbye() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("              THANK YOU FOR PLAYING!");
        System.out.println("=".repeat(60));
        System.out.println("Final Score: " + player.getScore() + " points");
        System.out.println("Modules Completed: " + player.getCompletedModules().length);
        System.out.println("\nKeep learning Java! Goodbye, " + player.getName() + "!");
        System.out.println("=".repeat(60));
    }
    
    private static int getIntInput(String prompt) throws InvalidInputException {
        System.out.print(prompt);
        try {
            int input = scanner.nextInt();
            scanner.nextLine();
            return input;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new InvalidInputException("Please enter a valid number.");
        }
    }
    
    private static void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

//player class - encapsulation are
class Player {
    private String name;
    private int score;
    private String[] completedModules;
    private int moduleCount;
    
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.completedModules = new String[10];
        this.moduleCount = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }
    
    public String[] getCompletedModules() {
        String[] result = new String[moduleCount];
        for (int i = 0; i < moduleCount; i++) {
            result[i] = completedModules[i];
        }
        return result;
    }
    
    //methods 
    public void addScore(int points) {
        if (points > 0) {
            this.score += points;
        }
    }
    
    public void completeModule(String moduleName) {
        for (int i = 0; i < moduleCount; i++) {
            if (completedModules[i].equals(moduleName)) {
                return;
            }
        }
        if (moduleCount < completedModules.length) {
            completedModules[moduleCount++] = moduleName;
        }
    }
}

//abstract class - abstraction 
abstract class LearningModule {
    protected String moduleName;
    
    public LearningModule(String moduleName) {
        this.moduleName = moduleName;
    }
    
    public String getModuleName() {
        return moduleName;
    }
    
    // method
    public abstract void ask();
    public abstract void learn();
    public abstract int playQuiz();
    
    protected void showHeader(String title) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  " + title);
        System.out.println("=".repeat(60));
    }
}

//mod2( inheritance at polymorphism)
class MainFunctionModule extends LearningModule {
    private Scanner scanner = new Scanner(System.in);
    
    public MainFunctionModule() {
        super("Main Function of Java");
    }
    
    @Override
    public void ask() {
        showHeader("ASK: Main Function of Java");
        
        System.out.println("\nQ: What is the main function in Java?");
        System.out.println("A: The main() method is the entry point of any Java program.");
        System.out.println("   The JVM calls this method to start program execution.\n");
        
        System.out.println("Q: Why is main() declared as 'public static void'?");
        System.out.println("A: - public: Accessible from anywhere (JVM can call it)");
        System.out.println("   - static: Can be called without creating an object");
        System.out.println("   - void: Does not return any value\n");
        
        System.out.println("Q: What is String[] args?");
        System.out.println("A: It's an array that holds command-line arguments passed");
        System.out.println("   to the program when it starts running.\n");
    }
    
    @Override
    public void learn() {
        showHeader("LEARN: Main Function of Java");
        
        System.out.println("\n--- THE MAIN FUNCTION ---\n");
        System.out.println("Every Java program must have a main() method:");
        System.out.println("\nSyntax:");
        System.out.println("  public static void main(String[] args) {");
        System.out.println("      // Your code here");
        System.out.println("  }\n");
        
        System.out.println("Breaking it down:");
        System.out.println("  • public    - Access modifier (accessible everywhere)");
        System.out.println("  • static    - Belongs to the class, not objects");
        System.out.println("  • void      - Returns nothing");
        System.out.println("  • main      - Method name (required by JVM)");
        System.out.println("  • String[]  - Array of string arguments\n");
        
        System.out.println("Example:");
        System.out.println("  public class HelloWorld {");
        System.out.println("      public static void main(String[] args) {");
        System.out.println("          System.out.println(\"Hello, World!\");");
        System.out.println("      }");
        System.out.println("  }\n");
        
        System.out.println("Output: Hello, World!");
    }
    
    @Override
    public int playQuiz() {
        showHeader("QUIZ: Main Function of Java");
        int score = 0;
        
        // unang tanong
        System.out.println("\nQuestion 1/3:");
        System.out.println("What keyword allows the JVM to call main() without creating an object?");
        System.out.println("a. public");
        System.out.println("b. static");
        System.out.println("c. void");
        System.out.println("d. main");
        
        try {
            System.out.print("\nYour answer: ");
            String ans = scanner.nextLine();
            scanner.nextLine();
            if (ans.equals("b.") || ans.equals("b")) {
                System.out.println("Correct! 'static' allows calling without an object.");
                score += 10;
            } else {
                System.out.println("Wrong! Correct answer is 'static'.");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Invalid input!");
        }
        
        // second question
        System.out.println("\nQuestion 2/3:");
        System.out.println("What does 'void' mean in the main method?");
        System.out.println("a. Returns an integer");
        System.out.println("b. Returns nothing");
        System.out.println("c. Returns a string");
        System.out.println("d. It's optional");
        
        try {
            System.out.print("\nYour answer: ");
            String ans = scanner.nextLine();
            scanner.nextLine();
            if (ans.equals("b.") || ans.equals("b")) {
                System.out.println("Correct! 'void' means no return value.");
                score += 10;
            } else {
                System.out.println("Wrong! 'void' means the method returns nothing.");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Invalid input!");
        }
        
        // Question 3
        System.out.println("\nQuestion 3/3:");
        System.out.println("What happens if you don't include main() in your program?");
        System.out.println("a. Program runs normally");
        System.out.println("b. Compilation error");
        System.out.println("c. Runtime error");
        System.out.println("d. Nothing happens");
        
        try {
            System.out.print("\nYour answer: ");
            String ans = scanner.nextLine();
            scanner.nextLine();
            if (ans.equals("c.") || ans.equals("c")) {
                System.out.println("Correct! You'll get a runtime error.");
                score += 10;
            } else {
                System.out.println( "Wrong! It causes a runtime error.");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Invalid input!");
        }
        
        System.out.println("\n" + "-".repeat(60));
        System.out.println("Quiz Complete! Score: " + score + "/30");
        System.out.println("-".repeat(60));
        
        return score;
    }
}

// mod2(Inheritance & Polymorphism)
class SyntaxPrintingModule extends LearningModule {
    private Scanner scanner = new Scanner(System.in);
    
    public SyntaxPrintingModule() {
        super("Java Syntax & Printing");
    }
    
    @Override
    public void ask() {
        showHeader("ASK: Java Syntax & Printing");
        
        System.out.println("\nQ: What are Java naming conventions?");
        System.out.println("A: - Classes: PascalCase (MyClass)");
        System.out.println("   - Methods/Variables: camelCase (myMethod)");
        System.out.println("   - Constants: UPPER_CASE (MAX_VALUE)\n");
        
        System.out.println("Q: Is Java case-sensitive?");
        System.out.println("A: Yes! 'Hello' and 'hello' are different identifiers.\n");
        
        System.out.println("Q: What are the printing methods in Java?");
        System.out.println("A: - System.out.println() - Prints with newline");
        System.out.println("   - System.out.print()   - Prints without newline");
        System.out.println("   - System.out.printf()  - Formatted printing\n");
        
        System.out.println("Q: What are escape sequences?");
        System.out.println("A: Special characters: \\n (newline), \\t (tab),");
        System.out.println("   \\\" (quote), \\\\ (backslash)\n");
    }
    
    @Override
    public void learn() {
        showHeader("LEARN: Java Syntax & Printing");
        
        System.out.println("\n--- JAVA SYNTAX RULES ---\n");
        System.out.println("1. Case Sensitivity:");
        System.out.println("   'Hello' ≠ 'hello'\n");
        
        System.out.println("2. Naming Conventions:");
        System.out.println("   Classes:   MyClass, StudentRecord (PascalCase)");
        System.out.println("   Methods:   calculateSum(), getName() (camelCase)");
        System.out.println("   Variables: totalScore, userName (camelCase)\n");
        
        System.out.println("3. Statement Termination:");
        System.out.println("   Every statement ends with semicolon (;)");
        System.out.println("   Example: int x = 5;\n");
        
        System.out.println("--- PRINTING IN JAVA ---\n");
        System.out.println("1. println() - Prints with new line:");
        System.out.println("   System.out.println(\"Hello\");");
        System.out.println("   System.out.println(\"World\");");
        System.out.println("   Output: Hello");
        System.out.println("           World\n");
        
        System.out.println("2. print() - Prints without new line:");
        System.out.println("   System.out.print(\"Hello \");");
        System.out.println("   System.out.print(\"World\");");
        System.out.println("   Output: Hello World\n");
        
        System.out.println("--- ESCAPE SEQUENCES ---");
        System.out.println("  \\n  - New line");
        System.out.println("  \\t  - Tab");
        System.out.println("  \\\"  - Double quote");
        System.out.println("  \\\\  - Backslash\n");
        
        System.out.println("Example:");
        System.out.println("  System.out.println(\"Hello\\nWorld\");");
        System.out.println("  Output: Hello");
        System.out.println("          World");
    }
    
    @Override
    public int playQuiz() {
        showHeader("QUIZ: Java Syntax & Printing");
        int score = 0;
        
        // Question 1
        System.out.println("\nQuestion 1/3:");
        System.out.println("Which is correct Java class naming?");
        System.out.println("a. myclass");
        System.out.println("b. MyClass");
        System.out.println("c. my_class");
        System.out.println("d. MYCLASS");
        
        try {
            System.out.print("\nYour answer: ");
            String ans = scanner.nextLine().trim();
            scanner.nextLine().trim();
            if (ans.equals("b.") || ans.equals("b")) {
                System.out.println("Correct! Classes use PascalCase.");
                score += 10;
            } else {
                System.out.println("Wrong! Classes should be in PascalCase (MyClass).");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine().trim();
            System.out.println("Invalid input!");
        }
        
        // Question 2
        System.out.println("\nQuestion 2/3:");
        System.out.println("What does \\n do?");
        System.out.println("a. Creates a tab");
        System.out.println("b. Creates a new line");
        System.out.println("c. Creates a space");
        System.out.println("d. Prints 'n'");
        
        try {
            System.out.print("\nYour answer: ");
            String ans = scanner.nextLine();
            scanner.nextLine();
            if (ans.equals("b.") || ans.equals("b")) {
                System.out.println("Correct! \\n creates a new line.");
                score += 10;
            } else {
                System.out.println("Wrong! \\n is the newline escape sequence.");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Invalid input!");
        }
        
        // Question 3
        System.out.println("\nQuestion 3/3:");
        System.out.println("Which prints WITHOUT a new line?");
        System.out.println("a. System.out.println()");
        System.out.println("b. System.out.print()");
        System.out.println("c. Both");
        System.out.println("d. Neither");
        
        try {
            System.out.print("\nYour answer: ");
            String ans = scanner.nextLine();
            scanner.nextLine();
            if (ans.equals("b.") || ans.equals("b")) {
                System.out.println("Correct! print() doesn't add a new line.");
                score += 10;
            } else {
                System.out.println("Wrong! print() prints without a new line.");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Invalid input!");
        }
        
        System.out.println("\n" + "-".repeat(60));
        System.out.println("Quiz Complete! Score: " + score + "/30");
        System.out.println("-".repeat(60));
        
        return score;
    }
}
// mod(Inheritance & Polymorphism)
class StringHandlingModule extends LearningModule {
    private Scanner scanner = new Scanner(System.in);
    
    public StringHandlingModule() {
        super("String Handling");
    }
    
    @Override
    public void ask() {
        showHeader("ASK: String Handling");
        
        System.out.println("\nQ: What is a String in Java?");
        System.out.println("A: A String is an object that represents a sequence of");
        System.out.println("   characters. Strings are immutable in Java.\n");
        
        System.out.println("Q: How do you create a String?");
        System.out.println("A: Two ways:");
        System.out.println("   1. String name = \"Java\";");
        System.out.println("   2. String name = new String(\"Java\");\n");
        
        System.out.println("Q: What are common String methods?");
        System.out.println("A: - length() - Returns string length");
        System.out.println("   - toUpperCase() - Converts to uppercase");
        System.out.println("   - toLowerCase() - Converts to lowercase");
        System.out.println("   - charAt(i) - Gets character at index");
        System.out.println("   - substring() - Extracts part of string\n");
        
        System.out.println("Q: How do you concatenate strings?");
        System.out.println("A: Using + operator or concat() method:");
        System.out.println("   String full = \"Hello\" + \" \" + \"World\";\n");
    }
    
    @Override
    public void learn() {
        showHeader("LEARN: String Handling");
        
        System.out.println("\n--- STRING BASICS ---\n");
        System.out.println("Creating Strings:");
        System.out.println("  String name = \"Java\";");
        System.out.println("  String text = new String(\"Learning\");\n");
        
        System.out.println("--- COMMON STRING METHODS ---\n");
        System.out.println("1. length() - Get string length");
        System.out.println("   String str = \"Hello\";");
        System.out.println("   int len = str.length(); // 5\n");
        
        System.out.println("2. toUpperCase() / toLowerCase()");
        System.out.println("   String upper = str.toUpperCase(); // HELLO");
        System.out.println("   String lower = str.toLowerCase(); // hello\n");
        
        System.out.println("3. charAt(index) - Get character");
        System.out.println("   char ch = str.charAt(0); // 'H'\n");
        
        System.out.println("4. substring() - Extract part");
        System.out.println("   String sub = str.substring(1, 4); // \"ell\"\n");
        
        System.out.println("--- STRING CONCATENATION ---\n");
        System.out.println("Method 1: Using + operator");
        System.out.println("  String first = \"Hello\";");
        System.out.println("  String second = \"World\";");
        System.out.println("  String full = first + \" \" + second;");
        System.out.println("  // Result: Hello World\n");
        
        System.out.println("Method 2: Using concat()");
        System.out.println("  String result = first.concat(\" \").concat(second);\n");
        
        System.out.println("--- PRINTF PLACEHOLDERS ---");
        System.out.println("  %s - String");
        System.out.println("  %d - Integer");
        System.out.println("  %f - Float/Double");
        System.out.println("  %c - Character\n");
        
        System.out.println("Example:");
        System.out.println("  String name = \"Alice\";");
        System.out.println("  int age = 20;");
        System.out.println("  System.out.printf(\"Name: %s, Age: %d\", name, age);");
        System.out.println("  Output: Name: Alice, Age: 20");
    }
    
    @Override
    public int playQuiz() {
        showHeader("QUIZ: String Handling");
        int score = 0;
        
        // Question 1
        System.out.println("\nQuestion 1/3:");
        System.out.println("Which method returns string length?");
        System.out.println("a. size()");
        System.out.println("b. length()");
        System.out.println("c. count()");
        System.out.println("d. getLength()");
        
        try {
            System.out.print("\nYour answer: ");
            String ans = scanner.nextLine();
            scanner.nextLine();
            if (ans.equals("b.") || ans.equals("b")) {
                System.out.println("Correct! length() returns string length.");
                score += 10;
            } else {
                System.out.println("Wrong! Use length() method.");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Invalid input!");
        }
        
        // Question 2
        System.out.println("\nQuestion 2/3:");
        System.out.println("What placeholder is used for integers in printf()?");
        System.out.println("a. %s");
        System.out.println("b. %i");
        System.out.println("c. %d");
        System.out.println("d. %n");
        
        try {
            System.out.print("\nYour answer: ");
            String ans = scanner.nextLine();
            scanner.nextLine();
            if (ans.equals("c.") || ans.equals("c")) {
                System.out.println("Correct! %d is for integers.");
                score += 10;
            } else {
                System.out.println("Wrong! Use %d for integers.");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Invalid input!");
        }
        
        // Question 3
        System.out.println("\nQuestion 3/3:");
        System.out.println("How do you concatenate strings?");
        System.out.println("a. str1 + str2");
        System.out.println("b. str1.concat(str2)");
        System.out.println("c. Both 1 and 2");
        System.out.println("d. Neither");
        
        try {
            System.out.print("\nYour answer: ");
            String ans = scanner.nextLine();
            scanner.nextLine();
            if (ans.equals("c.") || ans.equals("c")) {
                System.out.println("Correct! Both methods work.");
                score += 10;
            } else {
                System.out.println("Wrong! Both + and concat() work.");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Invalid input!");
        }
        
        System.out.println("\n" + "-".repeat(60));
        System.out.println("Quiz Complete! Score: " + score + "/30");
        System.out.println("-".repeat(60));
        
        return score;
    }
}
