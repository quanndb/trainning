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
        String builder = id +
                " " +
                userId +
                " " +
                title;
        return builder;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
