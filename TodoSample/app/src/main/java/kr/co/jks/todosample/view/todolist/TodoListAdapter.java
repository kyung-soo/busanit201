package kr.co.jks.todosample.view.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.co.jks.todosample.model.Item;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoListAdapterViewHolder> {

    List<Item> list;
    TodoListContract.Presenter presenter;
    TodoListAdapter(List<Item> list, TodoListContract.Presenter presenter) {
        this.list = list;
        this.presenter = presenter;
    }

    public static class TodoListAdapterViewHolder
            extends RecyclerView.ViewHolder {
        View view;
        TextView title;

        public TodoListAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            title = itemView.findViewById(android.R.id.text1);
        }
    }

    // 1번째 단계
    @NonNull
    @Override
    public TodoListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1,
                        parent,
                        false);
        return new TodoListAdapterViewHolder(view);
    }

    // 2번째 단계
    @Override
    public void onBindViewHolder(@NonNull TodoListAdapterViewHolder holder,
                                 int position) {
        Item item = list.get(position);
        holder.title.setText(item.getTitle());
//        holder.view.setOnClickListener(v ->
//                presenter.showDetail(item.getNo())
//        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
