# Basic Commands

## Fewer Commands
Basic
```python
import pandas as pd

df = pd.read_csv('diabetes.csv')

df.shape Df.shape[0] # rows Df.shape[1] # columns
df.dtypes # list data types
df.columns # list column names
df.info() # statistical data
df.info(include='object') df.info(include='all') df.describe(exclude='number')

df.isna().count()

df.drop(‘column_name’,axis=1)
df.drop([‘a’,‘b’], axis=1)

df_imputed['Gender'].unique() # if less vals find mode, otherwise mean

diabetes_data.replace(['Female'],'F', inplace=True)
diabetes_data['Gender'].fillna(diabetes_data['Gender'].mode()[0], inplace = True)

df.rename(columns={"sex":"gender", “male”:”F”}, inplace=True)

df_clean_copy = cleaned_df.copy()

```
Loc iLoc
```python
# iloc
df.iloc[start_row_index:end_row_index, start_column_index:end_column_index]
# loc
df.loc[start_row_index:end_row_index, [list of columns]]

# Feature sel
# using .loc[:,:] : means all
X = data.loc[:,['Pregnancies', 'Glucose', 'BloodPressure', 'SkinThickness', 'Insulin','BMI', 'DiabetesPedigreeFunction', 'Age']]

diabetes_data.loc[10:100,['Age','BMI','Gender']]

# add conditions
diabetes_data.loc[(diabetes_data['Gender'] == 'Female') & (diabetes_data['BMI'] < 30), ['Age','BMI','BloodPressure','Gender']]
diabetes_data[(diabetes_data['BMI']>21) & (diabetes_data['Gender']=='Male')]
```
Removing outliers
```python
# first check if outliers exist
plt.figure(figsize=(21,7))
sns.boxplot(data)

qt3 = df[‘BMI’].quantile(0.75)
q1 = cleaned_df.quantile(0.25,numeric_only=True)
qt1 = df[‘BMI’].quantile(0.25)
q3 = cleaned_df.quantile(0.75,numeric_only=True)
iqr = (qt_3 - qt_1)

upper_limit = qt_3 + (iqr * 1.5)
upper_limit = Q3 + 1.5 * IQR
lower_limit = qt_1 - (iqr * 1.5)
lower_limit = Q1 - 1.5 * IQR

BMI_filtered = df_dropped_na.BMI[ (df_dropped_na.BMI > lower_limit) & (df_dropped_na.BMI < upper_limit) ]

lower_array = df_diabetes.drop(index=np.where(df_diabetes['bmi'] <= lower)[0], inplace=True)

# Replacing workhour outliers with mean of WorkWeekHrs.
df_dropped_na.loc[BMI_outliers.index, 'BMI'] = df_dropped_na.BMI.mean()

# to be tested
data.loc[(data['age'] >= 25) | (data['age'] <= 75),['age']] = data['age'].mean()
```
Min Max Scaler and Label Encoder
```python
# label encoder only for string
from sklearn.preprocessing import LabelEncoder, MinMaxScaler

le = LabelEncoder()
df_clean_copy['region'] = le.fit_transform(df_clean_copy['region'])


mm = MinMaxScaler()
df_clean_copy[cols] = mm.fit_transform(df_clean_copy[cols])
df_imputed['BMI_rescaled'] = MinMaxScaler().fit_transform(df_imputed.loc[:, ['BMI']])
data.loc[:,['Gender']] = sc.fit_transform(data.loc[:,['Gender']])

X.iloc[:,:] = sc.fit_transform(X.iloc[:,:])

```
Model Selection and Training
```python
# if not separate files for testing training
from sklearn.model_selection import train_test_split
X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.3,random_state=42)

# Regression for continuous numeric vals, classifier for discrete vals
from sklearn.linear_model import LinearRegression
model = LinearRegression()
from sklearn.linear_model import LogisticRegression
lg = LogisticRegression()
from sklearn.tree import DecisionTreeRegressor
clf= DecisionTreeRegressor()
from sklearn.neighbors import KNeighborsClassifier
model = KNeighborsClassifier(n_neighbors=7)

model.fit(X_train, Y_train)
model.score(X_train, Y_train)
predictions = model.predict(X_test)

from sklearn.tree import DecisionTreeClassifier
clf_gini = DecisionTreeClassifier(criterion="gini", max_depth=3)#instance
clf_gini = clf_gini.fit(X_train,Y_train)
```
Model Evaluation
```python
from sklearn.metrics import mean_squared_error,mean_absolute_error
mse = mean_squared_error(Y_test, predictions)
print("mse: ",mse)
rmse = mean_squared_error(Y_test, predictions)**(0.5)
print("rmse: ",rmse)
mae = mean_absolute_error(Y_test, predictions)
print("mae: ",mae)

from sklearn import metrics
print('Mean Absolute Error:', metrics.mean_absolute_error(Y_test, Y_pred))
print('Mean Squared Error:', metrics.mean_squared_error(Y_test, Y_pred))
print('Root Mean Squared Error:', np.sqrt(metrics.mean_squared_error(Y_test, Y_pred)))

```
Plotting
```python
Plotting
import matplotlib.pyplot as plt
import seaborn as sns

average_values.plot(kind='bar', figsize=(10, 6))
plt.title('Average Values of Attributes by Diabetes Outcome')
plt.xlabel('Diabetes Outcome (0 = No, 1 = Yes)')
plt.ylabel('Average Value')
plt.xticks(rotation=0) # Rotate x-axis labels for better readability
plt.legend(title='Attributes')
plt.grid(axis='y')
# Show the plot
plt.tight_layout()
plt.show()

Histogram
#Histogram
plt.hist(df['age'], bins=50, color='red', edgecolor='black', alpha=0.6)
plt.title('Histogram of Age')
plt.xlabel('Value')
plt.ylabel('Frequency')
plt.show()

Correlation matrix
correlation_matrix = df.corr(numeric_only=True)
sns.heatmap(correlation_matrix, annot=True, cmap='coolwarm')

fig,ax = plt.subplots(figsize=(15,7))
sns.heatmap(data.corr(numeric_only=True), annot=True, cmap='Purples')
plt.title('HeatMap')
plt.show()

# Box Plot
sns.boxplot(x='gender', y='bmi', data=df, hue='gender')
plt.title('Box Plot of bmi by gender')
plt.show()
Scatter Plot
X=cleaned_df.bmi
Y=cleaned_df.charges

# Scatter Plot
plt.figure(figsize=(10, 6))
sns.scatterplot(x=X, y=Y, data=cleaned_df, hue='smoker', style='gender', s=50)

# Add titles and labels
plt.title('Scatter Plot of BMI vs. Charges', fontsize=16)
plt.xlabel('BMI', fontsize=14)
plt.ylabel('Charges', fontsize=14)

 # Adding trendline
z = np.polyfit(X, Y, 1)
p = np.poly1d(z)
plt.plot(X,p(X),"b--", label='the best-fit line')
    
# Show the plot
plt.legend()
plt.show()

Pie 
plt.pie([male_count,female_count], labels = ['Male','Female'], colors=['c','m'], startangle=45, autopct='%.2f%%',explode=(0,0.09))
plt.title('Male vs Female Comparison')
plt.show()

```
Pandas - Data analysis, data manipulation
```python
import pandas as pd, numpy as np, matplotlib.pyplot as plt, seaborn as sns

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