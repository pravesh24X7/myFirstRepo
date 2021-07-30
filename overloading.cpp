#include <iostream>
using namespace std;

class testClass {
    private:
    int x;
    public:
    testClass(int x) {
        this->x = x;
    }

    void __print() {
        cout << x << endl;
    }

    testClass operator ++(int) {
        return ++x;
    }

    testClass operator ++() {
        return x++;
    }

    testClass operator --() {
        return x--;
    }

    testClass operator --(int) {
        return --x;
    }
};

int main(int argc, char const *argv[]) {
    testClass tc1{12};
    tc1.__print();
    tc1++;
    tc1.__print();
    tc1--;
    tc1.__print();
    --tc1;
    tc1.__print();
    ++tc1;
    tc1.__print();
    
    return 0;
}
