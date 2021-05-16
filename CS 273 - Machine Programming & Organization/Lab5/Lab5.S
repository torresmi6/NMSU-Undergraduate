;;
;;  AVR code to do the function of the 4  x 7 segment display of Lab 5
;;
;;
;;   Shaun Cooper
;;    CS 273
;;    Semester XXXX , 20XX
;;
;;  The basic algorithm is to have the main loop
;; set some shared variable values
;;  we then use simulataneous arrays (vectors)
;;  to figure out which segment is desired 
;;; and which sequence is needed
;;
;;  Since our setup utilizes PORTB and PORTB, then we need to main
;;   simulataneous vectors for all of the segment sequences that are neededed
;;
;; main routine does
;;   setup_ports once
;; 
;;   C code to do the following
;;   segment=0
;;   digit=9
;;   display_segment();; will display 9 on segment 0, for example
;;  

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
  .size segment_table, 4
  .size portb_table, 10
  .size portd_table, 10
segment_table:  #binary for seting input on PORTB for segment select
    .byte 0b00011100, 0b00011010, 0b00010110, 0b00001110
    ;; 0, 1, 2,3 4, 5, 6 , 7, 8 , 9
portb_table:  # list of binary sequences for setting port B to be ORed with segment table ite
    .byte  0b00000000,0,1,1,1,1,1,0,1,1
    
portd_table: # list of binary sequences for setting port D.
    .byte  0b11111100,0b00011011,0b01101111,0b00111111,0b10011011,0b10110111,0b11110111,0b00011111,0b11111111, 0b10011111

segmentv: .byte 1
  .comm segment, 1 ;; the common name for segment
  .comm digit, 1 ;; the digit into our sequences
  .global segment
  .global digit

# --------
  .text
  .global setup_ports
 
  .global display_segment

  
setup_ports:  ;; routine to set the ports into output mode
   // set PORT B
   pushall
   ldi r16, 0b00011111
   out 0x04, r16
   // set PORT D
   ldi r16, 0b11111100
   out 0x0A, r16
   popall
  ret ;; of setup_ports





    
display_segment:  ;;  main entry point for setting the segment
   ;; the goal is the use "digit" to and "segment" to find the values that need
   ;; to be sent to PORTB and PORT D 
   // portb = table seg + table portb
   // portd = table portd
   pushall
   
   ldi r31, hi8(segment_table)
   ldi r30, lo8(segment_table)
   ldi r29, hi8(portb_table)
   ldi r28, lo8(portb_table)
   ldi r27, hi8(portd_table)
   ldi r26, lo8(portd_table)
   

   lds r16, segment
   lds r17, digit
   inc r16
   inc r17
  
segLoop:
   ld r20, Z+
   dec r16
   brne segLoop
   
  
 
   //add r20, r16 // sets the index to the correct segment
   
digLoop:
   ld r21, Y+
   ld r22, X+
   dec r17
   brne digLoop
  
   
   /*add r21, r17 // sets the index to the correct digit
   add r22, r18 // sets the index to the correct digit*/

     add R20, r21

     //ldi R22,0b11111100
     sts digit , r22
     
     out 0x05, r20
     out 0x0B, r22
  
    popall
   ret ;; of display_segment
