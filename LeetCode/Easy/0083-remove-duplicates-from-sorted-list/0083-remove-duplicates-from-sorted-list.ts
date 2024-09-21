/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function deleteDuplicates(head: ListNode | null): ListNode | null {
    if(head === null){
        return head;
    }
    
    let node = head;
    
    while(node.next){
        let nextNode = node.next;
        if(node.val === nextNode.val){
            node.next = nextNode.next;
        }else{
            node = nextNode;
        }
    }
    
    return head;
};