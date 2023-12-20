//Interfaces
/**
 * Genre
 */
interface Genre {
    //types assigned as integer
    int UNCLASSIFIED=0;
    int action=1;
    int comedy=2;
    int horror=3;

    //getter and setter methods
    void setGenre(int genre);
    int getGenre();    
}
interface PasswordLockable{

    void setPassword(String password);  //sets up password
    void lock(String password); //locks a book record
    void unlock(String password); //unlocks a book record
    boolean isLocked(); //checks if record is unlocked or locked
}
/**
 * Book class
 */
class Book implements Genre,PasswordLockable,Comparable<Book> {

    private String code;
    private String title;
    private int genre;
    private double price;
    private String password;
    private boolean bookIsLocked;

    public Book(String code,String title,double price,int genre){
        this.code = code;
        this.title=title;
        this.genre=genre;
        this.price=price;
    }
//accessors
    public String getCode() {
        return code;
    }
    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public int getGenre() {
        // TODO Auto-generated method stub
        return genre;
    }
    public String toString(){//overriding the toString() method  
        return "Book Code: " + code + "\tTitle: " 
        + title + "\tPrice: " + price + "\tGenre: "
        + genreString();  
    }  

//mutators
    public void setCode(String code) {
        if(!bookIsLocked){
            this.code = code;
        }
        else{
            System.out.println("record is locked no update performed");
        }
    }
    public void setTitle(String title) {
        if(!bookIsLocked){
            this.title = title;
        }
        else{
            System.out.println("record is locked no update performed");
        }
    }
    public void setPrice(double price) {
        if(!bookIsLocked){
            this.price = price;
        }
        else{
            System.out.println("record is locked no update performed");
        }

    }

    @Override
    public void setGenre(int genre) {
        // TODO Auto-generated method stub
        this.genre=genre;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
        System.out.println("record password protected");
    }

    @Override
    public void lock(String password) {
        if(password.equals(this.password)){
            bookIsLocked = true;
        }
        System.out.println("The product record is now locked.");
    }
    
    @Override
    public void unlock(String password) {
        if(password.equals(this.password)){
            bookIsLocked  = false;
        }
        System.out.println("The product record is now unlocked!");

    }

    @Override
    public boolean isLocked() {
        return bookIsLocked;
    }
    public String genreString(){
        switch(genre){
            case 0:
                return "UNCLASSIFIED";
            case 1:
                return "action";
            case 2:
                return "comedy";
            case 3:
                return "horror";
            default:
                return "category does not exists";

        }
    }
    public int compareTo(Book book){
        return Double.compare(this.price, book.price);
    }



}