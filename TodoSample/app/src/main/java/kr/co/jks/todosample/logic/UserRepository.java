package kr.co.jks.todosample.logic;

import io.reactivex.Single;
import kr.co.jks.todosample.model.User;
import kr.co.jks.todosample.view.main.MainContract;
import kr.co.jks.todosample.view.signup.SignUpContract;

// Data Layer
public interface UserRepository {
    void setPresenter(MainContract.Presenter presenter);
    void loginProc(User user);
    void setSignUpPresenter(SignUpContract.Presenter presenter);
    Single<Long> signUpProc(User user);
    void loginDone();
    void signUpDone();
}