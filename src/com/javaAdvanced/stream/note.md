## 1
Методы STREAM не меняют коллекцию или массив от которых был создан поток;

## 2  SORTED
В параметры метода sorted() нужно вставить comparator(), если предстоит сортировать
объекты;
.sorted((x,y) -> x.getName.compareTo(y.getName).
возвращает stream, поэтому нужен терминальный метод collect()

## 3 Intermediate methods (lazy)
Intermediate methods не вызываются до тех пор, пока не применен Terminal method;
* sorted()
* filer()
* map()
* flatMap()
* distinct()
* limit(n) - пропускает дальше только первые n эл-в 
* skip(n)  - не пропускает дальше первые n эл-в
* mapToInt()
* parallelStream() -> использовать только при умножении или сложении;


## 4 Terminal methods
Terminal methods возвращают либо void, либо отличное от stream значение:
* foreEach() 
* collect()
* reduce()
* count()
* groupingBy()
* partitioningBy()
* findFirst()  -> return Optional -> либо без проверки использовать .findFirst().get
* min()  -> return Optional
* max()  -> return Optional
* sum()
* average()
* 
* 


## 5
Потоки нельзя переиспользовать, например:
> System.out.println(stream2.count());
> 
> System.out.println(stream2.distinct().count()); 


