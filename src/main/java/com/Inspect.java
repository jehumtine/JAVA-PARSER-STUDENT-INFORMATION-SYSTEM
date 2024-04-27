package com;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.DotPrinter;
import com.github.javaparser.printer.YamlPrinter;
public class Inspect {
    static int totalTokens = 0;
    public static void main(String[] args) throws IOException {
        String filePath = "/home/jehu/Documents/JAVA PARSER STUDENT INFORMATION SYSTEM/src/main/java/com/Student.java";
        Map<String, Integer> tokenKindCount = new HashMap<>();
        try {
            // Parse the Java file
            CompilationUnit cu = StaticJavaParser.parse(new FileInputStream(filePath));
            
            // Print total number of tokens
            cu.getTokenRange().get().forEach(t -> {
                totalTokens++;
            });
            System.out.println(totalTokens);

            //Get kind of tokens and how many of each type
            cu.getTokenRange().get().forEach(t -> {
                //int kind = t.getKind();
                com.github.javaparser.JavaToken.Kind kind = com.github.javaparser.JavaToken.Kind.valueOf(t.getKind());
                tokenKindCount.put(kind.toString(),tokenKindCount.getOrDefault(kind.toString(), 0)+1);
            });
            tokenKindCount.forEach((kind, count) -> System.out.println(kind + ": " + count));

            // Print the AST
            
            YamlPrinter printerYaml = new YamlPrinter(true);
            System.out.println(printerYaml.output(cu));
            
            DotPrinter printer = new DotPrinter(false);
            try (FileWriter fileWriter = new FileWriter("ast.dot");
                PrintWriter printWriter = new PrintWriter(fileWriter)){
                    printWriter.print(printer.output(cu));
                }
            //System.out.println(printer.output(cu));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }    
    }

    
}
