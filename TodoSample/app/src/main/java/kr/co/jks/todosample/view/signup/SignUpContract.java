package kr.co.jks.todosample.view.signup;

import kr.co.jks.todosample.base.BasePresenter;
import kr.co.jks.todosample.base.BaseView;
import kr.co.jks.todosample.model.User;

public class SignUpContract {
    public interface View extends BaseView {
        // 작성완료 ( <= Presenter)
        void signUpDone();
    }

    public interface Presenter
            extends BasePresenter<SignUpContract.View> {
        // 저장
        void save(User user);
        // 작성완료 ( <= Repository)
        void signUpDone();
    }
}
