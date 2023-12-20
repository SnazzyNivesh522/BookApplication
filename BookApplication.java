public class BookApplication{
    public static void main(String[] args) {
        Book bookList[]=new Book[5];

        //create book objects and add them to the array
        bookList[0]=new Book("R001","Unknown Title",0,0);
        bookList[1]=new Book("X001","Rocket Man",123.45,1);
        bookList[2]=new Book("Y002","Wedding Party",88.94,2);
        bookList[3]=new Book("Z003","hAUNTED hOUSE",200.99,3);
        bookList[4]=new Book("E003","XYZ",200.99,3);

        System.out.println("Book records: \n");
        System.out.println(bookList[0]);
        System.out.println(bookList[1]);
        System.out.println(bookList[2]);
        System.out.println(bookList[3]);
        System.out.println();

        //locking a record
        System.out.println("set up a password\n");
        bookList[0].setPassword("ABC123");
        System.out.println("First book record: " + bookList[0]);
        bookList[0].lock("strawberry");
        System.out.println("The book is now locked");


        // attempt to change the price of first book record
        bookList[0].setPrice(200.99);
        System.out.println();

        //unlock with wrong password
        bookList[0].unlock("EFG12");
        bookList[0].setPrice(200.99);
        System.out.println();

        //UNLOCK WITH CORRECT PASSWORD
        bookList[0].unlock("ABC123");

        bookList[0].setTitle("kUNG fU hero");
        bookList[0].setGenre(1);
        bookList[0].setPrice(200.99);
        System.out.println();

        //book with highest price(s)
        Book temp=bookList[0];// make a temporary book as high for comparision
        System.out.println("List of books that have highest price:");
        for (int i = 0; i < bookList.length; i++) {
            if(bookList[i].compareTo(temp)>=0){
                temp=bookList[i];
                System.out.println(temp);
            }
        }
    }

}