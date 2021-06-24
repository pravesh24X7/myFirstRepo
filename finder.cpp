#include <iostream>
#include <fstream>
using namespace std;

void func(string src) {

    fstream file;
    // string path = "cd C:\Users\User\OneDrive\Desktop";

    file.open("sorry.txt", ios::in);

    if (!file) {
        cout << "file not found !!";
    } else {
        string str;
        while (getline(file, str)) {
            if (str.find(src)) {
                cout << str << endl;
            }
        }
    }

} 


void func() {
    string search;
    getline(cin, search);

    func(search);
}


int main() {
    cout << ": procedure started :";
    func();

    return 0;
}
