## IO
Stream (поток) для работы файлами - упорядоченная последовательность данных.

Файлы разделяются на:
* читабельные **text files** 
* нечитабельные **binary files**


### FileWriter
`FileWriter writer = new FileWriter("FileName.txt");
 FileWriter writer = new FileWriter("FileName.txt", true); // if want to append`

### FileReader
`FileReader reader = null;
reader = new FileReader("FileName.txt");`

### BufferedReader & BufferedWriter
`BufferedWriter writer = new BufferedWriter(new FileWriter("FileName.txt"))
BufferedReader reader = new BufferedReader(new FileReader("FileName.txt"))`

**BufferedWriter** & **BufferedReader** являются классами-обертками для _FileWriter_ & _FileReader_; Позволяет начать
воспроизведение потока даже в момент неполной загрузки;

Использование буферизации позволяет достичь большей производительности;

Используется для **читабельных** файлов. Для прочих файлов есть классы _FileInputStream & FileOutputStream_;

### DataInputStream и DataOutputStream
Используются для работы с примитивными типами данных.
`DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("my_test.bin"));`
Запись происходит в бинарные файлы.


### Сериализация
Сериализация - процесс преобразования объекта в последовательность байт. 
Де сериализация - обратный процесс;
`try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees.bin")))
try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("employees.bin")))`

Объект, класс которого не имплиментирует **Serializable** не может быть сериализован!
Все другие объекты, являющиеся параметрами записываемого объекта так же должны быть **Serializable**!!!

Поля класса, помеченные ключевым словом **transient** не записываются в файл при сериализации. Например
поле  **_transient double salary_** будет записываться дефолтным значением double (salary = 0.0);

Настоятельно рекомендуется явным образом объявлять serialVersionUID у объекта, т.к. внутренний механизм компилятора 
очень чувствителен к изменению содержания класса.
`static final long serialVersionUID = 1;`

В IntelliJ IDEA можно добавить опцию проверки наличия поля **SerialVersionUID**: 
_Preferences -> Editor -> Inspections -> JVM languages ->_ поставить галочку напротив 
_Serializable class without 'serialVersionUID'_

### RandomAccessFile
Класс RandomAccessFile позволяет читать\записывать информацию из\в любое место файла.
`try (RandomAccessFile file = new RandomAccessFile("IOtest3.txt", "rw"))`
имеет в наличии множество полезных методов (некоторые рассмотрены в файле)