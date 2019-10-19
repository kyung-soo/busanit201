package kr.co.jks.todosample.view.main;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import kr.co.jks.todosample.R;
import kr.co.jks.todosample.model.User;
import kr.co.jks.todosample.view.todolist.TodoListActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.txtId)
    EditText etTitle;
    @BindView(R.id.txtPw)
    EditText etPwd;

    static final String _TAG = "ttt";

    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        presenter = new MainPresenter();
        presenter.setView(this);
    }

    @OnClick(R.id.btnLogin)
    public void login() {
        Log.d(_TAG, "title : " + etTitle.getText() + ", pwd : " + etPwd.getText());
        String id = etTitle.getText().toString();
        String pwd = etPwd.getText().toString();
        User user = new User();
        user.setId(id);
        user.setPwd(pwd);
        presenter.loginProc(user);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loginDone() {
        Toast.makeText(this, " 디테일로 전환 ", Toast.LENGTH_SHORT).show();
        showDetail();
    }

    public void showDetail() {
        Intent intent = new Intent(this, TodoListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
