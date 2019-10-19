package kr.co.jks.todosample.view.todowrite;

import kr.co.jks.todosample.base.BasePresenter;
import kr.co.jks.todosample.base.BaseView;
import kr.co.jks.todosample.model.Item;

public class TodoWriteContract {
    public interface View extends BaseView {
        // 작성완료 ( <= Presenter)
        void saveDone();
    }

    public interface Presenter
            extends BasePresenter<View> {
        // 저장
        void save(Item item);
        // 작성완료 ( <= Repository)
        void saveDone();
    }
}
