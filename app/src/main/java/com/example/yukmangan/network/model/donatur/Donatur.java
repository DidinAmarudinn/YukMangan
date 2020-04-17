
package com.example.yukmangan.network.model.donatur;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@SuppressWarnings("unused")
public class Donatur {
    @Expose
    private List<Datum> data;
    @SerializedName("status ")
    private String status;
    public List<Datum> getData() {
        return data;
    }
    public void setData(List<Datum> data) {
        this.data = data;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
