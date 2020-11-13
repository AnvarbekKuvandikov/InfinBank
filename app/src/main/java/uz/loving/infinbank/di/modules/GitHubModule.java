package uz.loving.infinbank.di.modules;

import uz.loving.infinbank.di.scopes.UserScope;
import uz.loving.infinbank.network.interfaces.GitHubApiInterface;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

@Module
public class GitHubModule {

    @Provides
    @UserScope
    public GitHubApiInterface providesGitHubInterface(Retrofit retrofit) {
        return retrofit.create(GitHubApiInterface.class);
    }
}
