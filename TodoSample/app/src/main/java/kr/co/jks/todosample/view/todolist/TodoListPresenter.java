package kr.co.jks.todosample.view.todolist;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kr.co.jks.todosample.base.BasePresenterImpl;
import kr.co.jks.todosample.logic.Repository;
import kr.co.jks.todosample.logic.RepositoryImpl;
import kr.co.jks.todosample.model.Item;

public class TodoListPresenter extends BasePresenterImpl<TodoListContract.View>
        implements TodoListContract.Presenter{

    Repository repository;

    TodoListPresenter() {
        this.repository = new RepositoryImpl();
        this.repository.setPresenter(this);
    }

    @Override
    public void fetchItems() {
        Disposable da = this.repository.fetchItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<Item>>) items -> {
                    view.fetchItemsDone(items);
                });

        bag.add(da);

    }

    @Override
    public void fetchItemsDone(List<Item> items) {
        view.fetchItemsDone(items);
    }
}
