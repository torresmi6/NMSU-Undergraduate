#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

int main(){
    
    cout << "Number   Log base 2  Log base 10  Log base e" << endl;
    
    for(int i = 1; i <= 100; i++){
        
        cout << setw(4) << i;
        cout << setw(13) << setprecision(3) << fixed << log2(i);
        cout << setw(12) << setprecision(3) << fixed << log10(i);
        cout << setw(13) << setprecision(3) << fixed << log(i) 
             << endl;
    }
}
