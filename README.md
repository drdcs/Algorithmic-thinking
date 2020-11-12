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
  
  ```
  * printReverse(str[1...n-1]): print the substring str[1...n-1] in reverse order.
  * print(str[0]): print the first character in the string.
