package kr.co.jks.todosample.view.todowrite;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kr.co.jks.todosample.base.BasePresenterImpl;
import kr.co.jks.todosample.logic.Repository;
import kr.co.jks.todosample.logic.RepositoryImpl;
import kr.co.jks.todosample.model.Item;

public class TodoWritePresenter extends BasePresenterImpl<TodoWriteContract.View>
        implements TodoWriteContract.Presenter{

    TodoWriteContract.View view;
    Repository repository;

    @Override
    public void setView(TodoWriteContract.View view) {
        this.view = view;
        repository = new RepositoryImpl();
        repository.setPresenter(this);
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void save(Item item) {
        //TODO Repository에 저장
        repository.save(item)
                .doOnSuccess((object)
                        -> Log.d("WritePresenter",
                        Thread.currentThread().getName()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> view.saveDone());
    }

    @Override
    public void saveDone() {
        view.saveDone();
    }

}
