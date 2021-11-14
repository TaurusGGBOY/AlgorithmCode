#include <unordered_map>
using namespace std;

typedef struct Node{
    struct Node* prev;
    struct Node* next;
    int value;
    int key;
}Node;

class LRUCache {
private:
    Node* head;
    Node* tail;
    unordered_map<int, Node*> map;
    int cap;

    void delete_node(Node* node){
        Node* left = node->prev;
        Node* right = node->next;
        left->next = right;
        right->prev = left;
    }

    void add_node_to_tail(Node* node){
        Node* prev_last = tail->prev;
        prev_last->next = node;
        tail->prev = node;
        node->prev = prev_last;
        node->next = tail;
    }
public:
    LRUCache(int capacity) {
        cap = capacity;

        head = new Node();
        tail = new Node();

        head->prev = nullptr;
        head->next = tail;

        tail->prev = head;
        tail->next = nullptr;
    }

    int get(int key) {
        if(map.count(key)==0){
            return -1;
        }
        delete_node(map[key]);
        add_node_to_tail(map[key]);
        return map[key]->value;
    }

    void put(int key, int value) {
        if(map.count(key)>0){
            Node* node = map[key];
            node->value = value;
            delete_node(node);
            add_node_to_tail(node);
        }else{
            if(map.size()>=cap){
               Node* head_next = head->next;
               map.erase(head_next->key);
               delete_node(head_next);
               head_next = nullptr;
            }

            Node* node = new Node();
            node->key = key;
            node->value = value;
            map[key]=node;
            add_node_to_tail(node);
        }
    }
};
