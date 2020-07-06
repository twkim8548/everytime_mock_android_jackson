package com.example.everytime_mock.src.Boards;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.Boards.interfaces.SecretBoardActivityView;
import com.example.everytime_mock.src.Boards.models.BoardAdapter;
import com.example.everytime_mock.src.Boards.models.PostItem;
import com.example.everytime_mock.src.Boards.models.SecretBoardResponse;

import java.util.ArrayList;

public class AlumniBoardActivity extends BaseActivity implements SecretBoardActivityView, PopupMenu.OnMenuItemClickListener {

    private ArrayList<PostItem> m_post_item_list;
    private BoardAdapter secret_board_adapter;
    private RecyclerView rv_secret_board;
    private LinearLayoutManager linear_layout_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_board);

        rv_secret_board = findViewById(R.id.rv_secret_board_post_list);

        linear_layout_manager = new LinearLayoutManager(getApplicationContext());
        rv_secret_board.setLayoutManager(linear_layout_manager);

        m_post_item_list = new ArrayList<>();
        secret_board_adapter = new BoardAdapter(m_post_item_list);
        rv_secret_board.setAdapter(secret_board_adapter);

        tryGetSecretBoard();


    }

    private void tryGetSecretBoard() {
        showProgressDialog();

        final SecretBoardService secretBoardService = new SecretBoardService(this);
        secretBoardService.getSecretBoard();
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void secretBoardSuccess(SecretBoardResponse secretBoardResponse) {
        hideProgressDialog();

        switch (secretBoardResponse.getCode()) {
            case 100:
                /**
                 * PostItem 형식의 ArrayList에 모두 넣어두고 어댑터를 이용해서 하나하나 레이아웃에 갖다 붙이자!!
                 * */
                int num_of_posts_in_secret_board = secretBoardResponse.getSecretBoardResults().size();
                for (int i = 0; i < num_of_posts_in_secret_board; i++){
                    PostItem postItem = new PostItem();

                    postItem.setTitle(secretBoardResponse.getSecretBoardResults().get(i).getContentTitle());
                    postItem.setContent(secretBoardResponse.getSecretBoardResults().get(i).getContentInf());
                    postItem.setTime(secretBoardResponse.getSecretBoardResults().get(i).getWriteDay());
                    postItem.setWriter(secretBoardResponse.getSecretBoardResults().get(i).getContentWriter());
                    postItem.setLike_num(secretBoardResponse.getSecretBoardResults().get(i).getCountLike());
                    postItem.setComment_num(secretBoardResponse.getSecretBoardResults().get(i).getCountComment());

                    m_post_item_list.add(postItem);
                }
                secret_board_adapter.notifyDataSetChanged();

                break;

        }

    }

    public void customOnClick(View view) {
        switch (view.getId()){
            case R.id.iv_secret_board_go_back:
                onBackPressed();
                break;
            case R.id.iv_secret_board_more:
                showPopUp(view);
                break;
        }

    }

    public void showPopUp(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);

        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menu_board);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.write_post:
                Intent intent = new Intent(AlumniBoardActivity.this, WritingActivity.class);
                intent.putExtra("boardName", 2);
                startActivity(intent);
                return true;
            case R.id.remove_from_favorite:
                return true;
            default:
                return false;
        }
    }
}
