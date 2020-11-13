package uz.loving.infinbank.di.components;

import dagger.Component;
import uz.loving.infinbank.MainActivity;
import uz.loving.infinbank.di.modules.GitHubModule;
import uz.loving.infinbank.di.scopes.UserScope;

@UserScope
@Component(dependencies = NetComponent.class, modules = GitHubModule.class)
public interface GitHubComponent {
    void inject(MainActivity activity);
}
