package com.pars;

class ParseSiteOne {

    private String title, category, size, descriptionFirst, descriptionSecond;

    public ParseSiteOne(String title, String category, String size, String descriptionFirst, String descriptionSecond) {
        this.title = title;
        this.category = category;
        this.size = size;
        this.descriptionFirst = descriptionFirst;
        this.descriptionSecond = descriptionSecond;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescriptionFirst() {
        return descriptionFirst;
    }

    public void setDescriptionFirst(String descriptionFirst) {
        this.descriptionFirst = descriptionFirst;
    }

    public String getDescriptionSecond() {
        return descriptionSecond;
    }

    public void setDescriptionSecond(String descriptionSecond) {
        this.descriptionSecond = descriptionSecond;
    }

    @Override
    public String toString() {
        return "ParseSiteOne{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", size='" + size + '\'' +
                ", descriptionFirst='" + descriptionFirst + '\'' +
                ", descriptionSecond='" + descriptionSecond + '\'' +
                '}';
    }
}
