/* author: Adrian Brocke
This class contains the main method to illustrate my MinStack
 */

package com.company;

import java.util.Random;


public class Main {

    public static void main(String[] args) {

        /* generate a list of random integers */
        long seed = 10101010L;
        Random randNum = new Random(seed);
        MinStack minStack = new MinStack();
        System.out.println(" I am using the principle that we can keep track of minimum\n" +
                " values by memorizing them as they come in, and by doing so we can subtract\n" +
                " the min from new values we push, and do the reverse on the way back up. This\n" +
                " way we can keep track of min value changes by noticing when a value becomes \n" +
                " signed (negative)  ");

        for(int i = 0; i < 10; i ++){
            int num = Math.abs(  randNum.nextInt() % 20 );
            int currMin = minStack.getMinimum();
            minStack.push( new Node( num ) );
            System.out.println("Random Value:" + num +
                    " - " + currMin + " = " + (num - currMin) +
                    "    just pushed:" + minStack.top() +
                    ".    The current min is:" + minStack.getMinimum() );
        }

        System.out.println(" After all pushes ");

        for(int i = 0; i < 10; i ++){
            int num = minStack.top();
            minStack.pop();
            System.out.println("Just popped :" + num +
                    " + " + minStack.getMinimum() + " = " + (num + minStack.getMinimum()) +
                    "    original value:" + (num + minStack.getMinimum()) +
                    ".    The current min is:" + minStack.getMinimum() );

        }

    }
}
