#include <iostream>
#include <cstring>
#include <fstream>
using namespace std;

int main(int argc, char const *argv[]) {

    fstream my_file;
    my_file.open("DEMO.txt", ios::in);
    my_file.open("DEMO.txt", ios::binary);

    if (!my_file) {
        cout << "You aren't Successfull";
    }

    string str;
    while (getline(my_file, str)) {
        cout << str;
    }
    my_file.close();

    return 0;
}
