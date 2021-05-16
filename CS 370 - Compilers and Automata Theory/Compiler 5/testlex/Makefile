#
# Make file for simple scanner and parser example
#

# flags and defs for built-in compiler rules
CFLAGS = -I. -g -Wall -Wno-unused-function
CC = gcc

# default rule build the parser
all: assemble

assemble: file.S
	gcc file.S

file.S: output
	./ptest test2.c > file.S

output: ptest
	./ptest test2.c

# yacc "-d" flag creates y.tab.h header
y.tab.c: parser.y symtable.h astree.h
	yacc -d parser.y

# lex rule includes y.tab.c to force yacc to run first
# lex "-d" flag turns on debugging output
lex.yy.c: scanner.l y.tab.c
	lex scanner.l

# ptest executable needs scanner and parser object files
ptest: lex.yy.o y.tab.o symtable.o astree.o
	gcc -o ptest y.tab.o lex.yy.o symtable.o astree.o

astree.o: astree.c astree.h
	gcc -c astree.c

symtable.o: symtable.c symtable.h
	gcc -c symtable.c
# ltest is a standalone lexer (scanner)
# build this by doing "make ltest"
# -ll for compiling lexer as standalone
ltest: scanner.l
	lex scanner.l
	gcc -DLEXONLY lex.yy.c -o ltest -ll

# clean the directory for a pure rebuild (do "make clean")
clean: 
	rm -f lex.yy.c a.out y.tab.c y.tab.h *.o ptest ltest file.S

