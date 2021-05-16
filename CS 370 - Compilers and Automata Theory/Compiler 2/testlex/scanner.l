/****
* Lex scanner for simple example
****/

/****** Header definitions ******/
%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#ifndef LEXONLY
// definitions auto-created by yacc (when using yacc)
#include "y.tab.h"
#else
// explicit definitions for standalone mode
typedef union { int ival; char* str; } yystype;
#define YYSTYPE yystype
yystype yylval;
#define NUMBER      1
#define SEMICOLON   2
#define LPAREN      3
#define RPAREN      4
#define LBRACE      5
#define RBRACE      6
#define ID          7
#define STRING      8
#define COMMA       9
#define PLUS        10
#endif
extern int debug; // declared and set in parser.y
%}

%option yylineno

/****** Token Patterns ******/
%%
[ \t\n\r]* { /* skipping white space */ }
[0-9]+   {
            if (debug) printf("lex number: (%s)\n", yytext);
            yylval.ival = strtol(yytext,0,10);
            return(NUMBER);
         }
[,]     {
        yylval.str = strdup(yytext);
        return(COMMA);
        }
[+]     {
        yylval.str = strdup(yytext);
        return(PLUS);
        }
[;]     {
        if (debug) printf("lex semicolon: (%s)\n", yytext);
        yylval.str = strdup(yytext);
        return(SEMICOLON);
        }
[(]     {
        if (debug) printf("lex lparen: (%s)\n", yytext);
        yylval.str = strdup(yytext);
        return(LPAREN);
        }
[)]     {
        if (debug) printf("lex rparen: (%s)\n", yytext);
        yylval.str = strdup(yytext);
        return(RPAREN);
        }
[{]     {
        if (debug) printf("lex lbrace: (%s)\n", yytext);
        yylval.str = strdup(yytext);
        return(LBRACE);
        }
[}]     {
        if (debug) printf("lex rbrace: (%s)\n", yytext);
        yylval.str = strdup(yytext);
        return(RBRACE);
        }
[a-zA-Z_][a-zA-Z0-9_]*  {
        if (debug) printf("lex id: (%s)\n", yytext);
        yylval.str = strdup(yytext);
        return(ID);
                        }
[\"][^\"]*[\"]  {
        if (debug) printf("lex string: (%s)\n", yytext);
        yylval.str = strdup(yytext);
        return(STRING);
        }
%%
/****** Functions (not used when used with parser) *******/

//
// Code in the ifdef block below is only for compiling the
// scanner all by itself, for testing purposes. The 
// Makefile shows how to compile it under the "ltest" rule
// (do "make ltest" to build it)
//
#ifdef LEXONLY

// A main for standalone testing (uses just stdin as input)
int main(int argc, char **argv) 
{
   do {
      yylex();
   } while (1);
   // while (!feof(stdin)); doesn't work if redirecting a file
   // in because the file is read in and buffered, and eof is
   // true too early, causing lex to stop; rather, use while(1)
   // and then do a hard exit in yywrap(); ugly, but works!
   return 0;
}

int yywrap()
{
   exit(0); // hard exit!
   //return(1);
}

#endif // LEXONLY

