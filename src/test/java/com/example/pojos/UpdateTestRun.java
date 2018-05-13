package com.example.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateTestRun {

@SerializedName("status")
@Expose
private String status;
@SerializedName("comment")
@Expose
private String comment;
@SerializedName("defects")
@Expose
private Defects defects;
@SerializedName("evidences")
@Expose
private Evidences evidences;
@SerializedName("examples")
@Expose
private List<UpdateExample> examples = null;

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getComment() {
return comment;
}

public void setComment(String comment) {
this.comment = comment;
}

public Defects getDefects() {
return defects;
}

public void setDefects(Defects defects) {
this.defects = defects;
}

public Evidences getEvidences() {
return evidences;
}

public void setEvidences(Evidences evidences) {
this.evidences = evidences;
}

public List<UpdateExample> getExamples() {
return examples;
}

public void setExamples(List<UpdateExample> examples) {
this.examples = examples;
}

}
