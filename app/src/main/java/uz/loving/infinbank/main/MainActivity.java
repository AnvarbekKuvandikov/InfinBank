package uz.loving.infinbank.main;

import uz.loving.infinbank.MyApp;
import uz.loving.infinbank.R;
import uz.loving.infinbank.models.Owner;
import uz.loving.infinbank.models.Repository;
import uz.loving.infinbank.network.interfaces.GitHubApiInterface;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import uz.loving.infinbank.ui.MasterListAdapter;

public class MainActivity extends AppCompatActivity {


    @Inject
    SharedPreferences mSharedPreferences;

    @Inject
    Retrofit mRetrofit;

    @Inject
    GitHubApiInterface mGitHubApiInterface;

    private ListView listView;
    private MasterListAdapter adapter;
    private ArrayList<Repository> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.reposList);
        try {
            init();
        } catch (IOException | NullPointerException e) {
            list = new ArrayList<>();
        }
//        list = new ArrayList<>();
        /*adapter = new MasterListAdapter(this,R.layout.item,list);
        listView.setAdapter(adapter);*/

        Button button = (Button) findViewById(R.id.search_repo_button);
        EditText text = (EditText) findViewById(R.id.search_repo_query);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<ArrayList<Repository>> call = mGitHubApiInterface.getRepository("AnvarbekKuvandikov");
//                Call<ArrayList<Repository>> call = mGitHubApiInterface.searchRepository("q="+text.getText().toString()+"+user:AnvarbekKuvandikov");


                call.enqueue(new Callback<ArrayList<Repository>>() {
                    @Override
                    public void onResponse(Response<ArrayList<Repository>> response, Retrofit retrofit) {
                        if (response.isSuccess()) {
                            String encode = Base64.encodeToString(("loving.uz0000@gmil.com:BuMeningGithubQodim").getBytes(), Base64.DEFAULT).replace("\n", "");
                            list = response.body();
                            Log.i("MYCODE","Basic " + encode);
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

    private void init() throws IOException,NullPointerException {
        Call<ArrayList<Repository>> call = mGitHubApiInterface.getRepository("AnvarbekKuvandikov");
        Response<ArrayList<Repository>> response = call.execute();
        if(response.isSuccess()){
            list = response.body();
        }
    }


}
