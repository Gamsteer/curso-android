package net.silvacarvalho.marlon.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Uma Activity pode ser entendida como um Controlador dos eventos de uma
 * "Tela".
 * 
 * Mas tamb�m toda a tela pode ser constru�da na Activity, entretanto, evite
 * esta pr�tica.
 * 
 * @author Marlon Silva Carvalho
 */
public class MainActivity extends Activity {
	// Toda Activity precisa ser declarada no AndroidManifest.xml

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Verificar se foi salvo um estado em onSaveInstanceState().
		Log.d("CicloDeVidaDaActivity", "SavedInstanceState: " + savedInstanceState);
		if (savedInstanceState != null) {
			Toast.makeText(this, savedInstanceState.getString("Chave"), Toast.LENGTH_LONG).show();
		}

		// Todos os elementos de interface estendem de View.
		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);

		Button button = new Button(this);
		button.setText("OK");
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, MainActivity2.class));
			}

		});

		EditText editText = new EditText(this);
		editText.setHint("Isso � um hint");

		linearLayout.addView(editText);
		linearLayout.addView(button);

		setContentView(linearLayout);

		Log.d("CicloDeVidaDaActivity", "OnCreate");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	protected void onStart() {
		super.onStart();

		Log.d("CicloDeVidaDaActivity", "OnStart");
	}

	@Override
	protected void onStop() {
		super.onStop();

		Log.d("CicloDeVidaDaActivity", "OnStop");
	}

	@Override
	protected void onResume() {
		super.onResume();

		Log.d("CicloDeVidaDaActivity", "OnResume");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.d("CicloDeVidaDaActivity", "OnDestroy");
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();

		Log.d("CicloDeVidaDaActivity", "OnLowMemory");
	}

	@Override
	protected void onPause() {
		super.onPause();

		Log.d("CicloDeVidaDaActivity", "OnPause");
	}

	@Override
	protected void onRestart() {
		super.onRestart();

		Log.d("CicloDeVidaDaActivity", "OnRestart");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		// Verificar se foi salvo um estado em onSaveInstanceState().
		Log.d("CicloDeVidaDaActivity", "onRestoreInstanceState: " + savedInstanceState);
		if (savedInstanceState != null) {
			Toast.makeText(this, savedInstanceState.getString("Chave"), Toast.LENGTH_LONG).show();
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		Log.d("CicloDeVidaDaActivity", "onSaveInstanceState");
		super.onSaveInstanceState(outState);
		outState.putString("Chave", "Merda!");
	}

}
