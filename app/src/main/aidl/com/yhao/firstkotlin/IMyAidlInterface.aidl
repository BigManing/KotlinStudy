// IMyAidlInterface.aidl
package com.yhao.firstkotlin;

// Declare any non-default types here with import statements
import com.yhao.firstkotlin.Student;
interface IMyAidlInterface {
    Student getStudent();
       void setStudent(in Student student);
       String getValue();
}
