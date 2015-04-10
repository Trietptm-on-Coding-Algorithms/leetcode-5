/**
 * Solution to https://leetcode.com/problems/copy-list-with-random-pointer/
 * Among the top 10% fastest in running time.
 */
/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if(head == NULL) return NULL;
        RandomListNode *p = head;
        do {
            RandomListNode *q = p->next;
            p->next = new RandomListNode(p->label);
            p->next->next = q;
            p = q;
        } while(p != NULL);
        p = head;
        do {
            p->next->random = (p->random == NULL) ? NULL : p->random->next;
            p = p->next->next;
        } while(p != NULL);
        p = head;
        RandomListNode *r = head->next;
        for(RandomListNode *q = r;;) {
            p->next = q->next;
            p = p->next;
            if(p == NULL) break;
            q->next = p->next;
            q = q->next;
        }
        return r;
    }
};
