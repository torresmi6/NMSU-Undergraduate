all: test4

test4: lab4.o test4.o
	gcc lab4.o test4.o -o test4

lab4.o: lab4.c lab4.h
	gcc -c lab4.c

test4.o: test4.c lab4.h
	gcc -c test4.c

clean:
	rm -rf *.o
