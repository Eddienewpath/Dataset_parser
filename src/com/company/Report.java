package com.company;

public class Report {

    private long id;
    private Date date;
    private String category;
    private String district;

    public Report(String id, String date, String category, String district) {
        this.id = Long.valueOf(id);
        this.date = new Date(date);
        this.category = category;
        this.district = district;
    }

    @Override
    public String toString() {
        return " " + id + "\t" + category + "\t" + date.toString() + "\t" + district + "\n";
    }

    public boolean equals(Report report) {
        return id == report.getid();
    }

    public long getid() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getDistrict() {
        return district;
    }

    public void setid(long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


}
