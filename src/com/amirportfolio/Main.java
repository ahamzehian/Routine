package com.amirportfolio;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Practice routine = new Practice();
//        routine.commandsFunction();
        routine.executeCommand(args[0], Arrays.copyOfRange(args,1,args.length));

    }

}
