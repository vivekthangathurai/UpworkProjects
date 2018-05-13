package com.example.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("rank")
@Expose
private Integer rank;
@SerializedName("values")
@Expose
private List<String> values = null;
@SerializedName("status")
@Expose
private String status;
@SerializedName("statusDescription")
@Expose
private String statusDescription;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public Integer getRank() {
return rank;
}

public void setRank(Integer rank) {
this.rank = rank;
}

public List<String> getValues() {
return values;
}

public void setValues(List<String> values) {
this.values = values;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getStatusDescription() {
return statusDescription;
}

public void setStatusDescription(String statusDescription) {
this.statusDescription = statusDescription;
}

}