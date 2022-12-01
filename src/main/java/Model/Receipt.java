package Model;

import java.util.ArrayList;
import Model.User;
import Model.Login;
public class Receipt {
        private User buyer;
        private ArrayList<Product> products;

        public Receipt(ArrayList<Product> products){
            this.buyer= Login.getInstance().getIngelogdeUser();
            this.products=new ArrayList<>();
            this.products.addAll(products);
        }
        public String getReceipt(){
            String bon="";
            double totaalPrijsExclKorting=0.00;
            bon+= "Name buyer: \n"+bon+buyer.getName()+"\n\n";
            bon+= "Products: \n\n";
            for(Product product :products){
                totaalPrijsExclKorting=Math.round((totaalPrijsExclKorting+ product.getPrice()) * 100.0) / 100.0;
                bon+= product.getName()+ " €"+Math.round(product.getPrice() * 100.0) / 100.0+"\n";
            }

            double korting=Math.round((buyer.getBadge().getDiscount()*totaalPrijsExclKorting) * 100.0) / 100.0;
            double totaalPrijsInclKorting =Math.round((totaalPrijsExclKorting-korting) * 100.0) / 100.0;


            bon+= "\n";
            bon+= "Discount percentage: "+buyer.getBadge().getDiscount()*100+"% \n";
            bon+= "Discount: €"+korting+"\n\n";
            bon+= "Price excl. discount: €"+totaalPrijsExclKorting+"\n";
            bon+= "Price incl. discount: €"+totaalPrijsInclKorting+"\n";
            return bon;
        }

        public double getTotalDiscount(){
            double totalPriceExclDiscount=0.00;
            for(Product product :products){
                totalPriceExclDiscount=Math.round((totalPriceExclDiscount+ product.getPrice()) * 100.0) / 100.0;
            }
            double discount=Math.round((buyer.getBadge().getDiscount()*totalPriceExclDiscount) * 100.0) / 100.0;
            double totalPriceInclDiscount =Math.round((totalPriceExclDiscount-discount) * 100.0) / 100.0;
            return totalPriceInclDiscount;
        }


    }
