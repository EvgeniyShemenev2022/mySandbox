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

