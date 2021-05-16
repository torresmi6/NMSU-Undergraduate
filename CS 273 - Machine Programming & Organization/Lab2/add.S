
#
# Global data (x1, x2, and x3)
#
    .data
    .comm x1,1
    .global x1
    .comm x2,1
    .global x2
    .comm x3,1
    .global x3

#
# Program code (addition function)
#
    .text
    .global addition
addition:
    ldi  R18, 0b00100000
    out  0x04, R18
    ldi  R18, 0b00100000
    out  0x05, R18
    lds  r18, x1
    lds  r19, x2
    lds  r20, x3
    // Loaded registers 21, 22, and 23 with numbers needed in the calculation
    ldi  r21, 1
    ldi  r22, -1
    ldi  r23, -3
    // Adds 1 to x1, -1 to x2, and -3 to x3
    //  then doubles x1 by adding it to itself and then adds x2 and x3 to x1
    add  r18, r21
    add  r19, r22
    add  r20, r23
    add  r18, r18
    add  r18, r19
    add  r18, r20
    sts  x3, r18
    ret
    
