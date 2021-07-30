#include <iostream>
using namespace std;

template <typename T, typename U, typename X>
class DataValOf
{
private:
    T name;
    U age;
    X marks;

public:
    
    explicit DataValOf() = default;

    DataValOf (T name, U age, X marks) {
        this->age = age;
        this->name = name;
        this->marks = marks;
    }
    
    void print() {
    cout << "Name :" << name << endl << "Age :" << age << endl << "Marks :"
    << marks << endl;
    }

    void* operator new(size_t size) {
        void *ptr = ::new DataValOf();
        return ptr;
    }

    void operator delete(void *ptr) {
        free(ptr);
    }
};

int main(int argc, char const *argv[])
{
    DataValOf<string, int, float> *ptr = new DataValOf<string, int, float>("prince", 18, 95.0);
    ptr->print();
    delete(ptr);

    DataValOf<int, float, char> *pt = new DataValOf<int, float, char>(12, 25.00, 'p');
    ptr->print();
    delete(pt);

    return 0;
}
