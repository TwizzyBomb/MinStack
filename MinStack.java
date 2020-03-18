package com.company;

import java.util.LinkedList;
import java.util.List;

public class MinStack {

    private int minimum;
    private List<Node> minStack;

    public MinStack(){
        minStack = new LinkedList<Node>();
        minimum = Integer.MAX_VALUE;
    };

    public void push(Node n){
        /* if the current stack is empty we want to push a zero */
        if(this.minStack.isEmpty()) {
            minStack.add( n );
            minimum = n.getData();

        }
        /* if the current data is greater than min we want to retain
        min, and push data - min
        else we want to subtract current min from data, make new
        min, and push data into stack */
        if(n.getData() >= this.minimum){
            int temp = n.getData();
            n.setData(temp - this.minimum);

        }
        else {
            int temp = this.minimum;
            this.minimum = n.getData();
            n.setData(this.minimum - temp);

        }
        minStack.add(n);

    }

    /* shows the top element */
    public int top(){
        int lastElementIndex = minStack.size() - 1;
        return minStack.get( lastElementIndex ).getData();
    }

    /* pops the top element */
    public void pop(){
        int lastElementIndex = minStack.size() - 1;
        if(!minStack.isEmpty()){

            /* if top is less than zero we want to increase the minimum */
            if( (minStack.get( lastElementIndex ).getData() < 0) )
                minimum = minimum - minStack.get( lastElementIndex ).getData();

            minStack.remove( lastElementIndex );

        }
    }

    public boolean isEmpty(){
        return minStack.isEmpty();
    }

    public boolean isFull(){
        return !minStack.isEmpty();
    }

    public int getMinimum(){
        return this.minimum;
    }
}
