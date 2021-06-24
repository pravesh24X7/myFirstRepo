#include <iostream>
using namespace std;

class parent {
    public:
    void funcOf() {
        cout << "funcOfParent Called" << endl;
    }
};

class child : public parent {
    public:
    virtual void funcOf() {
        cout << "funcOfChild Called" << endl;
    }
};

int main(int argc, char const *argv[])
{
    parent *ptr = NULL;
    child c1 = child();
    ptr->funcOf();
    ptr = &c1;
    ptr->funcOf();  // child funcOf function should be called

    return 0;
}
