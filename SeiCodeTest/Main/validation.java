package Main;
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
        if(userInput.trim().equals("")|| userInput.trim().equals(" ")){
                System.out.println("Cannot be empty!");
                return false;
        }
        return true;
    }
}
