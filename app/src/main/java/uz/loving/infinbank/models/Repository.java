package uz.loving.infinbank.models;

public class Repository {

    String name;
    String htmlUrl;
    String language;
    Owner owner;

    public Repository(String name, String htmlUrl, String language, Owner owner) {
        this.name = name;
        this.htmlUrl = htmlUrl;
        this.language = language;
        this.owner = owner;
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

    public Owner getOwner() {
        return owner;
    }
}
