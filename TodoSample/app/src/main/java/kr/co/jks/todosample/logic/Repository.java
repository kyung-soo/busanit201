package kr.co.jks.todosample.logic;

import kr.co.jks.todosample.base.BasePresenter;
import kr.co.jks.todosample.model.Item;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface Repository<T> {
    void setPresenter(BasePresenter<T> presenter);
    Single<Long> save(Item item);
    void saveDone();

    //Fetch
    Flowable<List<Item>> fetchItems();
    void fetchItemsDone(List<Item> items);

    Single<Item> fetchItem(int no);
}
