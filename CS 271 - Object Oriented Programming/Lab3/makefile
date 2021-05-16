all: lab3

lab3: lab3.o lab3functions.o
	gcc -lm lab3.o lab3functions.o -o lab3

lab3.o: lab3.c lab3functions.h
	gcc -c lab3.c

lab3functions.o: lab3functions.c lab3functions.h
	gcc -c lab3functions.c
clean:
	rm -rf *.o
