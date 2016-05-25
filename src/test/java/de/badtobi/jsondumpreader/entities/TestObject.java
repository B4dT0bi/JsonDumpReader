package de.badtobi.jsondumpreader.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class TestObject {
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("value")
    @Expose
    private String value;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestObject)) return false;

        TestObject that = (TestObject) o;

        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;

    }

    @Override
    public int hashCode() {
        int result = language != null ? language.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "language='" + language + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
