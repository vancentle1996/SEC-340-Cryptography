/***************************************
** Class : SEC 340 Cryptography 
** Instructor : Dr. Bai
** Author : Hai Le
** Due Date : Feb 11th, 2021
***************************************/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


public class HVLAdvancedProj1
{
      
    //This method does necessary calculations to
    //determine if the data can form a magic square
    //Return true if it is a magic square 
    static boolean isMagicSquare(int mat[][]) 
    { 
        int len = mat.length;
          
        //Calculate the sum of left-to-right diagonal
        int sum = 0; 
        for (int i = 0; i < len; i++){ 
            sum = sum + mat[i][i]; 
        }
  
        //Calculate the sum of rows
        for(int i = 0; i < len; i++) { 
            int rowSum = 0; 
            for (int j = 0; j < len; j++) 
            {
                rowSum += mat[i][j]; 
            }
            //Check if sum of left-to-right diagonal is equal to sum of rows 
            if (rowSum != sum) 
                return false; 
        } 
        
        //Calculate the sum of columns
        for (int i = 0; i < len; i++) { 
            int colSum = 0; 
            for (int j = 0; j < len; j++) 
                colSum += mat[j][i]; 
  
            //Check if sum of left-to-right diagonal is equal to sum of columns 
            if (sum != colSum) 
                return false; 
        } 
  
        return true; 
    } 
   public static void main (String[] args) throws FileNotFoundException, IOException
   {     
         //Initialize variables
         String data = "";
         int row = 0;
         int size = 0;
         int [][] matrix = null;
         Scanner s = new Scanner(System.in);
         
         System.out.print("Please enter file name here (filename.txt format): ");
         String fname = s.nextLine();
         
         //Read file
     		File f = new File(fname);
         Scanner sc = new Scanner(f);
         
         while(sc.hasNextLine()) {
            //Split each line of numbers into individual ones
            //and store them into the array of strings
            String[] line = sc.nextLine().trim().split("\t"); 
            
            if (matrix == null) {
                size = line.length;
                matrix = new int[size][size]; //Create the matrix based on provided values
            }

            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.valueOf(line[col].trim()); //Convert each individual number in form of string into integers
            }
            row++;
         }
         
         if (isMagicSquare(matrix)){
            System.out.println("Magic Square!");
         } else {
            System.out.println("NOT Magic Square!");
         }
   }
}
