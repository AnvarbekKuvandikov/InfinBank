package uz.loving.infinbank.models;

public class Repository {

    String name;
    String htmlUrl;
    String language;
    Owner owner;

    public String getName() {
        return name;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getLanguage() {
        return language;
    }

    public Owner getOwner() {
        return owner;
    }
}
