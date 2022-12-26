
package com.DFA;

import java.util.Scanner;

public class Main_stringMatching {
static char currentChar;
static char currentState;
static char[] LineCharArray;
static int LineCharArrayCount = 0;
    
    public static void main(String[] args) {
        
        //Scanner obj's
        Scanner inputScanner = new Scanner(System.in);
        //reading input
        DFA.GetDFATable();
        
        boolean userSatisfied = false;
        while( ! userSatisfied){
            System.out.println("Enter Desired Input String");
            String inputString = inputScanner.nextLine();
            if(inputString.contentEquals("no"))
                break;
            else{
                //converting into readable format
                LineCharArray = inputString.toCharArray();
                LineCharArrayCount = 0;
                //transitions start
                Algorithm();    //string matching algorithm
            }
        }
    }
    
    private static void Algorithm() {
            //Algorithm used to match a DFA Table against a string
        currentState = DFA.InitialState();     //denotes current state
        currentChar = NextChar();       //current character from the input string
        while(currentChar != '$'){
            currentState = Move(currentState,currentChar);
            currentChar = NextChar();
        }
        //checking if input is correct or not
        System.out.println(FinalStateChecker());
    }
    
    private static char NextChar() {
        if(LineCharArray == null || LineCharArrayCount  == LineCharArray.length){
            return '$';
        }else{
            return LineCharArray[LineCharArrayCount++];
        }
    }
    
    private static char Move(char currentstate,char currentchar) {
        return DFA.NextState(currentstate,currentchar);
    }

    private static String FinalStateChecker() {
            if(DFA.FinalState(currentState)) {
                return "ACCEPTED";
            }else {
                return "REJECTED";
            }
        }
}