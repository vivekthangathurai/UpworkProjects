package com.example.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestRun {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("status")
@Expose
private String status;
@SerializedName("testKey")
@Expose
private String testKey;
@SerializedName("testExecKey")
@Expose
private String testExecKey;
@SerializedName("assignee")
@Expose
private String assignee;
@SerializedName("executedBy")
@Expose
private String executedBy;
@SerializedName("startedOn")
@Expose
private String startedOn;
@SerializedName("defects")
@Expose
private List<Defect> defects = null;
@SerializedName("evidences")
@Expose
private List<Evidence> evidences = null;
@SerializedName("comment")
@Expose
private String comment;
@SerializedName("scenarioOutline")
@Expose
private String scenarioOutline;
@SerializedName("examples")
@Expose
private List<Example> examples = null;
@SerializedName("environments")
@Expose
private List<String> environments = null;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getTestKey() {
return testKey;
}

public void setTestKey(String testKey) {
this.testKey = testKey;
}

public String getTestExecKey() {
return testExecKey;
}

public void setTestExecKey(String testExecKey) {
this.testExecKey = testExecKey;
}

public String getAssignee() {
return assignee;
}

public void setAssignee(String assignee) {
this.assignee = assignee;
}

public String getExecutedBy() {
return executedBy;
}

public void setExecutedBy(String executedBy) {
this.executedBy = executedBy;
}

public String getStartedOn() {
return startedOn;
}

public void setStartedOn(String startedOn) {
this.startedOn = startedOn;
}

public List<Defect> getDefects() {
return defects;
}

public void setDefects(List<Defect> defects) {
this.defects = defects;
}

public List<Evidence> getEvidences() {
return evidences;
}

public void setEvidences(List<Evidence> evidences) {
this.evidences = evidences;
}

public String getComment() {
return comment;
}

public void setComment(String comment) {
this.comment = comment;
}

public String getScenarioOutline() {
return scenarioOutline;
}

public void setScenarioOutline(String scenarioOutline) {
this.scenarioOutline = scenarioOutline;
}

public List<Example> getExamples() {
return examples;
}

public void setExamples(List<Example> examples) {
this.examples = examples;
}

public List<String> getEnvironments() {
return environments;
}

public void setEnvironments(List<String> environments) {
this.environments = environments;
}

}