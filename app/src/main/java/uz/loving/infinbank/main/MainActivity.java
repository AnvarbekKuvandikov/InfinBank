package uz.loving.infinbank.main;

import uz.loving.infinbank.MyApp;
import uz.loving.infinbank.R;
import uz.loving.infinbank.models.Repository;
import uz.loving.infinbank.network.interfaces.GitHubApiInterface;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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


        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<ArrayList<Repository>> call = mGitHubApiInterface.getRepository("AnvarbekKuvandikov");

                call.enqueue(new Callback<ArrayList<Repository>>() {
                    @Override
                    public void onResponse(Response<ArrayList<Repository>> response, Retrofit retrofit) {
                        if (response.isSuccess()) {
                            Repository repo = response.body().get(0);
                            Log.i("MYCODE", repo.getLanguage()+" "+repo.getHtmlUrl()+" "+repo.getOwner().getAvatarUrl());
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
