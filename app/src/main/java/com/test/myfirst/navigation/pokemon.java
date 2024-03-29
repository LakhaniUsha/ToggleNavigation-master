package com.test.myfirst.navigation;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class pokemon implements Parcelable {
    //111111

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("ability")
    @Expose
    private String ability;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("description")
    @Expose
    private String description;

    protected pokemon(Parcel in) {
        name = in.readString();
        image = in.readString();
        type = in.readString();
        ability = in.readString();
        height = in.readString();
        weight = in.readString();
        description = in.readString();
    }

    public static final Creator<pokemon> CREATOR = new Creator<pokemon>() {
        @Override
        public pokemon createFromParcel(Parcel in) {
            return new pokemon(in);
        }

        @Override
        public pokemon[] newArray(int size) {
            return new pokemon[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(image);
        parcel.writeString(type);
        parcel.writeString(ability);
        parcel.writeString(height);
        parcel.writeString(weight);
        parcel.writeString(description);
    }
}