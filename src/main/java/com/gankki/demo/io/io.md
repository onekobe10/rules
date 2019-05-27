# IO

E:/gankkscode/gankkidir/hello.txt

对于UTF-8编码的文件，我们需要特别说明一下，有一种方式，可以标记该文件是UTF-8编码的，那就是在文件最开头，加入三个特殊字节 (0xEF 0xBB 0xBF)，这三个特殊字节被称为BOM头，BOM是Byte Order Mark (即字节序标记) 的缩写。比如，对前面的hello.txt文件，带BOM头的UTF-8编码的十六进制形式为：EF BB BF ...        

在Windows中，目录之间用反斜线分隔，如"C:\code\hello.java"，在Linux中，目录之间用斜线分隔，如"/Users/laoma/Desktop/code/hello.java"。在Java中，java.io.File类定义了一个静态变量File.separator，表示路径分隔符，编程时应使用该变量而避免硬编码。

在Linux系统中，如果文件名以.开头，则为隐藏文件，在Windows系统中，隐藏是文件的一个属性，可以进行设置。

操作系统一般支持一种称之为内存映射文件的高效的随机读写大文件的方法，将文件直接映射到内存，操作内存就是操作文件，在内存映射文件中，只有访问到的数据才会被实际拷贝到内存，且数据只会拷贝一次，被操作系统以及多个应用程序共享。

InputStream.read()方法在输入数据可用、检测到文件末尾、抛出异常这些操作之前，此方法一直阻塞。
读入文件的时候，如果文件为空或者读到了文件的末尾read方法会返回-1     
在Socket IO中发送方如果不将输出流关闭，接收方就会认为输入流没有结束，直到超时，封装的协议中也会包含信息包的长度让接收方判断一次接收操作是否结束。


#### 字节流
1. InputStream/OutputStream：是抽象基类，有很多面向流的代码，以它们为参数。
2. ByteArrayInputStream/ByteArrayOutputStream：源和目的地是字节数组。可以将字节数组封装成字节数组流，是适配器模式的应用。
    >ByteArrayOutputStream类是在创建它的实例时，程序内部创建一个byte类型数组的缓冲区，然后利用ByteArrayOutputStream和ByteArrayInputStream的实例向数组中写入或读出byte型数据。在网络传输中我们往往要传输很多变量，我们可以利用ByteArrayOutputStream把所有的变量收集到一起，然后一次性把数据发送出去。
    >ByteArrayOutputStream: 可以捕获内存缓冲区的数据，转换成字节数组     
    >ByteArrayInputStream: 可以将字节数组转化为输入流    
    >要创建临时性文件的程序以及网络数据的传输、数据压缩后的传输等可以提高运行的的效率，可以不用访问磁盘。     
    >流的来源和目的地不一定都是文件，这两个类可以将字节数组当作流输入来源和输出目的地。
3. DataInputStream/DataOutputStream：装饰类，按基本类型和字符串读写流。
   >可以将Java中的基本数据类型和字符串类型以字节流的形式读取。
4. BufferedInputStream/BufferedOutputStream：装饰类，提供缓冲。**FileInputStream/FileOutputStream一般总是应该用该类装饰。**

对于文本文件，字节流没有编码的概念，也不能按行处理，使用不太方便，更适合的是使用字符流。

#### 字符流
1. Reader/Writer：字符流的基类，它们是抽象类。
2. InputStreamReader/OutputStreamWriter：适配器类，输入是InputStream，输出是OutputStream，将字节流转换为字符流。     
一个重要的参数是编码类型，可以通过名字charsetName或Charset对象传入，如果没有传，则为系统默认编码，默认编码可以通过Charset.defaultCharset()得到。OutputStreamWriter内部有一个类型为StreamEncoder的编码器，能将char转换为对应编码的字节。InputStreamReader内部有一个类型为StreamDecoder的解码器，能将字节根据编码转换为char。
3. FileReader/FileWriter：输入源和输出目标是文件的字符流。
4. CharArrayReader/CharArrayWriter: 输入源和输出目标是char数组的字符流。
5. StringReader/StringWriter：输入源和输出目标是String的字符流。
    >如果你遇到一个情景是你必须使用一个Reader或者Writer来作为参数传递参数，但你的数据源又仅仅是一个String类型数据，无需从文件中写出，那么此时就可以用到它们。并且值得注意的是StringWriter中，写入的数据只是存在于缓存中，并不会写入实质的存储介质之中。
6. BufferedReader/BufferedWriter：装饰类，对输入输出流提供缓冲，以及按行读写功能。
7. PrintWriter：装饰类，可将基本类型和对象转换为其字符串形式输出的类。缓冲大小为默认为8192。      
    >PrintWriter是一个非常方便的类，可以直接指定文件名作为参数，可以指定编码类型，可以自动缓冲，可以自动将多种类型转换为字符串，在输出到文件时，可以优先选择该类。      
>除了这些类，Java中还有一个类Scanner，类似于一个Reader，但不是Reader的子类，可以读取基本类型的字符串形式，类似于PrintWriter的逆操作。

PrintSteam&PrintWriter的区别：
1. PrintWriter多了一个 `public PrintWriter (Writer out){}`的构造方法，其余两者的构造方法都一样。
2. PrintStream在输出字符，将字符转换为字节时采用的是系统默认的编码格式，这样当数据传输另一个平台，而另一个平台使用另外一个编码格式解码时就会出现问题，存在不可控因素。而PrintWriter可以在传入Writer时 `public OutputStreamWriter(OutputStream out, Charset cs){}`可由程序员指定字符转换为字节时的编码格式，这样兼容性和可控性会更好。1.8中PrintSteam已经可以指定字符编码。`private PrintStream(boolean autoFlush, OutputStream out, Charset charset) {}`
3. PrintStream可以使用字节流对象输出，如果是字符对象的输出，会按系统的默认编码或者给定的编码转成字节数组输出。PrintWriter既可以处理字节流也可以处理字符流
4. PrintStream在遇到换行符的时候就会自动刷新，即在调用了println()方法，或者文本中出现“\n”,就会自动flush。PrintWriter则不会，要在构造方法中设置自动刷新，或者手动flush。
5. System.out.println()中使用的是PrintStream，PrintWriter虽然功能更强大，但是PrintSteam出现的早。

在文本文件中，编码非常重要，同一个字符，不同编码方式对应的二进制形式可能是不一样的。

UTF-16BE是Jvm内部对字符的编码方式。

字节流是按字节读取的，而字符流则是按char读取的，一个char在文件中保存的是几个字节与编码有关，但字符流给我们封装了这种细节，我们操作的对象就是char。

Reader中处理的单位是char，比如read读取的是一个char，取值范围为0到65535。Reader没有available方法，对应的方法是ready()。Writer处理的单位是char，Writer还接受String类型，我们知道，String的内部就是char数组，处理时，会调用String的getChar方法先获取char数组。

FileReader/FileWriter的输入和目的是文件。FileReader是InputStreamReader的子类

**需要注意的是，FileReader/FileWriter不能指定编码类型，只能使用默认编码，如果需要指定编码类型，可以使用InputStreamReader/OutputStreamWriter。**

CharArrayWriter与ByteArrayOutputStream类似，它的输出目标是char数组，这个数组的长度可以根据数据内容动态扩展。

StringReader/StringWriter与CharArrayReader/CharArrayWriter类似，只是输入源为String，输出目标为StringBuffer，而且，String/StringBuffer内部是由char数组组成的，所以它们本质上是一样的。

之所以要将char数组/String与Reader/Writer进行转换也是为了能够方便的参与Reader/Writer构成的协作体系，复用代码。

FileReader/FileWriter是没有缓冲的，也不能按行读写，所以，一般应该在它们的外面包上对应的缓冲类。

在Linux系统中，标准输入输出流也是一种重要的协作机制。很多命令都很小，只完成单一功能，实际完成一项工作经常需要组合使用多个命令，它们协作的模式就是通过标准输入输出流，每个命令都可以从标准输入接受参数，处理结果写到标准输出，这个标准输出可以连接到下一个命令作为标准输入，构成管道式的处理链条。比如，查找一个日志文件access.log中"127.0.0.1"出现的行数，可以使用命令：
`cat access.log | grep 127.0.0.1 | wc -l`       
有三个程序cat, grep, wc，|是管道符号，它将cat的标准输出重定向为了grep的标准输入，而grep的标准输出又成了wc的标准输入。

**写文件时，可以优先考虑PrintWriter，因为它使用方便，支持自动缓冲、支持指定编码类型、支持类型转换等。读文件时，如果需要指定编码类型，需要使用InputStreamReader，不需要，可使用FileReader，但都应该考虑在外面包上缓冲类BufferedReader。**
























