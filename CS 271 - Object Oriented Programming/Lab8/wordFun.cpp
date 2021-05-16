#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

int main(){
    
    string array[25];
    int index = 0;
    cout << "Type a word (press Ctrl-D to quit): ";
    getline(cin, array[index]);
    index++;
    
    while(!cin.eof() && index < 25){
        cout << "Type a word (press Ctrl-D to quit): ";
        getline(cin, array[index]);

        index++;
    }
    
    cout << endl << endl;
    for(int i = 0; i < index; i++){
        cout << array[i] << endl;
        for(int a = 0; a < array[i].size(); a++){
            cout << array[i].at(a) << endl;
        }
        cout << endl;
    }
}
