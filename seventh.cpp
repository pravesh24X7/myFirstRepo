#include <iostream>
#include <cstdlib>
using namespace std;

class Names {
    private:
    string name;
    int marks;
    public:
    explicit Names() = default;
    Names(string Name, int marks) {
        name = Name;
        this->marks = marks;
    }

    void printDetails() {
        cout << "Name :" << name << "\nMarks : " << marks << endl;
    }

    void* operator new(size_t size) {
        void *ptr = ::new Names();
        return ptr;
    }

    void operator delete(void *ptr) {
        free(ptr);
    }
};

int main() {
    Names *name1 = new Names("prince", 100);
    name1->printDetails();

    return 0;

}