#include <iostream>
#include <fstream>
using namespace std;

int main(int argc, char const *argv[])
{
    fstream my_file;
    my_file.open("DEMO.txt", ios::app);

    if (!my_file) {
        cout << "file couldn't be opened !!" << endl;
    }

    cout << "Enter data for file :" << endl;
    string str;
    getline(cin, str);

    my_file << str;

    my_file.close();

    return 0;
}
