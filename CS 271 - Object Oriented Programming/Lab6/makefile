all: lab6

lab6: lab6.o strFunctions.o
	gcc lab6.o strFunctions.o -o lab6

lab6.o: lab6.c strFunctions.h
	gcc -c lab6.c

strFunctions.o: strFunctions.c strFunctions.h
	gcc -c strFunctions.c

clean:
	rm -rf *.o
