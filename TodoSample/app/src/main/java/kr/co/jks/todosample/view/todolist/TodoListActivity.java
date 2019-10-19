package kr.co.jks.todosample.view.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import kr.co.jks.todosample.base.BaseActivity;

import kr.co.jks.todosample.R;
import kr.co.jks.todosample.model.Item;
import kr.co.jks.todosample.view.todowrite.TodoWriteActivity;

public class TodoListActivity extends BaseActivity<TodoListContract.View, TodoListContract.Presenter>
        implements TodoListContract.View{

    private static final String TAG = "MainActivity";

    TodoListAdapter mainAdapter;

    @BindView(R.id.mainRecylerView)
    RecyclerView recyclerView;

    List<Item> items;

    private static int _REUQEST_ADD_DATA = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TodoListActivity.this,
                        TodoWriteActivity.class);
                startActivityForResult(intent, _REUQEST_ADD_DATA);
            }
        });

        items = new ArrayList<>();
        initRecyclerView();
        mPresenter.fetchItems();
    }

    private void initRecyclerView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        mainAdapter = new TodoListAdapter(items, mPresenter);
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected TodoListContract.Presenter setPresenter() {
        return new TodoListPresenter();
    }

    @Override
    public void fetchItemsDone(List<Item> items) {
//        new Handler(Looper.getMainLooper())
//                .post(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(MainActivity.this, "fetch Items " + items.size(), Toast.LENGTH_SHORT).show();
//            }
//        });

        runOnUiThread(() -> {
            this.items.clear();
            this.items.addAll(items);
            this.mainAdapter.notifyDataSetChanged();
        });
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "requestCode: " + requestCode + ", resultcode: " + resultCode);

        if(requestCode == _REUQEST_ADD_DATA) {
            if(resultCode == RESULT_OK) {
                mPresenter.fetchItems();
            }
        }
    }
}
