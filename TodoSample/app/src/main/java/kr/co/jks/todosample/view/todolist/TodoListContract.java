package kr.co.jks.todosample.view.todolist;

import java.util.List;

import kr.co.jks.todosample.base.BasePresenter;
import kr.co.jks.todosample.base.BaseView;
import kr.co.jks.todosample.model.Item;

public class TodoListContract {
    public interface View
            extends BaseView {
        void fetchItemsDone(List<Item> items);
    }

    public interface Presenter
            extends BasePresenter<View> {
        //TODO fetch Items
        void fetchItems();
        void fetchItemsDone(List<Item> items);
    }
}
