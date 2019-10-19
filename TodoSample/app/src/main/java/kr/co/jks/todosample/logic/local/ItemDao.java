package kr.co.jks.todosample.logic.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import kr.co.jks.todosample.model.Item;

@Dao
public interface ItemDao {
    // TODO Query, Insert, Update
    // Query list
    @Query("select * from item order by no desc")
    Flowable<List<Item>> fetchItems();

    // Update
    @Query("select * from item where no = :no")
    Flowable<Item> fetchItem(int no);

    // Insert
    @Insert
    Single<Long> saveItem(Item item);
}
