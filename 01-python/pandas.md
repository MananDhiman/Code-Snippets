Pandas - Panel Data

[Bro Code](https://www.youtube.com/watch?v=VXtjG_GzO7Q)

Series

loc - location
iloc - index location

```python
import pandas as pd

# series - 1d array
# dataframe - table or 2d array

data = [100, 101]
series = pd.Series(data, index=["a","b"])
df = pd.read_csv("./path.csv", index_col = "Name") # index_col is optional  # pd.read_json("./path.json")

series.loc["a"] = 1000 # set row
print(series.loc["a"]) # get row where label is a

print(series[series >= 200]) # filters where val > 200

dic = {"day 1": 1000, "day 2": 2000, "day 3 ": 1500}
series = pd.Series(dic)
series.loc["day 3"] += 500
```

DataFrame
```python
data = {
  "Name": ["Spongebob", "Patrick", "Squidward"],
  "Age": [30, 35, 50]
}

df = pd.DataFrame(data, index = ["Employee 1", "Employee 2", "Employee 3"])
print(df.loc["Employee 1"]) # Spongebob
print(df.iloc[1]) # Patrick

# Add new Column
df["Job"] = ["cook", "N/A", "Cashier"]

# Add new row
new_row = pd.DataFrame([{"Name": "Sandy", "Age": 28, "Job":"Engineer"}])
df = pd.concat([df, new_row]) # inside array, n number of DFs
```

Important Operations

```python
print(df["Name"].to_string()) # prints entire datafram, no truncation

print(df[["Name","Height", "Weight"]].to_string()) # print selected columns

print(df.loc["Pikachy"]) # if index_col = "col_name" provided
print(df.loc["Pikachy", ["Height", "Weight"]]) # Select fewer cols
print(df.loc["Pikachy":"Some other thing", ["Height", "Weight"]]) # print range

df.iloc[start:end:step, col_start, col_end]
print(df.iloc[0:11]) # print first 10 rows

# filter using values
tall = df[df["Height"] >= 2]

# Conditions
avg = df[df["Height"] >= 2 & df["Height"] <=3]
fire_and_ice = df[df["power"] == 'Fire' | df["power"] == 'Ice']

# Single Col
print(df['Height'].mean())

# Aggregate - Whole dataframe
print(df.mean(numeric_only = True)) # sum min max count(doesn't require num_only param)

# Group By
print(df.groupby('col_name').mean(numeric_only = True))
```

Data Cleaning
```python
# drop / remove unwanted cols
df = df.drop(columns=['col_name']) # drop returns new df

# handle missing data
df = df.dropna(subset=['col_name']) # drop returns new df
# Fill in place
df = df.fillna({"Col_name":"Value"})

# modify
df = df['col_name'].replace({"old_val": "new_val"})
df['col_name'] = df['col_name'].upper()

```
