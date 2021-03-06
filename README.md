# Mars Rover Technical Challenge
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. The idea is to navigate the plateau using hard-coded input.

Program and tests have been run in both IntelliJ Community and in the terminal on the macOS Catalina (10.15.4) environment running Java 8. When running from the terminal run from the project root.

JUnit files are located in the `lib` folder for convenience.

## Assumptions

- All input comes from a file e.g. `src/input.txt` which is supplied but can be substituted
- Rovers cannot be in the same position as another
- Current `src/input.txt` contains the example input and 2 new rover inputs
- After plateau size on first input line, every 2 lines is a new rover and set of instructions
- There will never be more than 1 continuous line of either new rovers or instructions

## Running

### Program
Compiles the files

`javac -d bin -cp bin src/com/nandos/*.java`

Runs the program

`java -cp bin com/nandos/Mars`

### Tests
Compiles the tests

`javac -d bin -cp bin:lib/junit-platform-console-standalone-1.6.2.jar src/com/nandos/tests/*.java`

Runs the tests

`java -jar lib/junit-platform-console-standalone-1.6.2.jar -cp bin --scan-classpath`