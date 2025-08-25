package course.java_core.basics.final_project;

public class BookList {

    private int size = 0;
    private Book[] arrayBook = new Book[10];

    public void addBook(Book book){

        if (size == arrayBook.length){
            arrayBook = createLargerArray();
        }

        arrayBook[size] = book;
        size++;

    }

    public Book getBook(int index){
        if (index <= 0 || index >= size){
            System.err.println("невірний індекс.");
            return null;
        }else {

            return arrayBook[index];
        }
    }

    public void setBook(int index, Book book){

        if (index <= 0 || index >= size){
            System.err.println("невірний індекс.");
        }
        if (book == null){
            System.err.println("значення book пусте");
        }
        else {

            arrayBook[index] = book;
        }
    }

    public void removeBook(int index){
        if (index < 0 || index >= size){
            System.err.println("невірний індекс.");
        }else {

            for (int i = index; i < size - 1; i++) {
                arrayBook[i] = arrayBook[i+1];
            }

            arrayBook[size - 1] = null;
            size = size - 1;
        }
    }

    public int getSize(){
        return size;
    }



    //-------------- helpers ------------------

    private Book[] createLargerArray(){

        Book[] largerArray = new Book[arrayBook.length*2];

        for (int i = 0; i < arrayBook.length; i++) {
            largerArray[i] = arrayBook[i];
        }

        return largerArray;
    }
}
