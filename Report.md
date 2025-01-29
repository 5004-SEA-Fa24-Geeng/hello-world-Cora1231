# Homework Aloha World Report

The following report contains questions you need to answer as part of your submission for the homework assignment. 


## Design Doc
Please link your UML design file here. See resources in the assignment on how to
link an image in markdown. You may also use [mermaid] class diagrams if you prefer, if so, include the mermaid code here.  You DO NOT have to include Greeting.java as part of the diagram, just the AlohaWorld application that includes: [AlohaWorld.java], [Greeter.java], and [ConsoleView.java].



### Program Flow
Write a short paragraph detailing the flow of the program in your own words. This is to help you understand / trace the code (and give you practice of something called a code walk that will be required in this course).
   The program begins by asking the user for their name and locality selection through the ConsoleView class. This class validates the user’s input and allows them to retry if they provide invalid responses. 
   After gathering the name and locality, a Greeter object is initialized with this information. The Greeter class generates a customized greeting based on the chosen locality, which is displayed using the ConsoleView.printGreeting method. 
   The program then prompts the user to decide if they want to be greeted again. If the user responds with “yes,” the program repeats the process, letting them pick a new locality, update the Greeter object, and receive another greeting.
   This loop continues until the user enters “no,” at which point the program terminates. The program’s modular structure effectively separates input handling, greeting generation, and overall flow into distinct classes, resulting in clean and maintainable code.

## Assignment Questions

1. List three additional java syntax items you didn't know when reading the code.  (make sure to use * for the list items, see example below, the backtick marks are used to write code inline with markdown)
   
   * ‘Scanner SCANNER’
   * 'public static void'
   * 'Final'

2. For each syntax additional item listed above, explain what it does in your own words and then link a resource where you figured out what it does in the references section. 

    * In Java, the Scanner class, found in the java.util package, is used to capture input of primitive types such as int, double, and others, as well as strings[^1].
    * The static keyword is used to indicate that a particular member belongs to the class itself rather than to any specific instance of the class. This means that the static member is shared across all instances of the class.[^2].
    * In Java, the final keyword is used to indicate that a variable, method, or class cannot be modified or extended. [^3].

3. What does `main` do in Java? 

   main() method is in my word the engine of the whole program. If the main() is missing, the program will not execute. 


4. What does `toString()` do in Java? Why should any object class you create have a `toString()` method?

   For String values, the toString method returns the string itself (if it's a primitive) or the string that the String object wraps. It has the exact same implementation as String. prototype[^4]. It provides a clear, human-readable representation of your objects, which is helpful for debugging, logging, and understanding the object’s state. It also promotes consistency and enhances the usability of your objects, particularly when working with collections or displaying object information.

5. What is javadoc style commenting? What is it used for? 

   Javadoc is a unique form of comment in Java designed for documenting classes, methods, constructors, and other code components. It enables developers to create organized documentation that can be extracted and transformed into API documentation[^5].


6. Describe Test Driving Development (TDD) in your own words. 
   Writing tests before the actual code is implemented. 

        

7. Go to the [Markdown Playground](MarkdownPlayground.md) and add at least 3 different markdown elements you learned about by reading the markdown resources listed in the document. Additionally you need to add a mermaid class diagram (of your choice does not have to follow the assignment. However, if you did use mermaid for the assignment, you can just copy that there). Add the elements into the markdown file, so that the formatting changes are reserved to that file. 
classDiagram
    AlohaWorld --> ConsoleView : Uses
    ConsoleView --> Greeter : Uses

    class AlohaWorld {
        -AlohaWorld()
        +main(args: String[]): void
    }

    class ConsoleView {
        -SCANNER: scanner
        -LOCALITY_OPTIONS: List<String>
        +ConsoleView()
        +getName(): String
        +getLocality(): int
        +checkRunAgain(): boolean
        +printGreeting(greeting: String): void
    }

    class Greeter {
        -Name: String
        -locality: int
        -locality: List<String>
        -HAWAII: int
        -China: int
        -ITALY: int
        -DEFAULT_LOCALITY: int
        +Greeter(name: String)
        +Greeter(name: String, locality: int)
        +getName(): String
        +setLocality(locality: int): void
        +greet(): String
        +greet(asciiOnly: boolean): String
        +getLocalityString(): String
        +hashCode(): int
        +equals(obj: object): boolean
        +toString(): String
    }

## Deeper Thinking Questions

These questions require deeper thinking of the topic. We don't expect 100% correct answers, but we encourage you to think deeply and come up with a reasonable answer. 


### Why would we want to keep interaction with the client contained to ConsoleView?
   So from my perspective, keeping interaction with the client contained in ConsoleView promotes separation of concerns by isolating user input/output from business logic, improving modularity and maintainability. It follows the Single Responsibility Principle, ensuring that each class focuses on a specific task, making the code easier to understand and modify. This approach enhances testability by allowing easier simulation of user input, and provides flexibility for future changes

- Right now, the application isn't very dynamic in that it can be difficult to add new languages and greetings without modifying the code every time. Just thinking programmatically,  how could you make the application more dynamic? You are free to reference Geeting.java and how that could be used in your design.
  Maybe we can store the language and the greeting in an external database, which allows we to add or modify languages and greetings without modifying the code.



> [!IMPORTANT]
>  After you upload the files to your github (ideally you have been committing throughout this progress / after you answer every question) - make sure to look at your completed assignment on github/in the browser! You can make sure images are showing up/formatting is correct, etc. The TAs will actually look at your assignment on github, so it is important that it is formatted correctly.


## References

[^1]: Scanner Class in Java. https://www.geeksforgeeks.org/scanner-class-in-java/. Accessed: 2025-01-26

[^2]: Static and Final Keyword. https://www.datacamp.com/doc/java/static-and-final-keyword. Accessed: 2025-01-26

[^3]: Final keyword in Java: 2024. https://www.geeksforgeeks.org/final-keyword-in-java/. Accessed: 2025-01-27.

[^4]: String toString() Method in java with Examples. https://www.geeksforgeeks.org/string-tostring-method-in-java/. Accessed: 2025-01-27

[^5]: Javadoc. https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html. Accessed: 2025-01-27

[UML diagram](https://app.diagrams.net/#G1Vvpmt6BgJgBkEtb5UgBuijCGvd8pjNK1#%7B%22pageId%22%3A%2227C9NVqbexTvOaNnc5BV%22%7D)


<!-- This is a comment, below this link the links in the document are placed here to make ti easier to read. This is an optional style for markdown, and often as a student you will include the links inline. for example [mermaid](https://mermaid.js.org/intro/syntax-reference.html) -->
[mermaid]: https://mermaid.js.org/intro/syntax-reference.html
[AlohaWorld.java]: src/main/java/student/AlohaWorld.java
[Greeter.java]: src/main/java/student/Greeter.java
[ConsoleView.java]: src/main/java/student/ConsoleView.java





