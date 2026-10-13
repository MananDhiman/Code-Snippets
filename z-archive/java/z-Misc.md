# Memory Used
```java
long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

System.out.println("Memory Used by program is "+(afterUsedMem-beforeUsedMem) + " bytes");
```

# Time Taken
```java
long startTime = System.currentTimeMillis();
long endTime = System.currentTimeMillis();

System.out.println("Time Taken By Program is "+(endTime-startTime)+ " milliseconds");
```