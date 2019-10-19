package kr.co.jks.todosample.logic;

import kr.co.jks.todosample.model.Item;
import kr.co.jks.todosample.view.todolist.TodoListContract;
import kr.co.jks.todosample.view.todowrite.TodoWriteContract;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import kr.co.jks.todosample.base.BasePresenter;
import kr.co.jks.todosample.logic.local.LocalDataSourceImpl;
import kr.co.jks.todosample.logic.remote.RemoteDataSourceImpl;

public class RepositoryImpl<T> implements Repository {
    BasePresenter<T> presenter;
    DataSource localDataSource;
    DataSource remoteDataSource;

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = presenter;
        localDataSource = new LocalDataSourceImpl();
        remoteDataSource = new RemoteDataSourceImpl();
        localDataSource.setRepository(this);
        remoteDataSource.setRepository(this);
    }

    @Override
    public Single<Long> save(Item item) {
        return localDataSource.save(item);
    }

    @Override
    public void saveDone() {
        ((TodoWriteContract.Presenter)presenter).saveDone();
    }

    @Override
    public Flowable<List<Item>> fetchItems() {
        return localDataSource.fetchItems();
    }

    @Override
    public void fetchItemsDone(List list) {
        ((TodoListContract.Presenter)presenter).fetchItemsDone(list);
    }

    @Override
    public Single<Item> fetchItem(int no) {
        return localDataSource.fetchItem(no)
                .map(item -> {
                    item.setTitle(item.getTitle() + "_");
                    return item;
                });
    }
}
