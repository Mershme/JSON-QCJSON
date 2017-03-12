package Sandbox;

import JSON.JSONException;
import JSON.JSONInputStream;
import JSON.JSONOutputStream;
import JSON.JSONUtilities;

import java.io.*;
import java.util.*;

public class example {
    public static void main(String[] args) {

        // Writes objects
        // firstName, lastName, cardNumber, expiredDate
        customerInfo sterling = new customerInfo("Sterling", "Massey", "4802095674", "sterlingmassey@gmail.com");

        try {
            // Stringify takes any object, prints it out, and converts it to JSON
            String js = JSONUtilities.stringify(sterling);
            // Prints the string that has been stringified
            System.out.println(js);
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }

        customerInfo jake = new customerInfo("Jake", "Martin", "4808729879", "coolBroJake@hotmail.com");

        File test = new File("test.json");

        try {
            FileOutputStream fileOutput = new FileOutputStream(test);
            // Writes to JSON
            JSONOutputStream jsonOutput = new JSONOutputStream(fileOutput);
            jsonOutput.writeObject(jake);
            jsonOutput.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        // Reads object back from file
        try {
            // Creates FileInputStream
            FileInputStream fileInput = new FileInputStream(test);
            // Creates JSONInputStream
            JSONInputStream jsonInput = new JSONInputStream(fileInput);

            // Creates HashMap
            HashMap mapJson = (HashMap)jsonInput.readObject();
            jsonInput.close();

            
            // Creates new object
            customerInfo jake2 = new customerInfo();
            jake2.setFirstName((String)mapJson.get("firstName"));
            jake2.setLastName((String)mapJson.get("lastName"));
            jake2.setPhoneNumber((String)mapJson.get("phoneNumber"));
            jake2.setEmail((String)mapJson.get("email"));

            // Stingifies the object with the info from above
            String js1 =  JSONUtilities.stringify(jake2);
            // prints out the stringified object
            System.out.println(js1);


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        // All of the following are Nasty Paths
        // Tries to read a file that does not have correct permissions
        try {
            FileInputStream fileInput = new FileInputStream("noAccess.json");
            JSONInputStream jsonInput = new JSONInputStream(fileInput);

            jsonInput.close();

        }
        catch(Exception e)
        {
            System.out.println("Unable to read file without permissions!");
        }

        // Tries to write a file that does not have correct permissions
        try {

            FileOutputStream fileOutput = new FileOutputStream("noAccess.json");
            JSONOutputStream jsonOutput = new JSONOutputStream(fileOutput);
            jsonOutput.writeObject(jake);
            jsonOutput.close();

        }
        catch(Exception e)
        {
            System.out.println("Unable to write file without permissions!");
        }



        // Tries to read a null object
        try {
            FileInputStream fileInput = new FileInputStream("null.txt");
            JSONInputStream jsonInput = new JSONInputStream(fileInput);

            HashMap mapJson = (HashMap)jsonInput.readObject();
            jsonInput.close();


        }
        catch(Exception e)
        {
            System.out.println("Unable to read null object!");
        }

    }
}