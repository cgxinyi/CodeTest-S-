import java.util.*;

public class validation {
    public String acceptStringInput(String displayMessage)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(displayMessage);
        String userInput = "";
        try
        { 
            while(userInput.equals("")|| userInput.equals(" "))
            {
                userInput = input.nextLine();
                if(userInput.equals("")|| userInput.equals(" "))
                System.out.println("Cannot be empty!");
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
}
