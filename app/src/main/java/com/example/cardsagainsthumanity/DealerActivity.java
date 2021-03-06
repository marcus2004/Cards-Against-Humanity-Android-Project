package com.example.cardsagainsthumanity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static android.widget.AdapterView.*;

public class DealerActivity extends AppCompatActivity {

    ListView listView;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer);

        game = (Game) getIntent().getSerializableExtra("game");

        TextView statement = (TextView) findViewById(R.id.statement);
        statement.setText(game.getBlackStatementCards().get(0).getStatement());

        listView = (ListView) findViewById(R.id.list);

        String[] values = new String[game.getPlayers().size() - 1];

        for(int i = 0; i < game.getWhiteAnswerCards().size(); i++) {
            values[i] = game.getWhiteAnswerCards().get(i).getStatement();
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int playerPosition = i;
                Player winningPlayer = game.getPlayers().get(playerPosition);
                game.addPoint(winningPlayer);
                game.blackStatementCards.clear();
                game.whiteAnswerCards.clear();
                game.setTurn(0);
                game.setDealerIndex(playerPosition);

                Intent intent = new Intent(DealerActivity.this, DealerChooseActivity.class);
                intent.putExtra("game", game);
                startActivity(intent);

            }

        });


    }
}
