package com.amirportfolio;

import java.util.Arrays;

public class Practice {

    public final String HELP = "help";
    public final String DUPLICATE_COUNT = "duplicateCount";
    public final String CONVERT_TO_CAMEL_CASE = "convertToCamelCase";
    public final String BRACES_VALIDITY_CHECK = "bracesValidityCheck";

    public void executeCommand(String command, String[] arguments){
        switch(command){
            case DUPLICATE_COUNT:
                DuplicateCount.main(arguments);
            case CONVERT_TO_CAMEL_CASE:
                ConvertToCamelCase.main(arguments);
            case BRACES_VALIDITY_CHECK:
                BracesValidityCheck.main(arguments);
            case HELP:
                commandsFunction();
        }
    }

    public void commandsFunction(){
        System.out.println(DUPLICATE_COUNT + ": " +  new DuplicateCount().details);
        System.out.println(CONVERT_TO_CAMEL_CASE + ": " + new ConvertToCamelCase().details);
        System.out.println(BRACES_VALIDITY_CHECK + ": " + new BracesValidityCheck().details);
    }

}
