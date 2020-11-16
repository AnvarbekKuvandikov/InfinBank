package uz.loving.infinbank.main;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import uz.loving.infinbank.MyApp;
import uz.loving.infinbank.R;
import uz.loving.infinbank.databinding.ActivityMainBinding;
import uz.loving.infinbank.models.Repository;
import uz.loving.infinbank.network.interfaces.GitHubApiInterface;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;

import retrofit.Retrofit;
import uz.loving.infinbank.ui.MasterListAdapter;
import uz.loving.infinbank.viewmodel.RepositoryViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;

    @Inject
    SharedPreferences mSharedPreferences;

    @Inject
    Retrofit mRetrofit;

    @Inject
    GitHubApiInterface mGitHubApiInterface;

    private ListView listView;
    private MasterListAdapter adapter;
    private ArrayList<RepositoryViewModel> list;
    private RepositoryViewModel model;

    private ArrayList<Repository> repos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        model = new RepositoryViewModel();
        list = model.getArrayListRepo();

        adapter = new MasterListAdapter(this,R.layout.item,list);
        activityMainBinding.reposList.setAdapter(adapter);

//        ((MyApp) getApplication()).getGitHubComponent().inject(this);

    }
/* todo 112
    public  void onClick(){
        Log.i("MYCODE","click");
        Call<ArrayList<Repository>> call = mGitHubApiInterface.getRepository("AnvarbekKuvandikov");
//                Call<ArrayList<Repository>> call = mGitHubApiInterface.searchRepository("q="+text.getText().toString()+"+user:AnvarbekKuvandikov");


        call.enqueue(new Callback<ArrayList<Repository>>() {
            @Override
            public void onResponse(Response<ArrayList<Repository>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    String encode = Base64.encodeToString(("loving.uz0000@gmil.com:BuMeningGithubQodim").getBytes(), Base64.DEFAULT).replace("\n", "");
                    repos.clear();
                    repos.addAll(response.body());
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
*/

}
