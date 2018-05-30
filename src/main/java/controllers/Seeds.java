package controllers;

import db.DBHelper;
import models.stock.Stock;
import models.stock.StockType;
import models.users.Admin;
import models.users.Customer;

public class Seeds {

    public static void seedData(){
        Customer customer1 = new Customer("Daniel", "User1");
        DBHelper.save(customer1);

        Admin admin1 = new Admin("Bob", "808");
        DBHelper.save(admin1);
//        coffee stock
        Stock stock1 = new Stock("Ethiopian", "Java beans from the heart of Africa", StockType.COFFEE, 5.00, 100, "https://images-na.ssl-images-amazon.com/images/I/41vLhmCdNhL.jpg");
        Stock stock2 = new Stock("Kenyan", "Java coffee beans from the heart of Africa", StockType.COFFEE,5.00, 100, "https://images-na.ssl-images-amazon.com/images/I/71srV1IcYpL._SL1470_.jpg");
        Stock stock3 = new Stock("Columbian", "Java coffee beans from the heart of the Amazon", StockType.COFFEE, 6.00, 100, "http://www.sydneycellardoor.com.au/wp-content/uploads/2016/01/coffee.jpg");
        Stock stock4 = new Stock("Brazilian", "Java coffee beans from the heart of South America", StockType.COFFEE, 7.50, 100, "https://coffebeans.co.uk/wp-content/uploads/2016/11/Green-Brazilian-Coffee-Beans-100-Arabica-Speciality-Green-Coffee-Beans-From-Brazil-For-Home-Roasting-0.jpg");
        Stock stock5 = new Stock("Italian", "Java coffee beans from the heart of Europe", StockType.COFFEE, 9.00, 100, "https://images-na.ssl-images-amazon.com/images/I/61fH39pYqdL._SY445_.jpg");
        DBHelper.save(stock1);
        DBHelper.save(stock2);
        DBHelper.save(stock3);
        DBHelper.save(stock4);
        DBHelper.save(stock5);

//        equipment stock
        Stock stock6 = new Stock("Moka", "Batman Moka, why not?", StockType.EQUIPMENT, 25.00, 10, "https://images-eu.ssl-images-amazon.com/images/I/41voHdXXTaL._SL500_AC_SS350_.jpg");
        Stock stock7 = new Stock("French Press", "Stainless Steal French Press", StockType.EQUIPMENT, 25.00, 100, "https://images-na.ssl-images-amazon.com/images/I/41AhEpqQ-sL.jpg");
        Stock stock8 = new Stock("Espresso Machine", "You can run a Coffeeshop with this thing!", StockType.EQUIPMENT, 2199.99, 10, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-j0xJr7LwMsQhAyR7Kb0k1kF1Aqs_XmLjFH9oCrnXqXafjaym");
        Stock stock9 = new Stock("Coffee Grinder", "Another one bites the dust", StockType.EQUIPMENT, 30.00, 88, "https://alternativebrewing.com.au/wp-content/uploads/2017/05/Hario-22Standard22-Coffee-Grinder.jpg");
        Stock stock10 = new Stock("AeroPress", "Make a coffee with a plunger", StockType.EQUIPMENT, 40.00, 200, "http://www.anamcoffee.ie/wp-content/uploads/2015/12/aeropress.jpg");
        DBHelper.save(stock6);
        DBHelper.save(stock7);
        DBHelper.save(stock8);
        DBHelper.save(stock9);
        DBHelper.save(stock10);

//        misc stock
        Stock stock11 = new Stock("Cup", "Comdey Cup", StockType.MISC, 6.00, 30, "http://www.mugs.coffee/wp-content/uploads/2016/04/lick_cutecoffeemug2.jpg");
        Stock stock12 = new Stock("Travel Cup", "A wiery travel cup", StockType.MISC, 10.00, 50, "http://www.asuntospublicos.org/upload/2018/05/06/travelling-mug-coffee-kingdom-travel-espresso-mug-l-4e18276ab9be78a7.jpg");
        Stock stock13 = new Stock("Cookie Monster Cup", "A cops must trusted tool", StockType.MISC, 8.00, 5, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRq5h-LWaMqmbj9YE86W9jr2ZVGAjTRujoCtB8cEFJgFQNyd_r");
        Stock stock14 = new Stock("Inappropriate Cup", "Speaks for itself", StockType.MISC, 5.00, 0, "https://media1.popsugar-assets.com/files/thumbor/Ox2sJ5RS7kqDo2AJ_DjHPjcUXso/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2015/11/20/752/n/1922195/7a1965a9_edit_img_image_26123565_1416516929_sq/i/Gifts-Coffee-Lovers-Under-60.jpg");
       DBHelper.save(stock11);
       DBHelper.save(stock12);
       DBHelper.save(stock13);
       DBHelper.save(stock14);

    }
}
