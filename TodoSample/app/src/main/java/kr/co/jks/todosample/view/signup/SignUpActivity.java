package kr.co.jks.todosample.view.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import kr.co.jks.todosample.R;
import kr.co.jks.todosample.base.BaseActivity;
import kr.co.jks.todosample.model.Item;
import kr.co.jks.todosample.model.User;
import kr.co.jks.todosample.view.todowrite.TodoWriteContract;
import kr.co.jks.todosample.view.todowrite.TodoWritePresenter;

public class SignUpActivity extends BaseActivity<SignUpContract.View, SignUpContract.Presenter>
        implements SignUpContract.View {

    @BindView(R.id.btnSave)
    Button btnSave;

    @BindView(R.id.etId)
    EditText etId;

    @BindView(R.id.etPwd)
    EditText etPwd;

    @BindView(R.id.etPwdConfirm)
    EditText PwdConfirm;

    public SignUpContract.Presenter setPresenter() {
        return new SignUpPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO new Item

                User user = new User();
                user.setId(getEtString(etId));
                user.setPwd(getEtString(etPwd));
//                item.setDone(true);
                // TODO save item
                mPresenter.save(user);
            }
        });
    }

    private String getEtString(EditText et) {
        return et.getText().toString();
    }

    @Override
    public void signUpDone() {
        Toast.makeText(this, "Save Done", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }

}
