#include <iostream>
using namespace std;

class complex {
    private:
    int real, imag;

    public:
    explicit complex() = default;
    complex(int real, int imag) {
        this->imag = imag;
        this->real = real;
    }

    complex operator + (complex const &obj) {
        complex res = complex();
        res.real = real + obj.real;
        res.imag = imag + obj.imag;
        return res;
    }

    void print() {
        cout << real  << " + " << imag << "i" << endl;
    }
};

int main(int argc, char const *argv[])
{
    complex c1 = complex(12,34);
    complex c2 = complex(8,43);

    complex c = c1+c2;
    c1.print();
    c2.print();
    cout << endl << "res :" << endl;
    c.print();

    return 0;
}
