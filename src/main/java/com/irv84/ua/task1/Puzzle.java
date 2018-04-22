package com.irv84.ua.task1;

//Java class has three int fields which may be changed in the limited range:
//        int a; // may change from a1 to a2
//        int b; // may change from b1 to b2
//        int c; // may change from c1 to c2
//        where a1, a2, ... are some constants.
// Implement hashCode method for this class without collisions (assuming that the product of ranges does not exceed Integer.MAX_VALUE).




class Puzzle {
    int a;
    int b;
    int c;

    public Puzzle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
         public int hashCode()
         {

             final int prime = 31;
             int result = 1;
             result = prime * result + a;
             result = prime * result + b;
             result = prime * result + c;
             return result;
         }
}

