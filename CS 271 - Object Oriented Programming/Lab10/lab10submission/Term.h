#ifndef TERM_H
#define TERM_H

#include <iostream>
using namespace std;

class Term {
    
    friend ostream &operator<<( ostream &, const Term & );
    friend istream &operator>>( istream &, Term & );
    
    private:
        int coefficient;
        int exponent;
    public:
        Term ( int coef = 0, int exp = 0);
        Term& setCoefficient ( int );
        Term& setExponent ( int );
        int getCoefficient ( ) const;
        int getExponent( ) const;
        Term operator+ (const Term & ) const;
        Term operator- (const Term & ) const;
        Term operator* (const Term & ) const;
        Term operator/ (const Term & ) const;
};

#endif
