package uz.loving.infinbank.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import uz.loving.infinbank.models.Owner;
import uz.loving.infinbank.models.Repository;


public class RepositoryViewModel {
    String name;
    String htmlUrl;
    String language;
    String avatarUrl;

    public RepositoryViewModel() {
    }

    public RepositoryViewModel(Repository repository) {
        name = repository.getName();
        htmlUrl = repository.getHtmlUrl();
        language = repository.getLanguage();
        avatarUrl = repository.getOwner().getAvatarUrl();
    }


    public String getName() {
        return name;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getLanguage() {
        return language;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @BindingAdapter({"bind:avatarUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide
                .with(view.getContext())
                .load(imageUrl)
                .into(view);

    }

    public ArrayList<RepositoryViewModel> getArrayListRepo(){
        ArrayList<RepositoryViewModel> models = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Repository repo = new Repository("Infinbank","https://github.com/AnvarbekKuvandikov/InfinBank","Java",new Owner("https://avatars3.githubusercontent.com/u/26444968?v=4"));
            RepositoryViewModel repmodel = new RepositoryViewModel(repo);
            models.add(repmodel);
        }
        return models;
    }
}
