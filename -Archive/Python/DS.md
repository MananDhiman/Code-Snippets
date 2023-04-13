Linked List Transversal Recursion

```
class LinkedList:  
    def __init__(self):  
        self.head = None  
  
    class Node:  
        def __init__(self, key):  
            self.key = key  
            self.next_node = None

def printRecur(self, itr=None):  
    if self.head is None:  
        print("Empty List")  
        return  
  
    if itr is None:  
        itr = self.head  
  
    print("Data -> ", itr.key)  
  
    if itr.next_node:  
        return LinkedList.printRecur(self, itr.next_node)
```

# BST

```
from random import randrange  
  
class Node:  
    def __init__(self, value=None):  
        self.value = value  
        self.right = None  
        self.left = None  
  
def inorder(rootNode):  
    if rootNode is None:  
        return  
  
    inorder(rootNode.left)  
    print(rootNode.value)  
    inorder(rootNode.right)  
  
def addNode(rootNode, value):  
    if rootNode is None:  
        rootNode = Node(value)  
        return rootNode  
  
    if rootNode.value > value:  
        rootNode.left = addNode(rootNode.left, value)  
    else:  
        rootNode.right = addNode(rootNode.right, value)  
  
    return rootNode  
  
  
class BST:  
    def __init__(self):  
        self.rootNode = None  
  
    def addNode(self, value):  
        if self.rootNode is None:  
            self.rootNode = Node(value)  
            return  
  
        if self.rootNode.value > value:  
            self.rootNode.left = addNode(self.rootNode.left, value)  
        else:  
            self.rootNode.right = addNode(self.rootNode.right, value)  
  
    def inorder(self):  
        if self.rootNode is None:  
            print("Empty List")  
            return  
  
        inorder(self.rootNode.left)  
        print(self.rootNode.value)  
        inorder(self.rootNode.right)  
  
  
bst = BST()  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
bst.addNode(randrange(100))  
  
bst.inorder()

```