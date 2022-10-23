/*
 * This Program tracks your spending while you're shopping.
 * 
 * @author Vy Nguyen, Chris Stark
 * @version 5 October, 2022
 */

import java.util.Scanner;

public class SpendingSpree {
    
    //declaring global constant variables to ref in code below
    public static final double MAX_LIMIT = 100.0;
    public static final int MAX_ITEMS = 3;

    //Quick Notes: main method only takes in static VARIABLES

    public static void main(String[] args) {

        //declare vars
        int numItems = 0;
        double totalSpent = 0;
        double amountLeft = 0;

        Scanner in = new Scanner(System.in);
        System.out.printf("\n⭐️ You have $%.1f to spend, but are limited to only %1d items! ⭐️\n", MAX_LIMIT, MAX_ITEMS);
        
        //this loop will break, once numItems && totalSpent reaches correspondent LIMITS
        while (numItems < MAX_ITEMS && totalSpent <= MAX_LIMIT) { 
            //once the loop enters, numItem will become 1
            numItems++;
        
            //here we are dynamically referencing the item number in the print
            System.out.printf("\nCost of item #%1d: $", numItems);
            double cost = in.nextDouble();

            //ensures input is between $1 - $100 && this is our input validation
            while (cost <= 0 || cost > MAX_LIMIT) {
                System.out.println("Your input is either too high or too low. Try again!\n");
                System.out.printf("Cost of item #%1d: $", numItems);
                //prompt the use to enter the cost again since they entered the wrong amount
                cost = in.nextDouble();
            } 
            
            //ensures cost or numItems is b/w the limit we set. will break if otherwise
            if (cost < MAX_LIMIT || numItems < MAX_ITEMS) {
                
                totalSpent += cost; //only if the condition is true, will the cost be added to totalSpent

                //Once added, ensures use still has money to spend
                if (totalSpent < MAX_LIMIT) {
                    System.out.println("\nPerfect, you can buy this!🤑");
                    //if total spent is lower than max limit, then find out amountLeft
                    amountLeft = MAX_LIMIT - totalSpent;
                    if (numItems == MAX_ITEMS) {
                        System.out.printf("You have $%.1f leftover after buying %1d items. Bye! 🤗 \n", amountLeft, MAX_ITEMS);

                    } else {
                        System.out.printf("You have $%.1f left to spend on %1d items(s).\n", amountLeft, MAX_ITEMS - numItems);
                    }

                } else if (cost > amountLeft) { //checking if the user is trying to spend more than they have
                    if (numItems != 1) { //only check for item 2 & 3
                        System.out.printf("You only have $%.1f left to spend on %1d items(s). Buy something else!\n", amountLeft, MAX_ITEMS - numItems);
                        totalSpent -= cost; //user enter in wrong, have to substract
                        numItems--;
                    } else { //this handles item 1
                        System.out.printf("\nWowza, you're out of money! That was a high purchase 🙈.\nYou bought %1d item(s) 🛍 ", numItems);
                        break;
                    }

                } else { //once they spent all money
                    System.out.printf("\nShopping done! You bought %1d item(s). 🛍 ", numItems);
                    break;
                }
                

            } 
          
        }

    }

}