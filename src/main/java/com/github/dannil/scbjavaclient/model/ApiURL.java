package com.github.dannil.scbjavaclient.model;

import java.net.URL;
import java.util.Locale;
import java.util.Objects;

import com.github.dannil.scbjavaclient.utility.URLUtility;

public class ApiURL {

    private String url;

    public ApiURL(URL url) {
        this(url.toString());
    }

    public ApiURL(String url) {
        this.url = url;

        char[] chars = this.url.toCharArray();
        if (chars[chars.length - 1] != '/') {
            this.url = this.url + '/';
        }
    }

    public ApiURL toLanguage(Locale locale) {
        return toLanguage(locale.getLanguage());
    }

    public ApiURL toLanguage(String language) {
        String localizedUrl = URLUtility.changeLanguageForUrl(this.url, language);
        return new ApiURL(localizedUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.url);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ApiURL)) {
            return false;
        }

        ApiURL other = (ApiURL) obj;
        return Objects.equals(this.url, other.url);
    }

    @Override
    public String toString() {
        return this.url;
    }

}
