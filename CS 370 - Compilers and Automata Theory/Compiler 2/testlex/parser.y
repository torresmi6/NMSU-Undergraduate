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
int argNum=0;
char *argRegStr[] = {"%rdi", "%rsi", "%rdx", "%rcx", "%r8", "%r9"};
char *funcID[10][10];
int iDIndex = 0;

%}

/* token value data types */
%union { int ival; char* str; }

/* Starting non-terminal */
%start prog
%type <str> functions function statements statement funcall arguments argument expression

/* Token types */
%token <ival> NUMBER SEMICOLON LPAREN RPAREN LBRACE RBRACE COMMA PLUS
%token <str> ID STRING

%%
/******* Rules *******/

prog: functions
     {
         printf("%s\t.text\n", genString());

         for(int i = 0; i < iDIndex; i++){
            printf("\t.globl %s\n\t.type %s, @function\n", funcID[i][0], funcID[i][0]);
         }
         printf("%s", $1);
     }

functions: function functions
        { char *code = (char*) malloc(2000);
          sprintf(code,"%s\n%s",$1,$2);
          $$ = code;}
        |
        { $$ = "";}
        
function: ID LPAREN RPAREN LBRACE statements RBRACE
       { char *code = (char*) malloc(2000);
         sprintf(code,"%s:\n\tpushq %%rbp\n\tmovq %%rsp, %%rbp\n%s\n\tmovl $0, %%eax\n\tpopq %%rbp\n\tret\n\t.size %s, .-%s\n\t", $1, $5, $1, $1);
         funcID[iDIndex][0] = $1;
         iDIndex++;
         $$ = code;
         }
       
statements: statement statements 
        { char *code = (char*) malloc(2000);
          sprintf(code,"%s\n%s",$1,$2);
          $$ = code;}
        | /*empty*/
        { $$ = "";}
        
statement: funcall
        { $$ = $1;}
        
funcall: ID LPAREN arguments RPAREN SEMICOLON
        {
            
            char *code = (char*) malloc(1024);
            sprintf(code,"\t%s\n\tcall\t%s@PLT", $3, $1);
            argNum = 0;
            $$ = code;
            
        }

arguments: argument
        { $$ = $1;
        }
        | argument COMMA arguments
        { char *code = (char*) malloc(2000);
          sprintf(code,"%s\n\t%s",$1,$3);
          $$ = code;
        }
        |
        { $$ = "";}

argument: STRING
        { int sid = addString($1);
          char *code = (char*) malloc(2000);
          sprintf(code, "leaq\t.LC%d(%%rip), %s", sid, argRegStr[argNum]);
          argNum++;
          $$ = code;
        }
        | expression
        { char *code = (char*) malloc(2000);
          sprintf(code, "%s\n\tmovq\t%%rax, %s", $1, argRegStr[argNum]);
          argNum++;
          $$ = code;
        }
        
expression: NUMBER
        { char *code = (char*) malloc(2000);
          sprintf(code, "movl\t$%d, %%eax\n", $1);
          $$ = code;
        }
        | expression PLUS expression
        { char *code = (char*) malloc(2000);
          int sum = atoi($1) + atoi($3);
          sprintf(code, "%s\n\tpushq %%rax\n\t%s\n\tpopq %%rcx\n\taddl %%ecx, %%eax\n", $1, $3);
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
    
    char *temp = (char*) malloc(1024);
            
    strcpy(temp, "\t.text\n\t.section\t.rodata\n");
    int i;
    for(i = 0; i < strCnt; i++){
        sprintf(temp + strlen(temp), ".LC%d:\n\t.string %s\n", i, strInd[i]);
    }
    return temp;
}
