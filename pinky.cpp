#include <iostream>
#include <fstream>
using namespace std;

int main(int argc, char const *argv[])
{
    fstream my_file;
    my_file.open("DEMO.txt", ios::app);

    if (!my_file) {
        cout << "file coun't be opened " << endl;
    }

    my_file << "Hii, there are you feeling bored at home just like me";
    my_file.close();

    return 0;
}
