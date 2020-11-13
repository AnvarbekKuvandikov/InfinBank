package uz.loving.infinbank;


import uz.loving.infinbank.di.components.DaggerGitHubComponent;
import uz.loving.infinbank.di.components.DaggerNetComponent;
import uz.loving.infinbank.di.components.GitHubComponent;
import uz.loving.infinbank.di.components.NetComponent;
import uz.loving.infinbank.di.modules.AppModule;
import uz.loving.infinbank.di.modules.GitHubModule;
import uz.loving.infinbank.di.modules.NetModule;


import android.app.Application;

public class MyApp extends Application {

    private NetComponent mNetComponent;
    private GitHubComponent mGitHubComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();

        mGitHubComponent = DaggerGitHubComponent.builder()
                .netComponent(mNetComponent)
                .gitHubModule(new GitHubModule())
                .build();

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public GitHubComponent getGitHubComponent() {
        return mGitHubComponent;
    }
}