# MorseCode.S
# Feb 27, 2020
// Michael Torres
// Checks a morse code table to convert a string of binary into morse code and returns the letter
#--------------------------------------------------------------------
.macro pushall
push r16
push r17
push r18
push r19
push r20
push r21
push r22
push r23
push r24
push r25
push r26
push r27
push r28
push r29
push r30
push r31
.endm ; of pushall

.macro popall
pop r31
pop r30
pop r29
pop r28
pop r27
pop r26
pop r25
pop r24
pop r23
pop r22
pop r21
pop r20
pop r19
pop r18
pop r17
pop r16
.endm ; of popall
    
    
    .data
morse_table: # binary representation of Morse code: 0: dot; 1: dash
    .byte 0b01, 0b1000, 0b1010, 0b100, 0b0, 0b0010, 0b110, 0b0, 0b0, 0b0111, 0b101, 0b0100, 0b11, 0b10, 0b111, 0b110, 0b1101, 0b10, 0b0, 0b1, 0b001, 0b1, 0b11, 0b1001, 0b1011, 0b1100, 0b1111, 0b111, 0b11, 0b1, 0b0, 0b10000, 0b11000, 0b11100, 0b11110, 0b11111
morse_width: # the number of binary digits in each character
    .byte 2, 4, 4, 3, 1, 4, 3, 4, 2, 4, 3, 4, 2, 2, 3, 4, 4, 3, 3, 1, 3, 4, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5
ascii_table: # the English symbols encoded by the above Morse code 
    .byte 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
table_length:
    .byte 36

    .comm val, 1
    .comm width, 1
    .comm ascii, 1
    .global val, ascii, width

#---------------------------------------------------------------------
    .text
    .global decode_morse


decode_morse:
    pushall
    push R31
    push R30
    push R29
    push R28
    push R27
    push R26
    push R24
    push R22
    push R21
    push R20
    push R17
    push R16
    
    LDI R31, hi8(morse_table) ; initialize high byte of Z
    LDI R30, lo8(morse_table) ; initialize low byte of Z
    LDI R29, hi8(ascii_table) ; initialize high byte of Y
    LDI R28, lo8(ascii_table) ; initialize low byte of Y
    LDI R27, hi8(morse_width) ; initialize high byte of X
    LDI R26, lo8(morse_width) ; initialize low byte of X

    # ENTER YOUR CODE BELOW
    lds r16, val
    lds r17, width

match:
    ld r20, X+
    ld r21, Y+
    ld r22, Z+
    cp r22, r16 //compare val with array
    brne match
    cp r20, r17 //if val is a match, compare width
    brne match
    sts ascii, r21  //if both val and width are matches, store ascii
    
done:
    pop R16
    pop R17
    pop R20
    pop R21
    pop R22
    pop R24
    pop R26
    pop R27
    pop R28
    pop R29
    pop R30
    pop R31
    popall
    RET
