#include <iostream>
using namespace std;

class Mummy {
    string name;
    int age;
    string choice;
    public:
    Mummy(string Name, int age, string Choice) {
        this->age = age;
        name = Name;
        choice = Choice;
    }

    void printDetails() {
        cout << "Name :" << name << " Choice :" << choice << " Age :" << age << endl;
    }
};

int main() {
    Mummy m1{"Neelam", 52, "Reading"};
    m1.printDetails();

    return 0;
}