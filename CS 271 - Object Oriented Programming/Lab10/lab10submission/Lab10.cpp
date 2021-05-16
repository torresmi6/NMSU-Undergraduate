#include "Term.h"
#include <iostream>
#include <stdexcept>

using namespace std;

int main(){
    
    Term k(2, 3);
    Term r;
    cout << "Enter Term with exponent 3(Ex: 2x^3):" << endl;
    cin >> r;
    cout << "The sum of k and r is " << (k + r) << endl;
    
    cout << "Enter term:" << endl;
    cin >> r;
    cout << "Entered term's coefficient: " << r.getCoefficient() << endl;
    cout << "Entered term's exponent: " << r.getExponent() << endl;
    cout << "Set second term's coefficient:" << endl;
    int co, exp;
    cin >> co;
    cout << "Set second term's exponent (Must be the same as first term):" << endl;
    cin >> exp;
    Term second(co, exp);
    
    cout << r << " - " << second << " = " << r - second << endl;
    cout << r << " * " << second << " = " << r * second << endl;
    cout << r << " / " << second << " = " << r / second << endl;
    cout << r << " * " << k << " = " << r * k << endl;
    cout << r << " / " << k << " = " << r / k << endl;
}
