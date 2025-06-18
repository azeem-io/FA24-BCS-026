# Java File Handling Master Guide - OOP Exam Prep

## Table of Contents
1. [File Handling Fundamentals](#file-handling-fundamentals)
2. [Understanding Streams](#understanding-streams)
3. [Text File Operations](#text-file-operations)
4. [Binary File Operations](#binary-file-operations)
5. [Object Serialization](#object-serialization)
6. [Common Mistakes & How to Avoid Them](#common-mistakes--how-to-avoid-them)
7. [Quick Reference Checklists](#quick-reference-checklists)
8. [Practice MCQs](#practice-mcqs)
9. [Tips & Tricks for Exam](#tips--tricks-for-exam)

---

## File Handling Fundamentals

### What is File Handling?
File handling is the process of creating, reading, writing, and manipulating files stored on your computer's storage system. Think of it as a way for your Java program to communicate with files on your hard drive.

### Why Do We Need File Handling?
- **Data Persistence**: Store data permanently (survives program termination)
- **Data Exchange**: Share data between different programs
- **Large Data Processing**: Handle data too large for memory
- **Configuration Storage**: Save application settings

### Key Classes You Must Know
```java
// Essential imports for file handling
import java.io.*;
import java.nio.file.*;
```

**Core Classes:**
- `File`: Represents file/directory paths
- `FileInputStream/FileOutputStream`: For binary data
- `FileReader/FileWriter`: For text data
- `BufferedReader/BufferedWriter`: For efficient text operations
- `ObjectInputStream/ObjectOutputStream`: For object serialization

---

## Understanding Streams

### What is a Stream?
A stream is like a pipe that carries data between your program and a file. Data flows through this pipe in one direction.

### Types of Streams

#### 1. Byte Streams (Binary Data)
- Handle raw binary data (images, videos, executable files)
- Base classes: `InputStream` and `OutputStream`
- Process data as bytes (0-255)

```java
// Example: Copying a binary file
FileInputStream input = new FileInputStream("source.jpg");
FileOutputStream output = new FileOutputStream("copy.jpg");

int byteData;
while ((byteData = input.read()) != -1) {
    output.write(byteData);
}
input.close();
output.close();
```

#### 2. Character Streams (Text Data)
- Handle text data with proper character encoding
- Base classes: `Reader` and `Writer`
- Process data as characters (Unicode support)

```java
// Example: Reading text file
FileReader reader = new FileReader("text.txt");
int charData;
while ((charData = reader.read()) != -1) {
    System.out.print((char) charData);
}
reader.close();
```

### Stream Hierarchy (Important for Exams!)
```
InputStream (Abstract)
├── FileInputStream
├── BufferedInputStream
└── ObjectInputStream

OutputStream (Abstract)
├── FileOutputStream
├── BufferedOutputStream
└── ObjectOutputStream

Reader (Abstract)
├── FileReader
├── BufferedReader
└── InputStreamReader

Writer (Abstract)
├── FileWriter
├── BufferedWriter
└── OutputStreamWriter
```

---

## Text File Operations

### Writing Text Files

#### Method 1: Using FileWriter
```java
try {
    FileWriter writer = new FileWriter("output.txt");
    writer.write("Hello World!");
    writer.write("\nSecond line");
    writer.close(); // CRUCIAL: Always close!
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

#### Method 2: Using BufferedWriter (Recommended)
```java
try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
    writer.write("Hello World!");
    writer.newLine(); // Platform-independent new line
    writer.write("Second line");
    // Auto-closes due to try-with-resources
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

### Reading Text Files

#### Method 1: Using FileReader
```java
try {
    FileReader reader = new FileReader("input.txt");
    int character;
    while ((character = reader.read()) != -1) {
        System.out.print((char) character);
    }
    reader.close();
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

#### Method 2: Using BufferedReader (Recommended)
```java
try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## Binary File Operations

### Why Use Binary Operations?
- Faster than text operations
- Preserve exact data format
- Handle non-text files (images, audio, etc.)
- More memory efficient

### Writing Binary Data
```java
try (FileOutputStream fos = new FileOutputStream("data.bin");
     DataOutputStream dos = new DataOutputStream(fos)) {
    
    dos.writeInt(42);           // Write integer
    dos.writeDouble(3.14159);   // Write double
    dos.writeUTF("Hello");      // Write string
    dos.writeBoolean(true);     // Write boolean
    
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

### Reading Binary Data
```java
try (FileInputStream fis = new FileInputStream("data.bin");
     DataInputStream dis = new DataInputStream(fis)) {
    
    int number = dis.readInt();
    double pi = dis.readDouble();
    String text = dis.readUTF();
    boolean flag = dis.readBoolean();
    
    System.out.println("Number: " + number);
    System.out.println("Pi: " + pi);
    System.out.println("Text: " + text);
    System.out.println("Flag: " + flag);
    
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

**⚠️ IMPORTANT**: Read data in the same order you wrote it!

---

## Object Serialization

### What is Serialization?
Serialization converts Java objects into a byte stream that can be saved to a file or transmitted over a network. Deserialization reverses this process.

### Making a Class Serializable
```java
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Version control
    
    private String name;
    private int age;
    private transient String password; // Won't be serialized
    
    // Constructors, getters, setters...
    public Student(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
    
    // toString method for testing
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", password='" + password + "'}";
    }
}
```

### Serializing Objects (Writing)
```java
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
    Student student = new Student("Alice", 20, "secret123");
    oos.writeObject(student);
    System.out.println("Object serialized successfully!");
} catch (IOException e) {
    System.out.println("Serialization error: " + e.getMessage());
}
```

### Deserializing Objects (Reading)
```java
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
    Student student = (Student) ois.readObject();
    System.out.println("Deserialized: " + student);
} catch (IOException | ClassNotFoundException e) {
    System.out.println("Deserialization error: " + e.getMessage());
}
```

### Key Serialization Concepts

#### serialVersionUID
- Unique identifier for each serializable class
- Ensures compatibility between serialized and deserialized objects
- If not specified, JVM generates one automatically

#### transient keyword
- Marks fields that should NOT be serialized
- Useful for sensitive data (passwords) or derived values
- Transient fields get default values during deserialization

#### static fields
- Static fields are NOT serialized (they belong to the class, not instance)

---

## Common Mistakes & How to Avoid Them

### 1. Forgetting to Close Resources
**❌ Wrong:**
```java
FileWriter writer = new FileWriter("file.txt");
writer.write("Hello");
// Forgot to close - resource leak!
```

**✅ Correct:**
```java
try (FileWriter writer = new FileWriter("file.txt")) {
    writer.write("Hello");
} // Auto-closes
```

### 2. Not Handling Exceptions
**❌ Wrong:**
```java
FileReader reader = new FileReader("file.txt"); // Compilation error!
```

**✅ Correct:**
```java
try {
    FileReader reader = new FileReader("file.txt");
    // ... use reader
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

### 3. Wrong Order in Binary Read/Write
**❌ Wrong:**
```java
// Writing
dos.writeInt(42);
dos.writeString("Hello");

// Reading
String text = dis.readString(); // Wrong order!
int number = dis.readInt();
```

**✅ Correct:**
```java
// Writing
dos.writeInt(42);
dos.writeUTF("Hello");

// Reading (same order)
int number = dis.readInt();
String text = dis.readUTF();
```

### 4. Serialization Without Implementing Serializable
**❌ Wrong:**
```java
public class Person { // Missing Serializable
    private String name;
}
// Will throw NotSerializableException
```

**✅ Correct:**
```java
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
}
```

### 5. Forgetting File Paths
**❌ Wrong:**
```java
new FileReader("nonexistent.txt"); // FileNotFoundException
```

**✅ Correct:**
```java
File file = new File("data.txt");
if (file.exists()) {
    FileReader reader = new FileReader(file);
} else {
    System.out.println("File not found!");
}
```

---

## Quick Reference Checklists

### ✅ Text File Writing Checklist
- [ ] Import `java.io.*`
- [ ] Use try-with-resources or proper try-catch-finally
- [ ] Choose appropriate Writer (FileWriter/BufferedWriter)
- [ ] Handle IOException
- [ ] Close the stream (auto-close with try-with-resources)
- [ ] Test with sample data

### ✅ Text File Reading Checklist
- [ ] Import `java.io.*`
- [ ] Check if file exists
- [ ] Use try-with-resources
- [ ] Choose appropriate Reader (FileReader/BufferedReader)
- [ ] Handle IOException
- [ ] Check for end-of-file conditions
- [ ] Close the stream

### ✅ Binary File Operations Checklist
- [ ] Use DataInputStream/DataOutputStream for structured data
- [ ] Use FileInputStream/FileOutputStream for raw bytes
- [ ] Read data in the same order as written
- [ ] Handle IOException
- [ ] Use try-with-resources
- [ ] Test with known data values

### ✅ Serialization Checklist
- [ ] Class implements Serializable
- [ ] Add serialVersionUID
- [ ] Mark sensitive fields as transient
- [ ] Use ObjectOutputStream for writing
- [ ] Use ObjectInputStream for reading
- [ ] Handle IOException AND ClassNotFoundException
- [ ] Cast object after reading: `(ClassName) ois.readObject()`
- [ ] Test serialization/deserialization cycle

### ✅ General File Handling Checklist
- [ ] Proper exception handling
- [ ] Resource management (close streams)
- [ ] File path validation
- [ ] Permission checks (read/write access)
- [ ] Backup important data before modification
- [ ] Test with edge cases (empty files, large files)

---

## Practice MCQs

### Question 1
Which of the following is used to read binary data from a file?
a) FileReader
b) BufferedReader
c) FileInputStream
d) Scanner

**Answer: c) FileInputStream**

### Question 2
What happens if you forget to close a FileOutputStream?
a) Compilation error
b) Runtime exception
c) Resource leak
d) File gets corrupted

**Answer: c) Resource leak**

### Question 3
Which keyword prevents a field from being serialized?
a) static
b) final
c) transient
d) volatile

**Answer: c) transient**

### Question 4
What exception is thrown when trying to serialize a non-serializable object?
a) IOException
b) ClassNotFoundException
c) NotSerializableException
d) SerializationException

**Answer: c) NotSerializableException**

### Question 5
Which is the correct way to read a line from a text file?
a) `fileReader.readLine()`
b) `bufferedReader.readLine()`
c) `fileInputStream.readLine()`
d) `scanner.readLine()`

**Answer: b) bufferedReader.readLine()**

### Question 6
What is the purpose of serialVersionUID?
a) To generate unique object IDs
b) To ensure serialization compatibility
c) To improve serialization performance
d) To encrypt serialized data

**Answer: b) To ensure serialization compatibility**

### Question 7
Which stream should you use for copying a JPEG image?
a) FileReader and FileWriter
b) BufferedReader and BufferedWriter
c) FileInputStream and FileOutputStream
d) DataInputStream and DataOutputStream

**Answer: c) FileInputStream and FileOutputStream**

### Question 8
What does the `flush()` method do?
a) Closes the stream
b) Forces buffered data to be written
c) Clears the buffer
d) Resets the stream position

**Answer: b) Forces buffered data to be written**

---

## Tips & Tricks for Exam

### 🎯 Memory Tricks

**Stream Types:**
- **Byte streams** end with "Stream" (InputStream, OutputStream)
- **Character streams** end with "Reader" or "Writer"

**Buffered = Better Performance:**
- Always prefer BufferedReader over FileReader
- Always prefer BufferedWriter over FileWriter

**Serialization Rhyme:**
- "Serializable to save, transient to behave"
- "Same order read as write, or you'll be up all night"

### 🎯 Common Exam Patterns

1. **Try-with-resources is preferred** over manual close()
2. **Always handle IOException** in file operations
3. **Serialization needs Serializable interface**
4. **Read binary data in same order as written**
5. **transient fields don't get serialized**

### 🎯 Code Writing Strategy

1. **Start with imports**: `import java.io.*;`
2. **Use try-with-resources**: Automatic cleanup
3. **Handle exceptions**: IOException is checked
4. **Test boundary conditions**: Empty files, null values
5. **Remember serialVersionUID**: For serializable classes

### 🎯 Debugging Tips

- **FileNotFoundException**: Check file path and existence
- **ClassNotFoundException**: Ensure class is in classpath during deserialization
- **NotSerializableException**: Add implements Serializable
- **EOFException**: Trying to read beyond file end

### 🎯 Performance Tips for Exam Questions

- **BufferedReader/Writer**: Faster than FileReader/Writer
- **DataInputStream/OutputStream**: Efficient for primitive types
- **ObjectInputStream/OutputStream**: For complex objects
- **FileInputStream/OutputStream**: For raw binary data

---

## Final Exam Preparation Summary

### Must Remember for Exam:
1. **Stream hierarchy** and when to use each type
2. **Exception handling** - IOException is always required
3. **Resource management** - Use try-with-resources
4. **Serialization requirements** - Serializable interface, serialVersionUID
5. **Binary vs Text** - Choose appropriate stream type
6. **Order matters** - Read binary data in write order

### Quick Reference Code Templates:

**Text File Read:**
```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    String line;
    while ((line = br.readLine()) != null) {
        // Process line
    }
} catch (IOException e) {
    // Handle error
}
```

**Binary File Write:**
```java
try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"))) {
    dos.writeInt(value);
    dos.writeUTF(text);
} catch (IOException e) {
    // Handle error
}
```

**Object Serialization:**
```java
// Write
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.ser"))) {
    oos.writeObject(myObject);
} catch (IOException e) { /* handle */ }

// Read
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.ser"))) {
    MyClass obj = (MyClass) ois.readObject();
} catch (IOException | ClassNotFoundException e) { /* handle */ }
```

---

**Good luck with your exam! Remember: Practice makes perfect, and understanding concepts is better than memorizing code. You've got this! 🚀**
