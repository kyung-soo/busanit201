package kr.co.jks.todosample.logic;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import kr.co.jks.todosample.model.Item;
import kr.co.jks.todosample.model.User;

public interface DataSource {
    //Item
    void setRepository(Repository repository);
    Single<Long> save(Item item);
    Flowable<List<Item>> fetchItems();
    Single<Item> fetchItem(int no);

    //User
    void setUserRepository(UserRepository repository);
    Single<Long> signUp(User user);
    Single<User> checkUser(String id, String pwd);
}
