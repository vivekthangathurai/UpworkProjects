package com.example.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Evidences {

@SerializedName("add")
@Expose
private List<Add> add = null;
@SerializedName("remove")
@Expose
private List<String> remove = null;

public List<Add> getAdd() {
return add;
}

public void setAdd(List<Add> add) {
this.add = add;
}

public List<String> getRemove() {
return remove;
}

public void setRemove(List<String> remove) {
this.remove = remove;
}

}
