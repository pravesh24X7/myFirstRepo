#include <iostream>
#include <fstream>
using namespace std;

int main(int argc, char const *argv[])
{
    fstream my_file;
    my_file.open("new_doc.txt", ios::in);

    if (!my_file) {
        cout << "file not found" << endl;
    } else {
        string str;
        while (getline(my_file, str)) {
            cout << str;
        }
    }
    my_file.close();

    return 0;
}
