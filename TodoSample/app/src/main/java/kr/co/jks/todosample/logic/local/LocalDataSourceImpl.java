package kr.co.jks.todosample.logic.local;

import kr.co.jks.todosample.logic.DataSource;
import kr.co.jks.todosample.logic.UserRepository;
import kr.co.jks.todosample.logic.Repository;
import kr.co.jks.todosample.model.Item;
import kr.co.jks.todosample.model.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class LocalDataSourceImpl implements DataSource {
    Repository repository;
    UserRepository userRepository;
    AppDatabase appDatabase;

    public LocalDataSourceImpl() {
        try {
            appDatabase = AppDatabaseProvider.getINSTANCE();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Single<Long> save(final Item item) {
        //TODO SAVE
        return getItemDao().saveItem(item);
    }

    // Fetch Items
    @Override
    public Flowable<List<Item>> fetchItems() {
        return getItemDao().fetchItems();
    }

    @Override
    public Single<Item> fetchItem(int no) {
        // Item 내 title -> title + "_";
        return getItemDao().fetchItem(no)
                .firstOrError();

    }

    @Override
    public void setUserRepository(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public Single<Long> signUp(User user) {
        return getUserDao().addUser(user);
    }

    @Override
    public Single<User> checkUser(String id, String pwd) {
        return getUserDao().checkUser(id, pwd);
    }

    private ItemDao getItemDao() {
        return appDatabase.getItemDao();
    }
    private UserDao getUserDao() {
        return appDatabase.getUserDao();
    }
}
