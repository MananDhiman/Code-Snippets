# Basic C++ Program
```cpp
// hello.c
#include<iostream>

int main() {
    cout << "Program to check if numbers are even / odd \n"; // or << endl
    int n;
    cin >> n;

    for(int i=0; i<=n; i++) {
        if ((i & 1) == 0) 
            cout << i << " is even";
    }
}
```
## Check Data Type
`(typeid(a) == typeid(long long)`

## Set decimal precision
```cpp
double num = 123.456789;
std::cout << std::setprecision(5) << num << std::endl;
```
# Derived Data Types
## Type Conversion
```cpp
int (5.0);              // (int)

std::to_string(number)  // (string) number to string

#include <string>
stoi(str3);             // (int) string to int
atoi(str3)              // (int) only char array to int 
```
## String 

```cpp
string a = "abc";
int len = a.size(); // can also use .length()
string c = a + b;
char c0 = s[0];     // c0 = 'a'
```

## Vector
```cpp
#include <vector>

std::vector<int> first;               // empty vector of ints
std::vector<int> second (4,100);      // four ints with value 100
std::vector<int> fourth (third);      // a copy of third
std::cout << "The contents of fifth are:";

v[1];           // (int) accessing
v.push_back(6); // add value 6
v.pop_back();   // remove last index element
v.resize(5, 0)  // new size 5, inits with 0
v.size()        //  (int) size
v.front();      // (int)
v.back();       // (int)

// iterate
for (int x: v)
    cout << x << ' '
```

## Set
Unordered Set - Uses Hashing O(1)
Set - Uses Tree O(log n)
```cpp
#include<unordered_set>
using namespace std; 

// Declare an unordered_set of integers
unordered_set<int> hashSet;

// Inserting elements
hashSet.insert(10);
hashSet.insert(20);
hashSet.insert(30);
  
// Duplicate elements are ignored
hashSet.insert(10);
  
// Print the elements (unordered)
for(const auto &element : hashSet){
    cout<< element<< " ";
}

// Checking if an element exist
if(hashSet.find(20) != hashSet.end()){

// erasing an element
hashSet.erase(10);

// Size of the unordered_set
int s = hashSet.size(); // (int) Size of hashSet
```

## Map
```cpp
#include <unordered_map>

unordered_map<int, string> um; // declare
unordered_map<int, string> um = {{1, "A"}, {2, "B"}, {3, "C++"}}; // declare and init

// insert elements
um[1] = "Geeks";
um.insert({2, "For"});

// access elements
cout << um[2];
cout << um.at(1);

// update elements
um[2] = "By";       // if not exists will add
um.at(1) = "Tips";  // if not exists will not add

// delete element
um.erase(2);
um.erase(um.begin());

// find element
auto it = um.find(2); // if not found returns end() iterator
if (it != um.end())
    cout << "Found";

// iterate elements
for (auto i : um)
    cout << i.first << ": " << i.second << endl;
```

## Queue
```cpp
#include <queue>
queue<int> q;

// Pushing elements into the queue
q.push(3);

while (!q.empty()) {
    cout << q.front();  // (int) access first element
    q.back();           // (int) access last element
    q.pop();            // remove first element
}
```

Priority Queue
```cpp
priority_queue<int> pq; // By default largest element at top
priority_queue<int,vector<int>,greater<int> >pq; // smallest element on top
```

## Stack
```cpp
#include <stack>

// init and declare
stack<string> cars;
stack<string> cars = {"Volvo", "BMW", "Ford", "Mazda"};

// Add elements
cars.push("Volvo");
cars.push("BMW");

// access top element
cout << cars.top();

// Change the top element
cars.top() = "Tesla";

// Remove the last element
cars.pop();

// (int) get size
cout << cars.size();

cars.empty(); // (0 or 1)
```

# OOPS
```cpp
class SampleClass {
    private:
        int val;
    public:
        void set(int a) {
            val = a;
        }
        int get() {
            return val;
        }
};
```