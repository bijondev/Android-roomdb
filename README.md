# Android-roomdb
Android database example
Room is an Android library that provides an abstract layer over SQLite to allow for more robust database access while harnessing the full power of SQLite. It simplifies the process of working with SQLite in Android and helps to avoid common pitfalls.

Here is an example of how Room can be used in an Android app:

    Define an Entity class that represents a table in the database. Each field in the class represents a column in the table, and the class should be annotated with @Entity.
```
@Entity(tableName = "users")
public class User {
    @PrimaryKey
    public long id;

    public String name;
    public int age;
}
```
    Define a Data Access Object (DAO) interface that defines the methods for accessing the database. Each method should be annotated with a SQL query that describes the operation.
```
@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getAll();

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
```
    Create a RoomDatabase class that extends RoomDatabase and includes the entities and DAOs that you want to use in the app. The database class should be annotated with @Database and include a list of entities.
```
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
```
    To use the database in your app, create an instance of the database using Room.databaseBuilder(). You can then use the DAO to access the database.

AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "database-name").build();
UserDao userDao = db.userDao();

I hope this helps give you an idea of how Room can be used in an Android app! Let me know if you have any questions.
