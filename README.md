### Recursion Principle
Recursion is an approach to solving problems using a function that calls itself as a **subroutine**.
You might wonder how we can implement a function that calls itself. The trick is that each time a recursive function calls itself, it reduces the given problem into subproblems. The recursion call continues until it reaches a point where the subproblem can be solved without further recursion.
- A recursive function should have the following properties so that it does not result in an infinite loop:
  - A simple base case (or cases) — a terminating scenario that does not use recursion to produce an answer.
  - A set of rules, also known as **recurrence relation** that reduces all other cases towards the base case.
  
  
  ```python
  
  def reverseAStringRecursively(index,str):
    if str is None or index > len(str)-1:
        return
    reverseAStringRecursively(index+1, str)
    print(str[index], end='')
    
  if __name__ == '__main__': 
    str = "A string need to be reversed"
    print(reverseAStringRecursively(0,str))
    
    ** OR **
    
   class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        def helper(start, end, s):
            if start >= end:
                return
            s[start], s[end] = s[end], s[start]
            helper(start+1, end-1,s)
        helper(0, len(s)-1, s)
        
  
  ```
  * printReverse(str[1...n-1]): print the substring str[1...n-1] in reverse order.
  * print(str[0]): print the first character in the string.
  
  **Problem : To swap the pairs.**
  
  ```
  Input: head = [1,2,3,4]
  Output: [2,1,4,3]
  ```
  
  ```python
  
  class Node:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next
  
  def printList(msg, head):
      print(msg, end= '')
      ptr = head
      while ptr:
           print(ptr.data, end= "->")
           ptr = ptr.next
      print("None")


  def swapPairs(head):
      if not head or not head.next:
          return head

      # nodes to be swapped

      first_node = head
      second_node = head.next

      # swapping 

      first_node.next = swapPairs(second_node.next)
      second_node.next = first_node
      return second_node



  if __name__ == '__main__':
      head = None
      for i in reversed(range(8)):
          head = Node(i+1, head)
      printList("Before Swap Pair: ",head)
      head = swapPairs(head)
      printList("After Swap Pair: ",head)
  ```
 **reverse a linked list recursively**
 
 ```python
 
 class Node:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next
  
def printList(msg, head):
    print(msg, end= '')
    ptr = head
    while ptr:
         print(ptr.data, end= "->")
         ptr = ptr.next
    print("None")
        
def reverse(head):
    # emplty list base case
    if head is None:
        return head
    first = head # [1,2,3]
    rest = head.next # [2,3]
    
    #empty rest base case
    if rest is None:
        return head
        
    rest = reverse(rest) # recursively reverse rest.
    first.next.next = first # put 1st elemt at end of list
    first.next = None
    head = rest
    return head

if __name__ == '__main__':
    head = None
    for i in reversed(range(8)):
        head = Node(i+1, head)
    printList("Before Swap Pair: ",head)
    head = reverse(head)
    printList("After Swap Pair: ",head)
    
 ```
**now we will look into recursive implementation of the binary search tree**
- insert into the bst.
- search item in bst.
```python
class BST:
    
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left= left
        self.right= right
        

def inorder(root):
    if root is None:
        return
    inorder(root.left)
    print(root.val, end =' ')
    inorder(root.right)
    
    
def insert(root, key):
    if root is None:
        return BST(key)
    # if given key is less than root node
    # recur left ..
    if key < root.val:
        root.left = insert(root.left, key)
    else:
        root.right = insert(root.right, key)
    return root
    
def searchBST(root, item):
    if root is None or root.val == item:
        return root.val
    return searchBST(root.left, item) if item < root.val else searchBST(root.right, item)
        
if __name__ == '__main__':
    root = None
    keys = [15, 10, 20, 8, 12, 16, 26]
    for key in keys:
        root = insert(root, key)
        
    print(inorder(root))
    
    print(searchBST(root, 16))
 ```
