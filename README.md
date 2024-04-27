Change to the folder of where this sample project was installed (where the pom.xml file is located).
Now run `mvn clean install` and Maven will compile your project, 
and put the results into two jar files in the `target` directory.

You can now run the sample from the command line with
`java -jar target/javaparser-teamswift-1.0-SNAPSHOT-shaded.jar`.
This runs the sample program, Inspect, which reads, src/main/java/com/Student.java and then outputs a ast.dot which is a graphviz representation the AST
