package kr.co.jks.todosample.view.todowrite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import kr.co.jks.todosample.base.BaseActivity;

import kr.co.jks.todosample.R;
import kr.co.jks.todosample.model.Item;

public class TodoWriteActivity extends BaseActivity<TodoWriteContract.View, TodoWriteContract.Presenter>
        implements TodoWriteContract.View{

    @BindView(R.id.btnSave)
    Button btnSave;

    @BindView(R.id.etTitle)
    EditText etTitle;

    @BindView(R.id.etContent)
    EditText etContent;

    public TodoWriteContract.Presenter setPresenter() {
        return new TodoWritePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todowrite);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO new Item

                Item item = new Item();
                item.setTitle(getEtString(etTitle));
                item.setContent(getEtString(etContent));
//                item.setDone(true);
                // TODO save item
                mPresenter.save(item);
            }
        });
    }

    private String getEtString(EditText et) {
        return et.getText().toString();
    }

    @Override
    public void saveDone() {
        Toast.makeText(this, "Save Done", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }

}
