/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
#include "vector"
#include <algorithm>
#include <cstddef>
using namespace std;

// struct ListNode {
//     int val;
//     ListNode *next;
//     ListNode() : val(0), next(nullptr) {}
//     ListNode(int x) : val(x), next(nullptr) {}
//     ListNode(int x, ListNode *next) : val(x), next(next) {}
// };

class Solution {
public:
    vector<int> nextLargerNodes(ListNode* head) {
       head = reverse(head);
       
       vector<int> res;
       vector<int> maxStack;
       while(head != nullptr) {
        // append res
        while(!maxStack.empty() && maxStack.back() <= head->val) {
            maxStack.pop_back();
        }

        if (maxStack.empty()) {
            res.emplace_back(0);
        } else {
            res.emplace_back(maxStack.back());
        }

        //maintain maxStack
        maxStack.emplace_back(head->val);
        head = head->next;
       }
       ::reverse(res.begin(), res.end());
       return res;
    }

    ListNode* reverse(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        auto node = reverse(head->next);
        head->next->next = head;
        head->next = nullptr;
        return node;
    }
};