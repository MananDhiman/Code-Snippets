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

# Sample DataFrame
data = [("6-11",), ("5-9",), ("6-0",), (None,)]
df = spark.createDataFrame(data, ["height_str"])

# From CSV
df = spark.read.csv('./path.csv') # takes default columns as _c0, _c1
spark.read.csv('./path.csv', header=True, inferSchema = True)
# takes first row as header # if not using inferschema input is string, inferschema is perf heavy, reads all rows
spark.read.option('header', 'true').csv('./path.csv', inferSchema = True) 
df.show() # show dataframe

df.head(3) # first 3, as Row Datatype
df.printSchema() 
df.describe()
df.columns
```

## Column Manipulation
```python
# Point to Column # select() # params -> cols string, class column, or list  
x = df.col_name | df['col_name'] | col('col_name')
df.select(x)
# returns df with that single col # not necessary to use list
df.select('Column_name') | df.select(['Column_1', 'Column_2']) | df.select('c1', 'c2') 

# Add columns
df.withColumn('Column_name', df["exp"]+2) # pass pyspark col type as 2nd param

# Drop Column
df.drop('Column_name')

# Rename Column
df.withColumnRenamed('Old_name', 'New_Name')
```

## Type Conversion
```python
date_as_string = df['Date'].cast(StringType())

# For string (20.0) to int
df["Age"].cast(DoubleType()).cast(IntegerType())
```

## Data Manipulation
**Nulls**
```python
df = df.na.drop.show() # drop row if any cell contains null

# all if all cells null # thresh = minimum non null values # subset = check only in specific col
df = df.na.drop.show(how = "all", thresh = 2, subset = ['Exp']) 

df = df.na.fill('Missing', ['Col_1', 'Col_2']) # fills null with missing # can give columns array
```

**Filtering**
```python
df.filter("Column_name <= 20000") # can .select(['Col1', 'Col2']).show() to give few cols
df.filter((df["Column_name"] <= 20000) & (df["c2"] == "xyz"))
df.filter(~(df["Column_name"] <= 20000)) # ~ is not
```

**Date Manipulation**
```python
next_date = date_add(df['date'], 2)
```

**Group By and Aggregate**
```python
df.groupBy('Department').sum() # which department max salary # sum mean mode median count

# whole aggregate
df.agg({"salary":"max"}) # gives max sal from dataset
```

## SQL
```python
df.createOrReplaceTempView("df")
spark.sql("SELECT * FROM df")
```
