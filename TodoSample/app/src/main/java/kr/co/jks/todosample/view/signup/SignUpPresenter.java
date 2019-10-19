package kr.co.jks.todosample.view.signup;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kr.co.jks.todosample.base.BasePresenterImpl;
import kr.co.jks.todosample.logic.UserRepository;
import kr.co.jks.todosample.logic.UserRepositoryImpl;
import kr.co.jks.todosample.model.User;

public class SignUpPresenter extends BasePresenterImpl<SignUpContract.View>
        implements SignUpContract.Presenter {

    SignUpContract.View view;
    UserRepository userRepository;

    @Override
    public void setView(SignUpContract.View view) {
        this.view = view;
        userRepository = new UserRepositoryImpl();
        userRepository.setSignUpPresenter(this);
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void save(User user) {
        //TODO Repository에 저장
        userRepository.signUpProc(user)
                .doOnSuccess((object)
                        -> Log.d("WritePresenter",
                        Thread.currentThread().getName()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> view.signUpDone());
    }

    @Override
    public void signUpDone() {
        view.signUpDone();
    }

}
