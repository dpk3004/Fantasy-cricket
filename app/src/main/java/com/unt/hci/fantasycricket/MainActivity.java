package com.unt.hci.fantasycricket;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private ListView list;
    private PlayerListAdaptor adapter;
    private Score score; //reads scoring.json
//    Squads squads;
    private AssetManager assetManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assetManager = getResources().getAssets();
        Gson g = new Gson();
        String s;
        try {
            s =  IOUtils.toString(assetManager.open("tournament/match/1/scoring.json"), "UTF-8");
            score = g.fromJson(s, Score.class);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("ERROR", "Invalid drawable file path!");
        }

        //put list of players in listView
        adapter=new PlayerListAdaptor(this,score.getMatchInfo().getTeams(), assetManager);
        list=(ListView)findViewById(R.id.playerList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // if user clicks on list item...
            }
        });


    }
}
