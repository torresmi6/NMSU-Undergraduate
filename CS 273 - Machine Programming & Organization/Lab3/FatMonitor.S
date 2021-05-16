// Questions
// Gender   Hex   Age   Hex   Body Fat  Hex   Light
// F        01    42    2A    32        20    Green
// M        02    25    19    48        30    All
// F        01    30    1E    21        15    Green
// M        02    23    17    17        11    Green
.data
.comm gender, 1
.global gender
.comm age, 1
.global age
.comm fat, 1
.global fat


.text
.global lightup
lightup:

        lds r18, gender     // load gender into a register
        lds r19, age        // load age into a register
        lds r20, fat        // load fat into a register

        CPI r18, 0x01
        BREQ female
        CPI r18, 0x02
        BREQ male

female:
        CPI r19, 20
        BRLO fl20
        CPI r19, 40
        BRLO fl40
        CPI r19, 60
        BRLO fl60
        jmp fl80

fl20:
        ret
fl40:
        CPI r20, 21
        BRLO low
        CPI r20, 33
        BRLO norm
        CPI r20, 39
        BRLO hi
        jmp vh

fl60:
        CPI r20, 23
        BRLO low
        CPI r20, 34
        BRLO norm
        CPI r20, 40
        BRLO hi
        jmp vh

fl80:
        CPI r20, 24
        BRLO low
        CPI r20, 36
        BRLO norm
        CPI r20, 42
        BRLO hi
        jmp vh

// Stores r23 with correct led binary number then goes to blink
// If all are needed, no need to blnk
low:
        //store binary in register for blue light
        ldi r23, 0b00100000
        jmp lightled
norm:
        //store binary in register for green light
        ldi r23, 0b00010000
        jmp lightled
hi:
        //store binary in register for red light
        ldi r23, 0b00000001
        jmp lightled
vh:
        //store binary in register for all lights
        ldi r23, 0b00110001
        out 0x04, r23
        out 0x05, r23
        ret
male:

        CPI r19, 20
        BRLO ml20
        CPI r19, 40
        BRLO ml40
        CPI r19, 60
        BRLO ml60
        jmp ml80
ml20:
        ret
ml40:
        CPI r20, 8
        BRLO low
        CPI r20, 20
        BRLO norm
        CPI r20, 25
        BRLO hi
        jmp vh

ml60:
        CPI r20, 11
        BRLO low
        CPI r20, 22
        BRLO norm
        CPI r20, 28
        BRLO hi
        jmp vh

ml80:
        CPI r20, 13
        BRLO low
        CPI r20, 25
        BRLO norm
        CPI r20, 30
        BRLO hi
        jmp vh
        
// Loop to blink
// Uses r23 for which led to blink 
lightled:    
      mov    r17, r23
      out    0x04, r17
      ldi    r16, 150
all:  mov    r17, r23
      out    0x05, r17
      ldi    r18, 0xff
dl1:  ldi    r19, 0xff
dl2:  nop
      nop
      nop
      nop
      dec    r19
      brne   dl2
      dec    r18
      brne   dl1
      ldi    r17, 0x00
      out    0x05, r17
      ldi    r18, 0xff
dl3:  ldi    r19, 0xff
dl4:  nop
      nop
      nop
      nop
      dec    r19
      brne   dl4
      dec    r18
      brne   dl3
      dec    r16
      brne   all
      ret
