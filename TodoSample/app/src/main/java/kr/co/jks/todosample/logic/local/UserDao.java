package kr.co.jks.todosample.logic.local;

import io.reactivex.Flowable;
import io.reactivex.Single;
import kr.co.jks.todosample.model.User;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Query("select * from user where id = :id and pwd = :pwd ")
    Single<User> checkUser(String id, String pwd);

    @Insert
    Single<Long> addUser(User user);
}
