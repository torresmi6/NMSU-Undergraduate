.extern delay
.text
.global test
test:
      ldi r16, 0x20
      out 0x04, r16
      out 0x05, r16
      ldi r22, 0x00
      ldi r23, 0x08
      ldi r24, 0x00
      ldi r25, 0x00
      call delay
      ldi r16, 0x00
      out 0x04, r16
      out 0x05, r16
      ldi r22, 0x00
      ldi r23, 0x08
      ldi r24, 0x00
      ldi r25, 0x00
      call delay
      ldi r16, 0x20
      out 0x04, r16
      out 0x05, r16
      ldi r22, 0x00
      ldi r23, 0x08
      ldi r24, 0x00
      ldi r25, 0x00
      /*call delay
      ldi r16, 0x00
      out 0x04, r16
      out 0x05, r16
      ldi r22, 0xa0
      ldi r23, 0x00
      ldi r24, 0x00
      ldi r25, 0x00
      call delay*/
      ret
