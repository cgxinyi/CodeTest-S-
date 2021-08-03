package com.example.demo;

import java.util.*;

public class validation {
    public String acceptStringInput(String displayMessage)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(displayMessage);
        String userInput = "";
        boolean valid=false;
        try
        { 
            while(valid==false)
            {
                userInput = input.nextLine();
                valid = checkStringNotEmptyOrBlank(userInput);
            } 
        }
        catch(Exception e)
        {
            System.out.println("Please enter String only!");
        }
        return userInput;
        
    }

    public int acceptIntegerInput(String displayMessage)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(displayMessage);
        int userInput = 0;
        boolean valid=false;

        do{
            try
            {       
                userInput = input.nextInt();
                valid=true;
            }
            catch(Exception e)
            {
                System.out.println("Please enter integer only!");
                valid=false;
                input.next();
            }
        
        }while(valid==false);
        return userInput; 
    } 

    public boolean checkStringNotEmptyOrBlank(String userInput)
    {
        if(userInput.trim().equals("")|| userInput.trim().equals(" "))
        {
                System.out.println("Cannot be empty!");
                return false;
        }
        return true;
    }

    public boolean checkStringNotContainsNumber(String userInput)
    {
        if(userInput.matches(".*\\d.*"))
        {
            System.out.println("Cannot contains number!");
            return false;
        }
    return true;
    }

    public boolean checkIntegerWithinRange(int userInput,int min,int max)
    {
        if(userInput<=min || userInput>=max)
        {
            System.out.println("Please enter the value between " + min + " to " + max);
            return false;
        }
    return true;
    }

    public boolean checkStringLength(String msg, String userInput)
    {
        if(userInput.length()!=3)
        {
            System.out.println("Please enter the " + msg + " to MMM format!");
            return false;
        }
    return true;
    }

    public boolean checkInputIsMonth(String userInput)
    {
        boolean valid = false;
        if(userInput.toLowerCase().equals("jan"))
        {
            valid = true;
        }
        else if(userInput.toLowerCase().equals("feb"))
        {
            valid = true;
        }
        else if(userInput.toLowerCase().equals("mar"))
        {
            valid = true;
        }
        else if(userInput.toLowerCase().equals("apr"))
        {
            valid = true;
        }
        else if(userInput.toLowerCase().equals("may"))
        {
            valid = true;
        }
        else if(userInput.toLowerCase().equals("jun"))
        {
            valid = true;
        }
        else if(userInput.toLowerCase().equals("jul"))
        {
            valid = true;
        }
        else if(userInput.toLowerCase().equals("aug"))
        {
            valid = true;
        }
        else if(userInput.toLowerCase().equals("sep"))
        {
            valid = true;
        }
        else if(userInput.toLowerCase().equals("oct"))
        {
            valid = true;
        }
        else if(userInput.toLowerCase().equals("nov"))
        {
            valid = true;
        }
        else if(userInput.toLowerCase().equals("dec"))
        {
            valid = true;
        }
        else
        {
            System.out.println("Please enter correct MMM format, for example: Jan");
            valid = false;
        }
       
        return valid;
    }

    public String validMonth(String userInput)
    {
        String month="";
        String payperiod ="";
        if(userInput.toLowerCase().equals("jan"))
        {
            month="Jan";
            payperiod ="01 "+ month + " - " + "31 " + month;
        }
        else if(userInput.toLowerCase().equals("feb"))
        {
            month="Feb";
            payperiod ="01 "+ month + " - " + "31 " + month;
        }
        else if(userInput.toLowerCase().equals("mar"))
        {
            month="Mar";
            payperiod ="01 "+ month + " - " + "31 " + month;
        }
        else if(userInput.toLowerCase().equals("apr"))
        {
            month="Apr";
            payperiod ="01 "+ month + " - " + "31 " + month;
        }
        else if(userInput.toLowerCase().equals("may"))
        {
            month="May";
            payperiod ="01 "+ month + " - " + "31 " + month;
        }
        else if(userInput.toLowerCase().equals("jun"))
        {
            month="Jun";
            payperiod ="01 "+ month + " - " + "31 " + month;
        }
        else if(userInput.toLowerCase().equals("jul"))
        {
            month="Jul";
            payperiod ="01 "+ month + " - " + "31 " + month;
        }
        else if(userInput.toLowerCase().equals("aug"))
        {
            month="Aug";
            payperiod ="01 "+ month + " - " + "31 " + month;
        }
        else if(userInput.toLowerCase().equals("sep"))
        {
            month="Sep";
            payperiod ="01 "+ month + " - " + "31 " + month;
        }
        else if(userInput.toLowerCase().equals("oct"))
        {
            month="Oct";
            payperiod ="01 "+ month + " - " + "31 " + month;
        }
        else if(userInput.toLowerCase().equals("nov"))
        {
            month="Nov";
            payperiod ="01 "+ month + " - " + "31 " + month;
        }
        else if(userInput.toLowerCase().equals("dec"))
        {
            month="Dec";
            payperiod ="01 "+ month + " - " + "31 " + month;
        }
        
        return payperiod;
    }
}

