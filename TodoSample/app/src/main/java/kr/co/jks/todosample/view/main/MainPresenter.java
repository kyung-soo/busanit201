package kr.co.jks.todosample.view.main;

import io.reactivex.Single;
import kr.co.jks.todosample.logic.UserRepository;
import kr.co.jks.todosample.logic.UserRepositoryImpl;
import kr.co.jks.todosample.base.BasePresenterImpl;
import kr.co.jks.todosample.model.User;

public class MainPresenter
        extends BasePresenterImpl<MainContract.View>
        implements MainContract.Presenter {

    MainContract.View view;

    UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
        userRepository.setPresenter(this);
    }

    @Override
    public void removeView() {
        view = null;
    }


    @Override
    public void loginProc(User user) {
        userRepository.loginProc(user);
    }


    @Override

    public void loginDone() {
        view.loginDone();
    }

    @Override
    public void signUpProc(User user) {

    }

    @Override
    public void signUpDone() {

    }
}