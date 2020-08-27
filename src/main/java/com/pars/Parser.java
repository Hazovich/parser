package com.pars;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static void main(String[] args) throws IOException, NullPointerException, IllegalStateException {

        ArrayList<ParseSiteOne> elementsList = new ArrayList<>();

        FileWriter outOne = new FileWriter("SiteOnePars.csv");
        CSVPrinter printerOne = new CSVPrinter(outOne, CSVFormat.DEFAULT.withHeader(HeadersOne.class));

        Document pageSiteOne = Jsoup.connect("http://sonline.com.ua").get();

        for (int i = 6; i < 9; i++) {
            String pageStr = pageSiteOne.select("#header > div.top_menu > ul > li.item14" + i).select("a").attr("href");

            Document pageOne = Jsoup.connect("http://sonline.com.ua" + pageStr).get();

            Elements elements = pageOne.getElementsByClass("itemContainer");
            elements.forEach(element -> {
                String title = element.select("a").first().attr("title");
                String descriptionFirst = element.select("p").text();
                String category = pageOne.getElementsByAttributeValue("class", "componentheading").text();
                String size = pageOne.getElementsByClass("item_opus").select("p").get(1).text();
                String links = element.select("a").first().attr("href");

                try {
                    Document srcPage = Jsoup.connect("http://sonline.com.ua" + links).get();
                    String descriptionSecond = srcPage.select("span").text();
                    elementsList.add(new ParseSiteOne(title, category, size, descriptionFirst, descriptionSecond));
                    printerOne.printRecord(title, category, size, descriptionFirst, descriptionSecond);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        Document pageOne = Jsoup.connect("http://sonline.com.ua/toppers").get();

        Elements elements = pageOne.getElementsByClass("itemContainer");
        elements.forEach(element -> {
            String title = element.select("a").first().attr("title");
            String descriptionFirst = element.select("p").text();
            String category = pageOne.getElementsByAttributeValue("class", "componentheading").text();
            String size = pageOne.getElementsByClass("item_opus").select("p").get(0).text();
            String links = element.select("a").first().attr("href");

            try {
                Document srcPage = Jsoup.connect("http://sonline.com.ua" + links).get();
                String descriptionSecond = srcPage.select("span").text();
                elementsList.add(new ParseSiteOne(title, category, size, descriptionFirst, descriptionSecond));
                printerOne.printRecord(title, category, size, descriptionFirst, descriptionSecond);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        printerOne.close();

        //Second Site
        ArrayList<ParseSiteTwo> siteTwoElements = new ArrayList<>();
        FileWriter out = new FileWriter("SiteTwoPars.csv");

        CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(Headers.class));


        Document pageSiteTwoFirst = Jsoup.connect("https://shik-galichina.com/sofas/").get();
        //Sofas
        Elements elementsOne = pageSiteTwoFirst.getElementsByClass("store-item");
        elementsOne.forEach(element -> {

            String title = element.select("b").first().text();
            String category = element.getElementsByClass("subtitle").text();
            String collection = element.getElementsByClass("title").select("b").last().text();
            String links = element.select("a").attr("href");

            try {
                Document storeItem = Jsoup.connect(links).get();
                String description = storeItem.getElementsByClass("model-description").select("p").text();

                // Width
                String width = null;
                String widthEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternWidth = Pattern.compile("[шШ]ирина......");
                Matcher matcherWidth = patternWidth.matcher(widthEl);
                boolean bWidth = matcherWidth.find(0);
                if (matcherWidth.find(0)) {
                    width = matcherWidth.group();
                } else if (matcherWidth.find(0) == false) {
                    width = "---";
                }

                // Height
                String height = null;
                String heightEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternHeight = Pattern.compile("[вВ]исота.......");
                Matcher matcherHeight = patternHeight.matcher(heightEl);
                boolean bHeight = matcherHeight.find(0);
                if (matcherHeight.find(0)) {
                    height = matcherHeight.group();
                } else if (matcherHeight.find(0) == false) {
                    height = "---";
                }

                //Depth
                String depth = null;
                String depthEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternDepth = Pattern.compile("[гГ]либина......");
                Matcher matcherDepth = patternDepth.matcher(depthEl);
                boolean bDepth = matcherDepth.find();
                if (matcherDepth.find(0)) {
                    depth = matcherDepth.group();
                } else if (matcherDepth.find(0) == false) {
                    depth = "---";
                }

                //SeatDepth
                String seatDepth = null;
                String seatDepthEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternSeatDepth = Pattern.compile("[гГ]либина сидіння ......");
                Matcher matcherSeatDepth = patternSeatDepth.matcher(seatDepthEl);
                boolean bSeatDepth = matcherSeatDepth.find();
                if (matcherSeatDepth.find(0)) {
                    seatDepth = matcherSeatDepth.group();
                } else if (matcherSeatDepth.find(0) == false) {
                    seatDepth = "---";
                }


                //DepthSeatPillow
                String depthSeatPillow = null;
                String depthSeatPillowEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternDepthSeatPillow = Pattern.compile("[гГ]либина сидіння до подушки ......");
                Matcher matcherDepthSeatPillow = patternDepthSeatPillow.matcher(depthSeatPillowEl);
                boolean bDepthSeatPillow = matcherDepthSeatPillow.find(0);
                if (matcherDepthSeatPillow.find(0)) {
                    depthSeatPillow = matcherDepthSeatPillow.group();
                } else if (matcherDepthSeatPillow.find(0) == false) {
                    depthSeatPillow = "---";
                }

                //SeatHeight
                String seatHeight = null;
                String seatHeightEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternSeatHeight = Pattern.compile("[вВ]исота сидіння ......");
                Matcher matcherSeatHeight = patternSeatHeight.matcher(seatHeightEl);
                boolean bSeatHeight = matcherSeatHeight.find(0);
                if (matcherSeatHeight.find(0)) {
                    seatHeight = matcherSeatHeight.group();
                } else if (matcherSeatHeight.find(0) == false) {
                    seatHeight = "---";
                }

                //Textile
                String textileTitle = storeItem.getElementsByClass("texture-info").select("p").text();
                String textileColor = storeItem.getElementsByClass("texture-info").select("span").text();

                //Adding null
                String length = "---";
                String seatWidth = "---";
                String sleepingPlace = "---";
                String heightOnPillows = "---";
                String textAvailableSizes = "---";
                String standardSize = "---";
                String availableSizes = "---";

                //Adding element to list


                siteTwoElements.add(new ParseSiteTwo(title, category, collection, textileTitle, textileColor, width, height, length, depth, seatHeight, seatDepth, seatWidth, depthSeatPillow, sleepingPlace, heightOnPillows, textAvailableSizes, standardSize, availableSizes, description));
                printer.printRecord(title, category, collection, textileTitle, textileColor, width, height, length, depth, seatHeight, seatDepth, seatWidth, depthSeatPillow, sleepingPlace, heightOnPillows, textAvailableSizes, standardSize, availableSizes, description);

            } catch (IOException | NullPointerException | IllegalStateException e) {
                e.printStackTrace();
            }

        });

        Document pageSiteTwoSecond = Jsoup.connect("https://shik-galichina.com/chairs/").get();
        //Chairs
        Elements elementsTwo = pageSiteTwoSecond.getElementsByClass("store-item");
        elementsTwo.forEach(element -> {
            String title = element.select("b").first().text();
            String category = element.getElementsByClass("subtitle").text();
            String collection = element.getElementsByClass("title").select("b").last().text();
            String links = element.select("a").attr("href");

            try {
                Document storeItem = Jsoup.connect(links).get();
                String description = storeItem.getElementsByClass("model-description").select("p").text();

                //Width
                String width = null;
                String widthEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternWidth = Pattern.compile("[шШ]ирина.......");
                Matcher matcherWidth = patternWidth.matcher(widthEl);
                boolean bWidth = matcherWidth.find(0);
                if (matcherWidth.find(0)) {
                    width = matcherWidth.group();
                } else if (matcherWidth.find(0) == false) {
                    width = "---";
                }

                //Height
                String height = null;
                String heightEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternHeight = Pattern.compile("[вВ]исота.......");
                Matcher matcherHeight = patternHeight.matcher(heightEl);
                boolean bHeight = matcherHeight.find(0);
                if (matcherHeight.find(0)) {
                    height = matcherHeight.group();
                } else if (matcherHeight.find(0) == false) {
                    height = "---";
                }

                //Depth
                String depth = null;
                String depthEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternDepth = Pattern.compile("[гГ]либина.......");
                Matcher matcherDepth = patternDepth.matcher(depthEl);
                boolean bDepth = matcherDepth.find();
                if (matcherDepth.find(0)) {
                    depth = matcherDepth.group();
                } else if (matcherDepth.find(0) == false) {
                    depth = "---";
                }

                //SeatDepth
                String seatDepth = null;
                String seatDepthEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternSeatDepth = Pattern.compile("[гГ]либина сидіння ......");
                Matcher matcherSeatDepth = patternSeatDepth.matcher(seatDepthEl);
                boolean bSeatDepth = matcherSeatDepth.find();
                if (matcherSeatDepth.find(0)) {
                    seatDepth = matcherSeatDepth.group();
                } else if (matcherSeatDepth.find(0) == false) {
                    seatDepth = "---";
                }

                //SeatHeight
                String seatHeight = null;
                String seatHeightEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternSeatHeight = Pattern.compile("[вВ]исота сидіння ......");
                Matcher matcherSeatHeight = patternSeatHeight.matcher(seatHeightEl);
                boolean bSeatHeight = matcherSeatHeight.find(0);
                if (matcherSeatHeight.find(0)) {
                    seatHeight = matcherSeatHeight.group();
                } else if (matcherSeatHeight.find(0) == false) {
                    seatHeight = "---";
                }

                //Textile
                String textileTitle = storeItem.getElementsByClass("texture-info").select("p").text();
                String textileColor = storeItem.getElementsByClass("texture-info").select("span").text();

                //Adding null

                String length = "---";
                String seatWidth = "---";
                String depthSeatPillow = "---";
                String sleepingPlace = "---";
                String heightOnPillows = "---";
                String textAvailableSizes = "---";
                String standardSize = "---";
                String availableSizes = "---";

                //Adding element to list

                siteTwoElements.add(new ParseSiteTwo(title, category, collection, textileTitle, textileColor, width, height, length, depth, seatHeight, seatDepth, seatWidth, depthSeatPillow, sleepingPlace, heightOnPillows, textAvailableSizes, standardSize, availableSizes, description));
                printer.printRecord(title, category, collection, textileTitle, textileColor, width, height, length, depth, seatHeight, seatDepth, seatWidth, depthSeatPillow, sleepingPlace, heightOnPillows, textAvailableSizes, standardSize, availableSizes, description);

            } catch (IOException | NullPointerException | IllegalStateException e) {
                e.printStackTrace();
            }
        });

        Document pageSiteTwoThird = Jsoup.connect("https://shik-galichina.com/beds/").get();
        //Beds
        Elements elementsThree = pageSiteTwoThird.getElementsByClass("store-item");
        elementsThree.forEach(element -> {
            String title = element.select("b").first().text();
            String category = element.getElementsByClass("subtitle").text();
            String collection = element.getElementsByClass("title").select("b").last().text();
            String links = element.select("a").attr("href");

            try {
                Document storeItem = Jsoup.connect(links).get();
                String description = storeItem.getElementsByClass("model-description").select("p").text();

                //Width
                String width = null;
                String widthEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternWidth = Pattern.compile("[шШ]ирина........");
                Matcher matcherWidth = patternWidth.matcher(widthEl);
                boolean bWidth = matcherWidth.find(0);
                if (matcherWidth.find(0)) {
                    width = matcherWidth.group();
                } else if (matcherWidth.find(0) == false) {
                    width = "---";
                }

                //Height
                String height = null;
                String heightEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternHeight = Pattern.compile("[вВ]исота........");
                Matcher matcherHeight = patternHeight.matcher(heightEl);
                boolean bHeight = matcherHeight.find(0);
                if (matcherHeight.find(0)) {
                    height = matcherHeight.group();
                } else if (matcherHeight.find(0) == false) {
                    height = "---";
                }

                //Length
                String length = null;
                String lengthEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternLength = Pattern.compile("[дД]овжина........");
                Matcher matcherLength = patternLength.matcher(lengthEl);
                boolean bLength = matcherLength.find(0);
                if (matcherLength.find(0)) {
                    length = matcherLength.group();
                } else if (matcherLength.find(0) == false) {
                    length = "---";
                }


                //Sleeping Place
                String sleepingPlace = null;
                String sleepingPlaceEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternSleepingPlace = Pattern.compile("[сС]пальне місце.*\\d\\d\\d.*.\\d\\d\\d");
                Matcher matcherSleepingPlace = patternSleepingPlace.matcher(sleepingPlaceEl);
                boolean bSleepingPlace = matcherSleepingPlace.find(0);
                if (matcherSleepingPlace.find(0)) {
                    sleepingPlace = matcherSleepingPlace.group();
                } else if (matcherSleepingPlace.find(0) == false) {
                    sleepingPlace = "---";
                }

                //Textile
                String textileTitle = storeItem.getElementsByClass("texture-info").select("p").text();
                String textileColor = storeItem.getElementsByClass("texture-info").select("span").text();

                //Adding null
                String depth = "---";
                String seatHeight = "---";
                String seatDepth = "---";
                String seatWidth = "---";
                String depthSeatPillow = "---";
                String heightOnPillows = "---";
                String textAvailableSizes = "---";
                String standardSize = "---";
                String availableSizes = "---";

                //Adding element to list

                siteTwoElements.add(new ParseSiteTwo(title, category, collection, textileTitle, textileColor, width, height, length, depth, seatHeight, seatDepth, seatWidth, depthSeatPillow, sleepingPlace, heightOnPillows, textAvailableSizes, standardSize, availableSizes, description));
                printer.printRecord(title, category, collection, textileTitle, textileColor, width, height, length, depth, seatHeight, seatDepth, seatWidth, depthSeatPillow, sleepingPlace, heightOnPillows, textAvailableSizes, standardSize, availableSizes, description);


            } catch (IOException | NullPointerException | IllegalStateException e) {
                e.printStackTrace();
            }
        });

        Document pageSiteTwoFourth = Jsoup.connect("https://shik-galichina.com/mattresses//").get();
        //Mattresses
        Elements elementsFour = pageSiteTwoFourth.getElementsByClass("store-item");
        elementsFour.forEach(element -> {
            String title = element.select("b").first().text();
            String category = element.getElementsByClass("subtitle").text();
            String collection = element.getElementsByClass("title").select("b").last().text();
            String links = element.select("a").attr("href");

            try {
                Document storeItem = Jsoup.connect(links).get();
                String description = storeItem.getElementsByClass("model-description").select("p").text();
                //Standard Size
                String standardSize = null;
                String standardSizeEl = storeItem.getElementsByClass("characteristic-lists").select("p").text();
                Pattern patternStandardSize = Pattern.compile("[сС]тандартний розмір матрацу..\\d\\d\\d...\\d\\d\\d..см.");
                Matcher matcherStandardSize = patternStandardSize.matcher(standardSizeEl);
                boolean bStandardSize = matcherStandardSize.find(0);
                if (matcherStandardSize.find(0)) {
                    standardSize = matcherStandardSize.group();
                } else if (matcherStandardSize.find(0) == false) {
                    standardSize = "Стандартний розмір матрацу: 160 х 200 (см)";
                }

                //Available Sizes
                String availableSizes = null;
                String availableSizesEl = storeItem.getElementsByClass("characteristic-lists").select("p:matchesOwn([(\\d)+].*[(\\d)]+)").text();
                Pattern patternAvailableSizes = Pattern.compile("[(\\d)]+...[(\\d)]+.*");
                Matcher matcherAvailableSizes = patternAvailableSizes.matcher(availableSizesEl);
                boolean bAvailableSizes = matcherAvailableSizes.find();
                if (availableSizesEl.matches("[(\\d)+].*[(\\d)]+")) {
                    availableSizes = availableSizesEl;
                } else {
                    Pattern patternAvailableSizesElse = Pattern.compile("[дД]оступні розміри для замовлення..[(\\d)]+...[(\\d)]+.*");
                    Matcher matcherAvailableSizesElse = patternAvailableSizesElse.matcher(availableSizesEl);
                    boolean bAvailableSizesA = matcherAvailableSizesElse.find(0);
                    availableSizes = matcherAvailableSizesElse.group();
                    availableSizes = availableSizesEl;
                }

                String textAvailableSizes = "Доступні розміри для замовлення:";

                //textile
                String textileTitle = storeItem.getElementsByClass("texture-info").select("p").text();
                String textileColor = storeItem.getElementsByClass("texture-info").select("span").text();

                //Adding null
                String width = "---";
                String height = "---";
                String length = "---";
                String depth = "---";
                String seatHeight = "---";
                String seatDepth = "---";
                String seatWidth = "---";
                String depthSeatPillow = "---";
                String sleepingPlace = "---";
                String heightOnPillows = "---";

                //Adding element to list

                siteTwoElements.add(new ParseSiteTwo(title, category, collection, textileTitle, textileColor, width, height, length, depth, seatHeight, seatDepth, seatWidth, depthSeatPillow, sleepingPlace, heightOnPillows, textAvailableSizes, standardSize, availableSizes, description));
                printer.printRecord(title, category, collection, textileTitle, textileColor, width, height, length, depth, seatHeight, seatDepth, seatWidth, depthSeatPillow, sleepingPlace, heightOnPillows, textAvailableSizes, standardSize, availableSizes, description);


            } catch (IOException | NullPointerException | IllegalStateException e) {
                e.printStackTrace();
            }
        });


        printer.close();

    }
}








