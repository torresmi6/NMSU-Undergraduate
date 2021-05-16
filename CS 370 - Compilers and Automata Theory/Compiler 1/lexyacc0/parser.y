/*****
* Yacc parser for simple example
*
* The grammar in this example is:
* all -> phrases
* phrases -> <empty>
* phrases -> phrases NUMBER PLUS NUMBER
* phrases -> phrases NUMBER
* phrases -> phrases OTHER
* 
* The tokens that come from the scanner are: NUMBER, PLUS, and OTHER. 
* The scanner skips all whitespace (space, tab, newline, and carriage return).
* The lexemes of the token NUMBER are strings of digits ('0'-'9'). 
* The lexeme of PLUS is only a string consisting of the plus symbol ('+').
* The lexemes of the token OTHER are strings of characters that do not 
* include whitespace, digits, or the plus symbol.
* 
* Given the input "acb 42 +34 52this is", the scanner would produce 
* the tokens(/lexemes) of:
* <OTHER,"abc">, <NUMBER,"42">, <PLUS,"+">, <NUMBER,"34">, <NUMBER,"52">,
* <OTHER,"this">, <OTHER,"is">
* 
* and this would match the grammar.
*****/

/****** Header definitions ******/
%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
// function prototypes from lex
int yyerror(char *s);
int yylex(void);
int debug=0; // set to 1 to turn on extra printing
char *array;
int arrInd = 0;
int arrSize = 1024;
char* strInd[10];
int strCnt = 0;
int addString();
char* genString();
%}

/* token value data types */
%union { int ival; char* str; }

/* Starting non-terminal */
%start prog
%type <str> function statements statement funcall

/* Token types */
%token <ival> NUMBER SEMICOLON LPAREN RPAREN LBRACE RBRACE COMMA PLUS
%token <str> ID STRING

%%
/******* Rules *******/

prog: function 
     {
         printf("%s%s", genString(), $1);
         
     }

function: ID LPAREN RPAREN LBRACE statements RBRACE
       { char *code = (char*) malloc(1024);
         sprintf(code,"\t.text\n\t.global %s\n\t.type %s, @function\n%s:\n\tpushq %%rbp\n\tmovq %%rsp, %%rbp\n\t%s\n\tmovl $0, %%eax\n\tpopq %%rbp\n\tret\n\t", $1, $1, $1, $5);
         $$ = code;
         }
       
statements: statement statements 
        { char *code = (char*) malloc(1024);
          sprintf(code,"%s\n%s",$1,$2);
          $$ = code;}
        | /*empty*/
        { $$ = "";}
        
statement: funcall SEMICOLON
        { $$ = $1;}
        
funcall: ID LPAREN STRING RPAREN
        {
            //printf("function call\n");
            int sid = addString($3);
            char *code = (char*) malloc(128);
            sprintf(code,"movl\t$.LC%d, %%edi\n\tcall\t%s",sid,$1);
            $$ = code;
            
        }
        
     ;
%%
/******* Functions *******/
extern FILE *yyin; // from lex

int main(int argc, char **argv)
{
    
   if (argc==2) {
      yyin = fopen(argv[1],"r");
      if (!yyin) {
         printf("Error: unable to open file (%s)\n",argv[1]);
         return(1);
      }
   }
   
   array = (char*) malloc(1024);

   return(yyparse());
}

extern int yylineno; // from lex

int yyerror(char *s)
{
   fprintf(stderr, "Error: line %d: %s\n",yylineno,s);
   return 0;
}

int yywrap()
{
   return(1);
}

int addString(char *string){

    strInd[strCnt] = string;
    strCnt++;

    return strCnt-1;
}
char* genString(){
    
    char *temp = (char*) malloc(128);
            
    strcpy(temp, "\t.text\n\t.section\t.rodata\n");
    int i;
    for(i = 0; i < strCnt; i++){
        sprintf(temp, ".LC%d\n\t.string %s\n", i, strInd[i]);
    }
    return temp;
}
