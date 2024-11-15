public class Album {
    long id;
    long userId;
    String title;

    public Album(long id, long userId, String title){
        this.id = id;
        this.userId = userId;
        this.title = title;
    }

    public String toString(){
        return id +
                " " +
                userId +
                " " +
                title;
    }
}
