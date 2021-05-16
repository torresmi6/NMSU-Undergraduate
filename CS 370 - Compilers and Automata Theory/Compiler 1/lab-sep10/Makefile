
CC = gcc
CFLAGS = -Wall

all: hw
more.o: more.c more.h
hw.o: hw.c more.h
hw: hw.o more.o

clean: 
	rm -f *.o hw
