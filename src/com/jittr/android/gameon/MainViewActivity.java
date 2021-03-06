package com.jittr.android.gameon;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.jittr.android.gameon.adapters.GameListAdapter;
import com.jittr.android.gameon.games.Game;

public class MainViewActivity extends ListActivity {

	private Button addButton;
	private GameListAdapter adapter;
	private GameManagerApplication app;
	private Button removeButton;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setUpViews();
        app = (GameManagerApplication)getApplication();
        adapter = new GameListAdapter(this, app.getCurrentGames());
        setListAdapter(adapter);
    }
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
			
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.defaultmenu, menu);
	    return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
	
		Intent intent;
		if (item.getItemId() == R.id.update_user_settings) {
		    intent = new Intent(MainViewActivity.this,UpdateUserSettingsActivity.class);
		    startActivity(intent);
		    return true;
		} else if (item.getItemId() == R.id.testOAuth) {
		    intent = new Intent(MainViewActivity.this,testOAuthActivity.class);
		    startActivity(intent);
		    return true;	
		} else if (item.getItemId() ==R.id.testTwitterStatus) {
		    intent = new Intent(MainViewActivity.this,testTwitterStatusUpdateActivity.class);
		    startActivity(intent);
	         return true;
		}
		
       return false;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		adapter.forceReload();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		adapter.toggleGameCompleteAtPosition(position);
		Game g = adapter.getItem(position);
		app.saveGame(g);
	}
	
	protected void removeCompletedGames() {
		Long[] ids = adapter.removeCompletedGames();
		app.deleteGames(ids);
	}
	
	private void setUpViews() {
		addButton = (Button)findViewById(R.id.add_button);
		removeButton = (Button)findViewById(R.id.remove_button);
		
		addButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainViewActivity.this, AddGameActivity.class);
				startActivity(intent);
			}
		});
		removeButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				removeCompletedGames();
			}
		});

	}

}