package kr.co.jks.todosample.view.main;

import kr.co.jks.todosample.base.BasePresenter;
import kr.co.jks.todosample.base.BaseView;
import kr.co.jks.todosample.model.User;

public class MainContract {
    public interface View extends BaseView {
        void loginDone();
    }

    public interface Presenter extends BasePresenter<View> {
        void loginProc(User user);
        void loginDone();
        void signUpProc(User user);
        void signUpDone();
    }
}