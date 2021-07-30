#include <iostream>
using namespace std;

class Node {
    public:
    int data;
    Node *link;
    Node(int data) {
        this->data =  data;
        link = NULL;
    }
};

Node* aNode(Node *&head, int key) {
    if (!head) {
        return new Node(key);
    }
    Node *tmp = head;
    while (tmp->link != nullptr) tmp = tmp->link;
    tmp->link = new Node(key);
    return head;
}

void printLL(Node *&head) {
    if (!head) return;
    Node *tmp = head;
    while (tmp != nullptr) {
        cout << tmp->data << " ";
        tmp = tmp->link;
    }
}

int main(int argc, char const *argv[])
{
    Node *head = NULL;
    int keys[] = {1,2,3,4,5,6,7,8,9};

    for (auto &key : keys) head = aNode(head, key);
    printLL(head);
    return 0;
}
