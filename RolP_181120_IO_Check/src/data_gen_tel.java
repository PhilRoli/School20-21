public class data_gen_tel {
    public static void main(String[] args) {
        // Nachname,Vorname,Adresse,Tel Nr,Betrag
        // Nachname = Array + random picker
        // Vorname = Array + random picker
        // Adresse = Array + random picker
        // telnr = Array[1234] + Array [12345678] + random picker
        // Betrag = random Double 150 -> 1

        for (int i = 0; i < 800; i++) {
            System.out.println(nachname() + ',' + vorname() + ',' + adresse() + ',' + telnr() + ',' + betrag());
        }
    }

    public static String nachname() {
        String[] nachnameListe = { "Mustermann", "Scott", "Warner", "Walsh", "Hatfield", "Mcmillan", "Barrett",
                "Herman", "Hunter", "Paul", "Carroll", "Bruce", "Novak", "Drake", "Montes", "Short", "Rowland",
                "Golden", "Matthews", "Mack", "Singleton", "Martinez", "Valencia", "Vaughan", "Powers", "Fitzpatrick",
                "Powell", "Gould", "Hansen", "Donaldson", "Nelson", "Perkins", "Winters", "Booker", "Schultz",
                "Pollard", "Bates", "Oconnell", "Rollins", "Higgins", "Wiley", "Chambers", "Farrell", "Coffey", "Cruz",
                "Avila", "Bowers", "Dickson", "Burton", "Lozano", "Huerta", "Brown", "Dougherty", "Madden", "Leach",
                "Hale", "Cline", "Cole", "Briggs", "Irwin", "Galloway", "Paul", "Rodgers", "Kidd", "Ball", "Mosley",
                "Wood", "Middleton", "Villanueva", "Terry", "Hull", "Walton", "Griffith", "Ayala", "Cordova", "Montes",
                "Yang", "Freeman", "Gaines", "Mercer", "Good", "Daugherty", "Hoffman", "Grimes", "Cantu", "Tapia",
                "Mclaughlin", "Newman", "Shaw", "Ramirez", "Bridges", "Gould", "Osborn", "Moss", "Hopkins", "Browning",
                "Sullivan", "Bolton", "Cannon", "Richard", "Michael" };

        return nachnameListe[getRandomNumber(0, 50)];
    }

    public static String vorname() {
        String[] vornameListe = { "Max", "Casey", "Richard", "Cristal", "Lance", "Kylie", "Ruth", "Lydia", "Rohan",
                "Preston", "Rex", "Cindy", "Kara", "Daniela", "Gabriel", "Karen", "Deshawn", "Kyle", "Madelynn",
                "Margaret", "Gary", "Lyric", "Kelsie", "Cooper", "Kassandra", "Irvin", "Talan", "Lena", "Jared",
                "Guadalupe", "Rubi", "Neil", "Zoe", "Brooklynn", "Christine", "Jonathan", "Spencer", "Randy", "London",
                "Gunnar", "Byron", "Ella", "Jonathon", "Edwin", "Jakob", "Thalia", "Heaven", "Cameron", "Kianna",
                "Elliott", "Eleanor", "Valentin", "Anahi", "Broderick", "Nelson", "Wesley", "Deanna", "Keon", "Mason",
                "Ricky", "Anthony", "Mariana", "Salvador", "Ezra", "Aubrey", "Josephine", "Emery", "Mario", "Kadyn",
                "Alvin", "Kash", "Ryleigh", "Maria", "Alfred", "Dallas", "Emmanuel", "Ainsley", "Alfredo", "Brett",
                "Ann", "Tucker", "Lea", "Dale", "Erick", "Leonidas", "Jane", "Laney", "Zachery", "Kyan", "Mackenzie",
                "Jaydon", "Gavyn", "Jaidyn", "Colten", "Sage", "Darnell", "Dennis", "Isai", "Ansley", "Selah",
                "Renee" };

        return vornameListe[getRandomNumber(0, 50)];
    }

    public static String adresse() {
        String[] addresseListe = { "1010 Innere Stadt", "1020 Leopoldstadt", "1030 Landstraße", "1040 Wieden",
                "1050 Margareten", "1060 Mariahilf", "1070 Neubau", "1080 Josefstadt", "1090 Alsergrund",
                "1100 Favoriten", "1110 Simmering", "1120 Meidling", "1130 Hietzing", "1140 Penzing",
                "1150 Rudolfsheim", "1160 Ottakring", "1170 Hernals", "1180 Währing", "1190 Döbling",
                "1200 Brigittenau", "1210 Floridsdorf", "1220 Donaustadt", "1230 Liesing", "2000 Stockerau",
                "2002 Großmugl", "2020 Hollabrunn", "2054 Haugsdorf", "2062 Seefeld", "2070 Retz", "2093 Geras",
                "2100 Bisamberg", "2100 Korneuburg", "2102 Hagenbrunn", "2111 Harmannsdorf", "2114 Großrußbach",
                "2115 Ernstbrunn", "2120 Wolkersdorf", "2122 Ulrichskirchen", "2130 Mistelbach",
                "2135 Neudorf bei Staatz", "2136 Laa an der Thaya", "2152 Pyhra", "2152 Zwentendorf", "2500 Baden",
                "2680 Semmering", "2700 Wiener Neustadt", "2822 Bad Erlach", "3312 Oed-Oehling",
                "3340 Waidhofen an der Ybbs", "3500 Krems an der Donau", "3550 Langenlois",
                "3580 Sankt Bernhard-Frauenhofen", "3830 Waidhofen an der Thaya", "3860 Heidenreichstein",
                "3943 Schrems", "3950 Gmünd", "4020 Linz", "4030 Linz", "4040 Linz", "4052 Ansfelden", "4070 Eferding",
                "4210 Gallneukirchen", "4211 Alberndorf in der Riedmark", "4212 Neumarkt im Mühlkreis",
                "4213 Unterweitersdorf", "4400 Steyr", "4470 Enns", "4800 Attnang-Puchheim", "4801 Traunkirchen",
                "4802 Ebensee", "4810 Gmunden", "4812 Pinsdorf", "4813 Altmünster", "4814 Neukirchen bei Altmünster",
                "4815 Ort bei Gmunden", "4816 Gschwandt", "4817 St. Konrad", "4819 Gmunden", "4820 Bad Ischl",
                "4821 Lauffen", "4822 Bad Goisern", "4823 Steeg", "4824 Gosau", "4825 Gosau-Hintertal",
                "4829 Bad Ischl", "4830 Hallstatt", "4831 Obertraun", "4840 Vöcklabruck", "4841 Ungenach",
                "4842 Zell am Pettenfirst", "4843 Ampflwang im Hausruckwald", "4844 Regau", "4845 Rutzenmoos",
                "4850 Timelkam", "4851 Gampern", "4852 Weyregg", "4853 Steinbach am Attersee", "4854 Weißenbach",
                "4860 Lenzing", "4861 Schörfling", "4862 Kammer", "4863 Seewalchen", "4864 Attersee", "4865 Nußdorf",
                "4866 Unterach", "4870 Vöcklamarkt", "4871 Zipf", "4872 Neukirchen an der Vöckla", "4873 Frankenburg",
                "4874 Pramet", "4880 St. Georgen im Attergau", "4881 Straß im Attergau", "4882 Oberwang",
                "4890 Frankenmarkt", "4891 Pöndorf", "4892 Fornach", "4893 Zell am Moos", "4894 Oberhofen am Irrsee",
                "5222 Auerbach", "5020 Salzburg", "5023 Salzburg", "5026 Salzburg", "5061 Salzburg", "5071 Salzburg",
                "5081 Salzburg", "5082 Salzburg", "5071 Wals-Siezenheim", "5072 Wals-Siezenheim", "5081 Anif",
                "5090 Lofer", "5101 Bergheim", "5102 Anthering", "5110 Oberndorf bei Salzburg", "5111 Bürmoos",
                "5165 Berndorf bei Salzburg", "5302 Henndorf am Wallersee", "5323 Ebenau", "5330 Fuschl am See",
                "5340 St. Gilgen", "5350 Strobl", "5400 Hallein", "5421 Adnet", "5424 Bad Vigaun", "5431 Kuchl",
                "5441 Abtenau", "5450 Werfen", "5500 Bischofshofen", "5505 Mühlbach am Hochkönig", "5511 Hüttau",
                "5524 Annaberg-Lungötz", "5541 Altenmarkt im Pongau", "5550 Radstadt", "5570 Mauterndorf",
                "5580 Tamsweg", "5583 Muhr", "5584 Zederhaus", "5600 Sankt Johann im Pongau", "5622 Goldegg",
                "5630 Bad Hofgastein", "5640 Bad Gastein", "5661 Rauris", "5672 Fusch an der Großglocknerstraße",
                "5700 Zell am See", "5710 Kaprun", "5722 Niedernsill", "5730 Mittersill", "5743 Krimml",
                "5753 Saalbach-Hinterglemm", "5760 Saalfelden", "6020 Innsbruck", "6080 Igls", "6080 Vill",
                "6060 Ampass", "6060 Hall in Tirol", "6067 Absam", "6071 Aldrans", "6072 Lans", "6073 Sistrans",
                "6100 Seefield", "6112 Wattens", "6142 Mieders", "6166 Fulpmes", "6173 Oberperfuss", "6401 Inzing",
                "6402 Hatting", "6410 Telfs", "6460 Imst", "9900 Lienz", "9903 Oberlienz", "9904 Thurn",
                "9905 Gaimberg", "9906 Lavant", "9907 Tristach", "9908 Amlach", "9909 Leisach", "9911 Assling",
                "9912 Anras", "9913 Abfaltersbach", "9918 Strassen", "9919 Heinfels", "9920 Sillian", "9922 Strassen",
                "9931 Außervillgraten", "9932 Innervillgraten", "9941 Kartitsch", "9942 Obertilliach",
                "9943 Untertilliach", "9951 Ainet", "9952 Sankt Johann im Walde", "9953 Huben", "9954 Schlaiten",
                "9961 Hopfgarten in Defereggen", "9962 St. Veit in Defereggen", "9963 St. Jakob in Defereggen",
                "9971 Matrei in Osttirol", "9972 Virgen", "9974 Prägraten am Großvenediger",
                "9981 Kals am Großglockner", "9990 Nußdorf-Debant", "9991 Dölsach", "9992 Iselsberg-Stronach",
                "6733 Fontanella", "6763 Zürs", "6764 Lech", "6774 Tschagguns", "6780 Schruns", "6800 Feldkirch",
                "6820 Frastanz", "6830 Rankweil", "6840 Götzis", "6845 Hohenems", "6850 Dornbirn", "6858 Schwarzach",
                "6863 Egg", "6867 Schwarzenberg", "6870 Reuthe", "6870 Bezau", "6874 Bizau", "6881 Mellau", "6883 Au",
                "6886 Schoppernau", "6890 Lustenau", "6900 Bregenz", "6911 Lochau", "6922 Wolfurt", "6923 Lauterach",
                "6942 Krumbach", "6971 Hard", "6991 Riezlern", "2443 Leithaprodersdorf", "2443 Loretto",
                "2443 Stotzing", "2485 Wimpassing an der Leitha", "2491 Neufeld an der Leitha", "7000 Eisenstadt",
                "7011 Siegendorf", "7011 Zagersdorf", "7013 Klingenbach", "7023 Zemendorf", "7024 Hirm",
                "7034 Zillingtal", "7035 Steinbrunn", "7041 Wulkaprodersdorf", "7051 Großhöflein", "7052 Müllendorf",
                "7053 Hornstein", "7061 Trausdorf an der Wulka", "7062 Sankt Margarethen im Burgenland",
                "7063 Oggau am Neusiedler See", "7064 Oslip", "7072 Mörbisch am See", "7081 Schützen am Gebirge",
                "7082 Donnerskirchen", "7083 Purbach am Neusiedlersee", "7091 Breitenbrunn", "7423 Pinkafeld",
                "7421 Tauchen", "8010 Graz Innere Stadt", "8020 Algersdorf", "8036 Graz", "8041 Neudorf",
                "8042 Graz St. Peter", "8330 Feldbach", "8510 Stainz", "8511 Sankt Stefan ob Stainz", "8523 Frauental",
                "8530 Deutschlandsberg", "8671 Alpl", "8672 St.Kathrein am Hauenstein", "8680 Mürzzuschlag",
                "8684 Spital am Semmering", "9323 Dürnstein in der Steiermark", "9020 Klagenfurt", "9100 Völkermarkt",
                "9145 Bad Eisenkappel", "9150 Bleiburg", "9170 Ferlach", "9300 Sankt Veit", "9341 Straßburg",
                "9342 Gurk", "9400 Wolfsberg", "9473 Hart", "9470 Sankt Paul", "9500 Villach", "9545 Radenthein",
                "9546 Bad Kleinkirchheim", "9551 Steindorf am Ossiacher See", "9560 Feldkirchen", "9570 Ossiach",
                "9620 Hermagor", "9632 Kirchbach", "9701 Rothenthurn", "9702 Ferndorf", "9710 Feistritz an der Drau",
                "9711 Paternion", "9712 Fresach", "9713 Zlan", "9714 Stockenboi", "9781 Oberdrauburg",
                "9800 Spittal an der Drau", "9805 Baldramsdorf", "9811 Lendorf", "9812 Pusarnitz", "9813 Möllbrücke",
                "9814 Mühldorf", "9815 Kolbnitz", "9816 Penk", "9821 Obervellach", "9822 Mallnitz", "9831 Flattach",
                "9832 Stall", "9833 Rangersdorf", "9841 Winklern", "9842 Mörtschach", "9843 Großkirchheim",
                "9844 Heiligenblut", "9851 Lieserbrücke", "9852 Trebesing", "9853 Gmünd", "9854 Malta",
                "9861 Eisentratten", "9862 Kremsbrücke", "9863 Rennweg am Katschberg", "9871 Seeboden",
                "9872 Millstatt", "9873 Döbriach" };

        return addresseListe[getRandomNumber(0, 345)];
    }

    public static String telnr() {
        String[] provider = { "0650", "0680", "0681", "6998", "0665", "0688", "0677", "0670", "0690", "0660", "0699",
                "0664", "0676" };

        return provider[getRandomNumber(0, 12)] + ' ' + getRandomNumber(1111111, 99999999);
    }

    public static double betrag() {
        return round((Math.random() * (150.00 - 1.00)) + 1.00);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static double round(double value) {
        value = value * 100;
        value = Math.round(value);
        return value / 100;
    }
}
