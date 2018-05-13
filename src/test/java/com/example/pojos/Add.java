package com.example.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Add {

@SerializedName("filename")
@Expose
private String filename;
@SerializedName("contentType")
@Expose
private String contentType;
@SerializedName("data")
@Expose
private String data;

public String getFilename() {
return filename;
}

public void setFilename(String filename) {
this.filename = filename;
}

public String getContentType() {
return contentType;
}

public void setContentType(String contentType) {
this.contentType = contentType;
}

public String getData() {
return data;
}

public void setData(String data) {
this.data = data;
}

}
