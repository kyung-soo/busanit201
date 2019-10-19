package kr.co.jks.todosample.logic.remote;

import kr.co.jks.todosample.logic.DataSource;
import kr.co.jks.todosample.logic.Repository;
import kr.co.jks.todosample.logic.UserRepository;
import kr.co.jks.todosample.model.Item;
import kr.co.jks.todosample.model.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class RemoteDataSourceImpl implements DataSource {

    @Override
    public void setRepository(Repository repository) {

    }

    @Override
    public Single<Long> save(Item item) {

        return null;
    }

    @Override
    public Flowable<List<Item>> fetchItems() {
        return null;
    }

    @Override
    public Single<Item> fetchItem(int no) {
        return null;
    }

    @Override
    public void setUserRepository(UserRepository repository) {

    }

    @Override
    public Single<Long> signUp(User user) {
        return null;
    }

    @Override
    public Single<User> checkUser(String id, String pwd) {
        return null;
    }
}
