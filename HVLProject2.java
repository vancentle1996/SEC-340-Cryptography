/***************************************
** Class : SEC 340 Cryptography 
** Instructor : Dr. Bai
** Author : Hai Le
** Assignment : Project 2
** Due Date : Feb 25th, 2021
***************************************/

import java.util.Scanner; 
import java.util.*;

/* This program will encrypt and decrypt 
a message using Caesar cipher algorithm*/
public class HVLProject2 
{ 
   
   /* This method accepts 2 arguments:
    * 1. Plaintext (string)
    * 2. A key (or offset as an integer) 
    * It encrypts the input message according to an input key
    * Then display the ciphered string reprresentation of the plaintext*/
   static String cipher(String inputMsg, int offset) 
   {
      String encryptedText = "";
      char ch;
      
      // Encryption starts
      for(int i = 0; i < inputMsg.length(); ++i){
      
         // Loop through each character in the plaintext string 
         // results are ASCII values
			ch = inputMsg.charAt(i); 
			
         // Checks if a character in the plaintext string a lower-case letter
			if(ch >= 'a' && ch <= 'z'){
               
               // If it is a lower case letter, shift forward to the appropriate 
               // place in the alphabet depends on the offset value
	            ch = (char)(ch + offset);
	            
               // This block is used to make sure that we don't
               // go over z, if a character is greater than lower-case z, 
               // we go back to lower-case a
	            if(ch > 'z'){
	                ch = (char)(ch - 'z' + 'a' - 1);
	            }
               
	            encryptedText += ch;
	        }
           
           // This does the same thing as the if statement above, 
           // but it is for upper-case letters
	        else if(ch >= 'A' && ch <= 'Z'){
	            ch = (char)(ch + offset);
	            
	            if(ch > 'Z'){
	                ch = (char)(ch - 'Z' + 'A' - 1);
	            }
	            
	            encryptedText += ch;
	        }
           
           // Handles other character, like the dot (.) in the sample
	        else {
	        	encryptedText += ch; 
	        }
		}
      
      return encryptedText;
      
   }
   
   /* This method accepts 2 arguments:
    * 1. A ciphered string 
    * 2. A key (or offset as an integer) 
    * It decrypts the input ciphered message according to an input key
    * Then display the plaintext reprresentation of the ciphered text*/
   static String decipher(String inputMsg, int offset) 
   {
   
      String decryptedText = "";
      char ch;
      
      // Decryption starts
      for(int i = 0; i < inputMsg.length(); ++i){
         
         // Loop through each character in the ciphered string - results are ASCII values
			ch = inputMsg.charAt(i); 			
         
         // Checks if a character in the ciphered string a lower-case letter
			if(ch >= 'a' && ch <= 'z'){
         
               // If it is a lower case letter, shift backward to the appropriate 
               // place in the alphabet depends on the offset value
	            ch = (char)(ch - offset);
	            
               // Make sure we don't go over z
	            if(ch < 'a'){
	                ch = (char)(ch + 'z' - 'a' + 1);
	            }
	            
	            decryptedText += ch;
	        }
           
           // This does the same thing as the if statement above, 
           // but it is for upper-case letters
	        else if(ch >= 'A' && ch <= 'Z'){
	            ch = (char)(ch - offset);
	            
	            if(ch < 'A'){
	                ch = (char)(ch + 'Z' - 'A' + 1);
	            }
	            
	            decryptedText += ch;
	        }
           
           // Handles other character, like the dot (.) in the sample
	        else {
	        	decryptedText += ch; 
	        }
		}
      return decryptedText;

   }

 
   public static void main (String[] args)
   { 
      Scanner sc = new Scanner(System.in);
      
      //Variable initialization
      String yesOrNo = "y";
      final int offset = 3;
      
      // Keep asking if the user wants to continue the process
      // until "n" is entered to stop the program
      while (yesOrNo.equals("y"))
      {
         int choice = 0;
      
         System.out.println("Please enter 1 (to encrypt) or 2 (to decrypt): ");
         choice = sc.nextInt();
         
         sc.nextLine();
         
         if(choice == 1) // Indicates encryption
         {
            System.out.println("Please enter the message you wish to encrypt: ");
            String plaintext = sc.nextLine();
            System.out.println();
            
            System.out.println("The ciphertext (with an offset of 3) is: ");
            System.out.println(cipher(plaintext, offset).toString());
         }
         
         if (choice == 2) // Indicates decryption
         {
            System.out.println("Please enter the ciphertext you wish to decrypt: ");
            String ciphertext = sc.nextLine();
            System.out.println();

            System.out.println("The plaintext (with an offset of 3) is: ");
            System.out.println(decipher(ciphertext, offset).toString());
            
         }
         System.out.println();
         System.out.println("Do you want to continue? y/n: ");
         yesOrNo = sc.next();
         
      } 
      
   }
}