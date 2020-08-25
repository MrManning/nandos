# Mars Rover Technical Challenge
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. The idea is to navigate the plateau using hard-coded input.

Program and tests have been run in both IntelliJ Community and in the terminal on the macOS Catalina (10.15.4) environment. When running from the terminal run from the project root.

## Assumptions

- All input comes from a file named `input.txt`
- Rovers cannot be in the same position as another
- Current `input.txt` contains the example input and 2 new rover inputs

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