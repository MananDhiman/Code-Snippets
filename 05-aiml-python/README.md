# Basic Commands
Pandas - Data analysis, data manipulation
```python
import pandas as pd, numpy as np, matplotlib.pyplot as plt

dataframe = pd.read_csv("file.csv") # read csv
df.to_csv("new_file.csv") # write dataframe to csv

pd.read_json('xyz.json') # red json

# read first 10 rows for column 'name', if no param, 5 rows printed
dataframe['name'].head(10)
df.head() # Print first 5 rows
df.tail() # print last 5 rows

df.dtypes # Give Data types

df.shape # Give shape (grid) of the data
df.info() or df.describe() # data info

df.FRUITS.unique() # unique vals of fruits
# largest 2 rows by value of col QUANTITY (only num cols)
df.nlargest(2, 'QUANTITY')
# smallest 2 rows (only num cols)
df.nsmallest(2, 'QUANTITY')
# select rows with price > 50
df[df.PRICE > 50]

# Select FRUITS name, price having PRICE <70
df.loc[df['PRICE'] < 70, ['FRUITS', 'PRICE']]

df.iloc[2:5] # select 2 to 5 rows

df['PRICE'].sum() # sum of vals of col
df['PRICE'].cumsum() # cumulative sum?
df['PRICE'].min() # min val
df['PRICE'].max() # max val
df['PRICE'].mean() # mean value of 'price' col
df['PRICE'].median() # median value of 'price' col
df['PRICE'].var() # variance value of ‘PRICE’ column
df['PRICE'].std() # standard deviation value of ‘PRICE’ column
df['PRICE'].quantile([0.25, 0.75]) # 25, 75 percentile value
df.corr(numeric_only=True) # compute correlation b/w numerical values

df.isnull().sum() # Return rowwise count of null

# fill null values with the specified values which can be Mean, median, mode or any
df['DISCOUNT'] = df['DISCOUNT'].fillna(value=VALUE)
df['DISCOUNT'].fillna(value=df['DISCOUNT'].mode()[0], inplace=True)

# drop the null values
df1 = df.dropna()

# Sort values of ‘Price’ of data frame in asc order
df.sort_values('Price', ascending=True)	

# rename Fruits to FRUITS, inplace modifies original data set
df.rename(columns={'Fruits': 'FRUITS', 'Quantity': 'QUANTITY', 'Price': 'PRICE'},inplace=True)

df1 = df.drop(columns=['QUANTITY'], axis=1) # drop column, axis=1 means column
```