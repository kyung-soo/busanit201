package kr.co.jks.todosample.logic;

import io.reactivex.Single;
import kr.co.jks.todosample.logic.local.LocalDataSourceImpl;
import kr.co.jks.todosample.logic.remote.RemoteDataSourceImpl;
import kr.co.jks.todosample.model.User;
import kr.co.jks.todosample.view.main.MainContract;
import kr.co.jks.todosample.view.signup.SignUpContract;

public class UserRepositoryImpl implements UserRepository {

    MainContract.Presenter presenter;
    SignUpContract.Presenter signPresenter;
    DataSource localDataSource;
    DataSource remoteDataSource;

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
        localDataSource = new LocalDataSourceImpl();
        localDataSource.setUserRepository(this);
        remoteDataSource = new RemoteDataSourceImpl();
        remoteDataSource.setUserRepository(this);
    }

    @Override
    public void loginProc(User user) {
        localDataSource.checkUser(user.getId(), user.getPwd());
    }

    @Override
    public void setSignUpPresenter(SignUpContract.Presenter presenter) {
        this.signPresenter = presenter;
        localDataSource = new LocalDataSourceImpl();
        localDataSource.setUserRepository(this);
        remoteDataSource = new RemoteDataSourceImpl();
        remoteDataSource.setUserRepository(this);
    }

    @Override
    public void loginDone() {
        this.presenter.loginDone();
    }

    @Override
    public Single<Long> signUpProc(User user) {
        return localDataSource.signUp(user);
    }

    @Override
    public void signUpDone() {
        this.presenter.signUpDone();
    }
}