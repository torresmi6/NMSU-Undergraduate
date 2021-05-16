// GoAggies.S
// Feb 27, 2020
// Michael Torres
// Flashes the word "GOAGGIES" in morse code
.extern delay
.data
.comm val, 1
.global val
.comm width, 1
.global width
.comm ascii, 1
.global ascii


.text
.global goaggies
goaggies:

        call G
        call O
        call A
        call G
        call G
        call I
        call E
        call S
        ret
G:
        call LONG
        call LONG
        call SHORT
        ret
O:
        call LONG
        call LONG
        call LONG
        ret
A:
        call SHORT
        call LONG
        ret
I:
        call SHORT
        call SHORT
        ret
E:
        call SHORT
        ret
S:
        call SHORT
        call SHORT
        call SHORT
        ret        
LONG:
      ldi r16, 0x20
      out 0x04, r16
      out 0x05, r16
      call WAIT
      call WAIT
      ldi r16, 0x00
      out 0x05, r16
      call WAIT
      ret
SHORT:
      ldi r16, 0x20
      ldi r17, 0x03
      out 0x04, r16
      out 0x05, r16
      call WAIT
      ldi r16, 0x00
      out 0x05, r16
      call WAIT
      ret
WAIT:

      ldi r22, 0xa0
      ldi r23, 0x00
      ldi r24, 0x00
      ldi r25, 0x00
      call delay
      ret
