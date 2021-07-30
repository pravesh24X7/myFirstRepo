#include <iostream>
using namespace std;

class parent {
    public:
    virtual void printOf() {
        cout << "printOf parent Called" << endl;
    }

    void __printOf() {
        cout << "__printOf parent Called" << endl;
    }
};

class child : public parent {
    public:
    void printOf() {
        cout << "printOf child Called" << endl;
    }

    void __printOf() {
        cout << "__printOf child Called" << endl;
    }
};

int main(int argc, char const *argv[])
{
    parent *ptr = NULL;
    child c1 = child();

    //c1.printOf();
    //c1.__printOf();

    ptr = &c1;
    ptr->printOf();
    ptr->__printOf();


    return 0;
}

