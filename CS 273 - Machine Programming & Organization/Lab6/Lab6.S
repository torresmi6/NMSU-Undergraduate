// Michael Torres
// 3/12/20
// Lab6.S
// Displays the humidity and temperature using bit patterns to light up segments for the output
#
# I2C interface is wired to Arduino PORTB bits
# 4 and 5, with 4 being data and 5 being clock,
# so these symbols give us the values needed
#
      .set PORTB,0x05
      .set DDIRB,0x04
      .set SDA,0 ;; digital pin 8 
      .set SCL,1 ;; digital pin 9 

#
# I2C addresses of the components:
#  7-segment LED: 0x40
#   Position: 0xC0 + 4 bytes
#   Brightness: 0x8a
#  
#  We will be using pull up resistors which means that we have opposite logic about
#  When the value we set is the opposite that is being read by the display
#  This code is based heavily off of the TM1637Display.cpp code found on Github

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
#
# Global data (none)
#
#   
    .data

    .size digitDisplay, 10
digitDisplay:
    .byte 0b00111111, 0b00000110, 0b01011011, 0b01001111, 0b01100110, 0b01101101, 0b01111101, 0b00000111, 0b01111111, 0b01101111
   
    .comm data, 4
    .comm input, 1
    .comm result, 1
    .global data
    .global input
    .global result
    
# external symbol (delay function)
    .extern delay

#
# Program code
#
     .text
     .global display_symbol
     .global sendBrightness
     .global  stopBit
     .global  startBit
     .global encodeDigit
display_symbol: 
      call setupport ;; set the port to the correct IO direction
      
      call  sendAddress     ; send 7SEG address 
      call  sendPos        ; send instruction for each segment
      call  sendBrightness  ; set brightness
      ret                   ; all done, return to main program!

setupport: ;; set up the port for TM1637
       # set pins to input mode
       cbi   DDIRB,SDA
       cbi   DDIRB,SCL
       cbi   PORTB, SDA
       cbi   PORTB, SCL  ;; this means data and clock are high
       call  delay1          ; wait to make sure PORTB ready
       ret ;; of setupport
#
# Delay for 1 millisecond (saves/restores r18-r20)
#
delay1:
      push r18
      push r19
      push r20
      ldi  r22, 1
      ldi  r23, 0
      ldi  r24, 0
      ldi  r25, 0
      call delay
      pop  r20
      pop  r19
      pop  r18
      ret

#
# I2C startbit: a high-to-low transition on SDA while clock is high
#
startBit:
      sbi   DDIRB,SDA    ; set data bit high, maklng data line go low
      call  delay1       ; leave clock high long enough
      ret

#
# I2C stopit: a low-to-high transition on SDA while clock is high
#
stopBit:
      sbi   DDIRB,SDA    ;
      call delay1
      cbi   PORTB,SCL    ; set clock high
      cbi   DDIRB, SCL    ;  when we turn off one we have to take care of direction
      call  delay1       ; leave clock high long enough
      cbi   PORTB,SDA    ; bring up SDA while clock is high
      cbi   DDIRB, SDA     ; when we clear port we set input mode
      call  delay1       ; keep clock high for a while
      ret

#
# I2C 1 bit transmission: SDA high while clock is high
# 
oneBit:
      sbi   DDIRB,SCL    ; clock goes down due to pull-up 
      call delay1
      cbi   PORTB,SDA    ; A clear writes a 1 to the device
      cbi   DDIRB, SDA
      call  delay1       ; leave clock high long enough
      cbi   PORTB,SCL    ; finally bring clock low
      cbi   DDIRB, SCL
      call  delay1       ; leave clock low for long enough
      ret

#
# I2C 0 bit transmission: SDA low while clock is high
# 
zeroBit:
      sbi   DDIRB,SCL    ; clock goes down due to pull-up 
      call delay1
      sbi   DDIRB,SDA    ; A clear writes a 1 to the device
      call  delay1       ; leave clock high long enough
      cbi   PORTB,SCL    ; finally bring clock low
      cbi   DDIRB, SCL
      call  delay1       ; leave clock low for long enough
      ret

ack:  sbi DDIRB, SCL
      cbi PORTB, SDA
      cbi DDIRB, SDA
      call delay1
      cbi PORTB, SCL
      cbi DDIRB, SCL
      call delay1

      sbis PORTB, SDA  ;; skip if we have a 0 in this slot as per the arduino code
      sbi DDIRB, SDA
      call delay1
      
      sbi DDIRB, SCL
      call delay1
      ret
#
# I2C LED address transmission: must transmit the byte value 0x40
#
sendAddress:

      ldi r18, 0x40
      call startBit
      call sendByte
      call stopBit
      ret

#
# Position should be 0xC0 
#  - 
#
sendPos:
      ldi r18, 0xC0
      call startBit

      call sendByte
    
      call sendData // takes what is in the global array data, and uses it to send the bytes
      
      call stopBit
      ret

#
# Command Brightness 0x89
#  - in binary, 01001010
#
sendBrightness:

     ldi r18, 0x89
     call startBit
     call sendByte
     call stopBit
      ret

#
# Transmit a byte that will display a symbol
#  - you must figure it out!
#
show_one_symbol: ;; you should not have to call this other than testing
      call  oneBit
      call  zeroBit
      call  zeroBit
      call  zeroBit
      call  oneBit
      call  oneBit
      call  oneBit
      call  zeroBit
      call  ack
      ret

#  A simple routine which assumes R18 has the Byte in question
#  We loop through the bits of the R18 (this makes R18 not usable
#  and sends the appropriate zero or one bit. We send by least significant bit
#  We then send an ACK at the end


sendByte:
       ;  You need to fix this code
        pushall
        ldi r19, 8
L1:     LSR r18
        BRCC doZero
        call oneBit
        dec r19
        brne L1
        jmp done
doZero: call zeroBit
        dec r19
        brne L1
        jmp done
done:   call ack
        popall
        ret

sendData:                   // loads the data array in Z
        pushall
        ldi r31, hi8(data)
        ldi r30, lo8(data)
        ld r18, Z+          // data has 4 indecies, so it sends each of the 4 bytes
        call sendByte
        ld r18, Z+
        call sendByte
        ld r18, Z+
        call sendByte
        ld r18, Z+
        call sendByte
        popall
        ret

encodeDigit:                        
        pushall
        ldi r31, hi8(digitDisplay)  // loads the table digitDisplay into Z
        ldi r30, lo8(digitDisplay)
        lds r18, input              // loads the global input var into r18

zLoop:                  // loops through the table until input hits zero
        ld r19, Z+
        cpi r18, 0
        breq done2
        dec r18
        jmp zLoop
done2:
        sts result, r19 //stores the contents of the current index of the table in result
        popall
        ret
