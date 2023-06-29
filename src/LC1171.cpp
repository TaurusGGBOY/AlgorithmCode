#include "unordered_map"
#include <cstddef>
using namespace std;
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
//    struct ListNode {
//      int val;
//       ListNode *next;
//       ListNode() : val(0), next(nullptr) {}
//       ListNode(int x) : val(x), next(nullptr) {}
//       ListNode(int x, ListNode *next) : val(x), next(next) {}
//   };
class Solution {
public:
    ListNode* removeZeroSumSublists(ListNode* head) {

        ListNode yummy = ListNode(0, head);
        while(true) {
            auto node = &yummy;
            int sum = 0;
            unordered_map<int, ListNode*> map;

            while(node != nullptr) {
                sum += node->val;
                if (map.count(sum) != 0) {
                    map[sum]->next = node->next;
                    break;
                }
                map[sum] = node;
                node = node->next;
            }

            if (node == nullptr) {
                break;
            }
        }

        return yummy.next;
    }
};