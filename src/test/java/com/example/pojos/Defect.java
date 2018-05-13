package com.example.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Defect {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("key")
@Expose
private String key;
@SerializedName("summary")
@Expose
private String summary;
@SerializedName("status")
@Expose
private String status;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getKey() {
return key;
}

public void setKey(String key) {
this.key = key;
}

public String getSummary() {
return summary;
}

public void setSummary(String summary) {
this.summary = summary;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

}
