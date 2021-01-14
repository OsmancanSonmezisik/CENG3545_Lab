package com.osmancansonmezisik.lab11;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(foreignKeys = @ForeignKey(entity = Department.class, parentColumns = "id", childColumns = "deptId"))
public class Course  implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String code;

    public String name;

    public long deptId;
}
