# Basic C Program
```c
// hello.c
#include<stdio.h>

int main() {
    printf("Program to check if numbers are even / odd \n");
    for(int i=0; i<=10; i++) {
        if ((i & 1) == 0) {
            printf("%d is even\n", i);
        }
    }
}
```

# Compile and Run
```sh
# run using ./hello
gcc -o hello hello.c

# multiple files
gcc -o awesomegame ui.c characters.c npc.c items.c

# version
gcc -std=c11 -pedantic foo.c
```

# Types
```c
// int, float, char, string (pointer to char)
// in switch statement use int or enum, not float or char
int i = 2;
float f = 3.14;
char *s = "Hello, world!";  // char * ("char pointer") is the string type

printf("%s  i = %d and f = %f!\n", s, i, f);
```
Boolean

Does not exist, use `int (0, 1)` or `include <stdbool.h>`
```c
#include <stdbool.h>  // not needed in C23
bool x = true;

if (x) 
    printf("x is true!\n");
```

Size Of
```c
int a = 999;
// %zu is the format specifier for type size_t
printf("%zu\n", sizeof a);      // 4
printf("%zu\n", sizeof(2 + 7)); // 4
printf("%zu\n", sizeof 3.14);   // 8
```

# Loops
```c
for (i = 0, j = 10; i < 100; i++, j++)
    printf("%d, %d\n", i, j);
```

# Functions
```c
// prototyping, or define function before main
int foo(void);  // This is the prototype!

int main() { /* code */ }

int foo(void)  // This is the definition, just like the prototype!
{
    return 3490;
}
```

# Pointers
a[b] == *(a + b)
```c
int i;
int *p;  // p is a pointer, but is uninitialized and points to garbage

p = &i;  // p is assigned the address of i--p now "points to" i

int i;
int *p;  // this is NOT a dereference--this is a type "int*"

p = &i;  // p now points to i, p holds address of i

i = 10;  // i is now 10
*p = 20; // the thing p points to (namely i!) is now 20!!

printf("i is %d\n", i);   // prints "20"
printf("i is %d\n", *p);  // "20"! dereference-p is the same as i!

int i = 10;
printf("The value of i is %d\n", i);
printf("And its address is %p\n", &i);
```
Pointer arithmetic
```c
int a[5] = {11, 22, 33, 44, 55};
int *p = &a[0];  // Or "int *p = a;"

printf("%d\n", *p);  // Prints 11
printf("%d\n", *(p + 1));  // Prints 22!!

while (*p != 999) {       // While the thing p points to isn't 999
    printf("%d\n", *p);   // Print it
    p++;                  // Move p to point to the next int!
}

// subtraction
int my_strlen(char *s)
{
    // Start scanning from the beginning of the string
    char *p = s;

    // Scan until we find the NUL character
    while (*p != '\0')
        p++;

    // Return the difference in pointers
    return p - s;
}

my_strlen("Hello, world!"));  // Prints "13"
```
## Pass by reference
```c
void increment(int *p)  // note that it accepts a pointer to an int
{
    *p = *p + 1;        // add one to the thing p points to
}

printf("i is %d\n", i);  // prints "10"
increment(&i);
printf("i is %d\n", i);  // prints "11"!
```

# Arrays
```c
int a[] = {22, 37, 3490};
int a[5] = {22, 37, 3490}; // last 2 elemenets initialised to 0
int a[100] = {0}; // all elements initialised
nt a[10] = {0, 11, 22, [5]=55, 66, 77};  // 0 11 22 0 0 55 66 77 0 0
```

## Passing array to functions
```c
// Passing as a pointer to the first element
void times2(int *a, int len)

// Same thing, but using array notation
void times3(int a[], int len)

// Same thing, but using array notation with size
void times4(int a[5], int len)
```

# String
“string” is defined by two things:
- pointer to first char in string.
- A zero-valued byte (or NUL) (\0) in memory after the pointer that indicates the end of the string.

```c
char *s = "Hello, world!"; // pointer to first char
printf("%s\n", s);  // "Hello, world!"
printf("%c", s[2]); // l

// end of string or length
char *s = "Hello!";  // Actually "Hello!\0"
int count = 0;

while (s[count] != '\0')  // Single quotes for single char
    count++;
```
Mutablitiy
```c
char *s = "Hello, world!";
s[0] = 'z';  // BAD NEWS: tried to mutate a string literal!

char t[] = "Hello, again!";  // t is an array copy of the string 
t[0] = 'z'; //  No problem
```

# Structs
```c
struct car {
    char *name;
    float price;
    int speed;
};

struct car saturn = {"Saturn SL/2", 16000.99, 175}; // initialize
struct car saturn2;  // Variable "saturn" of type "struct car"
struct car saturn3 = {.speed=175, .name="Saturn SL/2"};

saturn2.name = "Saturn SL/2";
saturn2.price = 15999.99;
saturn2.speed = 175;


// typedef or alias
typedef struct animal { // if remove 'animal' anoynmous struct
    char *name;
    int leg_count, speed;
} animal;                         // <-- new name

struct animal y;  // This works // if removed animal, won't work
animal z;         // This also works because "animal" is an alias
```
Pass struct by reference to function

If struct (.), if pointer to struct (->)
```c
void set_price(struct car *c, float new_price) {
    // (*c).price = new_price;  // Works, but non-idiomatic
    c->price = new_price;
}
struct car saturn = {.speed=175, .name="Saturn SL/2"};
set_price(&saturn, 799.99);
```

# File Handling
```c
FILE *fp;                      // Variable to represent open file
fp = fopen("hello.txt", "r");  // Open file for reading

int c = fgetc(fp);             // Read a single character // subsequent fgetc() gets next char
printf("%c\n", c);             // Print char to stdout

while ((c = fgetc(fp)) != EOF)
    printf("%c", c);

// prints sentence
char s[1024];
while (fgets(s, sizeof s, fp) != NULL) 
    printf("%d: %s", ++linecount, s);

fclose(fp);                    // Close the file when done
```
fscanf
```c
// txt file
// blue 29.9 173
// right 20.7 135

FILE *fp;
char name[1024];
float length;
int mass;

fp = fopen("whales.txt", "r");

while (fscanf(fp, "%s %f %d", name, &length, &mass) != EOF)
    printf("%s whale, %d tonnes, %.1f meters\n", name, mass, length);

// output
// blue whale, 173 tonnes, 29.9 meters
// right whale, 135 tonnes, 20.7 meters
```
Write to file
```c

FILE *fp;
int x = 32;

fp = fopen("output.txt", "w");

fputc('B', fp);
fputc('\n', fp);   // newline
fprintf(fp, "x = %d\n", x);
fputs("Hello, world!\n", fp);

fclose(fp);
```
Binary

have to add a "b" to the mode. Open it in "rb" mode. To write a file, open it in "wb" mode. `fp = fopen("output.bin", "wb");`

# typedef
```c
typedef int antelope;  // Make "antelope" an alias for "int"
antelope x = 10;       // Type "antelope" is the same as type "int"

// demo
struct animal {
    char *name;
    int leg_count, speed;
};

typedef struct animal animal;
struct animal y;  // This works
animal z;         // This also works because "animal" is an alias

typedef struct {
    int x, y;
} point;

point p = {.x=20, .y=40};

printf("%d, %d\n", p.x, p.y);  // 20, 40
```

# Header File Functions
```c
#include <stdlib.h>  // For rand
int r = rand() % 100; // between 0 and 99


#include <string.h>
char *s = "Hello, world!";
printf("The string is %zu bytes long.\n", strlen(s));

strcpy(dest, source); // from source to dest
```



