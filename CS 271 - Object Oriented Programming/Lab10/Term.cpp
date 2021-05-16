#include <iostream>
#include <stdexcept>
#include "Term.h"

using namespace std;
    
    Term::Term(int coef, int exp){
        setCoefficient(coef);
        setExponent(exp);
    }
        
    Term& Term::setCoefficient(int coef){
        coefficient = coef;
        return *this;
    }
        
    Term& Term::setExponent (int exp){
        exponent = exp;
        return *this;
    }
    
    int Term::getCoefficient ( ) const{
        return coefficient;
    }
    
    int Term::getExponent( ) const{
        return exponent;
    }
    
    Term Term::operator+ (const Term & term2) const{
        if(exponent != term2.exponent){
            throw invalid_argument ("Exponents must be equal");
        }
        else{
            Term newTerm((coefficient + term2.coefficient), exponent);
            return newTerm;
        }
    }
    
    Term Term::operator- (const Term & term2) const{
        if(exponent != term2.exponent){
            throw invalid_argument ("Exponents must be equal");
        }
        else{
            Term newTerm(coefficient - term2.coefficient, exponent);
            return newTerm;
        }
    }
        
    Term Term::operator* (const Term & term2) const{
        int coef = coefficient * term2.coefficient;
        int exp = exponent + term2.exponent;
        Term newTerm(coef, exp);
        return newTerm;
    }
    
    Term Term::operator/ (const Term & term2) const{
        int coef = coefficient / term2.coefficient;
        int exp = exponent - term2.exponent;
        Term newTerm(coef, exp);
        return newTerm;
    }
    
    ostream &operator<<(ostream & out, const Term & term){
        out << term.getCoefficient() << "x^" << term.getExponent();
        return out;
    }
    
    istream &operator>>(istream & in, Term & term){
        in >> term.coefficient;
        in.ignore(2);
        in >> term.exponent;
        return in;
    }
