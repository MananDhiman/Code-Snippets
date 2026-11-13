**Apache Spark**

Enables clustering and splitting data into chunks to distribute to different computers for processing. Has APIs in Java, Python, Scala


# PySpark
[FreeCodeCamp](https://www.youtube.com/watch?v=_C8kWso4ne4)

```python
# pip install pyspark

import pyspark

from pyspark.sql impor SparkSession
spark = SparkSession.builder.appName('Practice').getOrCreate()

spark # get info

df = spark.read_csv('./path.csv') # takes default columns as _c0, _c1
spark.read.csv('./path.csv', header=True, inferSchema = True)
spark.read.option('header', 'true').csv('./path.csv', inferSchema = True) # takes first row as header # if not using inferschema input is string
df.show() # show dataframe

df.head(3) # first 3, as Row Datatype
df.printSchema() 
df.describe()
df.columns
```

## Column Manipulation
```python
df.select('Column_name')    df.select(['Column_1', 'Column_2']) # returns df with that single col

# Add columns
df.withColumn('Column_name', df["exp"]+2) # pass pyspark col type as 2nd param

# Drop Column
df.drop('Column_name')

# Rename Column
df.withColumnRenamed('Old_name', 'New_Name')
```

## Data Manipulation
**Nulls**
```python
df.na.drop.show() # drop row if any cell contains null

# all if all cells null # thresh = minimum non null values # subset = check only in specific col
df.na.drop.show(how = "all", thresh = 2, subset = ['Exp']) 

df.na.fill('Missing', ['Col_1', 'Col_2']) # fills null with missing # can give columns array
```

**Filtering**
```python
df.filter("Column_name <= 20000") # can .select(['Col1', 'Col2']).show() to give few cols
df.filter((df["Column_name"] <= 20000) & (df["c2"] == "xyz"))
df.filter(~(df["Column_name"] <= 20000)) # ~ is not
```

**Group By and Aggregate**
```python
df.groupBy('Department').sum() # which department max salary # sum mean mode median count

# whole aggregate
df.agg({"salary":"max"}) # gives max sal from dataset
```
