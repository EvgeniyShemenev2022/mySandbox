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

