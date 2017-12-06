package com.yhao.firstkotlin;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Locale;

/**
 * Created by BigManing on 17-12-6.
 * 邮箱：lingshui2008@qq.com
 */

public class Student implements Parcelable {
    public String name;
    public int age;
    protected Student(Parcel in) {
        readFromParcel(in);
    }
    public Student() {
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
    }

    public void readFromParcel(Parcel in){
        age = in.readInt();
        name = in.readString();
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "STUDENT[%s:%d]", name, age);
    }
}
