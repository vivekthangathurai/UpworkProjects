package com.example.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Evidence {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("fileName")
@Expose
private String fileName;
@SerializedName("fileSize")
@Expose
private String fileSize;
@SerializedName("created")
@Expose
private String created;
@SerializedName("author")
@Expose
private String author;
@SerializedName("fileURL")
@Expose
private String fileURL;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getFileName() {
return fileName;
}

public void setFileName(String fileName) {
this.fileName = fileName;
}

public String getFileSize() {
return fileSize;
}

public void setFileSize(String fileSize) {
this.fileSize = fileSize;
}

public String getCreated() {
return created;
}

public void setCreated(String created) {
this.created = created;
}

public String getAuthor() {
return author;
}

public void setAuthor(String author) {
this.author = author;
}

public String getFileURL() {
return fileURL;
}

public void setFileURL(String fileURL) {
this.fileURL = fileURL;
}

}