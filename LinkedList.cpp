#include <iostream>
using namespace std;

class llNode {
    public:
    int data;
    llNode *link;

    llNode(int data) {
        this->data = data;
        link = nullptr;
    }
};

llNode* add(llNode *&head, int key) {
    if (!head) {
        return new llNode(key);
    }
    llNode *newNode = new llNode(key);
    llNode *tmp = head;

    while (tmp->link != nullptr) tmp = tmp->link;
    tmp->link = newNode;

    return head;
}

void printLL(llNode *&head) {
    if (!head) {
        cout << "[]" << endl;
        return;
    }
    llNode *tmp = head;
    while (tmp != nullptr) {
        cout << tmp->data << " ";
        tmp = tmp->link;
    }    
}

int main(int argc, char const *argv[]) {
    int keys[] = {5,4,3,2,1};
    llNode *head = NULL;

    for (auto &i : keys) head = add(head, i);
    printLL(head);
    return 0;
}
