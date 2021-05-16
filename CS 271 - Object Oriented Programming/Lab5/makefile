all: lab5test

lab5test: lab5test.o lab5functions.o
	gcc lab5test.o lab5functions.o -o lab5test

lab5test.o: lab5test.c lab5functions.h
	gcc -c lab5test.c

lab5functions.o: lab5functions.c lab5functions.h
	gcc -c lab5functions.c

clean:
	rm -rf *.o
