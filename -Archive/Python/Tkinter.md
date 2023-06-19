# GUI using tkinter
# Basic custom
```python
import tkinter as tk
from tkinter import ttk

root = tk.Tk()
root.geometry("500x500")
root.title("Python GUI Project")
title = tk.Label(root, text="Enter your Credentials Here", font=('Arial', 18)).pack(padx=0, pady=10)

emailLabel = tk.Label(root, text="Email").pack(padx=0, pady=10)
email = tk.Entry(root).pack(pady=0)


passwordLabel = tk.Label(root, text="Password").pack(padx=0, pady=10)
password = tk.Entry(root).pack(pady=12)

button = ttk.Button(root, text="Login", command=save_data)
button.pack(pady=10)

root.mainloop()
```

# Basic copied
```python
#Import the required libraries
from tkinter import *
from tkinter import ttk

#Create an instance of Tkinter Frame
win = Tk()

#Set the geometry
win.geometry("700x250")

#Create an Entry Widget (entry is to input single line text)
entry = Entry(win, width= 42)
entry.place(relx= .5, rely= .5, anchor= CENTER)

#Label widget
label= Label(win, text="", font=('Helvetica 13'))
label.pack()

#Button to get input data
ttk.Button(win, text= "Click to Show", command= get_data).place(relx= .7, rely= .5, anchor= CENTER)

win.mainloop()
```
