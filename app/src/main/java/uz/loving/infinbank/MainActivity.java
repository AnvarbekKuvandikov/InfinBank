package uz.loving.infinbank;

import uz.loving.infinbank.models.Repository;
import uz.loving.infinbank.network.interfaces.GitHubApiInterface;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences mSharedPreferences;

    @Inject
    Retrofit mRetrofit;

    @Inject
    GitHubApiInterface mGitHubApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button fab = (Button) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                    Call<ArrayList<Repository>> call = mGitHubApiInterface.getRepository("codepath");

                    call.enqueue(new Callback<ArrayList<Repository>>() {
                        @Override
                        public void onResponse(Response<ArrayList<Repository>> response, Retrofit retrofit) {
                            if (response.isSuccess()) {
                                Log.i("DEBUG", response.body().toString());
                                Snackbar.make(view,"Data retrieved", Snackbar.LENGTH_LONG)
                                        .setAction("Action",null).show();
                            } else {
                                Log.i("ERROR", String.valueOf(response.code()));
                            }

                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                }

            });

        ((MyApp) getApplication()).getGitHubComponent().inject(this);
    }

}
