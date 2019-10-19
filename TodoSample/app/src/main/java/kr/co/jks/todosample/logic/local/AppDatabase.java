package kr.co.jks.todosample.logic.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import kr.co.jks.todosample.model.Item;
import kr.co.jks.todosample.model.User;

@Database(entities = {Item.class, User.class},
        version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao getItemDao();
    public abstract UserDao getUserDao();
}
