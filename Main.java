/*
Name: Maroof Sulaiman
Date: July 14th, 2024
Purpose of Program: To come up with and create a program that will 'show what I know' by implementing the use of arrays and loops together to complete a task. The program I have created is a conversion and analysis tool for the user to convert and analyze data regarding temperature (Celsius to Fahrenheit), pressure (ATP to kPa), distance (in to m) and currency (CAD TO USD). 
*/

import java.util.Scanner;         //Import scanner object

public class Main {

  static final int NUM_INPUTS = 10;                      //Size of array 
  static final double CONVERSION_RATE_CADTOUSD = 0.7330;   //Conversion rate for CAD to USD (As of Jul 14, 8:23:00 PM UTC) that can be changed easily across the program
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);      //Instantiate Scanner object

    //Declaring and initializing input values array
    double[] inputValues = new double[NUM_INPUTS];
    //Declaring and initializing converted values array
    double[] convertedValues = new double[NUM_INPUTS];           
    //Declaring and initializing variables
    double convertedValue;                        
    double total = 0;
    int conversionType = 0;
    String context;
    String context2;
    double max;
    double average;
    
    //Welcome and explanation for purpose of the program and how to use it
    System.out.println("Welcome to my conversion and analysis tool!");
    System.out.println("");
    System.out.println("In this program you can convert between different temperatures, pressures, distances and currency (CAD to USD).");
    System.out.println("");
    System.out.println("After choosing your desired conversion, the program will prompt you to enter 10 values that you want to convert. It will then output the converted values and provide the average and max values of your specific conversion. Ex.'The average currency value is ___' or 'The maximum temperature is ___'.");

    System.out.println("");
    System.out.println("Select a conversion type:");
    System.out.println("1. \u00B0C to \u00B0F");
    System.out.println("2. ATP to kPa");
    System.out.println("3. in to m");
    System.out.println("4. CAD to USD");
    System.out.println("5. Exit");
    System.out.println("");
    System.out.print("Enter a number between 1 and 5 to continue: ");

    //Take user input for selected conversion type
    conversionType = input.nextInt();      

    //Switch statement to determine context keywords for output statements based on the selected conversion type

    switch (conversionType) {
      case 1:
        context = "temperature";
        context2 = "\u00B0F";
        break;
      case 2:
        context = "pressure";
        context2 = "kPa";
        break;
      case 3:
        context = "distance";
        context2 = " meters";
        break;
      case 4:
        context = "currency value";
        context2 = " USD";
        break;
      case 5:
        System.out.println("Exiting program...");
        System.exit(0);
      default:
        System.out.println("Invalid selection, please enter a number between 1 and 5.");
        return;
    }

    //Gather user input for the input values array
    System.out.println("Enter " + NUM_INPUTS + " values to be converted. Press enter to confirm after each entry:  ");
    System.out.println("");

    //Read user input values until the array is full
    for (int i = 0; i < NUM_INPUTS; i++) 
    {
      inputValues[i] = input.nextDouble();
    }

    //Initialize max value to the first value in the inputValues array
    max = convertedValues[0];

    //Loop to convert all input values based on the selected conversion type
    for (int i = 0; i < NUM_INPUTS; i++) 
    {
      convertedValue = 0;
      switch (conversionType) 
      {
        case 1: 
          convertedValue = (inputValues[i] * 9/5) + 32;
          break;
        case 2:
          convertedValue = inputValues[i] * 101.3;
          break;
        case 3:
          convertedValue = inputValues[i] * 0.0254;   
          break;
        case 4:
          convertedValue = inputValues[i] * CONVERSION_RATE_CADTOUSD;
          break;
      }

      //Store all final converted values into the convertedValues array and add the converted value to the total
      convertedValues[i] = convertedValue;
      total += convertedValue;

      //Check if the current converted value being dealt with is greater than the current max value
      if (convertedValue > max) 
      {
        max = convertedValue;
      }
    }

    //Calculate average and round it off to two decimal places
    average = total / NUM_INPUTS;
    average = average * 100;
    average = Math.round(average);
    average = average / 100;

    //Print statement for outputting the converted values
    System.out.println("");
    System.out.println("The converted values are: ");
    System.out.println("");

    //Round off the converted values to 4 decimal places and then output the converted values
    for (double value : convertedValues)
      {
        value = value * 10000;
        value = Math.round(value);
        value = value / 10000;
        System.out.println(value);
      }

    //Round off the max value to two decimal places
    max = max * 100;
    max = Math.round(max);
    max = max / 100;

    //Print statements for the maximum and average values in the data set with context specific keywords based on the selected conversion 
    System.out.println("The max " + context + " is " + max + context2 + ".");
    System.out.println("The average " + context + " is " + average + context2 + ".");

    //Close scanner object
    input.close();    
  }
}
