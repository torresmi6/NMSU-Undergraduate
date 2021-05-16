import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import os
print(os.listdir(r"C:\Users\saite\Desktop\Saiteja\Saiteja"))
df = pd.read_csv(r"C:\Users\saite\Desktop\Saiteja\Saiteja\Mall_Customers_Extended.csv")
df.info()
df.columns
df.head()

#Violin plot on age frequency
plt.figure(figsize=(10,6))
plt.title("Ages Frequency")
sns.axes_style("dark")
sns.violinplot(y=df["Age"])
plt.show()

# Bar plot of age

plt.rcParams['figure.figsize'] = (15, 8)
sns.countplot(df['Age'], palette = 'hsv')
plt.title('Distribution of Age', fontsize = 20)
plt.show()

import warnings
warnings.filterwarnings('ignore')

plt.rcParams['figure.figsize'] = (18, 8)


#Distrubution of annual income...
plt.subplot(1, 2, 1)
sns.set(style = 'whitegrid')
sns.distplot(df['Annual Income'])
plt.title('Distribution of Annual Income', fontsize = 20)
plt.xlabel('Range of Annual Income')
plt.ylabel('Count')

#Distribution of age
plt.subplot(1, 2, 2)
sns.set(style = 'whitegrid')
sns.distplot(df['Age'], color = 'red')
plt.title('Distribution of Age', fontsize = 20)
plt.xlabel('Range of Age')
plt.ylabel('Count')
plt.show()

#Spending score and annual income

plt.figure(figsize=(15,6))
plt.subplot(1,2,1)
sns.boxplot(y=df["Spending Score"], color="red")
plt.subplot(1,2,2)
sns.boxplot(y=df["Annual Income"])
plt.show()

#seggeregation of various ages..
age18_25 = df.Age[(df.Age <= 25) & (df.Age >= 18)]
age26_35 = df.Age[(df.Age <= 35) & (df.Age >= 26)]
age36_45 = df.Age[(df.Age <= 45) & (df.Age >= 36)]
age46_55 = df.Age[(df.Age <= 55) & (df.Age >= 46)]
age55above = df.Age[df.Age >= 56]



x = ["18-25","26-35","36-45","46-55","55+"]
y = [len(age18_25.values),len(age26_35.values),len(age36_45.values),len(age46_55.values),len(age55above.values)]

#plot to comapre various age group of customers
plt.figure(figsize=(15,6))
sns.barplot(x=x, y=y, palette="rocket")
plt.title("Number of Customer and Ages")
plt.xlabel("Age")
plt.ylabel("Number of Customer")
plt.show()

#seggeregating spending scores of the people.

ss1_20 = df["Spending Score"][(df["Spending Score"] >= 1) & (df["Spending Score"] <= 20)]
ss21_40 = df["Spending Score"][(df["Spending Score"] >= 21) & (df["Spending Score"] <= 40)]
ss41_60 = df["Spending Score"][(df["Spending Score"] >= 41) & (df["Spending Score"] <= 60)]
ss61_80 = df["Spending Score"][(df["Spending Score"] >= 61) & (df["Spending Score"] <= 80)]
ss81_100 = df["Spending Score"][(df["Spending Score"] >= 81) & (df["Spending Score"] <= 100)]

ssx = ["1-20", "21-40", "41-60", "61-80", "81-100"]
ssy = [len(ss1_20.values), len(ss21_40.values), len(ss41_60.values), len(ss61_80.values), len(ss81_100.values)]

#This plot helps us to know the the spending ranges of various customers, Lets say it helps us to determine 35 customers are spending between some 1-20k
plt.figure(figsize=(15,6))
sns.barplot(x=ssx, y=ssy, palette="nipy_spectral_r")
plt.title("Spending Scores")
plt.xlabel("Score")
plt.ylabel("Number of Customer Having the Score")
plt.show()
#similar to above concept but different plot.
plt.rcParams['figure.figsize'] = (20, 8)
sns.countplot(df['Spending Score'], palette = 'copper')
plt.title('Distribution of Spending Score', fontsize = 20)
plt.show()


#Age groups spending seggeregation
ss18_25 = df["Spending Score"][(df.Age >= 18) & (df.Age <= 25)]
ss26_35 = df["Spending Score"][(df.Age >= 26) & (df.Age <= 35)]
ss36_45 = df["Spending Score"][(df.Age >= 36) & (df.Age <= 45)]
ss46_55 = df["Spending Score"][(df.Age >= 46) & (df.Age <= 55)]
ss55above = df["Spending Score"][(df.Age > 55)]
total_1=0
avg_1=0
total_2=0
avg_2=0
total_3=0
avg_3=0
total_4=0
avg_4=0
total_5=0
avg_5=0
ssy=[]
for i in ss18_25:
    total_1+=i
avg_1=total_1/len(ss18_25)
ssy.append(avg_1)
for i in ss26_35:
    total_2+=i
avg_2=total_2/len(ss26_35)
ssy.append(avg_2)
for i in ss36_45:
    total_3+=i
avg_3=total_3/len(ss36_45)
ssy.append(avg_3)
for i in ss46_55:
    total_4+=i
avg_4=total_4/len(ss46_55)
ssy.append(avg_4)
for i in ss55above:
    total_5+=i
avg_5=total_5/len(ss55above)
ssy.append(avg_5)



Agex = ["18-25", "26-35", "36-45", "46-55", ">55"]

print("Spending score vs age: ",ssy)
plt.figure(figsize=(15,6))
sns.barplot(x=Agex, y=ssy, palette="nipy_spectral_r")
plt.title("Age vs Spending scores")
plt.xlabel("Age")
plt.ylabel("Spending Scores")
plt.show()

# Annual Income seggeregation
ai0_30 = df["Annual Income"][(df["Annual Income"] >= 0) & (df["Annual Income"] <= 30)]
ai31_60 = df["Annual Income"][(df["Annual Income"] >= 31) & (df["Annual Income"] <= 60)]
ai61_90 = df["Annual Income"][(df["Annual Income"] >= 61) & (df["Annual Income"] <= 90)]
ai91_120 = df["Annual Income"][(df["Annual Income"] >= 91) & (df["Annual Income"] <= 120)]
ai121_150 = df["Annual Income"][(df["Annual Income"] >= 121) & (df["Annual Income"] <= 150)]

aix = ["$ 0 - 30,000", "$ 30,001 - 60,000", "$ 60,001 - 90,000", "$ 90,001 - 120,000", "$ 120,001 - 150,000"]
aiy = [len(ai0_30.values), len(ai31_60.values), len(ai61_90.values), len(ai91_120.values), len(ai121_150.values)]

#bar plot annual income range vs no of customers
plt.figure(figsize=(15,6))
sns.barplot(x=aix, y=aiy, palette="Set2")
plt.title("Annual Incomes")
plt.xlabel("Income")
plt.ylabel("Number of Customer")
plt.show()


# Distrubution plot of the above.
plt.rcParams['figure.figsize'] = (20, 8)
sns.countplot(df['Annual Income'], palette = 'rainbow')
plt.title('Distribution of Annual Income', fontsize = 20)
plt.show()
#plotting a
sns.pairplot(df)
plt.title('Pairplot for the Data', fontsize = 15)
plt.show()
plt.rcParams['figure.figsize'] = (15, 8)
sns.heatmap(df.corr(), cmap = 'Wistia', annot = True)
plt.title('Heatmap for the Data', fontsize = 20)
plt.show()
from mpl_toolkits.mplot3d import Axes3D
#3d plot
sns.set_style("white")
fig = plt.figure(figsize=(20,10))
ax = fig.add_subplot(111, projection='3d')
ax.scatter(df.Age, df["Annual Income"], df["Spending Score"], c='blue', s=60)
ax.view_init(30, 185)
plt.xlabel("Age")
plt.ylabel("Annual Income")
ax.set_zlabel('Spending Score')
plt.show()


from sklearn.cluster import KMeans
wcss = []
for k in range(1,11):
    kmeans = KMeans(n_clusters=k, init="k-means++")
    kmeans.fit(df.iloc[:,1:])
    wcss.append(kmeans.inertia_)
plt.figure(figsize=(12,6))
plt.grid()
plt.plot(range(1,11),wcss, linewidth=2, color="red", marker ="8")
plt.xlabel("K Value")
plt.xticks(np.arange(1,11,1))
plt.ylabel("WCSS")
plt.show()

km = KMeans(n_clusters=5)
clusters = km.fit_predict(df.iloc[:, 1:])
print(clusters)
df["label"] = clusters

fig = plt.figure(figsize=(20, 10))
cluster_1 = 0
cluster_2 = 0
cluster_3 = 0
cluster_4 = 0
cluster_5 = 0
for i in clusters:
    if(i == 0):
        cluster_1+=1
    elif(i == 1):
        cluster_2+=1
    elif(i == 3):
        cluster_3+=1
    elif(i == 4):
        cluster_4+=1
    else:
        cluster_5+=1
print("Cluster 1: " + str(cluster_1))
print("Cluster 2: " + str(cluster_2))
print("Cluster 3: " + str(cluster_3))
print("Cluster 4: " + str(cluster_4))
print("Cluster 5: " + str(cluster_5))

ax = fig.add_subplot(111, projection='3d')
ax.scatter(df.Age[df.label == 0], df["Annual Income"][df.label == 0], df["Spending Score"][df.label == 0],
           c='blue', s=60, label='Cluster 1')
ax.scatter(df.Age[df.label == 1], df["Annual Income"][df.label == 1], df["Spending Score"][df.label == 1],
           c='red', s=60, label='Cluster 2')
ax.scatter(df.Age[df.label == 2], df["Annual Income"][df.label == 2], df["Spending Score"][df.label == 2],
           c='green', s=60, label='Cluster 3')
ax.scatter(df.Age[df.label == 3], df["Annual Income"][df.label == 3], df["Spending Score"][df.label == 3],
           c='orange', s=60, label='Cluster 4')
ax.scatter(df.Age[df.label == 4], df["Annual Income"][df.label == 4], df["Spending Score"][df.label == 4],
           c='purple', s=60, label='Cluster 5')
plt.title("Clusters of Customers")
ax.view_init(30, 185)
plt.xlabel("Age")
plt.ylabel("Annual Income")
ax.set_zlabel('Spending Score')
plt.legend()
plt.show()