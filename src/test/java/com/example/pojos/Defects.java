package com.example.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Defects {

@SerializedName("add")
@Expose
private List<String> add = null;

public List<String> getAdd() {
return add;
}

public void setAdd(List<String> add) {
this.add = add;
}

}
