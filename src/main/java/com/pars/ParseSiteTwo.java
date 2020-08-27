package com.pars;

public class ParseSiteTwo {

    private String title, category, collection, description, textileTitle, textileColor, width, height, length, depth, seatHeight, seatDepth, seatWidth, depthSeatPillow, sleepingPlace, heightOnPillows, textAvailableSizes, standardSize, availableSizes;

    public ParseSiteTwo(String title, String category, String collection, String textileTitle, String textileColor, String width, String height, String length, String depth, String seatHeight, String seatDepth, String seatWidth, String depthSeatPillow, String sleepingPlace, String heightOnPillows, String textAvailableSizes, String standardSize, String availableSizes, String description) {
        this.title = title;
        this.category = category;
        this.collection = collection;
        this.description = description;
        this.textileTitle = textileTitle;
        this.textileColor = textileColor;
        this.width = width;
        this.height = height;
        this.length = length;
        this.depth = depth;
        this.seatHeight = seatHeight;
        this.seatDepth = seatDepth;
        this.seatWidth = seatWidth;
        this.depthSeatPillow = depthSeatPillow;
        this.sleepingPlace = sleepingPlace;
        this.heightOnPillows = heightOnPillows;
        this.textAvailableSizes = textAvailableSizes;
        this.standardSize = standardSize;
        this.availableSizes = availableSizes;
    }

    /*//Sofa
    public ParseSiteTwo(String title, String category, String collection, String description, String textileTitle, String textileColor, String width, String height, String depth, String seatHeight, String seatDepth, String depthSeatPillow) {
        this.title = title;
        this.category = category;
        this.collection = collection;
        this.description = description;
        this.textileTitle = textileTitle;
        this.textileColor = textileColor;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.seatHeight = seatHeight;
        this.seatDepth = seatDepth;
        this.depthSeatPillow = depthSeatPillow;
    }

    //Chair
    public ParseSiteTwo(String title, String category, String collection, String description, String textileTitle, String textileColor, String width, String height, String depth, String seatHeight, String seatDepth) {
        this.title = title;
        this.category = category;
        this.collection = collection;
        this.description = description;
        this.textileTitle = textileTitle;
        this.textileColor = textileColor;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.seatHeight = seatHeight;
        this.seatDepth = seatDepth;
    }

    //Beds
    public ParseSiteTwo(String title, String category, String collection, String description, String textileTitle, String textileColor, String width, String height, String length, String sleepingPlace) {
        this.title = title;
        this.category = category;
        this.collection = collection;
        this.description = description;
        this.textileTitle = textileTitle;
        this.textileColor = textileColor;
        this.width = width;
        this.height = height;
        this.length = length;
        this.sleepingPlace = sleepingPlace;
    }

    //Mattresses
    public ParseSiteTwo(String title, String category, String collection, String description, String textileTitle, String textileColor, String textAvailableSizes, String standardSize, String availableSizes) {
        this.title = title;
        this.category = category;
        this.collection = collection;
        this.description = description;
        this.textileTitle = textileTitle;
        this.textileColor = textileColor;
        this.textAvailableSizes = textAvailableSizes;
        this.standardSize = standardSize;
        this.availableSizes = availableSizes;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTextileTitle() {
        return textileTitle;
    }

    public void setTextileTitle(String textileTitle) {
        this.textileTitle = textileTitle;
    }

    public String getTextileColor() {
        return textileColor;
    }

    public void setTextileColor(String textileColor) {
        this.textileColor = textileColor;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(String seatHeight) {
        this.seatHeight = seatHeight;
    }

    public String getSeatDepth() {
        return seatDepth;
    }

    public void setSeatDepth(String seatDepth) {
        this.seatDepth = seatDepth;
    }

    public String getSeatWidth() {
        return seatWidth;
    }

    public void setSeatWidth(String seatWidth) {
        this.seatWidth = seatWidth;
    }

    public String getDepthSeatPillow() {
        return depthSeatPillow;
    }

    public void setDepthSeatPillow(String depthSeatPillow) {
        this.depthSeatPillow = depthSeatPillow;
    }

    public String getSleepingPlace() {
        return sleepingPlace;
    }

    public void setSleepingPlace(String sleepingPlace) {
        this.sleepingPlace = sleepingPlace;
    }

    public String getHeightOnPillows() {
        return heightOnPillows;
    }

    public void setHeightOnPillows(String heightOnPillows) {
        this.heightOnPillows = heightOnPillows;
    }

    public String getTextAvailableSizes() {
        return textAvailableSizes;
    }

    public void setTextAvailableSizes(String textAvailableSizes) {
        this.textAvailableSizes = textAvailableSizes;
    }

    public String getStandardSize() {
        return standardSize;
    }

    public void setStandardSize(String standardSize) {
        this.standardSize = standardSize;
    }

    public String getAvailableSizes() {
        return availableSizes;
    }

    public void setAvailableSizes(String availableSizes) {
        this.availableSizes = availableSizes;
    }

    @Override
    public String toString() {
        return  title + "      " +
                category + "      " +
                collection + "      " +
                textileTitle + "      " +
                textileColor + "      " +
                width + "      " +
                height + "      " +
                length + "      " +
                depth + "      " +
                seatHeight + "      " +
                seatDepth + "      " +
                seatWidth + "      " +
                depthSeatPillow + "      " +
                sleepingPlace + "      " +
                heightOnPillows + "      " +
                textAvailableSizes + "      " +
                standardSize + "      " +
                availableSizes + "      " +
                description + "      " +
                "\n";
    }
}


