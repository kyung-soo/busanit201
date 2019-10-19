package kr.co.jks.todosample.logic;

import kr.co.jks.todosample.logic.local.LocalDataSourceImpl;
import kr.co.jks.todosample.logic.remote.RemoteDataSourceImpl;
import kr.co.jks.todosample.model.User;
import kr.co.jks.todosample.view.main.MainContract;

public class UserRepositoryImpl implements UserRepository {

    MainContract.Presenter presenter;
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
    public void loginDone() {
        this.presenter.loginDone();
    }

    @Override
    public void signUpProc(User user) {
        localDataSource.signUp(user);
    }

    @Override
    public void signUpDone() {
        this.presenter.signUpDone();
    }
}